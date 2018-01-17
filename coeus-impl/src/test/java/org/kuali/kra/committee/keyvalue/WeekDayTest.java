/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.keyvalue;

import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.committee.impl.keyvalue.WeekDay;

import java.util.Map;

public class WeekDayTest extends Assert{
    
    public static final String SUNDAY = "Sunday";
    public static final String MONDAY = "Monday";
    public static final String TUESDAY = "Tuesday";
    public static final String WEDNESDAY = "Wednesday";
    public static final String THURSDAY = "Thursday";
    public static final String FRIDAY = "Friday";
    public static final String SATURDAY = "Saturday";
    
    /**
     * This method tests getKeyValues() method's return value.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testValues() throws Exception {
        WeekDay weekday = new WeekDay();
        Map map = weekday.getKeyLabelMap();
        assertTrue(((String)map.get(SUNDAY)).equalsIgnoreCase(SUNDAY));
        assertTrue(((String)map.get(MONDAY)).equalsIgnoreCase(MONDAY));
        assertTrue(((String)map.get(TUESDAY)).equalsIgnoreCase(TUESDAY));
        assertTrue(((String)map.get(WEDNESDAY)).equalsIgnoreCase(WEDNESDAY));
        assertTrue(((String)map.get(THURSDAY)).equalsIgnoreCase(THURSDAY));
        assertTrue(((String)map.get(FRIDAY)).equalsIgnoreCase(FRIDAY));
        assertTrue(((String)map.get(SATURDAY)).equalsIgnoreCase(SATURDAY));
    }
}
