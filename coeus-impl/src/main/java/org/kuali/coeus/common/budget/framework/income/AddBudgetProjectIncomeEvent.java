/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.income;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetEventBase;

public class AddBudgetProjectIncomeEvent extends BudgetEventBase {

	private BudgetProjectIncome budgetProjectIncome;
    
    public AddBudgetProjectIncomeEvent(Budget budget, BudgetProjectIncome budgetProjectIncome) {
		super(budget);
		this.budgetProjectIncome = budgetProjectIncome;
	}

    public BudgetProjectIncome getBudgetProjectIncome() {
        return budgetProjectIncome;
    }

}
