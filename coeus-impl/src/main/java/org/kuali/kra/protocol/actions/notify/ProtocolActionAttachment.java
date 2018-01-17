/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.notify;

import org.apache.struts.upload.FormFile;

import java.io.Serializable;

/**
 * 
 * This class is an attachment bean for action attachment. these information will be saved to ProtocolSubmissionDocBase
 */
public class ProtocolActionAttachment implements Serializable {

    private static final long serialVersionUID = 1635832672466787015L;
    
    private String fileName;
    private transient FormFile file;
    private String description;

    public ProtocolActionAttachment() {
        
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FormFile getFile() {
        return file;
    }

    public void setFile(FormFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
