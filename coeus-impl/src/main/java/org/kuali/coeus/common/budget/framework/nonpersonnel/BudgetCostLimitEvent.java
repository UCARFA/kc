/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.nonpersonnel;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetEventBase;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;

public class BudgetCostLimitEvent extends BudgetEventBase {
	private BudgetLineItem budgetLineItem;
	private BudgetPeriod budgetPeriod;
	
	public BudgetCostLimitEvent(Budget budget, BudgetPeriod budgetPeriod, BudgetLineItem budgetLineItem, String errorPath) {
		super(budget, errorPath);
		this.budgetLineItem = budgetLineItem;
		this.budgetPeriod = budgetPeriod;
	}

	public BudgetLineItem getBudgetLineItem() {
		return budgetLineItem;
	}

	public void setBudgetLineItem(BudgetLineItem budgetLineItem) {
		this.budgetLineItem = budgetLineItem;
	}

	public BudgetPeriod getBudgetPeriod() {
		return budgetPeriod;
	}

	public void setBudgetPeriod(BudgetPeriod budgetPeriod) {
		this.budgetPeriod = budgetPeriod;
	}

}
