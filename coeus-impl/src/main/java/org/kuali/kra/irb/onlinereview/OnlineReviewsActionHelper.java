/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview;

import org.kuali.kra.irb.ProtocolForm;
import org.kuali.kra.irb.actions.reviewcomments.ReviewAttachmentsBean;
import org.kuali.kra.irb.actions.reviewcomments.ReviewCommentsBean;
import org.kuali.kra.irb.actions.reviewcomments.ReviewCommentsService;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;
import org.kuali.kra.protocol.onlinereview.OnlineReviewsActionHelperBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewFormBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;


public class OnlineReviewsActionHelper extends  OnlineReviewsActionHelperBase {


    private static final long serialVersionUID = 5629826686189661976L;

    public OnlineReviewsActionHelper(ProtocolForm form) {
        super(form);
    }

    @Override
    protected ProtocolOnlineReviewFormBase getNewProtocolOnlineReviewFormInstanceHook() throws Exception {
        return new ProtocolOnlineReviewForm();
    }

    @Override
    protected ReviewAttachmentsBeanBase<ProtocolReviewAttachment> getNewReviewAttachmentsBeanHook(String errorPropertyKey) {
        return new ReviewAttachmentsBean(errorPropertyKey);
    }

    @Override
    protected ReviewCommentsBeanBase getNewReviewCommentsBeanInstanceHook(String errorPropertyKey) {
        return new ReviewCommentsBean(errorPropertyKey);
    }

    @Override
    protected Class<? extends ProtocolOnlineReviewService> getProtocolOnlineReviewServiceClassHook() {
        return org.kuali.kra.irb.onlinereview.ProtocolOnlineReviewService.class;
    }

    @Override
    protected Class<? extends org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsService<ProtocolReviewAttachment>> getReviewCommentsServiceClassHook() {
        return ReviewCommentsService.class;
    }    
}

