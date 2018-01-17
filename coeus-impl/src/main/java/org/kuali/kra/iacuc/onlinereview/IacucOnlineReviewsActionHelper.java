/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.kra.iacuc.IacucProtocolForm;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewAttachmentsBean;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewCommentsBean;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewCommentsService;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsService;
import org.kuali.kra.protocol.onlinereview.OnlineReviewsActionHelperBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewFormBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;

public class IacucOnlineReviewsActionHelper  extends  OnlineReviewsActionHelperBase {
   

    private static final long serialVersionUID = 8937646851450759832L;
    

    public IacucOnlineReviewsActionHelper(IacucProtocolForm form) {
        super(form);
    }

    
    @Override
    protected ReviewAttachmentsBeanBase getNewReviewAttachmentsBeanHook(String errorPropertyKey) {
        return new IacucReviewAttachmentsBean(errorPropertyKey);
    }

    @Override
    protected ReviewCommentsBeanBase getNewReviewCommentsBeanInstanceHook(String errorPropertyKey) {
        return new IacucReviewCommentsBean(errorPropertyKey);
    }


    @Override
    protected ProtocolOnlineReviewFormBase getNewProtocolOnlineReviewFormInstanceHook() throws Exception {
        return new IacucProtocolOnlineReviewForm();
    }


    @Override
    protected Class<? extends ProtocolOnlineReviewService> getProtocolOnlineReviewServiceClassHook() {
        return IacucProtocolOnlineReviewService.class;
    }


    @Override
    protected Class<? extends ReviewCommentsService> getReviewCommentsServiceClassHook() {
        return IacucReviewCommentsService.class;
    }


}
