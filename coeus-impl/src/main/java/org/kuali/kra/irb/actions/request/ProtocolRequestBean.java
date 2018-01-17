/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.request;

import org.kuali.kra.irb.actions.ActionHelper;
import org.kuali.kra.irb.actions.ProtocolSubmissionBeanBase;
import org.kuali.kra.irb.questionnaire.IrbSubmissionQuestionnaireHelper;
import org.kuali.kra.protocol.questionnaire.ProtocolSubmissionQuestionnaireHelper;

/**
 * The ProtocolRequestBean is used for some of the common, yet simple,
 * protocol request actions.  Those actions are:
 * 
 * 1. Request to Close
 * 2. Request for Suspension
 * 3. Request to Close Enrollment
 * 4. Request to Re-open Enrollment
 * 5. Request for Data Analysis Only
 * 
 * For each of these request actions, a user can select a committee and give
 * a reason for the request.  Each request, though, will require a different
 * protocol action type and submission type entry in the database.  Please
 * see the ActionHelper class for how this class is used.
 */
public class ProtocolRequestBean extends ProtocolSubmissionBeanBase implements org.kuali.kra.protocol.actions.request.ProtocolRequestBean {
    
    private static final long serialVersionUID = -4980779026132275453L;
    private String protocolActionTypeCode;
    private String submissionTypeCode;
    private String reason = "";
    private String beanName;
    private ProtocolSubmissionQuestionnaireHelper questionnaireHelper;

    /**
     * Constructs a ProtocolRequestBean.
     * @param actionHelper Reference back to the action helper for this bean
     * @param protocolActionTypeCode
     * @param submissionTypeCode
     * @param beanName
     */
    public ProtocolRequestBean(ActionHelper actionHelper, String protocolActionTypeCode, String submissionTypeCode, String beanName) {
        super(actionHelper);
        
        this.protocolActionTypeCode = protocolActionTypeCode;
        this.submissionTypeCode = submissionTypeCode;
        this.beanName = beanName;
        questionnaireHelper = new IrbSubmissionQuestionnaireHelper(actionHelper.getProtocol(), protocolActionTypeCode, null, false);

    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String getReason() {
        return reason;
    }

    @Override
    public String getProtocolActionTypeCode() {
        return protocolActionTypeCode;
    }

    @Override
    public String getSubmissionTypeCode() {
        return submissionTypeCode;
    }
    
    @Override
    public String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public ProtocolSubmissionQuestionnaireHelper getQuestionnaireHelper() {
        return questionnaireHelper;
    }

    public void setQuestionnaireHelper(ProtocolSubmissionQuestionnaireHelper questionnaireHelper) {
        this.questionnaireHelper = questionnaireHelper;
    }
    
}
