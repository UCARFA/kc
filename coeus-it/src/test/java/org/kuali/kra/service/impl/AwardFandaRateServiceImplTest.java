/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.commitments.AwardFandaRateService;
import org.kuali.kra.award.commitments.AwardFandaRateServiceImpl;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class tests <code>AwardFandaRateService</code>
 */
public class AwardFandaRateServiceImplTest extends KcIntegrationTestBase {
    
    private static final String FISCAL_LEAP_YEAR_STRING = "2008";
    private static final String FISCAL_NON_LEAP_YEAR_STRING = "2010";
    
    private static final List<String> MOCK_EXPECTED_DATE_NON_LEAP_YEAR = new ArrayList<String>();
    private static final List<String> MOCK_EXPECTED_DATE_LEAP_YEAR = new ArrayList<String>();
    private static final List<String> MOCK_EXPECTED_DATE_EMPTY = new ArrayList<String>();
    private AwardFandaRateServiceImpl awardFandaRateService;

    @Before
    public void setUp() throws Exception {
        awardFandaRateService = (AwardFandaRateServiceImpl) KcServiceLocator.getService(AwardFandaRateService.class);
    }

    @After
    public void tearDown() throws Exception {
        awardFandaRateService = null;
    }    
    
    @Test
    public final void testGetStartAndEndDatesWhenValidFiscalLeapYearPassed(){
        MOCK_EXPECTED_DATE_LEAP_YEAR.add("07/01/2007");
        MOCK_EXPECTED_DATE_LEAP_YEAR.add("06/30/2008");
                
        Assert.assertEquals(MOCK_EXPECTED_DATE_LEAP_YEAR,
                awardFandaRateService.getStartAndEndDatesBasedOnFiscalYear(FISCAL_LEAP_YEAR_STRING));
    }
    
    @Test
    public final void testGetStartAndEndDatesWhenValidFiscalNonLeapYearPassed(){ 
        MOCK_EXPECTED_DATE_NON_LEAP_YEAR.add("07/01/2009");
        MOCK_EXPECTED_DATE_NON_LEAP_YEAR.add("06/30/2010");        
                
        Assert.assertEquals(MOCK_EXPECTED_DATE_NON_LEAP_YEAR,
                awardFandaRateService.getStartAndEndDatesBasedOnFiscalYear(FISCAL_NON_LEAP_YEAR_STRING));
    }
    
    @Test
    public final void testGetStartAndEndDatesWhenInvalidFiscalYearPassed(){
        AwardFandaRateServiceImpl awardFandaRateService =  new AwardFandaRateServiceImpl();
                
        Assert.assertEquals(MOCK_EXPECTED_DATE_EMPTY,
                awardFandaRateService.getStartAndEndDatesBasedOnFiscalYear(""));
    }
}
