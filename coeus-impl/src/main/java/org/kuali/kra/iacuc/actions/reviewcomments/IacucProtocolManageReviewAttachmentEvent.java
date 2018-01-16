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
import org.kuali.kra.protocol.actions.reviewcomments.ProtocolManageReviewAttachmentEventBase;

import java.util.List;

public class IacucProtocolManageReviewAttachmentEvent extends ProtocolManageReviewAttachmentEventBase<IacucProtocolReviewAttachment> {

    public IacucProtocolManageReviewAttachmentEvent(IacucProtocolDocument document, String propertyName, List<IacucProtocolReviewAttachment> reviewAttachments) {
        super(document, propertyName, reviewAttachments);
    }

    @Override
    protected IacucProtocolManageReviewAttachmentRule getNewProtocolManageReviewAttachmentRuleInstaceHook() {
        return new IacucProtocolManageReviewAttachmentRule();
    }

}
