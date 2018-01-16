/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.commitments.AwardCostShare;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardCommentFactory;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalCostShare;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


class CostSharingDataFeedCommand extends ProposalDataFeedCommandBase {
    private static final String COST_SHARE_COMMENT_PATTERN = "Added Cost Shares from Proposal Number %s";
    
    public CostSharingDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }

    @Override
    void performDataFeed() {
        if (mergeType != FundingProposalMergeType.NOCHANGE) {
            int costshareCount = 0;
            if (mergeType == FundingProposalMergeType.REPLACE) {
                award.setAwardCostShares(new ArrayList<>());
            }
            List<InstitutionalProposalCostShare> costShares = proposal.getInstitutionalProposalCostShares();
            for (InstitutionalProposalCostShare ipCostShare : costShares) {
                award.add(copyCostShare(ipCostShare));
                costshareCount++;
            }

            if (costshareCount > 0) {
                addCostShareComment(proposal);
            }


        }
    }

    protected void addCostShareComment(InstitutionalProposal proposal) {
        if ((mergeType == FundingProposalMergeType.NEWAWARD || mergeType == FundingProposalMergeType.REPLACE)
                && !Objects.isNull(this.proposal.getCostShareComment())
                && !StringUtils.isEmpty(this.proposal.getCostShareComment().getComments())) {
            if (mergeType == FundingProposalMergeType.REPLACE) {
                award.getAwardCostShareComment().setComments(StringUtils.EMPTY);
            }
            this.award.getAwardCostShareComment().setComments(this.proposal.getCostShareComment().getComments());
        } else {
            String newComment = String.format(COST_SHARE_COMMENT_PATTERN, proposal.getProposalNumber());
            appendComments(findOrCreateCommentOfSpecifiedType(new AwardCommentFactory().createCostShareComment()), newComment);
        }
    }

    private AwardCostShare copyCostShare(InstitutionalProposalCostShare ipCostShare) {
        AwardCostShare awardCostShare = new AwardCostShare();
        awardCostShare.setCommitmentAmount(ipCostShare.getAmount());
        awardCostShare.setCostSharePercentage(ipCostShare.getCostSharePercentage());
        awardCostShare.setCostShareType(ipCostShare.getCostShareType());
        awardCostShare.setCostShareTypeCode(ipCostShare.getCostShareTypeCode());
        awardCostShare.setSource(ipCostShare.getSourceAccount());
        awardCostShare.setProjectPeriod(ipCostShare.getProjectPeriod());
        awardCostShare.setUnitNumber(ipCostShare.getUnitNumber());
        awardCostShare.setUnit(ipCostShare.getUnit());
        return awardCostShare;
    }
}
