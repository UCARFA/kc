/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core;

import java.util.List;

import org.kuali.coeus.propdev.impl.budget.core.ProposalBudgetForm;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.krad.uif.view.ViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("budgetPersonnelCostElementValuesFinder")
public class BudgetPersonnelCostElementValuesFinder extends CostElementValuesFinder {
    
	@Autowired
    @Qualifier("parameterService")
    private ParameterService parameterService;
	
    @Override
    public List<KeyValue> getKeyValues(ViewModel model) {
        String unitNumber = ((ProposalBudgetForm)model).getDevelopmentProposal().getUnitNumber();
        return super.getKeyValues(getPersonnelBudgetCategoryTypeCode(), true, null, unitNumber);
    }
    
    private String getPersonnelBudgetCategoryTypeCode() {
        return this.getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_BUDGET, ParameterConstants.DOCUMENT_COMPONENT,Constants.BUDGET_CATEGORY_TYPE_PERSONNEL);
    }

	public ParameterService getParameterService() {
		return parameterService;
	}

	public void setParameterService(ParameterService parameterService) {
		this.parameterService = parameterService;
	}
}
