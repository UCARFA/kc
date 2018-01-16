/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.specialreview;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.common.framework.compliance.core.SpecialReview;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;

/**
 * Defines the Institutional Proposal Special Review.
 */
public class InstitutionalProposalSpecialReview extends SpecialReview<InstitutionalProposalSpecialReviewExemption> implements SequenceAssociate<InstitutionalProposal> {

    private static final long serialVersionUID = -3351482754078003727L;

    private Long proposalSpecialReviewId;

    private Long proposalId;

    private InstitutionalProposal sequenceOwner;

    public Long getProposalSpecialReviewId() {
        return proposalSpecialReviewId;
    }

    public void setProposalSpecialReviewId(Long proposalSpecialReviewId) {
        this.proposalSpecialReviewId = proposalSpecialReviewId;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    @Override
    public InstitutionalProposal getSequenceOwner() {
        return sequenceOwner;
    }

    @Override
    public void setSequenceOwner(InstitutionalProposal sequenceOwner) {
        this.sequenceOwner = sequenceOwner;
    }

    @Override
    public Integer getSequenceNumber() {
        return sequenceOwner != null ? sequenceOwner.getSequenceNumber() : null;
    }

    @Override
    public void resetPersistenceState() {
        proposalSpecialReviewId = null;
        for (InstitutionalProposalSpecialReviewExemption exemption : getSpecialReviewExemptions()) {
            exemption.setProposalSpecialReviewExemptionId(null);
            exemption.setProposalSpecialReviewId(null);
        }
    }

    @Override
    public InstitutionalProposalSpecialReviewExemption createSpecialReviewExemption(String exemptionTypeCode) {
        InstitutionalProposalSpecialReviewExemption institutionalProposalSpecialReviewExemption = new InstitutionalProposalSpecialReviewExemption();
        institutionalProposalSpecialReviewExemption.setExemptionTypeCode(exemptionTypeCode);
        institutionalProposalSpecialReviewExemption.setInstitutionalProposalSpecialReview(this);
        return institutionalProposalSpecialReviewExemption;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((proposalId == null) ? 0 : proposalId.hashCode());
        result = prime * result + ((proposalSpecialReviewId == null) ? 0 : proposalSpecialReviewId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InstitutionalProposalSpecialReview other = (InstitutionalProposalSpecialReview) obj;
        if (proposalId == null) {
            if (other.proposalId != null) {
                return false;
            }
        } else if (!proposalId.equals(other.proposalId)) {
            return false;
        }
        if (proposalSpecialReviewId == null) {
            if (other.proposalSpecialReviewId != null) {
                return false;
            }
        } else if (!proposalSpecialReviewId.equals(other.proposalSpecialReviewId)) {
            return false;
        }
        return true;
    }
}
