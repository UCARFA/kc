/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.print;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public class BudgetDataPeriodVO {
	private int budgetPeriodId;
	private ScaleTwoDecimal periodCost;

	public int getBudgetPeriodId() {
		return budgetPeriodId;
	}

	public void setBudgetPeriodId(int budgetPeriofId) {
		this.budgetPeriodId = budgetPeriofId;
	}

	public ScaleTwoDecimal getPeriodCost() {
		return periodCost;
	}

	public void setPeriodCost(ScaleTwoDecimal periodCost) {
		this.periodCost = periodCost;
	}
}
