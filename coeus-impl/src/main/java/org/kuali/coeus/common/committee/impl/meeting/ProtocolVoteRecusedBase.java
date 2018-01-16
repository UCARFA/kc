/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;


/**
 * 
 * This class is for member recused from vote.
 */
public abstract class ProtocolVoteRecusedBase extends ProtocolMeetingVoterBase {

    private static final long serialVersionUID = 6207540592702779518L;

    private Long protocolVoteRecusedId;

    public ProtocolVoteRecusedBase() {
    }

    public Long getProtocolVoteRecusedId() {
        return protocolVoteRecusedId;
    }

    public void setProtocolVoteRecusedId(Long protocolVoteRecusedId) {
        this.protocolVoteRecusedId = protocolVoteRecusedId;
    }
}
