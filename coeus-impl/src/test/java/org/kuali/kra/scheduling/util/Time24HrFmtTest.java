/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.scheduling.util;

import org.junit.Test;
import org.kuali.coeus.sys.framework.scheduling.util.Time24HrFmt;

import static org.junit.Assert.assertTrue;


public class Time24HrFmtTest {
    
    @Test
    public void testParseTime() throws Exception {

        new Time24HrFmt("10:30");
        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeWithIncorrectMinutes() throws Exception {
            new Time24HrFmt("10:79");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeWithIncorrectHour() throws Exception {
            new Time24HrFmt("24:0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeWithNoMinutes() throws Exception {
            new Time24HrFmt("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseTimeWithNonInteger() throws Exception {
            new Time24HrFmt("10:1d");
    }
}
