/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItemBase;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;
import org.kuali.coeus.common.budget.framework.rate.BudgetRate;

import java.util.Collection;
import java.util.Map;

public interface BudgetService<T extends BudgetParent>  {
    

    Budget addBudgetVersion(BudgetParentDocument<T> budgetParent, String versionName, Map<String, Object> options);
    
    /**
     * check if this line item CE has inflation rate
     * @param budgetLineItem
     * @return
     */
    boolean validInflationCeRate(BudgetLineItemBase budgetLineItem);
    
    String getActivityTypeForBudget(Budget budget);

    Collection<BudgetRate> getSavedProposalRates(Budget budgetToOpen);

    boolean isBudgetVersionNameValid(BudgetParent parent, String versionName);

    /**
     * Returns a new finalized BudgetDocument with the data from the given BudgetDocument copied over.
     */
    Budget copyBudgetVersion(Budget budget, boolean onlyOnePeriod);
    
    void populateNewBudgetLineItem(BudgetLineItem newBudgetLineItem, BudgetPeriod budgetPeriod);

    boolean isValidSourceAccountCostShareType(String validationMessageType, CostShare budgetCostShare, String costShareField);


    }
