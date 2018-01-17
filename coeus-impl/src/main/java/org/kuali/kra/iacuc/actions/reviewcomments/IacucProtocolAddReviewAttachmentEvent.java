/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.reviewcomments;

import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.onlinereview.IacucProtocolReviewAttachment;
import org.kuali.kra.protocol.actions.reviewcomments.ProtocolAddReviewAttachmentEventBase;

public class IacucProtocolAddReviewAttachmentEvent extends ProtocolAddReviewAttachmentEventBase<IacucProtocolReviewAttachment> {

    public IacucProtocolAddReviewAttachmentEvent(IacucProtocolDocument document, String propertyName, IacucProtocolReviewAttachment reviewAttachment) {
        super(document, propertyName, reviewAttachment);
    }

    @Override
    protected IacucProtocolAddReviewAttachmentRule getNewProtocolAddReviewAttachmentRuleInstancehook() {
        return new IacucProtocolAddReviewAttachmentRule();        
    }

}
