/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.protocol.actions.submit.ProtocolReviewTypeBase;

public class IacucProtocolOnlineReviewDeterminationTypeRecommendation extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 2274982797374476521L;
    
    
    private String iacucProtocolReviewTypeCode;
    private ProtocolReviewTypeBase iacucProtocolReviewType;
    
    private transient String newProtocolReviewTypeCode;  //for values finder on create new page
    
    public IacucProtocolOnlineReviewDeterminationTypeRecommendation() {
        
    }
    
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
    
    public String getNewProtocolReviewTypeCode() {         
        return newProtocolReviewTypeCode;
    }
    
    public void setNewProtocolReviewTypeCode(String newProtocolReviewTypeCode) {         
        this.newProtocolReviewTypeCode = newProtocolReviewTypeCode;
    }
    
}
