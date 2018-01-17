/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.summary;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class AdditionalInfoSummary implements Serializable {

    private static final long serialVersionUID = 1740333929467337320L;
    
    private String fdaApplicationNumber;
    private String referenceId1;
    private String referenceId2;
    private String description;
    
    private boolean fdaApplicationNumberChanged;
    private boolean referenceId1Changed;
    private boolean referenceId2Changed;
    private boolean descriptionChanged;
    
    public String getFdaApplicationNumber() {
        return fdaApplicationNumber;
    }
    
    public void setFdaApplicationNumber(String fdaApplicationNumber) {
        this.fdaApplicationNumber = fdaApplicationNumber;
    }
    
    public String getReferenceId1() {
        return referenceId1;
    }
    
    public void setReferenceId1(String referenceId1) {
        this.referenceId1 = referenceId1;
    }
    
    public String getReferenceId2() {
        return referenceId2;
    }
    
    public void setReferenceId2(String referenceId2) {
        this.referenceId2 = referenceId2;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void compare(AdditionalInfoSummary other) {
        fdaApplicationNumberChanged = !StringUtils.equals(fdaApplicationNumber, other.fdaApplicationNumber);
        referenceId1Changed = !StringUtils.equals(referenceId1, other.referenceId1);
        referenceId2Changed = !StringUtils.equals(referenceId2, other.referenceId2);
        descriptionChanged = !StringUtils.equals(description, other.description);
    }

    public boolean isFdaApplicationNumberChanged() {
        return fdaApplicationNumberChanged;
    }

    public boolean isReferenceId1Changed() {
        return referenceId1Changed;
    }

    public boolean isReferenceId2Changed() {
        return referenceId2Changed;
    }

    public boolean isDescriptionChanged() {
        return descriptionChanged;
    }
}
