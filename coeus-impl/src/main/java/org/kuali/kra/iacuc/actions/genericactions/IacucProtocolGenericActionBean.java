/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.genericactions;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionBean;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewAttachmentsBean;
import org.kuali.kra.iacuc.actions.reviewcomments.IacucReviewCommentsBean;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewCommentsBeanBase;

import java.sql.Date;

/**
 * This class is really just a "form" for generic actions.
 */
public class IacucProtocolGenericActionBean extends IacucProtocolActionBean implements ProtocolGenericActionBean {

    private static final long serialVersionUID = 1098390205989217539L;
    
    private String comments = "";
    private Date actionDate = new Date(System.currentTimeMillis());
    
    private String errorPropertyKey;
    
    private ReviewCommentsBeanBase reviewCommentsBean;
    private ReviewAttachmentsBeanBase reviewAttachmentsBean;
    
    /**
     * Constructs a ProtocolGenericActionBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolGenericActionBean(IacucActionHelper actionHelper, String errorPropertyKey) {
        super(actionHelper);
        
        this.errorPropertyKey = errorPropertyKey;
        reviewCommentsBean = new IacucReviewCommentsBean(errorPropertyKey);       
        reviewAttachmentsBean = new IacucReviewAttachmentsBean(errorPropertyKey);
    }

    @Override
    public String getComments() {
        return comments;
    }
    
    @Override
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @Override
    public Date getActionDate() {
        return actionDate;
    }
    
    @Override
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    
    @Override
    public String getErrorPropertyKey() {
        return errorPropertyKey;
    }

    @Override
    public ReviewCommentsBeanBase getReviewCommentsBean() {
        return reviewCommentsBean;
    }

    @Override
    public ReviewAttachmentsBeanBase getReviewAttachmentsBean() {
        return reviewAttachmentsBean;
    }

    @Override
    public void setReviewAttachmentsBean(ReviewAttachmentsBeanBase reviewAttachmentsBean) {
        this.reviewAttachmentsBean = reviewAttachmentsBean;
    }
    
}
