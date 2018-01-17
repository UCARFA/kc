/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rpt;

import org.kuali.coeus.common.impl.rpt.cust.CustReportDetails;

import java.io.InputStream;
import java.util.List;


public interface BirtReportService {
    
    /**
    * Fetch input parameters from template.
    */    
    List<BirtParameterBean> getInputParametersFromTemplateFile(String reportId) throws Exception;

    /**
     * Generate ReportDesignFileStream.
     */
    InputStream getReportDesignFileStream(String reportId);

    /**
     * Fetch reports for which the user has permission.
     */
    List<CustReportDetails> getReports();
    
}
