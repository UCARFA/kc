/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a values finder for subPlanFlag of Award business object.
 */
@SuppressWarnings("unchecked")
public class SubPlanFlagValuesFinder extends UifKeyValuesFinderBase {
    
    /**
     * This method adds 3 pre-determined values to a key values pair and returns it.
     * 
     */
    @Override
    public List<KeyValue> getKeyValues() {
        
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        
        keyValues.add(new ConcreteKeyValue("U", new String("Unknown")));
        keyValues.add(new ConcreteKeyValue("Y", new String("Required")));
        keyValues.add(new ConcreteKeyValue("N", new String("Not Required")));
                
        return keyValues;
    }
   
}
