/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.summary;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.iacuc.species.exception.IacucProtocolException;

import java.io.Serializable;

public class IacucProtocolExceptionSummary implements Serializable { 
    
    private static final long serialVersionUID = -3542316037590648543L;

    private Integer iacucProtocolExceptionId; 
    private String  speciesName; 
    private String  exceptionCategory; 
    private String  exceptionDescription; 
    private Integer exceptionCount;

    private boolean speciesNameChanged; 
    private boolean exceptionCategoryChanged; 
    private boolean exceptionDescriptionChanged; 
    private boolean exceptionCountChanged;

    public IacucProtocolExceptionSummary(IacucProtocolException exception) { 
        this.iacucProtocolExceptionId = exception.getExceptionId();
        this.speciesName = exception.getSpeciesName();
        this.exceptionCategory = exception.getCategoryName();
        this.exceptionDescription = exception.getExceptionDescription();
        this.exceptionCount = exception.getExceptionCount();
    } 
    
    public Integer getIacucProtocolExceptionId() {
        return iacucProtocolExceptionId;
    }

    public void setIacucProtocolExceptionId(Integer iacucProtocolExceptionId) {
        this.iacucProtocolExceptionId = iacucProtocolExceptionId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getExceptionCategory() {
        return exceptionCategory;
    }

    public void setExceptionCategory(String exceptionCategory) {
        this.exceptionCategory = exceptionCategory;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }

    public void setExceptionDescription(String exceptionDescription) {
        this.exceptionDescription = exceptionDescription;
    }

    public Integer getExceptionCount() {
        return exceptionCount;
    }

    public void setExceptionCount(Integer exceptionCount) {
        this.exceptionCount = exceptionCount;
    }

    public boolean isSpeciesNameChanged() {
        return speciesNameChanged;
    }

    public void setSpeciesNameChanged(boolean speciesNameChanged) {
        this.speciesNameChanged = speciesNameChanged;
    }

    public boolean isExceptionCategoryChanged() {
        return exceptionCategoryChanged;
    }

    public void setExceptionCategoryChanged(boolean exceptionCategoryChanged) {
        this.exceptionCategoryChanged = exceptionCategoryChanged;
    }

    public boolean isExceptionDescriptionChanged() {
        return exceptionDescriptionChanged;
    }

    public void setExceptionDescriptionChanged(boolean exceptionDescriptionChanged) {
        this.exceptionDescriptionChanged = exceptionDescriptionChanged;
    }

    public boolean isExceptionCountChanged() {
        return exceptionCountChanged;
    }

    public void setExceptionCountChanged(boolean exceptionCountChanged) {
        this.exceptionCountChanged = exceptionCountChanged;
    }
    
    public void compare(IacucProtocolSummary other) {
        IacucProtocolExceptionSummary otherSummary = (other == null) ? null : other.findExceptionSummary(iacucProtocolExceptionId);
        if (otherSummary == null) {
            speciesNameChanged = true; 
            exceptionCategoryChanged = true; 
            exceptionDescriptionChanged = true; 
            exceptionCountChanged = true;
        } else {
            speciesNameChanged = !StringUtils.equals(speciesName, otherSummary.speciesName); 
            exceptionCategoryChanged = !StringUtils.equals(exceptionCategory, otherSummary.exceptionCategory); 
            exceptionDescriptionChanged = !StringUtils.equals(exceptionDescription, otherSummary.exceptionDescription);
            exceptionCountChanged = !Objects.equals(exceptionCount, otherSummary.exceptionCount);
        }
    }

}

