/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import java.util.ArrayList;
import java.util.List;

public enum ProtocolPrintType {
    
    PROTOCOL_SUMMARY_VIEW_REPORT("Summary View Report", "ProtocolSummary.xsl", "ProtocolSummary"), 
    PROTOCOL_FULL_PROTOCOL_REPORT("Full Protocol Report", "ProtocolSummary.xsl","FullProtocolReport"),
    PROTOCOL_PROTOCOL_HISTORY_REPORT("Protocol History Report", "ProtocolHistoryReport.xsl","ProtocolHistoryReport"), 
    PROTOCOL_REVIEW_COMMENTS_REPORT("Review Comments Report", "ReviewCommentsReport.xsl","ProtocolReviewComments");


    
    private final String protocolPrintType;
    private final String template;
    private final String reportName;

    ProtocolPrintType(String protocolPrintType, String template,String reportName) {
        this.protocolPrintType = protocolPrintType;
        this.template = template;
        this.reportName = reportName;
    }

    public String getProtocolPrintType() {
        return protocolPrintType;
    }
    public String getTemplate() {
        return template;
    }

    public static List<String>  getReportTypes() {
        List<String> reportTypes = new ArrayList<String>();
        for (ProtocolPrintType printType : values()) {
            reportTypes.add(printType.getProtocolPrintType());
        }
        return reportTypes;
        
    }

    /**
     * Gets the reportName attribute. 
     * @return Returns the reportName.
     */
    public String getReportName() {
        return reportName;
    }
}
