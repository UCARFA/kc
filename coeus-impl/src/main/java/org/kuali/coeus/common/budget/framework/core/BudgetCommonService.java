/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import java.util.Map;

import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;

/**
 * This interface has services which required different implementations in AwardBudget and ProposalBudget modules 
 */
public interface BudgetCommonService<T extends BudgetParent> extends BudgetService<T> {
    /**
     * Returns a new finalized BudgetDocument based on the given ProposalDevelopmentDocument and documentDescription.
     */
    public Budget getNewBudgetVersion(BudgetParentDocument<T> parent, String documentDescription, Map<String, Object> options);
    /**
     * Returns a new finalized BudgetDocument with the data from the given BudgetDocument copied over.
     */
    public Budget copyBudgetVersion(Budget budget);
    
    @Override
    public Budget copyBudgetVersion(Budget budget, boolean onlyOnePeriod);
    
    /**
     * This method is to check whether Budget Summary calculated amounts for a BudgetPeriod 
     * have been modified on AwardBudgetSummary screen
     * @return true if there is any change
     */
    public boolean isRateOverridden(BudgetPeriod budgetPeriod);
    
    /**
     * 
     * This method is recalculate the budget. For Proposal Budget, recalcuate is same as calculate. 
     * For Award Budget, it removes Award Budget Sumamry Calc Amounts before the calculation 
     * @param budget
     */
    public void recalculateBudget(Budget budget);
    /**
     * 
     * This method will take care of summing up all line item costs or summary line items to Period totals
     * @param budget
     */
    public void calculateBudgetOnSave(Budget budget);

    /**
     * Make sure its ok to add a new budget version. This is primarily used for the award budgets
     * as the other budgets status affects whether a new budget may be created. This method
     * should add error messages as to why the budget may not be created.
     * @param parentDocument
     * @return true if ok to add new budget, false otherwise
     */
    boolean validateAddingNewBudget(BudgetParentDocument<T> parentDocument);
    public void recalculateBudgetPeriod(Budget budget, BudgetPeriod budgetPeriod);

}
