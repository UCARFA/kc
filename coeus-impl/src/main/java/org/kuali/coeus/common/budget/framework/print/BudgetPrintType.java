/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.framework.print;

/**
 * This class represents different types of reports for Budget Printing
 */
public enum BudgetPrintType {
	BUDGET_SUMMARY_REPORT("Budget Summary Report"), BUDGET_COST_SHARE_SUMMARY_REPORT(
			"Budget Costshare Summary Report"), INDUSTRIAL_CUMULATIVE_BUDGET_REPORT(
			"Industrial Cumulative Budget Report"), BUDGET_SALARY_REPORT(
			"Budget Salary Report"), BUDGET_TOTAL_REPORT("Budget Total Report"), BUDGET_SUMMARY_TOTAL_REPORT(
			"Budget Summary Total Report"), BUDGET_CUMULATIVE_REPORT("Budget Cumulative Report"), INDUSTRIAL_BUDGET_REPORT(
			"Industrial Budget Report");

	private final String budgetPrintType;

	BudgetPrintType(String budgetPrintType) {
		this.budgetPrintType = budgetPrintType;
	}

	public String getBudgetPrintType() {
		return budgetPrintType;
	}
}
