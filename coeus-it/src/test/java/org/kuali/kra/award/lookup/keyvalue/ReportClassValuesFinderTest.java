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
import org.kuali.kra.award.paymentreports.ReportClass;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.kns.service.KNSServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class ReportClassValuesFinderTest extends KcIntegrationTestBase {
    
    ReportClassValuesFinder reportClassValuesFinder;
    List<KeyValue> reportClasses;

    @Before
    public void setUp() throws Exception {
        reportClassValuesFinder = new ReportClassValuesFinder();
        reportClasses = new ArrayList<KeyValue>();
        reportClasses = reportClassValuesFinder.getKeyValues();
    }

    @After
    public void tearDown() throws Exception {
        reportClassValuesFinder = null;
        reportClasses = null;
    }

    @Test
    public final void testGetKeyValues() {
        int count = KNSServiceLocator.getBusinessObjectService().findAll(ReportClass.class).size();
        Assert.assertEquals(count, reportClasses.size());
        
        for(KeyValue KeyValue:reportClasses){
            Assert.assertNotNull(KeyValue.getKey());
            Assert.assertNotNull(KeyValue.getValue());
        }
    }
}

