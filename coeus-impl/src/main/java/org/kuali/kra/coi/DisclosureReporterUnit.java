/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.krad.util.KRADConstants;

public abstract class DisclosureReporterUnit extends KcPersistableBusinessObjectBase {
    private String unitName;
    private Unit unit; 
    
    public abstract String getUnitNumber();
    public abstract Long getReporterUnitId();
    public abstract void setUnitNumber(String unitNumber);
    public abstract boolean isLeadUnitFlag();

    public abstract void setLeadUnitFlag(boolean leadUnitFlag);

//    public abstract String getPersonId();

 
    public String getUnitName() {
        // first use getUnit(0 to see if unit needs to be refreshed
        if (getUnit() != null) {
            unitName = unit.getUnitName();
        }
        else {
            if (StringUtils.isNotBlank(getUnitNumber())) {
                unitName = "not found";
            }
            else {
                unitName = KRADConstants.EMPTY_STRING;
            }
        }
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Unit getUnit() {
        if (StringUtils.isNotBlank(getUnitNumber())) {
            if (this.getReporterUnitId() == null) {
                this.refreshReferenceObject("unit");
            } else if (unit == null) {
                this.refreshReferenceObject("unit");
            }
        } else {
            unit = null;
        }
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

}
