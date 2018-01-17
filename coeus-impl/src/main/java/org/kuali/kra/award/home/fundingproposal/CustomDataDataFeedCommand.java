/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.kuali.kra.award.customdata.AwardCustomData;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.institutionalproposal.customdata.InstitutionalProposalCustomData;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

class CustomDataDataFeedCommand extends ProposalDataFeedCommandBase {
    
    public CustomDataDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }

    @Override
    void performDataFeed() {
        if (mergeType == FundingProposalMergeType.NEWAWARD 
                || mergeType == FundingProposalMergeType.REPLACE) {
            for (InstitutionalProposalCustomData ipCustomData : proposal.getInstitutionalProposalCustomDataList()) {
                for (AwardCustomData awardCustomData : award.getAwardCustomDataList()) {
                    if (ipCustomData.getCustomAttributeId().equals(awardCustomData.getCustomAttributeId())) {
                        awardCustomData.setValue(ipCustomData.getValue());
                    }
                }
            }
        }
    }

}
