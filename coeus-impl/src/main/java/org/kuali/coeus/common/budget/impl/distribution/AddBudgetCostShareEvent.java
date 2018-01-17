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

public class AddBudgetCostShareEvent {

    private BudgetCostShare budgetCostShare;
    private Budget budget;
    
    public AddBudgetCostShareEvent(Budget budget, BudgetCostShare budgetCostShare) {
    	this.budget = budget;
        this.budgetCostShare = budgetCostShare;
    }

    public BudgetCostShare getBudgetCostShare() {
        return budgetCostShare;
    }

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public void setBudgetCostShare(BudgetCostShare budgetCostShare) {
		this.budgetCostShare = budgetCostShare;
	}

}
