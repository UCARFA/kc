/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.state;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

/**
 * The Proposal State Service is responsible for computing the state of a proposal.
 * The well-defined states are:
 * <ul>
 * <li>In Progress</li>
 * <li>Approval Pending</li>
 * <li>Approval Granted</li>
 * <li>Approval Not Initiated - Submitted</li>
 * <li>Approval Pending - Submitted</li>
 * <li>Approved and Submitted</li>
 * <li>Disapproved</li>
 * <li>Approved Post-Submission</li>
 * <li>Disapproved Post-Submission</li>
 * <li>Canceled</li>
 * <li>Document Error Occurred</li>
 * </ul>
 */
public interface ProposalStateService {

    /**
     * Get the Proposal State type code based upon the current configuration of the
     * given proposal.  The Proposal State must be recomputed whenever the workflow
     * route status changes or when the proposal is submitted to the sponsor.  The
     * order matters.  For example, if the proposal is approved and then submitted,
     * the state is "Approved and Submitted".  If the proposal is submitted first and
     * then approved, the state is "Approved Post-Submission".
     * 
     * @param proposalDevelopmentDocument the proposal development document
     * @param isReject was the action taken a rejection of the document?
     * @return the proposal state type code
     */
    String getProposalStateTypeCode(ProposalDevelopmentDocument proposalDevelopmentDocument, boolean isReject);

}
