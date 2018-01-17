/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministrator;
import org.kuali.coeus.common.framework.unit.admin.AbstractUnitAdministratorDerivedRoleTypeService;
import org.kuali.coeus.common.framework.unit.admin.UnitAdministrator;
import org.kuali.coeus.propdev.impl.budget.ProposalDevelopmentBudgetExt;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kim.framework.role.RoleTypeService;
import org.kuali.rice.krad.data.DataObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component("proposalCostShareUnitAdministratorDerivedRoleTypeService")
public class ProposalCostshareUnitAdministratorDerivedRoleTypeServiceImpl extends AbstractUnitAdministratorDerivedRoleTypeService
        implements RoleTypeService {

    @Autowired
    @Qualifier("unitService")
    private UnitService unitService;

    @Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;

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
        List<UnitAdministrator> result = new ArrayList<>();
        if (proposalNumber != null) {
            DevelopmentProposal proposal = getDataObjectService().find(DevelopmentProposal.class,proposalNumber);
            Set<String> units = getApplicableUnits(proposal);
            String costShareAdministratorTypeCode = getCostShareAdministratorTypeCode();
            if (units != null) {
                result = units.stream().
                        filter(unit -> StringUtils.isNotBlank(unit)).
                        map(unit -> unitService.retrieveUnitAdministratorsByUnitNumberAndType(unit, costShareAdministratorTypeCode)).
                        flatMap(l -> l.stream()).
                        collect(Collectors.toList());
            }
        }
        return result;
    }

    public String getCostShareAdministratorTypeCode() {
        return parameterService.getParameterValueAsString(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT,
                Constants.KC_ALL_PARAMETER_DETAIL_TYPE_CODE, Constants.COST_SHARE_ADMINISTRATOR_TYPE_CODE);
    }

	public Set<String> getApplicableUnits(DevelopmentProposal proposal) {
        ProposalDevelopmentBudgetExt budget = proposal.getFinalBudget();
        if (Objects.isNull(budget) || Objects.isNull(budget.getBudgetCostShares()) || budget.getBudgetCostShares().size() == 0) {
            return new HashSet<>();
        }

		return budget.getBudgetCostShares().stream()
                .filter(budgetCostShare -> budgetCostShare.getUnit() != null)
                .map(budgetCostShare -> budgetCostShare.getUnit().getUnitNumber())
                .collect(Collectors.toSet());
	}

}
