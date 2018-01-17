/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.coeus.sys.framework.keyvalue.ExtendedPersistableBusinessObjectValuesFinder;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.service.KeyValuesService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IacucProtocolOnlineReviewTypesNotDeterminationValuesFinder extends ExtendedPersistableBusinessObjectValuesFinder {
        

    private static final long serialVersionUID = -4118821657613491616L;
    
    
    //value should match org.kuali.kra.maintenanceIacucProtocolOnlineReviewDeterminationTypeRecommendationMaintainableImpl.DEFAULT_SELECTION
    private static final String DEFAULT_SELECTION = "select"; 
    
    KeyValuesService keyValuesService = null;

    
    
    @Override
    public List<KeyValue> getKeyValues() {        
        Collection<IacucProtocolOnlineReviewDeterminationTypeRecommendation> reviewTypesUsedInDetermination = getKeyValuesService().findAll(IacucProtocolOnlineReviewDeterminationTypeRecommendation.class);
        Collection<IacucProtocolReviewType> allReviewTypes = getKeyValuesService().findAll(IacucProtocolReviewType.class);
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue("", DEFAULT_SELECTION));
        boolean found = false;
        
        for (IacucProtocolReviewType reviewType : allReviewTypes) {            
            for (IacucProtocolOnlineReviewDeterminationTypeRecommendation reviewTypesUsed : reviewTypesUsedInDetermination) {
                if (reviewType.getReviewTypeCode() != null && reviewTypesUsed.getIacucProtocolReviewTypeCode() != null && 
                    reviewType.getReviewTypeCode().equalsIgnoreCase(reviewTypesUsed.getIacucProtocolReviewTypeCode())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                String description = new String (reviewType.getReviewTypeCode() + " - " + reviewType.getDescription());
                keyValues.add(new ConcreteKeyValue(reviewType.getReviewTypeCode(), description));
            }
            found = false;
        }       
        
        return keyValues;
    }
    

    protected KeyValuesService getKeyValuesService() {
        if (keyValuesService == null) {
            keyValuesService =  KNSServiceLocator.getKeyValuesService();
        }
        return keyValuesService;
    }
    
}
