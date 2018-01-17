/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Class representation of the Attachments Entry Type Type Business Object
 *
 */
public class AttachmentsEntryType extends KcPersistableBusinessObjectBase implements Comparable< AttachmentsEntryType>{

    private String attachmentsTypeCode;
    private Integer sortId;
    private String description;
    
    @Override
    public int compareTo(AttachmentsEntryType arg) {
        return this.getSortId().compareTo(arg.getSortId());
    }
    
    /**
     * Gets the attachmentsTypeCode attribute. 
     * @return Returns the attachmentsTypeCode.
     */
    public String getAttachmentsTypeCode() {
        return attachmentsTypeCode;
    }
    
    /**
     * Sets the deadlineTypeCode attribute value.
     * @param deadlineTypeCode
     */
    public void setAttachmentsTypeCode(String attachmentsTypeCode) {
        this.attachmentsTypeCode = attachmentsTypeCode;
    }
    
    /**
     * Gets the sortId attribute. 
     * @return Returns the sortId.
     */
    public Integer getSortId() {
        return sortId;
    }
    /**
     * Sets the sortId attribute value.
     * @param sortId
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
    
    /**
     * Gets the description attribute. 
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Sets the description attribute value.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
