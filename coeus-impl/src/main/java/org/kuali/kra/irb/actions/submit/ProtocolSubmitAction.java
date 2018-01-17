/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeMembershipBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.committee.bo.CommitteeMembership;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolActionBean;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewerBeanBase;
import org.springframework.util.AutoPopulatingList;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is really just a "form" for submitting a protocol for review in the Submit for Review Action.
 */
@SuppressWarnings("unchecked")
public class ProtocolSubmitAction extends ProtocolActionBean implements org.kuali.kra.protocol.actions.submit.ProtocolSubmitAction  {

    private static final long serialVersionUID = -4712974868607781787L;

    private String submissionTypeCode = "";
    private String protocolReviewTypeCode = "";
    private String submissionQualifierTypeCode = "";
    private String committeeId = "";
    private String scheduleId = "";
    private boolean committeeIdChanged = false;
    private boolean scheduleIdChanged = false;
    private boolean reviewerListAvailable = false;
    private int numberOfReviewers = 0;
    

    /*
     * We use a AutoPopulatingList because we need it to grow. When JavaScript is enabled, it will display the list of reviewers. When
     * the form is submitted, this list will automatically grow to accommodate all of the reviewers.
     */
    private List<ProtocolReviewerBean> reviewers = new AutoPopulatingList<ProtocolReviewerBean>(ProtocolReviewerBean.class);
    private List<ExpeditedReviewCheckListItem> expeditedReviewCheckList = null;
    private List<ExemptStudiesCheckListItem> exemptStudiesCheckList = null;
    private String newCommitteeId = "";
    private String newScheduleId = "";

    private int checkListItemDescriptionIndex = 0;
    private String selectedProtocolReviewTypeCode = null;

    private boolean javascriptEnabled = true;


    public ProtocolSubmitAction() {
    }

    /**
     * Constructs a ProtocolSubmitAction.
     * 
     * @param actionHelper Reference back to the action helper for this bean
     */
    public ProtocolSubmitAction(ActionHelper actionHelper) {
        super(actionHelper);
    }

    /**
     * Prepare the Submit for Review for rendering with JSP.
     */
    @Override
    public void prepareView() {
        if (expeditedReviewCheckList == null) {
            expeditedReviewCheckList = getCheckListService().getExpeditedReviewCheckList();
            exemptStudiesCheckList = getCheckListService().getExemptStudiesCheckList();
        }
        

        /*
         * The Submit for Review has to work with and without JavaScript. When JavaScript is enabled, the newly selected committee
         * and schedule are what we want to continue to display. When JavaScript is disabled, we have to change the schedule dates
         * that we display if the committee has changed.
         */
        if (!this.getJavascriptEnabled()) {
            if ((!StringUtils.isBlank(this.committeeId)) && (!this.committeeIdChanged) && (!StringUtils.isBlank(this.scheduleId))) {
                if (this.scheduleIdChanged) {
                    reviewers.clear();
                    buildReviewers();
                }
            }
            else {
                reviewers.clear();
                this.reviewerListAvailable = false;
            }
        }
        else {
            // use the numberOfReviewers property (sent in as a hidden input field) to truncate the reviewers collection if needed
            this.reviewers.subList(this.numberOfReviewers, this.reviewers.size()).clear();            
        }
    }


    /**
     * Create the list of reviewers based upon the currently selected committee and schedule.
     */
    private void buildReviewers() {
        this.reviewerListAvailable = true;
        List<CommitteeMembershipBase> members = getProtocol().filterOutProtocolPersonnel(
                getCommitteeService().getAvailableMembers(this.committeeId, this.scheduleId));
        for (CommitteeMembershipBase member : members) {
            ProtocolReviewerBean reviewer = new ProtocolReviewerBean((CommitteeMembership) member);
            reviewers.add(reviewer);
        }
    }
    

    @Override
    public void setNumberOfReviewers(int numberOfReviewers) {
        this.numberOfReviewers = numberOfReviewers;
    }


    @Override
    public CommitteeService getCommitteeService() {
        return KcServiceLocator.getService(CommitteeService.class);
    }

    @Override
    public String getSubmissionTypeCode() {
        return submissionTypeCode;
    }

    @Override
    public void setSubmissionTypeCode(String submissionTypeCode) {
        this.submissionTypeCode = submissionTypeCode;
    }

    @Override
    public String getProtocolReviewTypeCode() {
        return protocolReviewTypeCode;
    }

    @Override
    public void setProtocolReviewTypeCode(String protocolReviewTypeCode) {
        this.protocolReviewTypeCode = protocolReviewTypeCode;
    }

    @Override
    public String getSubmissionQualifierTypeCode() {
        return submissionQualifierTypeCode;
    }

    @Override
    public void setSubmissionQualifierTypeCode(String submissionQualifierTypeCode) {
        this.submissionQualifierTypeCode = submissionQualifierTypeCode;
    }

    @Override
    public String getCommitteeId() {
        return committeeId;
    }

    @Override
    public void setCommitteeId(String committeeId) {
        this.committeeIdChanged = true;
        if (StringUtils.equals(this.committeeId, committeeId)) {
            this.committeeIdChanged = false;
        }
        this.committeeId = committeeId;

        // TODO: to be removed eventually
        this.newCommitteeId = committeeId;
    }

    // TODO: to be removed eventually deleted
    @Override
    public void setNewCommitteeId(String id) {
        this.newCommitteeId = id;
    }

    // TODO: to be removed eventually with references renamed to getCommitteeId()
    @Override
    public String getNewCommitteeId() {
        return newCommitteeId;
    }

    @Override
    public String getScheduleId() {
        return scheduleId;
    }

    @Override
    public void setScheduleId(String scheduleId) {
        this.scheduleIdChanged = true;
        if (StringUtils.equals(this.scheduleId, scheduleId)) {
            this.scheduleIdChanged = false;
        }
        this.scheduleId = scheduleId;
        
        // TODO: to be removed eventually
        this.newScheduleId = scheduleId;
    }

    // TODO: to be removed eventually with references renamed to getScheduleId()
    @Override
    public String getNewScheduleId() {
        return newScheduleId;
    }

    @Override
    public boolean isReviewerListAvailable() {
        return reviewerListAvailable;
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
     * We display the reviewers in two columns. These are the reviewers in the left column.
     * 
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
     * We display the reviewers in two columns. These are the reviewers in the right column.
     * 
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

    @Override
    public void setReviewers(List<ProtocolReviewerBeanBase> reviewerBeans) {
        this.reviewers = (List) reviewerBeans;
    }

    public void setExpeditedReviewCheckList(List<ExpeditedReviewCheckListItem> checkList) {
        this.expeditedReviewCheckList = checkList;
    }

    public List<ExpeditedReviewCheckListItem> getExpeditedReviewCheckList() {
        return expeditedReviewCheckList;
    }

    public void setExemptStudiesCheckList(List<ExemptStudiesCheckListItem> checkList) {
        this.exemptStudiesCheckList = checkList;
    }

    public List<ExemptStudiesCheckListItem> getExemptStudiesCheckList() {
        return exemptStudiesCheckList;
    }

    /**
     * When a user wants to display the entire description of check list item, the currently selected protocol review type and the
     * index of the check list item are stored here for later rendering.
     * 
     * @param protocolReviewTypeCode
     * @param index
     */
    public void setCheckListItemDescriptionInfo(String protocolReviewTypeCode, int index) {
        this.selectedProtocolReviewTypeCode = protocolReviewTypeCode;
        checkListItemDescriptionIndex = index;
    }

    /**
     * Get the description of the check list item that was specified in setCheckListItemDescriptionInfo().
     * 
     * @return
     */
    public String getCheckListItemDescription() {
        if (ProtocolReviewType.EXPEDITED_REVIEW_TYPE_CODE.equals(selectedProtocolReviewTypeCode)) {
            return getExpeditedReviewCheckList().get(checkListItemDescriptionIndex).getDescription();
        }
        else if (ProtocolReviewType.EXEMPT_STUDIES_REVIEW_TYPE_CODE.equals(selectedProtocolReviewTypeCode)) {
            return getExemptStudiesCheckList().get(checkListItemDescriptionIndex).getDescription();
        }
        return "";
    }

    private CheckListService getCheckListService() {
        return KcServiceLocator.getService(CheckListService.class);
    }

    @Override
    public boolean getJavascriptEnabled() {
        return javascriptEnabled;
    }

    @Override
    public void setJavascriptEnabled(boolean javascriptEnabled) {
        this.javascriptEnabled = javascriptEnabled;
    }
    
    public boolean isExpeditedProtocolReviewType() {
        boolean retVal = false;
        if (ProtocolReviewType.EXPEDITED_REVIEW_TYPE_CODE.equals(getProtocolReviewTypeCode())) {
            retVal = true;
        }
        return retVal;
    }


}
