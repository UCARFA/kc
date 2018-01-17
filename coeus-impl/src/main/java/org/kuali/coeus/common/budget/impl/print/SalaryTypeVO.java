/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.print;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.util.List;

/**
 * This class having the budget salary calculated values.
 */
public class SalaryTypeVO {
	private String costElement;
	private String costElementCode;
	private String name;
	private ScaleTwoDecimal total;
	private List<BudgetDataPeriodVO> budgetPeriodVOs;

	public String getCostElement() {
		return costElement;
	}

	public void setCostElement(String costElement) {
		this.costElement = costElement;
	}

	public String getCostElementCode() {
		return costElementCode;
	}

	public void setCostElementCode(String costElementCode) {
		this.costElementCode = costElementCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScaleTwoDecimal getTotal() {
		return total;
	}

	public void setTotal(ScaleTwoDecimal total) {
		this.total = total;
	}

	public List<BudgetDataPeriodVO> getBudgetPeriodVOs() {
		return budgetPeriodVOs;
	}

	public void setBudgetPeriodVOs(List<BudgetDataPeriodVO> budgetPeriodVOs) {
		this.budgetPeriodVOs = budgetPeriodVOs;
	}
}
