/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.summary;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.iacuc.procedures.IacucProtocolStudyCustomData;

import java.io.Serializable;

public class IacucProcedureCustomDataSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String customDataTag; 
    private String customDataVal; 
    private boolean customDataTagChanged; 
    private boolean customDataValChanged; 

    public IacucProcedureCustomDataSummary(IacucProtocolStudyCustomData customData) {
        id = customData.getProcedureCustomAttributeId();
        customDataTag = customData.getIacucProcedureCategoryCustomData().getLabel();
        customDataVal = customData.getValue();
        customDataTagChanged = false;
        customDataValChanged = false;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCustomDataTag() {
        return customDataTag;
    }

    public void setCustomDataTag(String customDataTag) {
        this.customDataTag = customDataTag;
    }

    public String getCustomDataVal() {
        return customDataVal;
    }

    public void setCustomDataVal(String customDataVal) {
        this.customDataVal = customDataVal;
    }

    public boolean isCustomDataTagChanged() {
        return customDataTagChanged;
    }

    public void setCustomDataTagChanged(boolean customDataTagChanged) {
        this.customDataTagChanged = customDataTagChanged;
    }

    public boolean isCustomDataValChanged() {
        return customDataValChanged;
    }

    public void setCustomDataValChanged(boolean customDataValChanged) {
        this.customDataValChanged = customDataValChanged;
    } 

    public void compare(IacucProcedureSummary other) {
        IacucProcedureCustomDataSummary otherSummary = (other == null) ? null : other.findProcedureCustomDataSummary(id);
        if (otherSummary == null) {
            customDataTagChanged = false;  // doesn't do any good to highlight the label
            customDataValChanged = true;
        } else {
            customDataTagChanged = false;
            customDataValChanged = !StringUtils.equals(customDataVal, otherSummary.customDataVal);
        }
    }

}
