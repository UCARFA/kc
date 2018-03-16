package org.kuali.coeus.common.api;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public class BudgetRateAndBaseDto {

    private String rateClassCode;
    private String rateTypeCode;
    private ScaleTwoDecimal appliedRate;
    private ScaleTwoDecimal calculatedCost;
    private ScaleTwoDecimal baseCost;

    public String getRateClassCode() {
        return rateClassCode;
    }

    public void setRateClassCode(String rateClassCode) {
        this.rateClassCode = rateClassCode;
    }

    public String getRateTypeCode() {
        return rateTypeCode;
    }

    public void setRateTypeCode(String rateTypeCode) {
        this.rateTypeCode = rateTypeCode;
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

    public ScaleTwoDecimal getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(ScaleTwoDecimal baseCost) {
        this.baseCost = baseCost;
    }
}
