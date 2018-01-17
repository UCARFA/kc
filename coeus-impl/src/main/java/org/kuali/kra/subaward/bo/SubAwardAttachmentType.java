/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class SubAwardAttachmentType extends KcPersistableBusinessObjectBase {
    
    private Integer subAwardAttachmentTypeCode;
    
    private String description;

    public Integer getSubAwardAttachmentTypeCode() {
        return subAwardAttachmentTypeCode;
    }

    public void setSubAwardAttachmentTypeCode(Integer subAwardAttachmentTypeCode) {
        this.subAwardAttachmentTypeCode = subAwardAttachmentTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
