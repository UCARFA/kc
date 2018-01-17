/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.specialreview;

import org.kuali.coeus.common.framework.compliance.core.SpecialReview;
import org.kuali.coeus.common.framework.compliance.core.SpecialReviewApprovalType;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.specialreview.impl.ProtocolSpecialReviewServiceImplBase;

import java.util.ArrayList;
import java.util.List;

public class IacucProtocolSpecialReviewServiceImpl extends ProtocolSpecialReviewServiceImplBase 
    implements IacucProtocolSpecialReviewService {

    @SuppressWarnings("rawtypes")
    @Override
    protected void setSpecialReviewApprovalTypeHook(SpecialReview specialReview)
    {
        specialReview.setApprovalTypeCode(SpecialReviewApprovalType.LINK_TO_IACUC);        
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    protected void setProtocolExemptStudiesCheckListItemHook(ProtocolBase protocol, SpecialReview specialReview) {
        List<String> exemptionTypeCodes = new ArrayList<String>();
        specialReview.setExemptionTypeCodes(exemptionTypeCodes);

    }

}
