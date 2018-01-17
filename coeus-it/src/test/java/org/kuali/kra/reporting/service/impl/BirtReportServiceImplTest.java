/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.reporting.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.impl.rpt.BirtParameterBean;
import org.kuali.coeus.common.impl.rpt.cust.CustReportDetails;
import org.kuali.coeus.common.impl.rpt.BirtReportService;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kns.service.KNSServiceLocator;

import java.util.List;

import static org.junit.Assert.assertTrue;
public class BirtReportServiceImplTest extends KcIntegrationTestBase {
    
    private BirtReportService birtReportService;
    private String reportId;
    List<BirtParameterBean> parameterList;
    List<CustReportDetails> custReportDetails;
    
    @Before
    public void setUp() throws Exception {
        birtReportService = KcServiceLocator.getService(BirtReportService.class);
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testGetReports() {
        custReportDetails =  (List<CustReportDetails>) KNSServiceLocator.getBusinessObjectService().findAll(CustReportDetails.class);
        assertTrue(custReportDetails.size() > 0);
    }
    
    @Test
    public void testGetInputParametersFromTemplateFile() throws Exception{ 
        List<CustReportDetails> custReportDetailsList = (List<CustReportDetails>) KNSServiceLocator.getBusinessObjectService().findAll(CustReportDetails.class);
        reportId = custReportDetailsList.get(0).getReportId().toString();
        parameterList = birtReportService.getInputParametersFromTemplateFile(reportId);
        assertTrue(parameterList.size() > 0);
    }
}
