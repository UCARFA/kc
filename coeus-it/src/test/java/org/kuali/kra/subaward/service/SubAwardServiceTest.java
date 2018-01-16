/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.service;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
public class SubAwardServiceTest extends KcIntegrationTestBase {
    SubAwardService subAwardService;
    @Before
    public void setUp() throws Exception {
        subAwardService = KcServiceLocator.getService(SubAwardService.class);
    }

    @After
    public void tearDown() throws Exception {
        subAwardService = null;
    }

    @Test
    public void testGetFollowupDateDefaultLength() {
        String checkVal = subAwardService.getFollowupDateDefaultLength();
        assertEquals("6W", checkVal);
    }

    @Test
    public void testGetCalculatedFollowupDate() {
        Date checkDate = subAwardService.getCalculatedFollowupDate(new Date(2012, 1, 1));
        Date expectedDate = new Date(DateUtils.addWeeks(new Date(2012, 1, 1), 6).getTime());
        assertEquals(expectedDate, checkDate);
    }
    
    @Test
    public void testGetFollowupDateDefaultLengthInDays() {
        int followUpDays = subAwardService.getFollowupDateDefaultLengthInDays();
        int expectedFollowUpDays = 6 * 7;
        assertEquals(expectedFollowUpDays, followUpDays);
        
    }

}
