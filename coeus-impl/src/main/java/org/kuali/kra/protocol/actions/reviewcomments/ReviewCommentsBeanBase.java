/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.reviewcomments;

import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleMinuteBase;
import org.kuali.coeus.common.committee.impl.meeting.MinuteEntryType;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class ReviewCommentsBeanBase  implements Serializable {



    private static final long serialVersionUID = 994429171132365761L;

    private String errorPropertyKey;
    
    private CommitteeScheduleMinuteBase newReviewComment;
    private List<CommitteeScheduleMinuteBase> reviewComments;
    private List<CommitteeScheduleMinuteBase> deletedReviewComments;
    // flag to hide reviewer name for this bean.
    private boolean hideReviewerName;

    public ReviewCommentsBeanBase(String errorPropertyKey) {
        this.errorPropertyKey = errorPropertyKey + ".reviewCommentsBean";
        
        this.newReviewComment = getNewCommitteeScheduleMinuteInstanceHook();
        this.newReviewComment.setMinuteEntryTypeCode(MinuteEntryType.PROTOCOL);
        this.reviewComments = new ArrayList<CommitteeScheduleMinuteBase>();
        this.deletedReviewComments = new ArrayList<CommitteeScheduleMinuteBase>();
    }

    protected abstract CommitteeScheduleMinuteBase getNewCommitteeScheduleMinuteInstanceHook();

    public String getErrorPropertyName() {
        return errorPropertyKey;
    }
    
    public CommitteeScheduleMinuteBase getNewReviewComment() {
        return newReviewComment;
    }
    
    public void setNewReviewComment(CommitteeScheduleMinuteBase newReviewComment) {
        this.newReviewComment = newReviewComment;
    }
    
    public List<CommitteeScheduleMinuteBase> getReviewComments() {
        return reviewComments;
    }
    
    public void setReviewComments(List<CommitteeScheduleMinuteBase> reviewComments) {
        this.reviewComments = reviewComments;         
        this.setHideReviewerName(getReviewCommentsService().setHideReviewerName(this.reviewComments));
    }
    
    public List<CommitteeScheduleMinuteBase> getDeletedReviewComments() {
        return deletedReviewComments;
    }
    
    public void setDeletedReviewComments(List<CommitteeScheduleMinuteBase> deletedReviewComments) {
        this.deletedReviewComments = deletedReviewComments;
    }

    public boolean isHideReviewerName() {
        return hideReviewerName;
    }

    public void setHideReviewerName(boolean hideReviewerName) {
        this.hideReviewerName = hideReviewerName;
    }
    
    private ReviewCommentsService getReviewCommentsService() {
        return KcServiceLocator.getService(getReviewCommentsServiceClassHook());
    }

    protected abstract Class<? extends ReviewCommentsService> getReviewCommentsServiceClassHook();


}
