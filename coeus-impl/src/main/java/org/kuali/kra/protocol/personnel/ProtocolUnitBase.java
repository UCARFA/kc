/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.kra.SkipVersioning;
import org.kuali.kra.protocol.ProtocolAssociateBase;

public abstract class ProtocolUnitBase extends ProtocolAssociateBase {


    private static final long serialVersionUID = 8187880795930346699L;

    private Integer protocolUnitsId;

    private Integer protocolPersonId;

    private String unitNumber;

    private boolean leadUnitFlag;

    private String personId;

    private String unitName;

    private Unit unit;

    @SkipVersioning
    private ProtocolPersonBase protocolPerson;

    public ProtocolUnitBase() {
        setLeadUnitFlag(false);
    }

    public Integer getProtocolUnitsId() {
        return protocolUnitsId;
    }

    public void setProtocolUnitsId(Integer protocolUnitsId) {
        this.protocolUnitsId = protocolUnitsId;
    }

    public Integer getProtocolPersonId() {
        return protocolPersonId;
    }

    public void setProtocolPersonId(Integer protocolPersonId) {
        this.protocolPersonId = protocolPersonId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public boolean getLeadUnitFlag() {
        return leadUnitFlag;
    }

    public void setLeadUnitFlag(boolean leadUnitFlag) {
        this.leadUnitFlag = leadUnitFlag;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public ProtocolPersonBase getProtocolPerson() {
        return protocolPerson;
    }

    public void setProtocolPerson(ProtocolPersonBase protocolPerson) {
        this.protocolPerson = protocolPerson;
    }

    // Note this field isn't persisted in protocolUnit so  
    // we've got do pull from the Unit reference.  
    public String getUnitName() {
        if (StringUtils.isEmpty(unitName) && StringUtils.isNotEmpty(unitNumber)) {
            this.refreshReferenceObject("unit");
            if (unit != null) {
                setUnitName(unit.getUnitName());
            }
        }
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void init(ProtocolPersonBase protocolPerson) {
        setProtocolPerson(protocolPerson);
        setProtocolPersonId(protocolPerson.getProtocolPersonId());
        //this is a little weird...  
        this.init(protocolPerson.getProtocol());
    }

    @Override
    public void resetPersistenceState() {
        this.setProtocolUnitsId(null);
    }
}
