/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.budget.framework.income;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.io.Serializable;

public class BudgetPeriodIncomeTotal implements Serializable {
    private Integer budgetPeriodNumber;
    private ScaleTwoDecimal projectIncomePeriodTotal;

    public BudgetPeriodIncomeTotal ( Integer budgetPeriodNumber, ScaleTwoDecimal projectIncomePeriodTotal){
        setBudgetPeriodNumber(budgetPeriodNumber);
        setProjectIncomePeriodTotal(projectIncomePeriodTotal);
    }

    public Integer getBudgetPeriodNumber() {
        return budgetPeriodNumber;
    }

    public void setBudgetPeriodNumber(Integer budgetPeriodNumber) {
        this.budgetPeriodNumber = budgetPeriodNumber;
    }

    public ScaleTwoDecimal getProjectIncomePeriodTotal() {
        return projectIncomePeriodTotal;
    }

    public void setProjectIncomePeriodTotal(ScaleTwoDecimal projectIncomePeriodTotal) {
        this.projectIncomePeriodTotal = projectIncomePeriodTotal;
    }
    
}
