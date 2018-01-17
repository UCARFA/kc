/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.income;


import org.kuali.coeus.common.budget.impl.core.ValidationHelper;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRule;
import org.kuali.coeus.common.framework.ruleengine.KcEventMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@KcBusinessRule
public class BudgetProjectIncomeRule {

	@Autowired
	@Qualifier("validationHelper")
    private ValidationHelper validationHelper;

    
    @KcEventMethod
    public boolean processAddBudgetProjectIncomeBusinessRules(AddBudgetProjectIncomeEvent addBudgetIncomeEvent) {
        BudgetProjectIncome projectIncome = addBudgetIncomeEvent.getBudgetProjectIncome();
        return areRequiredRulesSatisfied(projectIncome) && isProjectIncomeAmountValid(projectIncome);
    }

    private boolean isProjectIncomeAmountValid(BudgetProjectIncome budgetProjectIncome) {
        return validationHelper.checkValuePositive(budgetProjectIncome.getProjectIncome(), "newBudgetProjectIncome.projectIncome", "error.projectIncome.negativeOrZero", (String[])null);
    }

    /**
     * This method checks each required field, tracking validation state
     * @param budgetProjectIncome The Budget Project Income
     * @return Validation state; true if all required fields are not null, and if String, not empty
     */
    private boolean areRequiredRulesSatisfied(BudgetProjectIncome budgetProjectIncome) {
        boolean valid = validationHelper.checkRequiredField(budgetProjectIncome.getBudgetPeriodNumber(), "newBudgetProjectIncome.budgetPeriod", "Budget Period");
        valid &= validationHelper.checkRequiredField(budgetProjectIncome.getProjectIncome(), "newBudgetProjectIncome.projectIncome", "Project Income");
        valid &= validationHelper.checkRequiredField(budgetProjectIncome.getDescription(), "newBudgetProjectIncome.description", "Description");
        
        return valid;
    }

	protected ValidationHelper getValidationHelper() {
		return validationHelper;
	}

	public void setValidationHelper(ValidationHelper validationHelper) {
		this.validationHelper = validationHelper;
	}

}
