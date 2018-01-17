/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.lookup.keyvalue;

import org.apache.commons.collections4.CollectionUtils;
import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;

public class IacucCommitteeIdIdPairValuesFinder extends IacucCommitteeIdValuesFinder {


    private static final long serialVersionUID = -1856217969303750675L;
    
    /**
     * This override will return the active committee <id, id> pairs list as key-labels. 
     * 
     * @see org.kuali.coeus.common.committee.impl.lookup.keyvalue.CommitteeIdValuesFinderBase#getKeyValues()
     */
    @Override
    public List<KeyValue> getKeyValues() {        
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(ValuesFinderUtils.getSelectOption());
        
        List<CommitteeBase> committees = this.getActiveCommittees();
        if (CollectionUtils.isNotEmpty(committees)) {
            for (CommitteeBase committee : committees) {
                keyValues.add(new ConcreteKeyValue(committee.getCommitteeId(), committee.getCommitteeId()));
            }
        }
        return keyValues;
    }
    

    

}
