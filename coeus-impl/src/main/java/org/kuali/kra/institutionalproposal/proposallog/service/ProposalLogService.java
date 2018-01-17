/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog.service;

import org.kuali.kra.institutionalproposal.proposallog.ProposalLog;
import org.kuali.kra.institutionalproposal.proposallog.ProposalLogType;

import java.util.List;

/**
 * External services provided by the Proposal Log module.
 */
public interface ProposalLogService {
    
    /**
     * Tie the temporary proposal to the permanent one and update the status.
     */
    void mergeProposalLog(ProposalLog permanentProposalLog, String temporaryProposalNumber);    
    
    /**
     * Update the state of the log entry for the given proposal number to reflect that it has been merged
     * with another proposal log.
     */
    void mergeProposalLog(String proposalNumber);
    
    /**
     * Update the state of the log entry for the given proposal number to reflect that it has been promoted
     * to an Institutional Proposal.
     */
    void promoteProposalLog(String proposalNumber);
    
    /**
     * links merged institutional proposal and proposal log
     */    
    void updateMergedInstProposal(Long proposalId, String proposalNumber);
    
    /**
     * Gets all temporary proposal logs with the matching pi that haven't been merged yet.
     */
    List<ProposalLog> getMatchingTemporaryProposalLogs(String proposalLogTypeCode, String piId, String rolodexId); 
    
    /**
     * Based on the provided description will return the associated ProposalLogType. If no exact matches are found, then null is returned.
     */
    ProposalLogType getProposalLogTypeFromDescription(String description);
}
