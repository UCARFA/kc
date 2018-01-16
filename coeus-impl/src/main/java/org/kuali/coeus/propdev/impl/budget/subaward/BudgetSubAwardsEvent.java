/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.subaward;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetEventBase;

public class BudgetSubAwardsEvent extends BudgetEventBase {

	private BudgetSubAwards budgetSubAwards;
	
	public BudgetSubAwardsEvent(BudgetSubAwards budgetSubAwards, Budget budget, String errorPath) {
		super(budget, errorPath);
		this.budgetSubAwards = budgetSubAwards;
	}

	public BudgetSubAwards getBudgetSubAwards() {
		return budgetSubAwards;
	}

	public void setBudgetSubAwards(BudgetSubAwards budgetSubAwards) {
		this.budgetSubAwards = budgetSubAwards;
	}
}
