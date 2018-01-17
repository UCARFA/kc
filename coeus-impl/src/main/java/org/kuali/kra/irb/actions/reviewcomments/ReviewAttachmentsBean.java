/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.reviewcomments;

import org.kuali.kra.irb.onlinereview.ProtocolReviewAttachment;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;

/**
 * 
 * This class for UI set up review attachments
 */
public class ReviewAttachmentsBean extends ReviewAttachmentsBeanBase<ProtocolReviewAttachment> {

    private static final long serialVersionUID = -5330578993055642005L;

    public ReviewAttachmentsBean(String errorPropertyKey) {
        super(errorPropertyKey);
    }

    @Override
    protected ProtocolReviewAttachment getNewProtocolReviewAttachmentInstanceHook() {
        return new ProtocolReviewAttachment();
    }
}
