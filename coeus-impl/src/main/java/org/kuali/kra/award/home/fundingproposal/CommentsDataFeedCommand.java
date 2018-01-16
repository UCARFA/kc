/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.fundingproposal;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardComment;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposalComment;

/**
 * This class will populate Award comments based on their corresponding Institutional Proposal comments.
 * The mapping is based on the Comment Type code, even though some of the comment names don't quite match.
 */
public class CommentsDataFeedCommand extends ProposalDataFeedCommandBase {
    
    private static final String FUNDING_PROPOSAL_ADDED_MSG_PATTERN = "Funding Proposal Number %s was added to Award";
    
    public CommentsDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }

    @Override
    void performDataFeed() {
        if (mergeType != FundingProposalMergeType.NOCHANGE) {
            feedProposalComment();
            feedProposalSummaryComment();
            feedUnrecoveredFandARateComment();
            feedCostShareComment();
            feedProposalIPReviewComment();
        }
    }
    
    void feedProposalComment() {
        InstitutionalProposalComment proposalDeliveryComment = proposal.getDeliveryComment();
        AwardComment awardProposalComment = award.getawardProposalComments();
        if (proposalDeliveryComment != null) {
            appendComments(awardProposalComment, proposalDeliveryComment.getComments());
        } else {
            appendComments(awardProposalComment, String.format(FUNDING_PROPOSAL_ADDED_MSG_PATTERN, proposal.getProposalNumber()));
        }
    }
    
    void feedProposalSummaryComment() {
        InstitutionalProposalComment proposalSummaryComment = proposal.getSummaryComment();
        if (proposalSummaryComment != null) {
            AwardComment awardProposalSummaryComment = award.getawardProposalSummary();
            appendComments(awardProposalSummaryComment, proposalSummaryComment.getComments());
        }
    }
    
    void feedUnrecoveredFandARateComment() {
        InstitutionalProposalComment proposalFandAComment = proposal.getUnrecoveredFandAComment();
        if (proposalFandAComment != null) {
            AwardComment awardFandAComment = award.getAwardFandaRateComment();
            appendComments(awardFandAComment, proposalFandAComment.getComments());
        }
    }
    
    void feedCostShareComment() {
        InstitutionalProposalComment proposalCostShareComment = proposal.getCostShareComment();
        if (proposalCostShareComment != null) {
            AwardComment awardCostShareComment = award.getAwardCostShareComment();
            appendComments(awardCostShareComment, proposalCostShareComment.getComments());
        }
    }
    
    void feedProposalIPReviewComment() {
        InstitutionalProposalComment proposalGeneralComment = proposal.getGeneralComment();
        if (proposalGeneralComment != null) {
            AwardComment awardIpReviewComment = award.getAwardProposalIPReviewComment();
            appendComments(awardIpReviewComment, proposalGeneralComment.getComments());
        }
    }
}
