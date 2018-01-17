/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.notifyiacuc;

import org.kuali.kra.iacuc.actions.submit.IacucProtocolReviewType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionType;
import org.kuali.kra.iacuc.actions.submit.IacucValidProtoSubRevType;
import org.kuali.kra.irb.actions.IrbActionsKeyValuesBase;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubmissionReviewTypeValuesFinder extends IrbActionsKeyValuesBase {
    
    private static final long serialVersionUID = 1525606389532878075L;

    @Override
    public List<KeyValue> getKeyValues() {
       
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        Map<String, String> fieldValues = new HashMap<String, String>();
        fieldValues.put("submissionTypeCode", IacucProtocolSubmissionType.FYI);
        List<IacucValidProtoSubRevType> validProtoSubRevTypes = (List<IacucValidProtoSubRevType>) getBusinessObjectService().findMatching(
                IacucValidProtoSubRevType.class, fieldValues);
        if (validProtoSubRevTypes.isEmpty()) {
            List<IacucProtocolReviewType> reviewTypes = (List<IacucProtocolReviewType>) getBusinessObjectService().findAll(
                    IacucProtocolReviewType.class);
            for (IacucProtocolReviewType reviewType : reviewTypes) {
                keyValues.add(new ConcreteKeyValue(reviewType.getReviewTypeCode(), 
                        reviewType.getDescription()));
            }
            
        } else {
            for (IacucValidProtoSubRevType submRevType :  validProtoSubRevTypes) {
                keyValues.add(new ConcreteKeyValue(submRevType.getProtocolReviewTypeCode(), submRevType.getProtocolReviewType().getDescription()));
            }
        }
        
        return keyValues;
    }
}
