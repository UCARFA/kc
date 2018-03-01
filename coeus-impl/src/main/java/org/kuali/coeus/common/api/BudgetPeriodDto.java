/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api;

import com.codiform.moo.annotation.CollectionProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.kuali.coeus.common.api.BudgetLineItemDto;
import org.kuali.coeus.instprop.impl.api.customSerializers.CustomSqlDateSerializer;
import org.kuali.coeus.instprop.impl.api.customSerializers.ScaleTwoDecimalSerializer;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;
import java.util.List;

public class BudgetPeriodDto {

    private String comments;
    private ScaleTwoDecimal costSharingAmount;
    @JsonDeserialize(using = CustomSqlDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date endDate;
    @JsonDeserialize(using = CustomSqlDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date startDate;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalCost;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalCostLimit;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalDirectCost;
    private boolean overrideIndirectAndFringeRates = false;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalIndirectCost;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal totalFringeAmount;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal underrecoveryAmount;
    private Integer budgetPeriod;

    @JsonProperty(value="budgetLineItems")
    @CollectionProperty(source="budgetLineItems", itemClass= BudgetLineItemDto.class)
    private List<BudgetLineItemDto> budgetLineItems;
    private Integer numberOfParticipants;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal directCostLimit;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal expenseTotal;
    private Long budgetId;
    private Integer periodNumber;

    public boolean isOverrideIndirectAndFringeRates() {
        return overrideIndirectAndFringeRates;
    }

    public void setOverrideIndirectAndFringeRates(boolean overrideIndirectAndFringeRates) {
        this.overrideIndirectAndFringeRates = overrideIndirectAndFringeRates;
    }

    public Long getBudgetId() {
        return budgetId;
    }
    public Long setBudgetId(Long budgetId) {
        return this.budgetId = budgetId;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public ScaleTwoDecimal getCostSharingAmount() {
        return costSharingAmount;
    }
    public void setCostSharingAmount(ScaleTwoDecimal costSharingAmount) {
        this.costSharingAmount = costSharingAmount;
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
    public ScaleTwoDecimal getTotalCostLimit() {
        return totalCostLimit;
    }

    public void setTotalCostLimit(ScaleTwoDecimal totalCostLimit) {
        this.totalCostLimit = totalCostLimit;
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

    public ScaleTwoDecimal getUnderrecoveryAmount() {
        return underrecoveryAmount;
    }
    public void setUnderrecoveryAmount(ScaleTwoDecimal underrecoveryAmount) {
        this.underrecoveryAmount = underrecoveryAmount;
    }

    public List<BudgetLineItemDto> getBudgetLineItems() {
        return budgetLineItems;
    }
    public void setBudgetLineItems(List<BudgetLineItemDto> budgetLineItems) {
        this.budgetLineItems = budgetLineItems;
    }

    public ScaleTwoDecimal getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(ScaleTwoDecimal expenseTotal) {
        this.expenseTotal = expenseTotal;
    }

    public ScaleTwoDecimal getDirectCostLimit() {
        return directCostLimit;
    }

    public void setDirectCostLimit(ScaleTwoDecimal directCostLimit) {
        this.directCostLimit = directCostLimit;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public ScaleTwoDecimal getTotalFringeAmount() {
        return totalFringeAmount;
    }

    public void setTotalFringeAmount(ScaleTwoDecimal totalFringeAmount) {
        this.totalFringeAmount = totalFringeAmount;
    }

    public Integer getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(Integer periodNumber) {
        this.periodNumber = periodNumber;
    }

    public Integer getBudgetPeriod() {
        return budgetPeriod;
    }

    public void setBudgetPeriod(Integer budgetPeriod) {
        this.budgetPeriod = budgetPeriod;
    }
}