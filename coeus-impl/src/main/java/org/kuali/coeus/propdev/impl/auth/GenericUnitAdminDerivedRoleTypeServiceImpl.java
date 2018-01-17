/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import java.util.Map;

import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.rice.core.api.criteria.QueryByCriteria;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("genericUnitAdminDerivedRoleTypeService")
public class GenericUnitAdminDerivedRoleTypeServiceImpl extends ProposalAllUnitAdministratorDerivedRoleTypeServiceImpl {
	
	@Autowired
	@Qualifier("dataObjectService")
	private DataObjectService dataObjectService;
	
	@Override
	protected String getUnitAdministratorTypeCode(Map<String, String> qualifications, String roleName) {
		return getUnitAdministratorTypeCodeByName(roleName);
	}
	
	protected String getUnitAdministratorTypeCodeByName(String roleName) {
		return dataObjectService.findMatching(UnitAdministratorType.class, QueryByCriteria.Builder.forAttribute("description", roleName).build())
			.getResults().stream()
			.findFirst()
			.map(UnitAdministratorType::getCode)
			.orElse(null);
	}

	@Override
    public DataObjectService getDataObjectService() {
		return dataObjectService;
	}

	@Override
    public void setDataObjectService(DataObjectService dataObjectService) {
		this.dataObjectService = dataObjectService;
	}
}
