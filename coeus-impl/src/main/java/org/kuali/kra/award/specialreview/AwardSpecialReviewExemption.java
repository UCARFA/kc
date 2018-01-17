/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.specialreview;

import org.kuali.coeus.common.framework.compliance.exemption.SpecialReviewExemption;

/**
 * Defines the Special Review Exemption for an Award.
 */
public class AwardSpecialReviewExemption extends SpecialReviewExemption {

    private static final long serialVersionUID = -589624827761999058L;

    private Long awardSpecialReviewExemptionId;

    private Long awardSpecialReviewId;

    private AwardSpecialReview awardSpecialReview;

    public Long getAwardSpecialReviewExemptionId() {
        return awardSpecialReviewExemptionId;
    }

    public void setAwardSpecialReviewExemptionId(Long awardSpecialReviewExemptionId) {
        this.awardSpecialReviewExemptionId = awardSpecialReviewExemptionId;
    }

    public Long getAwardSpecialReviewId() {
        return awardSpecialReviewId;
    }

    public void setAwardSpecialReviewId(Long awardSpecialReviewId) {
        this.awardSpecialReviewId = awardSpecialReviewId;
    }

    public AwardSpecialReview getAwardSpecialReview() {
        return awardSpecialReview;
    }

    public void setAwardSpecialReview(AwardSpecialReview awardSpecialReview) {
        this.awardSpecialReview = awardSpecialReview;
    }
}
