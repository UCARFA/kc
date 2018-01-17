/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;

import java.util.HashMap;
import java.util.Map;

public class ReportTrackingNotificationTask {

    private String reportClassCode;
    private String reportCode;
    private String frequencyCode;
    private String frequencyBaseCode;
    private String ospDistributionCode;
    
    public ReportTrackingNotificationTask() {
        
    }

    /**
     * 
     * Constructs a ReportTrackingNotificationTask.java using the reportClassCode as the single parameter to this task.
     * @param reportClassCode
     */
    public ReportTrackingNotificationTask(String reportClassCode) {
        this.reportClassCode = reportClassCode;
    }
    
    public Map<String, String> getReportTrackingValueMap() {
        Map<String, String> values = new HashMap<>();
        if (StringUtils.isNotBlank(reportClassCode)) {
            values.put(ReportTrackingConstants.REPORT_CLASS_CODE, reportClassCode);
        }
        if (StringUtils.isNotBlank(reportCode)) {
            values.put(ReportTrackingConstants.REPORT_CODE, reportCode);
        }
        if (StringUtils.isNotBlank(frequencyCode)) {
            values.put(ReportTrackingConstants.FREQUENCY_CODE, frequencyCode);
        }
        if (StringUtils.isNotBlank(frequencyBaseCode)) {
            values.put(ReportTrackingConstants.FREQUENCY_BASE_CODE, frequencyBaseCode);
        }
        if (StringUtils.isNotBlank(ospDistributionCode)) {
            values.put(ReportTrackingConstants.OSP_DISTRIBUTION_CODE, ospDistributionCode);
        }
        return values;
    }
    
    public String getReportClassCode() {
        return reportClassCode;
    }
    public void setReportClassCode(String reportClassCode) {
        this.reportClassCode = reportClassCode;
    }
    public String getFrequencyBaseCode() {
        return frequencyBaseCode;
    }
    public void setFrequencyBaseCode(String frequencyBaseCode) {
        this.frequencyBaseCode = frequencyBaseCode;
    }
    public String getFrequencyCode() {
        return frequencyCode;
    }
    public void setFrequencyCode(String frequencyCode) {
        this.frequencyCode = frequencyCode;
    }
    public String getOspDistributionCode() {
        return ospDistributionCode;
    }
    public void setOspDistributionCode(String ospDistributionCode) {
        this.ospDistributionCode = ospDistributionCode;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }
    
}
