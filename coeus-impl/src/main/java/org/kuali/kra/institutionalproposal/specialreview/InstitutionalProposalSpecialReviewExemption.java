/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.specialreview;

import org.kuali.coeus.common.framework.compliance.exemption.SpecialReviewExemption;

/**
 * Defines the Special Review Exemption for Institutional Proposal.
 */
public class InstitutionalProposalSpecialReviewExemption extends SpecialReviewExemption {

    private static final long serialVersionUID = -329478900344140486L;

    private Long proposalSpecialReviewExemptionId;

    private Long proposalSpecialReviewId;

    private InstitutionalProposalSpecialReview institutionalProposalSpecialReview;

    public Long getProposalSpecialReviewExemptionId() {
        return proposalSpecialReviewExemptionId;
    }

    public void setProposalSpecialReviewExemptionId(Long proposalSpecialReviewExemptionId) {
        this.proposalSpecialReviewExemptionId = proposalSpecialReviewExemptionId;
    }

    public Long getProposalSpecialReviewId() {
        return proposalSpecialReviewId;
    }

    public void setProposalSpecialReviewId(Long proposalSpecialReviewId) {
        this.proposalSpecialReviewId = proposalSpecialReviewId;
    }

    public void setInstitutionalProposalSpecialReview(InstitutionalProposalSpecialReview institutionalProposalSpecialReview) {
        this.institutionalProposalSpecialReview = institutionalProposalSpecialReview;
    }

    public InstitutionalProposalSpecialReview getInstitutionalProposalSpecialReview() {
        return institutionalProposalSpecialReview;
    }
}
