/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondence;

/**
 * 
 * This class implements the CommitteeBatchCorrespondenceDetailBase business object.
 */
public abstract class CommitteeBatchCorrespondenceDetailBase extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 1L;

    private Long committeeBatchCorrespondenceDetailId;

    private String committeeBatchCorrespondenceId;

    private Long protocolActionId;

    private Long protocolCorrespondenceId;

    private boolean selected;

    private CommitteeBatchCorrespondenceBase committeeBatchCorrespondence;

    private ProtocolActionBase protocolAction;

    private ProtocolCorrespondence protocolCorrespondence;


    public CommitteeBatchCorrespondenceDetailBase() {
    }

    public Long getCommitteeBatchCorrespondenceDetailId() {
        return committeeBatchCorrespondenceDetailId;
    }

    public void setCommitteeBatchCorrespondenceDetailId(Long committeeBatchCorrespondenceDetailId) {
        this.committeeBatchCorrespondenceDetailId = committeeBatchCorrespondenceDetailId;
    }

    public String getCommitteeBatchCorrespondenceId() {
        return committeeBatchCorrespondenceId;
    }

    public void setCommitteeBatchCorrespondenceId(String committeeBatchCorrespondenceId) {
        this.committeeBatchCorrespondenceId = committeeBatchCorrespondenceId;
    }

    public Long getProtocolActionId() {
        return protocolActionId;
    }

    public void setProtocolActionId(Long protocolActionId) {
        this.protocolActionId = protocolActionId;
    }

    public Long getProtocolCorrespondenceId() {
        return protocolCorrespondenceId;
    }

    public void setProtocolCorrespondenceId(Long protocolCorrespondenceId) {
        this.protocolCorrespondenceId = protocolCorrespondenceId;
    }

    public CommitteeBatchCorrespondenceBase getCommitteeBatchCorrespondence() {
        return committeeBatchCorrespondence;
    }

    public void setCommitteeBatchCorrespondence(CommitteeBatchCorrespondenceBase committeeBatchCorrespondence) {
        this.committeeBatchCorrespondence = committeeBatchCorrespondence;
    }

    public ProtocolActionBase getProtocolAction() {
        return protocolAction;
    }

    public void setProtocolAction(ProtocolActionBase protocolAction) {
        this.protocolAction = protocolAction;
    }

    public ProtocolCorrespondence getProtocolCorrespondence() {
        return protocolCorrespondence;
    }

    public void setProtocolCorrespondence(ProtocolCorrespondence protocolCorrespondence) {
        this.protocolCorrespondence = protocolCorrespondence;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
