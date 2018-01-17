/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.rate;

import org.kuali.coeus.common.budget.framework.rate.FormulatedType;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public class UnitFormulatedCost extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 8388817616860002696L;
    private Long unitFormulatedCostId;
    private String formulatedTypeCode; 
    private String unitNumber; 
    private ScaleTwoDecimal unitCost;
    
    private Unit unit; 
    private FormulatedType formulatedType; 
    
    public Long getUnitFormulatedCostId() {
        return unitFormulatedCostId;
    }

    public void setUnitFormulatedCostId(Long unitFormulatedCostId) {
        this.unitFormulatedCostId = unitFormulatedCostId;
    }

    public UnitFormulatedCost() { 

    } 
    
    public String getFormulatedTypeCode() {
        return formulatedTypeCode;
    }

    public void setFormulatedTypeCode(String formulatedTypeCode) {
        this.formulatedTypeCode = formulatedTypeCode;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public ScaleTwoDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(ScaleTwoDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public FormulatedType getFormulatedType() {
        return formulatedType;
    }

    public void setFormulatedType(FormulatedType formulatedType) {
        this.formulatedType = formulatedType;
    }

}
