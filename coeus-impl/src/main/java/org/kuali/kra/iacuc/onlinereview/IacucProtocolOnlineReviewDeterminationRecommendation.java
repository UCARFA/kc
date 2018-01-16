/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewTypeBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewDeterminationRecommendationBase;

public class IacucProtocolOnlineReviewDeterminationRecommendation extends ProtocolOnlineReviewDeterminationRecommendationBase {


    private static final long serialVersionUID = -1768290517796704487L;

    private String iacucProtocolReviewTypeCode;
    
    private ProtocolReviewTypeBase iacucProtocolReviewType;

    private IacucProtocolActionType iacucProtocolActionType;
    
    private String iacucProtocolActionTypeCode;
    
    public String getIacucProtocolReviewTypeCode() {
        return iacucProtocolReviewTypeCode;
    }

    public void setIacucProtocolReviewTypeCode(String iacucProtocolReviewTypeCode) {
        this.iacucProtocolReviewTypeCode = iacucProtocolReviewTypeCode;
    }

    public ProtocolReviewTypeBase getIacucProtocolReviewType() {
        if (iacucProtocolReviewType == null || !iacucProtocolReviewType.getReviewTypeCode().equals(iacucProtocolReviewTypeCode)) {
            refreshReferenceObject("iacucProtocolReviewType");
        }
        return iacucProtocolReviewType;
    }

    public void setIacucProtocolReviewType(ProtocolReviewTypeBase iacucProtocolReviewType) {
        this.iacucProtocolReviewType = iacucProtocolReviewType;
    }

    public IacucProtocolActionType getIacucProtocolActionType() {
        if (iacucProtocolActionType == null || !iacucProtocolActionType.getProtocolActionTypeCode().equals(iacucProtocolActionTypeCode)) {
            refreshReferenceObject("iacucProtocolActionType");
        }
        return iacucProtocolActionType;
    }

    public void setIacucProtocolActionType(IacucProtocolActionType iacucProtocolActionType) {
        this.iacucProtocolActionType = iacucProtocolActionType;
    }

    public String getIacucProtocolActionTypeCode() {
        return iacucProtocolActionTypeCode;
    }

    public void setIacucProtocolActionTypeCode(String iacucProtocolActionTypeCode) {
        this.iacucProtocolActionTypeCode = iacucProtocolActionTypeCode;
    }

}
