/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.kra.award.infrastructure.AwardOnOffCampusFlagConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This is a values finder class used in AwardIndirectCostRate.xml for populating
 * On-Off CampusContractContractContract Flag Select box.
 */
public class AwardOnOffCampusValuesFinder extends UifKeyValuesFinderBase {

    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> KeyValues = new ArrayList<KeyValue>();

        for (AwardOnOffCampusFlagConstants awardOnOffCampusFlagConstants : AwardOnOffCampusFlagConstants.values()) {
            KeyValues.add(new ConcreteKeyValue(awardOnOffCampusFlagConstants.code(), awardOnOffCampusFlagConstants.description()));
        }
        
        return KeyValues; 
    }
    
}
