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
 * This class is for member abstained from vote.
 */
public abstract class ProtocolVoteAbstaineeBase extends ProtocolMeetingVoterBase {

    private static final long serialVersionUID = 6207540592702779528L;

    private Long protocolVoteAbstaineesId;

    public ProtocolVoteAbstaineeBase() {
    }

    public Long getProtocolVoteAbstaineesId() {
        return protocolVoteAbstaineesId;
    }

    public void setProtocolVoteAbstaineesId(Long protocolVoteAbstaineesId) {
        this.protocolVoteAbstaineesId = protocolVoteAbstaineesId;
    }
}
