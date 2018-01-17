/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * A ProtocolBase Action Type refers to the type of actions that an
 * that can be performed against a ProtocolBase document.
 */
@SuppressWarnings("serial")
public abstract class ProtocolActionTypeBase extends KcPersistableBusinessObjectBase {

    private String protocolActionTypeCode;

    private String description;

    private boolean triggerSubmission;

    private boolean triggerCorrespondence;

    private boolean finalActionForBatchCorrespondence;


    public ProtocolActionTypeBase() {
    }

    public void setProtocolActionTypeCode(String protocolActionTypeCode) {
        this.protocolActionTypeCode = protocolActionTypeCode;
    }

    public String getProtocolActionTypeCode() {
        return protocolActionTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTriggerSubmission(boolean triggerSubmission) {
        this.triggerSubmission = triggerSubmission;
    }

    public boolean getTriggerSubmission() {
        return triggerSubmission;
    }

    public void setTriggerCorrespondence(boolean triggerCorrespondence) {
        this.triggerCorrespondence = triggerCorrespondence;
    }

    public boolean getTriggerCorrespondence() {
        return triggerCorrespondence;
    }

    public boolean isFinalActionForBatchCorrespondence() {
        return finalActionForBatchCorrespondence;
    }

    public void setFinalActionForBatchCorrespondence(boolean finalActionForBatchCorrespondence) {
        this.finalActionForBatchCorrespondence = finalActionForBatchCorrespondence;
    }
}
