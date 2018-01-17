/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.bo;

import org.kuali.coeus.common.framework.crrspndnt.Correspondent;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.kra.iacuc.correspondence.IacucCorrespondentType;

public class IacucUnitCorrespondent extends Correspondent {

    private static final long serialVersionUID = 1L;
    
    private String unitNumber;
    
    private Unit unit;
    
    public IacucUnitCorrespondent() {
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
    public IacucCorrespondentType getCorrespondentType() {
        return (IacucCorrespondentType) correspondentType;
    }
    
    public void setCorrespondentType(IacucCorrespondentType correspondentType) {
        this.correspondentType = correspondentType;
    }

}
