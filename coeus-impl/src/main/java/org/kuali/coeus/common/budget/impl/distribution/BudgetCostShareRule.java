/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.distribution;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.distribution.BudgetCostShare;
import org.kuali.coeus.common.framework.costshare.CostShareRuleResearchDocumentBase;
import org.kuali.coeus.common.framework.ruleengine.KcBusinessRule;
import org.kuali.coeus.common.framework.ruleengine.KcEventMethod;
import org.kuali.rice.krad.util.GlobalVariables;

@KcBusinessRule("budgetCostShareRule")
public class BudgetCostShareRule extends CostShareRuleResearchDocumentBase {

    private static final String ADD_ERROR_KEY = "error.custom";
    
    @KcEventMethod
    public boolean processAddBudgetCostShareBusinessRules(AddBudgetCostShareEvent budgetCostShareEvent) {
        boolean retVal = !areDuplicatesPresent(budgetCostShareEvent.getBudget(), budgetCostShareEvent.getBudgetCostShare());
        retVal &= validateProjectPeriod(budgetCostShareEvent);
        retVal &= validateUnit(budgetCostShareEvent.getBudgetCostShare().getUnitNumber(), "newBudgetCostShare.unitNumber");
        return retVal;
    }

    /**
     * This method ensures that an added BudgetCostShare won't duplicate another. A duplicate record would have the same source
     * account, share amount, and fiscal year as another already in the list.
     */
    protected boolean areDuplicatesPresent(Budget budget, BudgetCostShare testBudgetCostShare) {

        if (testBudgetCostShare == null) {
            return false;
        }

        boolean duplicate = false;

        for (BudgetCostShare budgetCostShare : budget.getBudgetCostShares()) {
            duplicate = checkForDuplicateFields(testBudgetCostShare, budgetCostShare);
            if (duplicate) {
                break;
            }
        }
        return duplicate;
    }

    /**
     * This method checks if two BudgetCostShare objects are duplicates, meaning the fiscalYear, shareAmount, and sourceAccount are
     * equal.
     */
    private boolean checkForDuplicateFields(BudgetCostShare testBudgetCostShare,
                                            BudgetCostShare budgetCostShare) {
        boolean duplicate = testBudgetCostShare.equals(budgetCostShare);
        if (duplicate) {
            GlobalVariables.getMessageMap().putError("newCostShare.*", ADD_ERROR_KEY,
                    "A Cost Share with the same Fiscal Year, Source Account and Amount exists in the table");
        }
        return duplicate;
    }

    private boolean validateProjectPeriod(AddBudgetCostShareEvent budgetCostShareEvent) {
        String projectPeriodField = "newBudgetCostShare.projectPeriod";
        int numberOfProjectPeriods = budgetCostShareEvent.getBudget().getBudgetPeriods().size();
        return this.validateProjectPeriod(budgetCostShareEvent.getBudgetCostShare().getProjectPeriod(), projectPeriodField, numberOfProjectPeriods);
    }
}
