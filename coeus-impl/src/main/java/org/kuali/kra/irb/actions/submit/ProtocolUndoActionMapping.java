/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.kuali.kra.protocol.drools.brms.FactBean;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;

/*
 * This is the post condition attributes for a protocol action
 */
public class ProtocolUndoActionMapping implements FactBean {
    
    String actionTypeCode;
    String submissionTypeCode;
    String protocolStatusCode;
    
    boolean protocolSubmissionToBeDeleted = false;
    
    Protocol protocol;
    
    ProtocolSubmission protocolSubmission;
    
    ProtocolAction protocolAction;
    
    public ProtocolUndoActionMapping(String actionTypeCode, String submissionTypeCode, String protocolStatusCode) {
        super();
        this.actionTypeCode=actionTypeCode;
        this.submissionTypeCode = submissionTypeCode;
        this.protocolStatusCode = protocolStatusCode;
    }
    
    public ProtocolSubmission getProtocolSubmission() {
        return protocolSubmission;
    }

    public void setProtocolSubmission(ProtocolSubmission protocolSubmission) {
        this.protocolSubmission = protocolSubmission;
    }
    
    public String getActionTypeCode() {
        return actionTypeCode;
    }
    
    public void setActionTypeCode(String actionTypeCode) {
        this.actionTypeCode = actionTypeCode;
    }
    
    public String getSubmissionTypeCode() {
        return submissionTypeCode;
    }

    public void setSubmissionTypeCode(String submissionTypeCode) {
        this.submissionTypeCode = submissionTypeCode;
    }

    public String getProtocolStatusCode() {
        return protocolStatusCode;
    }

    public void setProtocolStatusCode(String protocolStatusCode) {
        this.protocolStatusCode = protocolStatusCode;
    }

    public Protocol getProtocol() {
        return protocol;
    }
    
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }
    
    public ProtocolAction getProtocolAction() {
        return protocolAction;
    }

    public void setProtocolAction(ProtocolAction protocolAction) {
        this.protocolAction = protocolAction;
    }

    public boolean isProtocolSubmissionToBeDeleted() {
        return protocolSubmissionToBeDeleted;
    }

    public void setProtocolSubmissionToBeDeleted(boolean protocolSubmissionToBeDeleted) {
        this.protocolSubmissionToBeDeleted = protocolSubmissionToBeDeleted;
    }
    
}
