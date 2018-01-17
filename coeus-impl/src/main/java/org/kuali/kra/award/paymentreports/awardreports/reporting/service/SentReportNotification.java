/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;

import java.sql.Date;
import java.util.Calendar;

public class SentReportNotification extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 3646683642938736073L;

    private Long awardReportNotifSentId;
    private String awardNumber;
    private Date dueDate;
    private Date dateSent;
    private String actionCode;
    private String reportClassCode;
    private String reportCode;
    
    public SentReportNotification() {
        dateSent = new Date(Calendar.getInstance().getTimeInMillis());
    }
    
    public SentReportNotification(String actionCode, ReportTracking report) {
        dateSent = new Date(Calendar.getInstance().getTimeInMillis());
        this.actionCode = actionCode;
        this.reportClassCode = report.getReportClassCode();
        this.reportCode = report.getReportCode();
        this.awardNumber = report.getAwardNumber();
        this.dueDate = report.getDueDate();
    }

    public Long getAwardReportNotifSentId() {
        return awardReportNotifSentId;
    }

    public void setAwardReportNotifSentId(Long awardReportNotifSentId) {
        this.awardReportNotifSentId = awardReportNotifSentId;
    }

    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getDateSent() {
        return dateSent;
    }
    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
    public String getActionCode() {
        return actionCode;
    }
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getReportClassCode() {
        return reportClassCode;
    }

    public void setReportClassCode(String reportClassCode) {
        this.reportClassCode = reportClassCode;
    }

    public String getReportCode() {
        return reportCode;
    }

    public void setReportCode(String reportCode) {
        this.reportCode = reportCode;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }
}
