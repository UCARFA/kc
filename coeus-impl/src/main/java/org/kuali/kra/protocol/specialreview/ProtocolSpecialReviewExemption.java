/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.specialreview;

import org.kuali.coeus.common.framework.compliance.exemption.SpecialReviewExemption;

/**
 * Defines a Special Review Exemption for a ProtocolBase.
 */
public class ProtocolSpecialReviewExemption extends SpecialReviewExemption {

    private static final long serialVersionUID = 5397618472812176402L;

    private Long protocolSpecialReviewExemptionId;

    private Long protocolSpecialReviewId;

    private ProtocolSpecialReviewBase protocolSpecialReview;

    public Long getProtocolSpecialReviewExemptionId() {
        return protocolSpecialReviewExemptionId;
    }

    public void setProtocolSpecialReviewExemptionId(Long protocolSpecialReviewExemptionId) {
        this.protocolSpecialReviewExemptionId = protocolSpecialReviewExemptionId;
    }

    public Long getProtocolSpecialReviewId() {
        return protocolSpecialReviewId;
    }

    public void setProtocolSpecialReviewId(Long protocolSpecialReviewId) {
        this.protocolSpecialReviewId = protocolSpecialReviewId;
    }

    public ProtocolSpecialReviewBase getProtocolSpecialReview() {
        return protocolSpecialReview;
    }

    public void setProtocolSpecialReview(ProtocolSpecialReviewBase protocolSpecialReview) {
        this.protocolSpecialReview = protocolSpecialReview;
    }
}
