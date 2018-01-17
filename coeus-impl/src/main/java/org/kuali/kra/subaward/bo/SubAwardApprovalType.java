/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;


public class SubAwardApprovalType extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Integer subAwardApprovalTypeCode;

    private String description;


    public SubAwardApprovalType() {
    }

    /**
     * This method is for getting subAwardApprovalTypeCode ...
     * @return subAwardApprovalTypeCode
     */
    public Integer getSubAwardApprovalTypeCode() {
        return subAwardApprovalTypeCode;
    }
    
    /**
     * This method is for setting subAwardApprovalTypeCode...
     * @param subAwardApprovalTypeCode the subAwardApprovalTypeCode to set
     */
    public void setSubAwardApprovalTypeCode(Integer subAwardApprovalTypeCode) {
        this.subAwardApprovalTypeCode = subAwardApprovalTypeCode;
    }
    /**
     * This method is for getting Description ...
     * @return description
     */
    public String getDescription() {
        return description;
    }
    /**
     * This method is for setting description...
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
