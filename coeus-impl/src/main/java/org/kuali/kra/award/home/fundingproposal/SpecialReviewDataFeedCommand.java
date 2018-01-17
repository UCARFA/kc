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
import org.kuali.kra.award.home.AwardCommentFactory;
import org.kuali.kra.award.specialreview.AwardSpecialReview;
import org.kuali.kra.award.specialreview.AwardSpecialReviewExemption;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.specialreview.InstitutionalProposalSpecialReview;
import org.kuali.kra.institutionalproposal.specialreview.InstitutionalProposalSpecialReviewExemption;

class SpecialReviewDataFeedCommand extends ProposalDataFeedCommandBase {
    private static final String SPECIAL_REVIEW_COMMENT_PATTERN = "Added Special Review from Proposal Number %s for Special Review #%d and Protocol #%s";
    
    public SpecialReviewDataFeedCommand(Award award, InstitutionalProposal proposal, FundingProposalMergeType mergeType) {
        super(award, proposal, mergeType);
    }

    @Override
    void performDataFeed() {
        if (mergeType != FundingProposalMergeType.NOCHANGE) {
            //unsure why, but without the refresh special reviews were often incorrectly empty
            proposal.refreshReferenceObject("specialReviews");
            for(InstitutionalProposalSpecialReview ipSpecialReview: proposal.getSpecialReviews()) {
                copySpecialReview(award, proposal, ipSpecialReview);
            }
        }
    }
    
    private void addSpecialReviewComment(Award award, InstitutionalProposal proposal, AwardSpecialReview copiedSpecialReview) {
        String newComment = String.format(SPECIAL_REVIEW_COMMENT_PATTERN, proposal.getProposalNumber(), 
                                            copiedSpecialReview.getSpecialReviewNumber(), copiedSpecialReview.getProtocolNumber());
        appendComments(findOrCreateCommentOfSpecifiedType(new AwardCommentFactory().createSpecialReviewComment()), newComment);
    }
    
    private void copySpecialReview(Award award, InstitutionalProposal proposal, InstitutionalProposalSpecialReview ipSpecialReview) {
        AwardSpecialReview copiedSpecialReview = copySpecialReview(ipSpecialReview);
        award.add(copiedSpecialReview);
        addSpecialReviewComment(award, proposal, copiedSpecialReview);
    }
    
    /**
     * This method copies a InstitutionalProposalSpecialReview into an AwardSpecialReview
     * @param ipSpecialReview
     * @return AwardSpecialReview
     */
    private AwardSpecialReview copySpecialReview(InstitutionalProposalSpecialReview ipSpecialReview) {
        AwardSpecialReview copiedSpecialReview = new AwardSpecialReview();
        copiedSpecialReview.setApplicationDate(ipSpecialReview.getApplicationDate());
        copiedSpecialReview.setApprovalDate(ipSpecialReview.getApprovalDate());
        copiedSpecialReview.setApprovalTypeCode(ipSpecialReview.getApprovalTypeCode());
        copiedSpecialReview.setComments(ipSpecialReview.getComments());
        copiedSpecialReview.setExemptionTypeCodes(ipSpecialReview.getExemptionTypeCodes());
        copiedSpecialReview.setExpirationDate(ipSpecialReview.getExpirationDate());
        copiedSpecialReview.setProtocolNumber(ipSpecialReview.getProtocolNumber());
        copiedSpecialReview.setSpecialReviewType(ipSpecialReview.getSpecialReviewType());
        copiedSpecialReview.setApprovalType(ipSpecialReview.getApprovalType());
        copiedSpecialReview.setSpecialReviewTypeCode(ipSpecialReview.getSpecialReviewTypeCode());
        for (InstitutionalProposalSpecialReviewExemption ipExempt : ipSpecialReview.getSpecialReviewExemptions()) {
            if (StringUtils.isNotBlank(ipExempt.getExemptionTypeCode())) {
                AwardSpecialReviewExemption newAwardExempt = copiedSpecialReview.createSpecialReviewExemption(ipExempt.getExemptionTypeCode());
                copiedSpecialReview.getSpecialReviewExemptions().add(newAwardExempt);
            }
        }
        copiedSpecialReview.setSpecialReviewNumber(ipSpecialReview.getSpecialReviewNumber());
        
        return copiedSpecialReview;
    }
}
