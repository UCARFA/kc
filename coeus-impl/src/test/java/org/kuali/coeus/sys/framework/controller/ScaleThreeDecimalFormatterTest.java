/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.api.model.ScaleThreeDecimal;
import org.kuali.coeus.sys.framework.controller.GlobalFormatterRegistry;
import org.kuali.rice.core.web.format.FormatException;

import java.math.BigDecimal;

public class ScaleThreeDecimalFormatterTest {

    private static final String ALPHANUMERIC_VALUE = "98.efg";
    private static final String ALPHA_VALUE = "ab.cde";
    private static final String TEST_NUMBER_AS_STRING = "98.765";
    private static final double TEST_NUMBER = 98.765;
    
    private GlobalFormatterRegistry.ScaleThreeDecimalFormatter formatter;

    @Before
    public void setUp() {
        formatter = new GlobalFormatterRegistry.ScaleThreeDecimalFormatter();
    }
    
    @After
    public void tearDown() {
        formatter = null;
    }
    
    @Test
    public void testConvertingFromStringToScaleThreeDecimal_GoodData() {
        ScaleThreeDecimal scaleThreeDecimal = new ScaleThreeDecimal(new BigDecimal(TEST_NUMBER));
        Assert.assertEquals(scaleThreeDecimal, formatter.convertToObject(TEST_NUMBER_AS_STRING));
    }
    
    @Test(expected=FormatException.class)
    public void testConvertingFromStringToScaleThreeDecimal_AllBadData() {
        formatter.convertToObject(ALPHA_VALUE);
    }
    
    @Test(expected=FormatException.class)
    public void testConvertingFromStringToScaleThreeDecimal_MixedBadData() {
        formatter.convertToObject(ALPHANUMERIC_VALUE);
    }
}
