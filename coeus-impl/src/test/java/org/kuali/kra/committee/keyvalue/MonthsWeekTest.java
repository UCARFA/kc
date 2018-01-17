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
import org.kuali.coeus.common.committee.impl.keyvalue.MonthsWeek;

import java.util.Map;

public class MonthsWeekTest extends Assert{
    
    public static final String FIRST =  "first";
    public static final String SECOND = "second";
    public static final String THIRD = "third";
    public static final String FOURTH = "fourth";
    public static final String LAST = "last";
    
    /**
     * This method tests getKeyValues() method's return value.
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testValues() throws Exception {
        MonthsWeek monthsWeek = new MonthsWeek();
        Map map = monthsWeek.getKeyLabelMap();
        assertTrue(((String)map.get(FIRST)).equalsIgnoreCase(FIRST));
        assertTrue(((String)map.get(SECOND)).equalsIgnoreCase(SECOND));
        assertTrue(((String)map.get(THIRD)).equalsIgnoreCase(THIRD));
        assertTrue(((String)map.get(LAST)).equalsIgnoreCase(LAST));
    }
}
