/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.nonpersonnel;

import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.core.BudgetEventBase;
import org.kuali.coeus.common.budget.framework.nonpersonnel.BudgetFormulatedCostDetail;

public class AddFormulatedCostBudgetEvent extends BudgetEventBase {

	private BudgetFormulatedCostDetail formulatedCostDetail;
	
	public AddFormulatedCostBudgetEvent(Budget budget, String errorPath, BudgetFormulatedCostDetail formulatedCostDetail) {
		super(budget, errorPath);
		this.formulatedCostDetail = formulatedCostDetail;
	}

	public BudgetFormulatedCostDetail getFormulatedCostDetail() {
		return formulatedCostDetail;
	}

	public void setFormulatedCostDetail(
			BudgetFormulatedCostDetail formulatedCostDetail) {
		this.formulatedCostDetail = formulatedCostDetail;
	}



}
