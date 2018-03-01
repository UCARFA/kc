package org.kuali.coeus.common.api;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public class BudgetRateAndBaseDto {

    private String rateClassCode;
    private ScaleTwoDecimal appliedRate;
    private ScaleTwoDecimal calculatedCost;

    public String getRateClassCode() {
        return rateClassCode;
    }

    public void setRateClassCode(String rateClassCode) {
        this.rateClassCode = rateClassCode;
    }

    public ScaleTwoDecimal getAppliedRate() {
        return appliedRate;
    }

    public void setAppliedRate(ScaleTwoDecimal appliedRate) {
        this.appliedRate = appliedRate;
    }

    public ScaleTwoDecimal getCalculatedCost() {
        return calculatedCost;
    }

    public void setCalculatedCost(ScaleTwoDecimal calculatedCost) {
        this.calculatedCost = calculatedCost;
    }
}
