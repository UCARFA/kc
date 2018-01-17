/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notifyirb;

import org.kuali.kra.irb.actions.IrbActionsKeyValuesBase;
import org.kuali.kra.irb.actions.submit.ProtocolReviewType;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionType;
import org.kuali.kra.irb.actions.submit.ValidProtoSubRevType;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmissionReviewTypeValuesFinder extends IrbActionsKeyValuesBase {
    
    @Override
    @SuppressWarnings("unchecked")
    public List<KeyValue> getKeyValues() {
       
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("submissionTypeCode", ProtocolSubmissionType.NOTIFY_IRB);
        List<ValidProtoSubRevType> validProtoSubRevTypes = (List<ValidProtoSubRevType>) getBusinessObjectService().findMatching(
                ValidProtoSubRevType.class, fieldValues);
        if (validProtoSubRevTypes.isEmpty()) {
            List<ProtocolReviewType> reviewTypes = (List<ProtocolReviewType>) getBusinessObjectService().findAll(
                    ProtocolReviewType.class);
            for (ProtocolReviewType reviewType : reviewTypes) {
                keyValues.add(new ConcreteKeyValue(reviewType.getReviewTypeCode(), 
                        reviewType.getDescription()));
            }
            
        } else {
            for (ValidProtoSubRevType submRevType :  validProtoSubRevTypes) {
                keyValues.add(new ConcreteKeyValue(submRevType.getProtocolReviewTypeCode(), 
                        submRevType.getProtocolReviewType().getDescription()));
            }
        }
        
        return keyValues;
    }
}
