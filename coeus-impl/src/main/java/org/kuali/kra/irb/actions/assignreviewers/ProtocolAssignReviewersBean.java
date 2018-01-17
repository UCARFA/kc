/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assignreviewers;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;
import org.kuali.kra.irb.actions.submit.ProtocolReviewType;
import org.kuali.kra.irb.actions.submit.ProtocolReviewerBean;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewerBeanBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is really just a "form" for assigning a protocol
 * to one or more reviewers.
 */
public class ProtocolAssignReviewersBean extends ProtocolActionBean implements org.kuali.kra.protocol.actions.assignreviewers.ProtocolAssignReviewersBean {

    private static final long serialVersionUID = -3769655019628462999L;
    
    private String currentCommitteeId = null;
    private String currentScheduleId = null;
    private List<ProtocolReviewerBean> reviewers = new ArrayList<ProtocolReviewerBean>();
    
    /**
     * Constructs a ProtocolAssignReviewersBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolAssignReviewersBean(ActionHelper actionHelper) {
        super(actionHelper);
    }
    
    /**
     * Create the list of reviewers based upon the current committee
     * and schedule, and assigns their reviewer types if any have been saved in the past
     */
    @Override
    public void prepareView() {
        ProtocolSubmission submission = (ProtocolSubmission) getProtocol().getProtocolSubmission();
        if (submission != null) {
            String committeeId = submission.getCommitteeId();
            String scheduleId = submission.getScheduleId();
            
            //reviwers list always needs to be emptied as it will be either left empty or re-populated
            reviewers.clear();
            if (!StringUtils.equals(committeeId, currentCommitteeId) || !StringUtils.equals(scheduleId, currentScheduleId)) {
                currentCommitteeId = committeeId;
                currentScheduleId = scheduleId;
                //scheduleID present in this conditional so submit for review action will dynamically show/hide reviewers on that action panel
                if (!StringUtils.isBlank(committeeId) && (!StringUtils.isBlank(scheduleId) || isExpeditedSubmission(submission))) {
                    populateReviewers(committeeId, scheduleId, submission);
                } else {
                    //get reviewers based solely on committeeId letting scheduleId be null when submission review type is not a full committee review
                    if (!StringUtils.isBlank(committeeId) && !isFullCommitteeReview(submission)) {
                        populateReviewers(committeeId, scheduleId, submission);
                    }
                }
            } else {
                //committeeId and scheduleId may not have changed but submission review type could have
                //get reviewers based solely on committeeId letting scheduleId be null when submission review type is not a full committee review
                if (!StringUtils.isBlank(committeeId) && !(isScheduleRequiredForReview(submission, scheduleId) && StringUtils.isBlank(scheduleId)) ) {
                    populateReviewers(committeeId, scheduleId, submission);
                }
            }
        }
    }
    
    
    private void populateReviewers(String committeeId, String scheduleId, ProtocolSubmission submission) {
                    List<CommitteeMembershipBase> members = getProtocol().filterOutProtocolPersonnel(getCommitteeService().getAvailableMembers(committeeId, scheduleId));
                    for (CommitteeMembershipBase member : members) {
                        reviewers.add(new ProtocolReviewerBean((CommitteeMembership) member));
                    }
                    
                    for (ProtocolOnlineReviewBase review : submission.getProtocolOnlineReviews()) {
                        if (review.isActive()) {
                            for (ProtocolReviewerBean reviewerBean : reviewers) {
                                if (reviewerBean.isProtocolReviewerBeanForReviewer(review.getProtocolReviewer())) {
                                    reviewerBean.setReviewerTypeCode(review.getProtocolReviewer().getReviewerTypeCode());
                                    break;
                                }
                            }
                        }
                    }
                }
    
    private CommitteeService getCommitteeService() {
        return KcServiceLocator.getService(CommitteeService.class);
    }
    
    @Override
    public List<ProtocolReviewerBeanBase> getReviewers() {
        return (List) reviewers;
    }
    
    @Override
    public ProtocolReviewerBean getReviewer(int i) {
        return reviewers.get(i);
    }
    
    /**
     * We display the reviewers in two columns.  These are the
     * reviewers in the left column.
     * @return
     */
    @Override
    public List<ProtocolReviewerBeanBase> getLeftReviewers() {
        List<ProtocolReviewerBeanBase> leftReviewers = new ArrayList<ProtocolReviewerBeanBase>();
        for (int i = 0; i < (reviewers.size() + 1) / 2; i++) {
            leftReviewers.add(reviewers.get(i));
        }
        return leftReviewers;
    }
    
    /**
     * We display the reviewers in two columns.  These are the
     * reviewers in the right column.
     * @return
     */
    @Override
    public List<ProtocolReviewerBeanBase> getRightReviewers() {
        List<ProtocolReviewerBeanBase> rightReviewers = new ArrayList<ProtocolReviewerBeanBase>();
        for (int i = (reviewers.size() + 1) / 2; i < reviewers.size(); i++) {
            rightReviewers.add(reviewers.get(i));
        }
        return rightReviewers;
    }
    
    private boolean isExpeditedSubmission(ProtocolSubmission submission) {
        return submission != null && ProtocolReviewType.EXPEDITED_REVIEW_TYPE_CODE.equals(submission.getProtocolReviewTypeCode());
    }
    
    private boolean isFullCommitteeReview(ProtocolSubmission submission) {
        return submission != null && ProtocolReviewType.FULL_TYPE_CODE.equals(submission.getProtocolReviewTypeCode());
    }
    
    private boolean isScheduleRequiredForReview (ProtocolSubmission submission, String scheduleId) {        
        return isFullCommitteeReview(submission) && !StringUtils.isBlank(scheduleId);
    }
    
}
