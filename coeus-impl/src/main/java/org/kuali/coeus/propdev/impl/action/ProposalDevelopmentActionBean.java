/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.action;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class ProposalDevelopmentActionBean implements Serializable {

    private static final long serialVersionUID = 4081027512143550976L;
    
    private String actionReason;
    private  transient MultipartFile actionFile;

    public MultipartFile getActionFile() {
        return actionFile;
    }

    public void setActionFile(MultipartFile actionFile) {
        this.actionFile = actionFile;
    }

    public String getActionReason() {
        return actionReason;
    }

    public void setActionReason(String actionReason) {
        this.actionReason = actionReason;
    }
}
