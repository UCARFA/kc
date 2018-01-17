/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

public class ProtocolPrintHelper {

    private final String template;
    private final String reportName;
    private final String fileName;
 
    public ProtocolPrintHelper(String template, String reportName, String fileName) {
        this.template = template;
        this.reportName = reportName;
        this.fileName = fileName;
    }

    public String getTemplate() {
        return template;
    }

    public String getReportName() {
        return reportName;
    }

    public String getFileName() {
        return fileName;
    }

}
