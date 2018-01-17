/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.apache.struts.upload.FormFile;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.irb.actions.ProtocolActionType;

/**
 * 
 * This class is bo of protocol notification template
 */
public class ProtocolNotificationTemplate extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Integer notificationTemplateId;

    private String actionTypeCode;

    private String fileName;

    private byte[] notificationTemplate;

    private ProtocolActionType protocolActionType;

    private transient FormFile templateFile;

    public ProtocolNotificationTemplate() {
        super();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTemplateFile(FormFile templateFile) {
        this.templateFile = templateFile;
    }

    public FormFile getTemplateFile() {
        return templateFile;
    }

    public Integer getNotificationTemplateId() {
        return notificationTemplateId;
    }

    public void setNotificationTemplateId(Integer notificationTemplateId) {
        this.notificationTemplateId = notificationTemplateId;
    }

    public String getActionTypeCode() {
        return actionTypeCode;
    }

    public void setActionTypeCode(String actionTypeCode) {
        this.actionTypeCode = actionTypeCode;
    }

    public byte[] getNotificationTemplate() {
        return notificationTemplate;
    }

    public void setNotificationTemplate(byte[] notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
    }

    public ProtocolActionType getProtocolActionType() {
        return protocolActionType;
    }

    public void setProtocolActionType(ProtocolActionType protocolActionType) {
        this.protocolActionType = protocolActionType;
    }
}
