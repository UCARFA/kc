/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.summary;

import java.io.Serializable;

public class UnitSummary implements Serializable {

    private static final long serialVersionUID = -5513896542027540966L;
    
    private String unitNumber;
    private String unitName;
    
    private boolean changed;
    
    public UnitSummary(String unitNumber, String unitName) {
        this.unitNumber = unitNumber;
        this.unitName = unitName;
    }
    
    public String getUnitNumber() {
        return unitNumber;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public boolean isChanged() {
        return changed;
    }

    public void compare(PersonnelSummary otherPerson) {
        UnitSummary unit = otherPerson.findUnit(unitNumber);
        changed = (unit == null);
    }
}
