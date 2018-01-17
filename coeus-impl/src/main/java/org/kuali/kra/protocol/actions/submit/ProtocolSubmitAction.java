/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.submit;

import org.kuali.coeus.common.committee.impl.service.CommitteeServiceBase;
import org.kuali.kra.protocol.actions.ProtocolActionBean;

import java.io.Serializable;
import java.util.List;

/**
 * This class is really just a "form" for submitting a protocol for review in the Submit for Review Action.
 */
public interface ProtocolSubmitAction extends ProtocolActionBean, Serializable {

    public void prepareView();

    public void setNumberOfReviewers(int numberOfReviewers);

    public CommitteeServiceBase getCommitteeService();

    public String getSubmissionTypeCode();

    public void setSubmissionTypeCode(String submissionTypeCode);

    public String getProtocolReviewTypeCode();

    public void setProtocolReviewTypeCode(String protocolReviewTypeCode);

    public String getSubmissionQualifierTypeCode();

    public void setSubmissionQualifierTypeCode(String submissionQualifierTypeCode);

    public String getCommitteeId();
    
    public void setCommitteeId(String committeeId);
    
    // TODO: to be removed eventually deleted
    public void setNewCommitteeId(String id);

    // TODO: to be removed eventually with references renamed to getCommitteeId()
    public String getNewCommitteeId();

    public String getScheduleId();

    public void setScheduleId(String scheduleId);

    // TODO: to be removed eventually with references renamed to getScheduleId()
    public String getNewScheduleId();

    public boolean isReviewerListAvailable();

    public List<ProtocolReviewerBeanBase> getReviewers();

    public ProtocolReviewerBeanBase getReviewer(int i);

    /**
     * We display the reviewers in two columns. These are the reviewers in the left column.
     * 
     * @return
     */
    public List<ProtocolReviewerBeanBase> getLeftReviewers();
    
    /**
     * We display the reviewers in two columns. These are the reviewers in the right column.
     * 
     * @return
     */
    public List<ProtocolReviewerBeanBase> getRightReviewers();

    public void setReviewers(List<ProtocolReviewerBeanBase> reviewerBeans);
    
    public boolean getJavascriptEnabled();

    public void setJavascriptEnabled(boolean javascriptEnabled);

}
