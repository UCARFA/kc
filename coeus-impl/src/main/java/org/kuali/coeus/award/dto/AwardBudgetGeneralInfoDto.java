/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.kuali.coeus.common.api.RateClassDto;
import org.kuali.coeus.instprop.impl.api.customSerializers.CustomSqlDateSerializer;
import org.kuali.coeus.instprop.impl.api.customSerializers.ScaleTwoDecimalSerializer;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;

public class AwardBudgetGeneralInfoDto {
    private Long awardId;
    private Long budgetId;
    private Integer budgetVersionNumber;
    private String budgetInitiator;
    private String awardBudgetStatusCode;
    @JsonIgnore
    @Property(translate = true)
    private AwardBudgetStatusDto awardBudgetStatus;
    private String awardBudgetTypeCode;
    @JsonIgnore
    @Property(translate = true)
    private AwardBudgetTypeDto awardBudgetType;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal obligatedTotal = ScaleTwoDecimal.ZERO;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal obligatedAmount = ScaleTwoDecimal.ZERO;
    private String description;
    private String onOffCampusFlag;
    @JsonDeserialize(using = CustomSqlDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date endDate;
    @JsonDeserialize(using = CustomSqlDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date startDate;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalCost;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalDirectCost;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalIndirectCost;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal costSharingAmount;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal underrecoveryAmount;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalCostLimit;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal residualFunds;
    private String ohRateClassCode;
    @JsonIgnore
    @Property(translate = true, source = "rateClass")
    private RateClassDto ohRateClass;
    private String ohRateTypeCode;
    private String comments;
    private Boolean modularBudgetFlag = Boolean.FALSE;
    private String urRateClassCode;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalDirectCostLimit;
    private String name;

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public Integer getBudgetVersionNumber() {
        return budgetVersionNumber;
    }

    public void setBudgetVersionNumber(Integer budgetVersionNumber) {
        this.budgetVersionNumber = budgetVersionNumber;
    }

    public String getBudgetInitiator() {
        return budgetInitiator;
    }

    public void setBudgetInitiator(String budgetInitiator) {
        this.budgetInitiator = budgetInitiator;
    }

    public String getAwardBudgetStatusCode() {
        return awardBudgetStatusCode;
    }

    public void setAwardBudgetStatusCode(String awardBudgetStatusCode) {
        this.awardBudgetStatusCode = awardBudgetStatusCode;
    }

    public String getAwardBudgetTypeCode() {
        return awardBudgetTypeCode;
    }

    public void setAwardBudgetTypeCode(String awardBudgetTypeCode) {
        this.awardBudgetTypeCode = awardBudgetTypeCode;
    }

    public ScaleTwoDecimal getObligatedTotal() {
        return obligatedTotal;
    }

    public void setObligatedTotal(ScaleTwoDecimal obligatedTotal) {
        this.obligatedTotal = obligatedTotal;
    }

    public ScaleTwoDecimal getObligatedAmount() {
        return obligatedAmount;
    }

    public void setObligatedAmount(ScaleTwoDecimal obligatedAmount) {
        this.obligatedAmount = obligatedAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOnOffCampusFlag() {
        return onOffCampusFlag;
    }

    public void setOnOffCampusFlag(String onOffCampusFlag) {
        this.onOffCampusFlag = onOffCampusFlag;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ScaleTwoDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(ScaleTwoDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public ScaleTwoDecimal getTotalDirectCost() {
        return totalDirectCost;
    }

    public void setTotalDirectCost(ScaleTwoDecimal totalDirectCost) {
        this.totalDirectCost = totalDirectCost;
    }

    public ScaleTwoDecimal getTotalIndirectCost() {
        return totalIndirectCost;
    }

    public void setTotalIndirectCost(ScaleTwoDecimal totalIndirectCost) {
        this.totalIndirectCost = totalIndirectCost;
    }

    public ScaleTwoDecimal getCostSharingAmount() {
        return costSharingAmount;
    }

    public void setCostSharingAmount(ScaleTwoDecimal costSharingAmount) {
        this.costSharingAmount = costSharingAmount;
    }

    public ScaleTwoDecimal getUnderrecoveryAmount() {
        return underrecoveryAmount;
    }

    public void setUnderrecoveryAmount(ScaleTwoDecimal underrecoveryAmount) {
        this.underrecoveryAmount = underrecoveryAmount;
    }

    public ScaleTwoDecimal getTotalCostLimit() {
        return totalCostLimit;
    }

    public void setTotalCostLimit(ScaleTwoDecimal totalCostLimit) {
        this.totalCostLimit = totalCostLimit;
    }

    public ScaleTwoDecimal getResidualFunds() {
        return residualFunds;
    }

    public void setResidualFunds(ScaleTwoDecimal residualFunds) {
        this.residualFunds = residualFunds;
    }

    public String getOhRateClassCode() {
        return ohRateClassCode;
    }

    public void setOhRateClassCode(String ohRateClassCode) {
        this.ohRateClassCode = ohRateClassCode;
    }

    public String getOhRateTypeCode() {
        return ohRateTypeCode;
    }

    public void setOhRateTypeCode(String ohRateTypeCode) {
        this.ohRateTypeCode = ohRateTypeCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getModularBudgetFlag() {
        return modularBudgetFlag;
    }

    public void setModularBudgetFlag(Boolean modularBudgetFlag) {
        this.modularBudgetFlag = modularBudgetFlag;
    }

    public String getUrRateClassCode() {
        return urRateClassCode;
    }

    public void setUrRateClassCode(String urRateClassCode) {
        this.urRateClassCode = urRateClassCode;
    }

    public ScaleTwoDecimal getTotalDirectCostLimit() {
        return totalDirectCostLimit;
    }

    public void setTotalDirectCostLimit(ScaleTwoDecimal totalDirectCostLimit) {
        this.totalDirectCostLimit = totalDirectCostLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public AwardBudgetStatusDto getAwardBudgetStatus() {
        return awardBudgetStatus;
    }
    @JsonIgnore
    public void setAwardBudgetStatus(AwardBudgetStatusDto awardBudgetStatus) {
        this.awardBudgetStatus = awardBudgetStatus;
    }
    @JsonProperty
    public AwardBudgetTypeDto getAwardBudgetType() {
        return awardBudgetType;
    }
    @JsonIgnore
    public void setAwardBudgetType(AwardBudgetTypeDto awardBudgetType) {
        this.awardBudgetType = awardBudgetType;
    }

    @JsonProperty
    public RateClassDto getOhRateClass() {
        return ohRateClass;
    }
    @JsonIgnore
    public void setOhRateClass(RateClassDto ohRateClass) {
        this.ohRateClass = ohRateClass;
    }

}