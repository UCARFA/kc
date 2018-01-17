/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetEventBase;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;

public class AddPersonnelBudgetEvent extends BudgetEventBase {

	private BudgetPeriod budgetPeriod;
	private BudgetLineItem budgetLineItem;
	private BudgetPersonnelDetails budgetPersonnelDetails;
	private String errorKey;
	
	public AddPersonnelBudgetEvent(Budget budget, BudgetPeriod budgetPeriod, BudgetLineItem budgetLineItem, BudgetPersonnelDetails budgetPersonnelDetails,
			String errorKey) {
		super(budget);
		this.budgetPeriod = budgetPeriod;
		this.budgetLineItem = budgetLineItem;
		this.budgetPersonnelDetails = budgetPersonnelDetails;
		this.errorKey = errorKey;
	}

	public BudgetLineItem getBudgetLineItem() {
		return budgetLineItem;
	}

	public void setBudgetLineItem(BudgetLineItem budgetLineItem) {
		this.budgetLineItem = budgetLineItem;
	}

	public BudgetPersonnelDetails getBudgetPersonnelDetails() {
		return budgetPersonnelDetails;
	}

	public void setBudgetPersonnelDetails(
			BudgetPersonnelDetails budgetPersonnelDetails) {
		this.budgetPersonnelDetails = budgetPersonnelDetails;
	}

	public BudgetPeriod getBudgetPeriod() {
		return budgetPeriod;
	}

	public void setBudgetPeriod(BudgetPeriod budgetPeriod) {
		this.budgetPeriod = budgetPeriod;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

}
