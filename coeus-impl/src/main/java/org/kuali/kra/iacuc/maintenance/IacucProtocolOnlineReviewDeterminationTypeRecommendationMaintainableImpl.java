/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.maintenance;


import org.kuali.kra.iacuc.onlinereview.IacucProtocolOnlineReviewDeterminationTypeRecommendation;
import org.kuali.kra.maintenance.KraMaintainableImpl;


public class IacucProtocolOnlineReviewDeterminationTypeRecommendationMaintainableImpl extends KraMaintainableImpl {

    private static final long serialVersionUID = 6613313050279041286L;
    
    //value should match org.kuali.kra.iacuc.onlinereview.IacucProtocolOnlineReviewTypesNotDeterminationValuesFinder.DEFAULT_SELECTION
    private static final String DEFAULT_SELECTION = "select";
      
    @Override
    public void prepareForSave() {
        IacucProtocolOnlineReviewDeterminationTypeRecommendation reviewTypeDeterBO = (IacucProtocolOnlineReviewDeterminationTypeRecommendation) getBusinessObject();
        
        if (reviewTypeDeterBO.getNewProtocolReviewTypeCode() != null && !reviewTypeDeterBO.getNewProtocolReviewTypeCode().equalsIgnoreCase(DEFAULT_SELECTION)) {
            reviewTypeDeterBO.setIacucProtocolReviewTypeCode(reviewTypeDeterBO.getNewProtocolReviewTypeCode());
        }

        super.prepareForSave();
    }
}
