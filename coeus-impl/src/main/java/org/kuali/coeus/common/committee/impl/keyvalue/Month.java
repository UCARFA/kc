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

public class Month extends UifKeyValuesFinderBase {

    public static final String JANUARY = "JANUARY";
    
    public static final String FEBRUARY = "FEBRUARY";
    
    public static final String MARCH = "MARCH";
    
    public static final String APRIL = "APRIL";
    
    public static final String MAY = "MAY";
    
    public static final String JUNE = "JUNE";
    
    public static final String JULY = "JULY";
    
    public static final String AUGUST = "AUGUST";
    
    public static final String SEPTEMBER = "SEPTEMBER";
    
    public static final String OCTOBER = "OCTOBER";
    
    public static final String NOVEMBER = "NOVEMBER";
    
    public static final String DECEMBER = "DECEMBER";
    
    public Month() {
    }

    /**
     * Creates and return List of months.
     */
    @Override
    public List<KeyValue> getKeyValues() {
        List<KeyValue> keyValues = new ArrayList<KeyValue>();
        keyValues.add(new ConcreteKeyValue(JANUARY,JANUARY));
        keyValues.add(new ConcreteKeyValue(FEBRUARY,FEBRUARY));
        keyValues.add(new ConcreteKeyValue(MARCH,MARCH));
        keyValues.add(new ConcreteKeyValue(APRIL,APRIL));
        keyValues.add(new ConcreteKeyValue(MAY,MAY));
        keyValues.add(new ConcreteKeyValue(JUNE,JUNE));
        keyValues.add(new ConcreteKeyValue(JULY,JULY));
        keyValues.add(new ConcreteKeyValue(AUGUST,AUGUST));
        keyValues.add(new ConcreteKeyValue(SEPTEMBER,SEPTEMBER));
        keyValues.add(new ConcreteKeyValue(OCTOBER,OCTOBER));
        keyValues.add(new ConcreteKeyValue(NOVEMBER,NOVEMBER));
        keyValues.add(new ConcreteKeyValue(DECEMBER,DECEMBER));
        return keyValues;
    }

}
