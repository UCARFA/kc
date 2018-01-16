/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.notifyiacuc;

import org.kuali.kra.iacuc.actions.IacucActionHelper;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.request.IacucProtocolRequestBean;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;

import java.io.Serializable;

/**
 * This class is really just a "form" for notifying the IRB.
 */
public class IacucProtocolNotifyIacucBean extends  IacucProtocolRequestBean implements Serializable {
    
    private static final long serialVersionUID = -1572148230502384077L;
    private String submissionQualifierTypeCode;
    private String reviewTypeCode;
    private String comment = "";
    
    /**
     * Constructs a ProtocolNotifyIrbBean.
     * @param actionHelper Reference back to the action helper for this bean
     */
    public IacucProtocolNotifyIacucBean(IacucActionHelper actionHelper, String beanName) {
        super(actionHelper, IacucProtocolActionType.NOTIFY_IACUC, IacucProtocolSubmissionType.NOTIFY_IACUC, beanName);
        setCommitteeId(actionHelper.getProtocol().getProtocolSubmission().getCommitteeId());
    }

    public String getSubmissionQualifierTypeCode() {
        return submissionQualifierTypeCode;
    }

    public void setSubmissionQualifierTypeCode(String submissionQualifierTypeCode) {
        this.submissionQualifierTypeCode = submissionQualifierTypeCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String getReviewTypeCode() {
        return reviewTypeCode;
    }

    public void setReviewTypeCode(String reviewTypeCode) {
        this.reviewTypeCode = reviewTypeCode;
    }
}
