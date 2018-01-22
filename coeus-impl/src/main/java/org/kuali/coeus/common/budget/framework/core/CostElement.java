/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.coeus.common.budget.api.core.CostElementContract;
import org.kuali.coeus.common.budget.framework.core.category.BudgetCategory;
import org.kuali.coeus.common.budget.framework.rate.ValidCeRateType;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.persistence.BooleanNFConverter;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.data.jpa.FilterGenerator;
import org.kuali.rice.krad.data.jpa.converters.BooleanYNConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COST_ELEMENT")
public class CostElement extends KcPersistableBusinessObjectBase implements Comparable<CostElement>, MutableInactivatable, CostElementContract {

    @Id
    @Column(name = "COST_ELEMENT")
    private String costElement;

    @Column(name = "BUDGET_CATEGORY_CODE")
    private String budgetCategoryCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ON_OFF_CAMPUS_FLAG")
    @Convert(converter = BooleanNFConverter.class)
    private Boolean onOffCampusFlag;

    @Column(name = "ACTIVE_FLAG")
    @Convert(converter = BooleanYNConverter.class)
    private boolean active;

    @Column(name = "FIN_OBJECT_CODE")
    private String financialObjectCode;

    @Column(name = "UNIT_NUMBER")
    private String unitNumber;

    @ManyToOne(targetEntity = Unit.class, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "UNIT_NUMBER", referencedColumnName = "UNIT_NUMBER", insertable = false, updatable = false)
    private Unit unit;

    @OneToMany(mappedBy = "costElementBo", fetch = FetchType.EAGER)
    @FilterGenerator(attributeName = "active", attributeValue = "true")
    private List<ValidCeRateType> validCeRateTypes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "BUDGET_CATEGORY_CODE", referencedColumnName = "BUDGET_CATEGORY_CODE", insertable = false, updatable = false)
    private BudgetCategory budgetCategory;

    @Transient
    private String budgetCategoryTypeCode;

    public CostElement() {
        validCeRateTypes = new ArrayList<>();
    }

    @Override
    public String getFinancialObjectCode() {
        return financialObjectCode;
    }

    public void setFinancialObjectCode(String financialObjectCode) {
        this.financialObjectCode = financialObjectCode;
    }

    @Override
    public String getCostElement() {
        return costElement;
    }

    public void setCostElement(String costElement) {
        this.costElement = costElement;
    }

    @Override
    public String getBudgetCategoryCode() {
        return budgetCategoryCode;
    }

    public void setBudgetCategoryCode(String budgetCategoryCode) {
        this.budgetCategoryCode = budgetCategoryCode;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Boolean getOnOffCampusFlag() {
        return onOffCampusFlag;
    }

    public void setOnOffCampusFlag(Boolean onOffCampusFlag) {
        this.onOffCampusFlag = onOffCampusFlag;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public List<ValidCeRateType> getValidCeRateTypes() {
        return validCeRateTypes;
    }

    public void setValidCeRateTypes(List<ValidCeRateType> validCeRateTypes) {
        this.validCeRateTypes = validCeRateTypes;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public int compareTo(CostElement costElement) {
        return this.costElement.compareTo(costElement.costElement);
    }

    @Override
    public BudgetCategory getBudgetCategory() {
        return budgetCategory;
    }

    public void setBudgetCategory(BudgetCategory budgetCategory) {
        this.budgetCategory = budgetCategory;
    }

    public String getBudgetCategoryTypeCode() {
        return budgetCategoryTypeCode;
    }

    public void setBudgetCategoryTypeCode(String budgetCategoryTypeCode) {
        this.budgetCategoryTypeCode = budgetCategoryTypeCode;
    }
}
