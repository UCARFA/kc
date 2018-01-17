/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.common.budget.framework.core.CostElement;

public class AwardBudgetPeriodSummaryCalculatedAmount extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = -8085114536868213976L;

    private Long awardBudgetPeriodSummaryCalculatedAmountId;

    private Long budgetPeriodId;

    private String costElement;

    private boolean onOffCampusFlag;

    private String rateClassType;

    private ScaleTwoDecimal calculatedCost;

    private ScaleTwoDecimal calculatedCostSharing;

    private CostElement costElementBO;

    public Long getAwardBudgetPeriodSummaryCalculatedAmountId() {
        return awardBudgetPeriodSummaryCalculatedAmountId;
    }

    public void setAwardBudgetPeriodSummaryCalculatedAmountId(Long awardBudgetPeriodSummaryCalculatedAmountId) {
        this.awardBudgetPeriodSummaryCalculatedAmountId = awardBudgetPeriodSummaryCalculatedAmountId;
    }

    public Long getBudgetPeriodId() {
        return budgetPeriodId;
    }

    public void setBudgetPeriodId(Long budgetPeriodId) {
        this.budgetPeriodId = budgetPeriodId;
    }

    public String getCostElement() {
        return costElement;
    }

    public void setCostElement(String costElement) {
        this.costElement = costElement;
    }

    public boolean getOnOffCampusFlag() {
        return onOffCampusFlag;
    }

    public void setOnOffCampusFlag(boolean onOffCampusFlag) {
        this.onOffCampusFlag = onOffCampusFlag;
    }

    public String getRateClassType() {
        return rateClassType;
    }

    public void setRateClassType(String rateClassType) {
        this.rateClassType = rateClassType;
    }

    public ScaleTwoDecimal getCalculatedCost() {
        return calculatedCost;
    }

    public void setCalculatedCost(ScaleTwoDecimal calculatedCost) {
        this.calculatedCost = calculatedCost;
    }

    public ScaleTwoDecimal getCalculatedCostSharing() {
        return calculatedCostSharing;
    }

    public void setCalculatedCostSharing(ScaleTwoDecimal calculatedCostSharing) {
        this.calculatedCostSharing = calculatedCostSharing;
    }

    public CostElement getCostElementBO() {
        return costElementBO;
    }

    public void setCostElementBO(CostElement costElementBO) {
        this.costElementBO = costElementBO;
    }
}
