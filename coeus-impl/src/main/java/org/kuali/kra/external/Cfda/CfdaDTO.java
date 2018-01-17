/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.Cfda;

import java.io.Serializable;

/**
 * This class is the cfda number DTO to be sent over to the
 * financial system
 */
public class CfdaDTO implements Serializable {

    private String cfdaNumber;
    private String cfdaProgramTitleName;
    private String cfdaMaintenanceTypeId;
    private boolean active;
    private String awardId;
    private static final long serialVersionUID = 7517946137745989736L;

    
    public String getAwardId() {
        return awardId;
    }
    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }
    public String getCfdaNumber() {
        return cfdaNumber;
    }
    public void setCfdaNumber(String cfdaNumber) {
        this.cfdaNumber = cfdaNumber;
    }
    public String getCfdaProgramTitleName() {
        return cfdaProgramTitleName;
    }
    public void setCfdaProgramTitleName(String cfdaProgramTitleName) {
        this.cfdaProgramTitleName = cfdaProgramTitleName;
    }
    public String getCfdaMaintenanceTypeId() {
        return cfdaMaintenanceTypeId;
    }
    public void setCfdaMaintenanceTypeId(String cfdaMaintenanceTypeId) {
        this.cfdaMaintenanceTypeId = cfdaMaintenanceTypeId;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
