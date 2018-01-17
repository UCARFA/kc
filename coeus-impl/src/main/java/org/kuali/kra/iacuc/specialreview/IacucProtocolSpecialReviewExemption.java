/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.specialreview;

import org.kuali.kra.protocol.specialreview.ProtocolSpecialReviewExemption;

/**
 * Defines a Special Review Exemption for a Protocol.
 */
public class IacucProtocolSpecialReviewExemption extends ProtocolSpecialReviewExemption {

    @Override
    public IacucProtocolSpecialReview getProtocolSpecialReview() {
        return (IacucProtocolSpecialReview) getProtocolSpecialReview();
    }

    public void setProtocolSpecialReview(IacucProtocolSpecialReview protocolSpecialReview) {
        super.setProtocolSpecialReview(protocolSpecialReview);
    }
}
