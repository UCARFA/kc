/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api;


import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.kuali.coeus.instprop.impl.api.customSerializers.CustomSqlDateSerializer;
import org.kuali.coeus.instprop.impl.api.customSerializers.ScaleTwoDecimalSerializer;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;
import java.util.List;

public class BudgetLineItemDto {

    private ScaleTwoDecimal costSharingAmount;
    private Long budgetLineItemId;
    private Integer lineItemNumber;
    private Boolean applyInRateFlag;
    private Integer basedOnLineItem;
    private String budgetJustification;
    private String groupName;
    @JsonDeserialize(using = CustomSqlDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date endDate;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal lineItemCost;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal obligatedAmount;
    private String hierarchyProposalNumber;
    private String lineItemDescription;
    private Integer lineItemSequence;
    private Boolean onOffCampusFlag;
    private Integer quantity;
    @JsonDeserialize(using = CustomSqlDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date startDate;
    @JsonDeserialize(using = ScaleTwoDecimalSerializer.class)
    private ScaleTwoDecimal underrecoveryAmount;
    private Boolean formulatedCostElementFlag;
    private String costElement;
    private boolean applyRateFlag;

    @JsonIgnore
    @Property(translate = true)
    private CostElementDto costElementBO;
    private String budgetCategoryCode;
    private String budgetCategoryTypeCode;
    @JsonIgnore
    @Property(translate = true)
    private BudgetCategoryDto budgetCategory;
    @JsonProperty(value="budgetPersonnelDetailsList")
    @CollectionProperty(source="budgetPersonnelDetailsList", itemClass= BudgetPersonnelDetailsDto.class)
    private List<BudgetPersonnelDetailsDto> budgetPersonnelDetailsList;
    @JsonProperty(value="budgetLineItemCalculatedAmounts")
    @CollectionProperty(source="budgetLineItemCalculatedAmounts", itemClass= BudgetLineItemCalculatedAmountDto.class)
    private List<BudgetLineItemCalculatedAmountDto> budgetLineItemCalculatedAmounts;
    @JsonProperty(value="budgetRateAndBaseList")
    @CollectionProperty(source="budgetRateAndBaseList", itemClass=BudgetRateAndBaseDto.class)
    private List<BudgetRateAndBaseDto> budgetRateAndBaseList;

    public String getBudgetCategoryTypeCode() {
        return budgetCategoryTypeCode;
    }

    public void setBudgetCategoryTypeCode(String budgetCategoryTypeCode) {
        this.budgetCategoryTypeCode = budgetCategoryTypeCode;
    }

    public ScaleTwoDecimal getCostSharingAmount() {
        return costSharingAmount;
    }

    public void setCostSharingAmount(ScaleTwoDecimal costSharingAmount) {
        this.costSharingAmount = costSharingAmount;
    }

    public Long getBudgetLineItemId() {
        return budgetLineItemId;
    }

    public void setBudgetLineItemId(Long budgetLineItemId) {
        this.budgetLineItemId = budgetLineItemId;
    }

    public Integer getLineItemNumber() {
        return lineItemNumber;
    }

    public void setLineItemNumber(Integer lineItemNumber) {
        this.lineItemNumber = lineItemNumber;
    }

    public Boolean getApplyInRateFlag() {
        return applyInRateFlag;
    }

    public void setApplyInRateFlag(Boolean applyInRateFlag) {
        this.applyInRateFlag = applyInRateFlag;
    }

    public Integer getBasedOnLineItem() {
        return basedOnLineItem;
    }

    public void setBasedOnLineItem(Integer basedOnLineItem) {
        this.basedOnLineItem = basedOnLineItem;
    }

    public String getBudgetCategoryCode() {
        return budgetCategoryCode;
    }

    public void setBudgetCategoryCode(String budgetCategoryCode) {
        this.budgetCategoryCode = budgetCategoryCode;
    }

    public String getBudgetJustification() {
        return budgetJustification;
    }

    public void setBudgetJustification(String budgetJustification) {
        this.budgetJustification = budgetJustification;
    }

    public String getCostElement() {
        return costElement;
    }

    public void setCostElement(String costElement) {
        this.costElement = costElement;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ScaleTwoDecimal getLineItemCost() {
        return lineItemCost;
    }

    public void setLineItemCost(ScaleTwoDecimal lineItemCost) {
        this.lineItemCost = lineItemCost;
    }

    public String getLineItemDescription() {
        return lineItemDescription;
    }

    public void setLineItemDescription(String lineItemDescription) {
        this.lineItemDescription = lineItemDescription;
    }

    public Integer getLineItemSequence() {
        return lineItemSequence;
    }

    public void setLineItemSequence(Integer lineItemSequence) {
        this.lineItemSequence = lineItemSequence;
    }

    public Boolean getOnOffCampusFlag() {
        return onOffCampusFlag;
    }

    public void setOnOffCampusFlag(Boolean onOffCampusFlag) {
        this.onOffCampusFlag = onOffCampusFlag;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ScaleTwoDecimal getUnderrecoveryAmount() {
        return underrecoveryAmount;
    }

    public void setUnderrecoveryAmount(ScaleTwoDecimal underrecoveryAmount) {
        this.underrecoveryAmount = underrecoveryAmount;
    }

    public Boolean getFormulatedCostElementFlag() {
        return formulatedCostElementFlag;
    }

    public void setFormulatedCostElementFlag(Boolean formulatedCostElementFlag) {
        this.formulatedCostElementFlag = formulatedCostElementFlag;
    }

    public List<BudgetPersonnelDetailsDto> getBudgetPersonnelDetailsList() {
        return budgetPersonnelDetailsList;
    }

    public void setBudgetPersonnelDetailsList(List<BudgetPersonnelDetailsDto> budgetPersonnelDetailsList) {
        this.budgetPersonnelDetailsList = budgetPersonnelDetailsList;
    }
    @JsonProperty
    public CostElementDto getCostElementBO() {
        return costElementBO;
    }
    @JsonIgnore
    public void setCostElementBO(CostElementDto costElementBO) {
        this.costElementBO = costElementBO;
    }
    @JsonProperty
    public BudgetCategoryDto getBudgetCategory() {
        return budgetCategory;
    }
    @JsonIgnore
    public void setBudgetCategory(BudgetCategoryDto budgetCategory) {
        this.budgetCategory = budgetCategory;
    }

    public List<BudgetLineItemCalculatedAmountDto> getBudgetLineItemCalculatedAmounts() {
        return budgetLineItemCalculatedAmounts;
    }

    public void setBudgetLineItemCalculatedAmounts(List<BudgetLineItemCalculatedAmountDto> budgetLineItemCalculatedAmounts) {
        this.budgetLineItemCalculatedAmounts = budgetLineItemCalculatedAmounts;
    }

    public ScaleTwoDecimal getObligatedAmount() {
        return obligatedAmount;
    }

    public void setObligatedAmount(ScaleTwoDecimal obligatedAmount) {
        this.obligatedAmount = obligatedAmount;
    }

    public boolean isApplyRateFlag() {
        return applyRateFlag;
    }

    public void setApplyRateFlag(boolean applyRateFlag) {
        this.applyRateFlag = applyRateFlag;
    }

    public String getHierarchyProposalNumber() {
        return hierarchyProposalNumber;
    }

    public void setHierarchyProposalNumber(String hierarchyProposalNumber) {
        this.hierarchyProposalNumber = hierarchyProposalNumber;
    }

    public List<BudgetRateAndBaseDto> getBudgetRateAndBaseList() {
        return budgetRateAndBaseList;
    }

    public void setBudgetRateAndBaseList(List<BudgetRateAndBaseDto> budgetRateAndBaseList) {
        this.budgetRateAndBaseList = budgetRateAndBaseList;
    }
}
