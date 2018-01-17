/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingSearchViews;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;
import static org.junit.Assert.*;
public class ReportTrackingViewValuesFinderTest extends KcIntegrationTestBase {
    
    ReportTrackingViewValuesFinder finder;

    @Before
    public void setUp() throws Exception {
        finder = new ReportTrackingViewValuesFinder();
    }

    @After
    public void tearDown() throws Exception {
        finder = null;
    }

    @Test
    public void testGetKeyValues() {
        List<KeyValue> labelPairs = finder.getKeyValues();
        assertEquals(4, labelPairs.size());
    }

    @Test
    public void testGetReportTrackingSearchViews() {
        ReportTrackingSearchViews views = finder.getReportTrackingSearchViews();
        assertEquals(3, views.getCustomViewIndex());
    }

}
