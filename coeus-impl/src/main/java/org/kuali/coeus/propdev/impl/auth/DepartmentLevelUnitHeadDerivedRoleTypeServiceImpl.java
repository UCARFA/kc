/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("departmentLevelUnitHeadDerivedRoleTypeService")
public class DepartmentLevelUnitHeadDerivedRoleTypeServiceImpl extends ProposalAllUnitAdministratorDerivedRoleTypeServiceImpl {

	private static final String UNIT_HEAD_ADMIN_TYPE_CODE = "3";
	
	@Value(UNIT_HEAD_ADMIN_TYPE_CODE)
	private String unitAdministratorTypeCode;
	
	@Override
	protected String getUnitAdministratorTypeCode(Map<String, String> qualifications, String roleName) {
		return getUnitAdministratorTypeCode();
	}

	public String getUnitAdministratorTypeCode() {
		return unitAdministratorTypeCode;
	}

	public void setUnitAdministratorTypeCode(String unitAdministratorTypeCode) {
		this.unitAdministratorTypeCode = unitAdministratorTypeCode;
	}
}
