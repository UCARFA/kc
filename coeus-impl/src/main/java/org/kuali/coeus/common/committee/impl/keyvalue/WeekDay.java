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

public class WeekDay extends UifKeyValuesFinderBase {

    public static final String SUNDAY = "Sunday";
    
    public static final String MONDAY = "Monday";
    
    public static final String TUESDAY = "Tuesday";
    
    public static final String WEDNESDAY = "Wednesday";
    
    public static final String THURSDAY = "Thursday";
    
    public static final String FRIDAY = "Friday";
    
    public static final String SATURDAY = "Saturday";
    
    public WeekDay() {
    }

    /**
     * Creates and return List of week days.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue(SUNDAY, SUNDAY));
        keyValues.add(new ConcreteKeyValue(MONDAY, MONDAY));
        keyValues.add(new ConcreteKeyValue(TUESDAY, TUESDAY));
        keyValues.add(new ConcreteKeyValue(WEDNESDAY, WEDNESDAY));
        keyValues.add(new ConcreteKeyValue(THURSDAY, THURSDAY));
        keyValues.add(new ConcreteKeyValue(FRIDAY, FRIDAY));
        keyValues.add(new ConcreteKeyValue(SATURDAY, SATURDAY));
        return keyValues;
    }

}
