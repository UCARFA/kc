/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.reviewcomments;

import org.kuali.kra.protocol.onlinereview.ProtocolReviewAttachmentBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ReviewAttachmentsBeanBase<PRA extends ProtocolReviewAttachmentBase> implements Serializable {



    private static final long serialVersionUID = -376105485699731967L;
    
    private String errorPropertyKey;
    private PRA newReviewAttachment;
    private List<PRA> reviewAttachments;
    private List<PRA> deletedReviewAttachments;
    // flag to hide reviewer name for this bean.
    private boolean hideReviewerName;

    public ReviewAttachmentsBeanBase(String errorPropertyKey) {
        this.errorPropertyKey = errorPropertyKey + ".reviewAttachmentsBean";        
        this.newReviewAttachment = getNewProtocolReviewAttachmentInstanceHook();
        this.reviewAttachments = new ArrayList<PRA>();
        this.deletedReviewAttachments = new ArrayList<PRA>();
    }

    protected abstract PRA getNewProtocolReviewAttachmentInstanceHook();
    
    public String getErrorPropertyName() {
        return errorPropertyKey;
    }
    

    public boolean isHideReviewerName() {
        return hideReviewerName;
    }

    public void setHideReviewerName(boolean hideReviewerName) {
        this.hideReviewerName = hideReviewerName;
    }
    
    public PRA getNewReviewAttachment() {
        return newReviewAttachment;
    }

    public void setNewReviewAttachment(PRA newReviewAttachment) {
        this.newReviewAttachment = newReviewAttachment;
    }

    public List<PRA> getReviewAttachments() {
        return reviewAttachments;
    }

    public void setReviewAttachments(List<PRA> reviewAttachments) {
        this.reviewAttachments = reviewAttachments;
    }

    public List<PRA> getDeletedReviewAttachments() {
        return deletedReviewAttachments;
    }

    public void setDeletedReviewAttachments(List<PRA> deletedReviewAttachments) {
        this.deletedReviewAttachments = deletedReviewAttachments;
    }
}
