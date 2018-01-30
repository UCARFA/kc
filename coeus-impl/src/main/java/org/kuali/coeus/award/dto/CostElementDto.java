/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

public class CostElementDto {

    private String costElement;
    private String description;
    private Boolean onOffCampusFlag;
    private boolean active;
    private String unitNumber;

    public String getCostElement() {
        return costElement;
    }

    public void setCostElement(String costElement) {
        this.costElement = costElement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOnOffCampusFlag() {
        return onOffCampusFlag;
    }

    public void setOnOffCampusFlag(Boolean onOffCampusFlag) {
        this.onOffCampusFlag = onOffCampusFlag;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
}