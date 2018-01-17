/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.unit.crrspndnt;

import org.kuali.coeus.common.framework.crrspndnt.Correspondent;
import org.kuali.coeus.common.framework.unit.Unit;

public class UnitCorrespondent extends Correspondent {

    private static final long serialVersionUID = 1L;

	private String unitNumber;
	
    private Unit unit;
    
    public UnitCorrespondent() {
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    public String getUnitNumber() {
    	return unitNumber;
    }
    
    public void setUnitNumber(String unitNumber) {
    	this.unitNumber = unitNumber;
    }
    
    @Override
    public org.kuali.kra.irb.correspondence.CorrespondentType getCorrespondentType() {
        return (org.kuali.kra.irb.correspondence.CorrespondentType) correspondentType;
    }

    public void setCorrespondentType(org.kuali.kra.irb.correspondence.CorrespondentType correspondentType) {
        this.correspondentType = correspondentType;
    }

}
