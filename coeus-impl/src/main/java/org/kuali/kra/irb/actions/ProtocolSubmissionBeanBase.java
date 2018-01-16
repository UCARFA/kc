/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions;

import org.kuali.kra.protocol.actions.notify.ProtocolActionAttachment;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class for the base property of request/notify irb action
 */
public abstract class ProtocolSubmissionBeanBase extends ProtocolActionBean implements org.kuali.kra.protocol.actions.ProtocolSubmissionBeanBase {
    
    private String committeeId;
    private ProtocolActionAttachment newActionAttachment;
    private List<ProtocolActionAttachment> actionAttachments = new ArrayList<ProtocolActionAttachment>();

    public ProtocolSubmissionBeanBase(ActionHelper actionHelper) {
        super(actionHelper);
    }

    @Override
    public String getCommitteeId() {
        return committeeId;
    }

    @Override
    public void setCommitteeId(String committeeId) {
        this.committeeId = committeeId;
    }

    @Override
    public ProtocolActionAttachment getNewActionAttachment() {
        return newActionAttachment;
    }

    @Override
    public void setNewActionAttachment(ProtocolActionAttachment newActionAttachment) {
        this.newActionAttachment = newActionAttachment;
    }

    @Override
    public List<ProtocolActionAttachment> getActionAttachments() {
        return actionAttachments;
    }

    @Override
    public void setActionAttachments(List<org.kuali.kra.protocol.actions.notify.ProtocolActionAttachment> actionAttachments) {
        this.actionAttachments = actionAttachments;
    }

}
