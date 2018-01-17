/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import org.apache.struts.upload.FormFile;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.krad.bo.PersistableAttachment;

public class PersonBiosketch extends KcPersistableBusinessObjectBase implements PersistableAttachment {

    private static final long serialVersionUID = 6206100185207514370L;
    
    private Long personBiosketchId;
    private String personId;

    private String description;
    private String fileName;
    private String contentType;
    private byte[] attachmentContent;
    private transient FormFile attachmentFile;
    
    public Long getPersonBiosketchId() {
        return personBiosketchId;
    }
    
    public void setPersonBiosketchId(Long personBiosketchId) {
        this.personBiosketchId = personBiosketchId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String getFileName() {
        return fileName;
    }
    
    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    @Override
    public String getContentType() {
        return contentType;
    }
    
    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    @Override
    public byte[] getAttachmentContent() {
        return attachmentContent;
    }
    
    @Override
    public void setAttachmentContent(byte[] attachmentContent) {
        this.attachmentContent = attachmentContent;
    }
    
    public FormFile getAttachmentFile() {
        return attachmentFile;
    }
    
    public void setAttachmentFile(FormFile attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

}
