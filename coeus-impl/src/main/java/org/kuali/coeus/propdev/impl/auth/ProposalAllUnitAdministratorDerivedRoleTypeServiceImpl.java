/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministrator;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministratorDerivedRoleTypeService;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.rice.kim.framework.role.RoleTypeService;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component("proposalAllUnitAdministratorDerivedRoleTypeService")
public class ProposalAllUnitAdministratorDerivedRoleTypeServiceImpl extends AbstractUnitAdministratorDerivedRoleTypeService
        implements RoleTypeService {

    @Autowired
    @Qualifier("unitService")
    private UnitService unitService;

    @Autowired
    @Qualifier("dataObjectService")
    private DataObjectService dataObjectService;
    
    public void setUnitService(UnitService unitService) {
        this.unitService = unitService;
    }
    
    protected UnitService getUnitService() {
        return unitService;
    }

    public DataObjectService getDataObjectService() {
        return dataObjectService;
    }

    public void setDataObjectService(DataObjectService dataObjectService) {
        this.dataObjectService = dataObjectService;
    }

    @Override
    public List<? extends AbstractUnitAdministrator> getUnitAdministrators(Map<String, String> qualifiers) {
        String proposalNumber = qualifiers.get(KcKimAttributes.PROPOSAL);
        String unitNumber = qualifiers.get(KcKimAttributes.UNIT_NUMBER);
        List<UnitAdministrator> result = new ArrayList<UnitAdministrator>();
        if (proposalNumber != null) {
            DevelopmentProposal proposal = getDataObjectService().find(DevelopmentProposal.class,proposalNumber);
            Set<String> units = getApplicableUnits(proposal);
            for (String unit : units) {
                if (StringUtils.isNotBlank(unit)) {
                    result.addAll(unitService.retrieveUnitAdministratorsByUnitNumber(unit));
                }
            }
        } else if (unitNumber != null) {
        	result.addAll(unitService.retrieveUnitAdministratorsByUnitNumber(getUnitNumberForPersonUnit(unitService.getUnit(unitNumber))));
        }
        return result;
    }

	public Set<String> getApplicableUnits(DevelopmentProposal proposal) {
		return proposal.getProposalPersons().stream()
				  .flatMap(person -> person.getUnits().stream())
				  .map(unit -> getUnitNumberForPersonUnit(unit.getUnit()))
				  .filter(Objects::nonNull)
				  .collect(Collectors.toSet());
	}

	protected String getUnitNumberForPersonUnit(Unit unit) {
		return unit.getUnitNumber();
	}

}
