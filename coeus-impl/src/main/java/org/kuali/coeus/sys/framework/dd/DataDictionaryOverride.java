/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.dd;


import org.apache.struts.upload.FormFile;
import org.kuali.coeus.sys.api.model.Identifiable;
import org.kuali.coeus.sys.api.model.Inactivatable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.rice.core.api.mo.common.active.MutableInactivatable;
import org.kuali.rice.krad.bo.PersistableAttachment;

public class DataDictionaryOverride extends KcPersistableBusinessObjectBase implements Inactivatable, Identifiable, PersistableAttachment, MutableInactivatable {

    private String id;
    private byte[] attachmentContent;
    private String fileName;
    private String contentType;
    private boolean active;

    private transient FormFile overrideBeansFile;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public byte[] getAttachmentContent() {
        return attachmentContent;
    }

    @Override
    public void setAttachmentContent(byte[] attachmentContent) {
        this.attachmentContent = attachmentContent;
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
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    public FormFile getOverrideBeansFile() {
        return overrideBeansFile;
    }

    public void setOverrideBeansFile(FormFile overrideBeansFile) {
        this.overrideBeansFile = overrideBeansFile;
    }
}
