/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.request;

import org.kuali.kra.protocol.actions.ProtocolSubmissionBeanBase;
import org.kuali.kra.protocol.questionnaire.ProtocolSubmissionQuestionnaireHelper;

import java.io.Serializable;

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
 * see the ActionHelperBase class for how this class is used.
 */
public interface ProtocolRequestBean extends ProtocolSubmissionBeanBase, Serializable {
   

    public void setReason(String reason);
    
    public String getReason();

    public String getProtocolActionTypeCode();

    public String getSubmissionTypeCode();
    
    public String getBeanName();

    public void setBeanName(String beanName);
    
    public ProtocolSubmissionQuestionnaireHelper getQuestionnaireHelper();
}
