/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.distribution;

import org.kuali.coeus.common.budget.framework.distribution.BudgetUnrecoveredFandA;
import org.kuali.coeus.common.budget.impl.core.ValidationHelper;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRule;
import org.kuali.coeus.common.framework.ruleengine.KcEventMethod;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * ProcessDefinitionDefinitiones Budget Project Income rules
 */
@KcBusinessRule("budgetUnrecoveredFandARule")
public class BudgetUnrecoveredFandARuleImpl {

private static final String ADD_ERROR_KEY = "error.custom";
    
    /**
     * Provides general validation support
     */
	@Autowired
	@Qualifier("validationHelper")
    private ValidationHelper validationHelper;

    /**
     * This method ensures that an added BudgetCostShare won't duplicate another. A duplicate record would have the same source account, share amount, 
     * and fiscal year as another already in the list.
     */
	@KcEventMethod
    public boolean processAddBudgetUnrecoveredFandABusinessRules(AddBudgetUnrecoveredFandAEvent event) {
        return !areDuplicatesPresent(event.getBudget(), event.getBudgetUnrecoveredFandA());
    }

    private boolean areDuplicatesPresent(Budget budget, BudgetUnrecoveredFandA testBudgetUnrecoveredFandA) {
        boolean duplicate = false;
        
        if(testBudgetUnrecoveredFandA == null) {
            return duplicate;
        }
    
        List<BudgetUnrecoveredFandA> budgetUnrecoveredFandAs = budget.getBudgetUnrecoveredFandAs();
        for(BudgetUnrecoveredFandA budgetUnrecoveredFandA: budgetUnrecoveredFandAs) {
            duplicate = checkForDuplicateFields(testBudgetUnrecoveredFandA, budgetUnrecoveredFandA);
            if(duplicate) { break; }
        }

        return duplicate;
    }
    
    /** 
     * This method checks if two BudgetCostShare objects are duplicates, meaning the fiscalYear, shareAmount, and sourceAccount are equal
     */
    private boolean checkForDuplicateFields(BudgetUnrecoveredFandA testBudgetUnrecoveredFandA, BudgetUnrecoveredFandA budgetUnrecoveredFandA) {
        boolean duplicate = testBudgetUnrecoveredFandA.equals(budgetUnrecoveredFandA);
        if(duplicate) {
            GlobalVariables.getMessageMap().putError("newUnrecoveredFandA.*", ADD_ERROR_KEY, "A duplicate Unrecovered F&A exists in the table");
        }
        return duplicate;
    }

	public ValidationHelper getValidationHelper() {
		return validationHelper;
	}

	public void setValidationHelper(ValidationHelper validationHelper) {
		this.validationHelper = validationHelper;
	}
}
