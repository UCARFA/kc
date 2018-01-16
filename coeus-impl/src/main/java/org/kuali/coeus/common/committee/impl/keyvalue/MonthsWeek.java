/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.keyvalue;

import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.List;

public class MonthsWeek extends UifKeyValuesFinderBase {

    public static final String FIRST =  "first";
    
    public static final String SECOND = "second";
    
    public static final String THIRD = "third";
    
    public static final String FOURTH = "fourth";
    
    public static final String LAST = "last";
    
    public MonthsWeek() {
    }

    /**
     * Creates and return List of week of month.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue(FIRST, FIRST));
        keyValues.add(new ConcreteKeyValue(SECOND, SECOND));
        keyValues.add(new ConcreteKeyValue(THIRD, THIRD));
        keyValues.add(new ConcreteKeyValue(FOURTH, FOURTH));
        keyValues.add(new ConcreteKeyValue(LAST, LAST));
        return keyValues;
    }

}
