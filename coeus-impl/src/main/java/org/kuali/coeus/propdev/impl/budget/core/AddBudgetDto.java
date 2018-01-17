/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget.core;

import java.io.Serializable;

public class AddBudgetDto implements Serializable {

	private String budgetName;
	private Boolean summaryBudget;
	private Boolean modularBudget;
	private Long originalBudgetId;
	private Boolean allPeriods;

	public String getBudgetName() {
		return budgetName;
	}

	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}

	public Boolean getSummaryBudget() {
		return summaryBudget;
	}

	public void setSummaryBudget(Boolean summaryBudget) {
		this.summaryBudget = summaryBudget;
	}

	public Boolean getModularBudget() {
		return modularBudget;
	}

	public void setModularBudget(Boolean modularBudget) {
		this.modularBudget = modularBudget;
	}

	public Long getOriginalBudgetId() {
		return originalBudgetId;
	}

	public void setOriginalBudgetId(Long originalBudgetId) {
		this.originalBudgetId = originalBudgetId;
	}

	public Boolean getAllPeriods() {
		return allPeriods;
	}

	public void setAllPeriods(Boolean allPeriods) {
		this.allPeriods = allPeriods;
	}
	
}
