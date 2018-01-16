/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.personnel;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetLineItem;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetSaveLineItemPeriodEvent;
import org.kuali.coeus.common.budget.framework.period.BudgetPeriod;

public class BudgetAddPersonnelPeriodEvent extends BudgetSaveLineItemPeriodEvent {

	private BudgetPersonnelDetails budgetPersonnelDetails;
	private String errorKeyPerson;

	public BudgetAddPersonnelPeriodEvent(Budget budget, BudgetPeriod budgetPeriod, BudgetLineItem budgetLineItem,
                                         BudgetPersonnelDetails budgetPersonnelDetails, String errorPath) {
		super(budget, budgetPeriod, budgetLineItem, errorPath); 
		this.budgetPersonnelDetails = budgetPersonnelDetails;
	}

	public BudgetAddPersonnelPeriodEvent(Budget budget, BudgetPeriod budgetPeriod, BudgetLineItem budgetLineItem,
            BudgetPersonnelDetails budgetPersonnelDetails, String errorPath, String errorKeyPerson) {
		super(budget, budgetPeriod, budgetLineItem, errorPath); 
		this.budgetPersonnelDetails = budgetPersonnelDetails;
		this.errorKeyPerson = errorKeyPerson;
	}
	
	
	public BudgetPersonnelDetails getBudgetPersonnelDetails() {
		return budgetPersonnelDetails;
	}

	public void setBudgetPersonnelDetails(BudgetPersonnelDetails budgetPersonnelDetails) {
		this.budgetPersonnelDetails = budgetPersonnelDetails;
	}

	public String getErrorKeyPerson() {
		return errorKeyPerson;
	}

	public void setErrorKeyPerson(String errorKeyPerson) {
		this.errorKeyPerson = errorKeyPerson;
	}
}
