/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;

import java.sql.Date;

/**
 * This class encapsulates the notion of a protocol review. Essentially 
 * a join between protocol, submission, and a reviewer.  The ProtocolReview
 * is created by the IRB Admin as request.
 */
public class IacucProtocolOnlineReview extends ProtocolOnlineReviewBase {
    
    

    private static final long serialVersionUID = -3526853926706200095L;

    private String determinationReviewTypeCode;

    private Date determinationReviewDateDue;

    
    @Override
    public String getNamespace() {
        return "KC-IACUC";
    }

    public String getDeterminationReviewTypeCode() {
        return determinationReviewTypeCode;
    }

    public void setDeterminationReviewTypeCode(String determinationReviewTypeCode) {
        this.determinationReviewTypeCode = determinationReviewTypeCode;
    }

    public Date getDeterminationReviewDateDue() {
        return determinationReviewDateDue;
    }

    public void setDeterminationReviewDateDue(Date determinationReviewDateDue) {
        this.determinationReviewDateDue = determinationReviewDateDue;
    }

    @Override
    protected String getProtocolOLRRemovedCancelledStatusCodeHook() {
        return IacucProtocolOnlineReviewStatus.REMOVED_CANCELLED_STATUS_CD;
    }

    @Override
    protected String getProtocolOLRFinalStatusCodeHook() {
        return IacucProtocolOnlineReviewStatus.FINAL_STATUS_CD;
    }


}
