/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.reporting.web.struts.form;

import org.kuali.rice.kns.web.struts.form.KualiForm;

@SuppressWarnings("deprecation")
public class IsrSsrReportGenerationForm extends KualiForm {


    private static final long serialVersionUID = 1L;
    private String reportName;
    private String awardNo;    
    private String startDate;
    private String endDate;
    private String reportType;   
    
    public IsrSsrReportGenerationForm() {
        initialize();
    }     

    public void initialize() {
        setReportType("Regular");        
    }
    
    public String getReportName() {
        return reportName;
    }
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    public String getAwardNo() {
        return awardNo;
    }
    public void setAwardNo(String awardNo) {
        this.awardNo = awardNo;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }    

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }  
}
