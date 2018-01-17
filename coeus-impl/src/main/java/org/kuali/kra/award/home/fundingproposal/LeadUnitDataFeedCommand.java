/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

/**
 *  Feed Proposal Lead unit into Award  
 */
class LeadUnitDataFeedCommand extends ProposalDataFeedCommandBase {
    LeadUnitDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }

    @Override
    void performDataFeed() {
        if (mergeType != FundingProposalMergeType.NOCHANGE) {
            if (StringUtils.isBlank(award.getLeadUnitNumber())) {
                award.setLeadUnit(proposal.getLeadUnit());
                award.setUnitNumber(proposal.getUnitNumber());
            }
        }
    }
}
