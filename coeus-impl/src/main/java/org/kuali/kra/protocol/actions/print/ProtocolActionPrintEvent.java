/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

public class ProtocolActionPrintEvent<T extends KcBusinessRule> extends KcDocumentEventBaseExtension {

    private Boolean summaryReport;
    private Boolean fullReport;
    private Boolean historyReport;
    private Boolean reviewCommentsReport;

    public ProtocolActionPrintEvent(ProtocolDocumentBase document, Boolean summaryReport, Boolean fullReport,Boolean historyReport ,Boolean reviewCommentsReport) {
        super("ProtocolBase Print", "", document);
        this.summaryReport = summaryReport;
        this.fullReport = fullReport;
        this.historyReport = historyReport;
        this.reviewCommentsReport = reviewCommentsReport;
    }
    
    public ProtocolDocumentBase getProtocolDocument() {
        return (ProtocolDocumentBase) getDocument();
    }
    

    @Override
    public KcBusinessRule getRule() {
        return new ProtocolActionPrintRule();
    }

    public Boolean getSummaryReport() {
        return summaryReport;
    }

    public void setSummaryReport(Boolean summaryReport) {
        this.summaryReport = summaryReport;
    }

    public Boolean getFullReport() {
        return fullReport;
    }

    public void setFullReport(Boolean fullReport) {
        this.fullReport = fullReport;
    }

    public Boolean getHistoryReport() {
        return historyReport;
    }

    public void setHistoryReport(Boolean historyReport) {
        this.historyReport = historyReport;
    }

    public Boolean getReviewCommentsReport() {
        return reviewCommentsReport;
    }

    public void setReviewCommentsReport(Boolean reviewCommentsReport) {
        this.reviewCommentsReport = reviewCommentsReport;
    }

}
