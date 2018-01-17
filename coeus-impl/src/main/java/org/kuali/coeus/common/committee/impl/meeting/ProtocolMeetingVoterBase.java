/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolReviewerBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

/**
 * 
 * This class sets the base data points for an abstainer or a recuser.
 */
public abstract class ProtocolMeetingVoterBase extends ProtocolReviewerBase {

    private String comments;

    private ProtocolBase protocol;

    private ProtocolSubmissionBase protocolSubmission;

    @Override
    public ProtocolSubmissionBase getProtocolSubmission() {
        return protocolSubmission;
    }

    @Override
    public void setProtocolSubmission(ProtocolSubmissionBase protocolSubmission) {
        this.protocolSubmission = protocolSubmission;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public ProtocolBase getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(ProtocolBase protocol) {
        this.protocol = protocol;
    }
}
