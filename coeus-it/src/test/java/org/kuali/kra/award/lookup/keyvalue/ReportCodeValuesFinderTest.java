/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.lookup.keyvalue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.util.ValuesFinderUtils;
import org.kuali.kra.award.paymentreports.ValidClassReportFrequency;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportCodeValuesFinderTest extends KcIntegrationTestBase {
    
    ReportCodeValuesFinder reportCodeValuesFinder;
    List<KeyValue> reportCodes;
    Collection<ValidClassReportFrequency> validClassReportFrequencies;

    @Before
    public void setUp() throws Exception {
        reportCodeValuesFinder = new ReportCodeValuesFinder("1");
        reportCodes = new ArrayList<KeyValue>();        
        validClassReportFrequencies = new ArrayList<ValidClassReportFrequency>();      
    }

    @After
    public void tearDown() throws Exception {
        reportCodeValuesFinder = null;
        reportCodes = null;
    }

    @Test
    public final void testGetKeyValues() {
        reportCodes = reportCodeValuesFinder.getKeyValues();
        Assert.assertEquals(11,reportCodes.size());
        
        for(KeyValue KeyValue:reportCodes){
            Assert.assertNotNull(KeyValue.getKey());
            Assert.assertNotNull(KeyValue.getValue());
        }
    }

    @Test
    public final void testGetKeyValuesWithNoValidReports() {
        ReportCodeValuesFinder invalidCodeValuesFinder = new ReportCodeValuesFinder("INVALID");
        reportCodes = invalidCodeValuesFinder.getKeyValues();
        Assert.assertEquals(1, reportCodes.size());
        Assert.assertEquals(ValuesFinderUtils.getSelectOption(), reportCodes.get(0));
    }

}

