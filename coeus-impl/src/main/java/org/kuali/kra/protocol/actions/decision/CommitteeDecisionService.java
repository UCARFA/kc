/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.decision;

import org.kuali.coeus.common.committee.impl.meeting.ProtocolVoteAbstaineeBase;
import org.kuali.coeus.common.committee.impl.meeting.ProtocolVoteRecusedBase;
import org.kuali.kra.protocol.ProtocolBase;

import java.util.List;

/**
 * The Committee Decision Service processes committee decisions.
 */
public interface CommitteeDecisionService<CD extends CommitteeDecision<? extends CommitteePersonBase> > {

    /**
     * Record the committee's decision.
     * @param protocol
     * @param committeeDecision
     */
    void processCommitteeDecision(ProtocolBase protocol, CD committeeDecision) throws Exception;
    
    /**
     * Finds all of the abstainer votes for the given protocolNumber and submissionNumber.
     * @param protocolNumber The human-readable protocol number
     * @param submissionNumber The submission number
     * @return the list of abstainee votes for the given protocolNumber
     */
    List<ProtocolVoteAbstaineeBase> getAbstainers(String protocolNumber, int submissionNumber);
    
    /**
     * Finds all of the recused votes for the given protocolNumber and submissionNumber.
     * @param protocolNumber The human-readable protocol number
     * @param submissionNumber The submission number
     * @return the list of recused votes for the given protocolNumber
     */
    List<ProtocolVoteRecusedBase> getRecusers(String protocolNumber, int submissionNumber);
}
