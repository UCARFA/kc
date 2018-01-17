/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.kra.award.home.InvInstructionsIndicatorConstants;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Values Finder for Invoice Instructions Indicator Values.
 * 
 */
public class InvInstructionsIndicatorValuesFinder extends UifKeyValuesFinderBase {
    
    private List<KeyValue> labels;

    @Override
    public List<KeyValue> getKeyValues() {
        if( labels!=null ) return labels;
        labels = new ArrayList<KeyValue>();
        
        for( InvInstructionsIndicatorConstants inv : InvInstructionsIndicatorConstants.values() ) 
            labels.add(new ConcreteKeyValue( inv.getCode(),  inv.toString()));
        return labels;
    }
    
}
