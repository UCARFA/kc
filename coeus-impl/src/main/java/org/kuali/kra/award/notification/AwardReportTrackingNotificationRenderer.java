/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class AwardReportTrackingNotificationRenderer extends AwardNotificationRenderer {

    private static final long serialVersionUID = -2035058699415467934L;
    protected static final String START_REPEAT_SECTION = "{BEGIN_REPEAT_SECTION}";
    protected static final String END_REPEAT_SECTION = "{END_REPEAT_SECTION}";
    private static final String MM_DD_YYYY = "MM/dd/yyyy";

    private List<ReportTracking> reports;
    
    public AwardReportTrackingNotificationRenderer() {
        super();
    }
    
    public AwardReportTrackingNotificationRenderer(List<ReportTracking> reports) {
        super();
        this.reports = reports;
    }
    
    protected Map<String, String> getReportReplacementParameters(ReportTracking report) {
        Map<String, String> result = getAwardReplacementParameters(report.getAward());
        SimpleDateFormat dateFormatter = new SimpleDateFormat(MM_DD_YYYY);
        if (report.getReportClass() == null) {
            report.refreshReferenceObject(ReportTrackingConstants.REPORT_CLASS);
        }
        result.put("{REPORT_CLASS}", report.getReportClass().getDescription());
        if (report.getReport() == null) {
            report.refreshReferenceObject(ReportTrackingConstants.REPORT);
        }
        result.put("{REPORT_TYPE}", report.getReport().getDescription());
        result.put("{REPORT_DUE_DATE}", dateFormatter.format(report.getDueDate()));
        result.put(START_REPEAT_SECTION, StringUtils.EMPTY);
        result.put(END_REPEAT_SECTION, StringUtils.EMPTY);
        return result;
    }
    
    @Override
    public String render(String text) {
        int startIndex = StringUtils.indexOf(text, START_REPEAT_SECTION);
        int endIndex = StringUtils.indexOf(text, END_REPEAT_SECTION) + END_REPEAT_SECTION.length();
        String startStr = text.substring(0, startIndex);
        String repeatedStr = text.substring(startIndex, endIndex);
        String endStr = text.substring(endIndex);
        StringBuilder buffer = new StringBuilder();
        buffer.append(startStr);
        reports.forEach(report -> buffer.append(this.render(repeatedStr, getReportReplacementParameters(report))));

        buffer.append(endStr);
        return buffer.toString();
    }

    public List<ReportTracking> getReports() {
        return reports;
    }

    public void setReports(List<ReportTracking> reports) {
        this.reports = reports;
    }
}
