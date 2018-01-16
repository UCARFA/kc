/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.genericactions;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;
import org.kuali.kra.irb.actions.reviewcomments.ReviewAttachmentsBean;
import org.kuali.kra.irb.actions.reviewcomments.ReviewCommentsBean;
import org.kuali.kra.protocol.actions.reviewcomments.ReviewAttachmentsBeanBase;

import java.sql.Date;

/**
 * This class is really just a "form" for generic actions.
 */
public class ProtocolGenericActionBean extends ProtocolActionBean implements org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean {

    private static final long serialVersionUID = 1098390205989217539L;
    
    private String comments = "";
    private Date actionDate = new Date(System.currentTimeMillis());
    
    private String errorPropertyKey;
    
    private ReviewCommentsBean reviewCommentsBean;
    private ReviewAttachmentsBean reviewAttachmentsBean;

    public ProtocolGenericActionBean() {}

    /**
     * Constructs a ProtocolGenericActionBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolGenericActionBean(ActionHelper actionHelper, String errorPropertyKey) {
        super(actionHelper);
        
        this.errorPropertyKey = errorPropertyKey;
        reviewCommentsBean = new ReviewCommentsBean(errorPropertyKey);
        reviewAttachmentsBean = new ReviewAttachmentsBean(errorPropertyKey);
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
    public ReviewCommentsBean getReviewCommentsBean() {
        return reviewCommentsBean;
    }

    @Override
    public ReviewAttachmentsBean getReviewAttachmentsBean() {
        return reviewAttachmentsBean;
    }

    @Override
    public void setReviewAttachmentsBean(ReviewAttachmentsBeanBase reviewAttachmentsBean) {
        this.reviewAttachmentsBean = (ReviewAttachmentsBean) reviewAttachmentsBean;
    }
    
}
