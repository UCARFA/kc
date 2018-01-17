/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;

public class AwardPaymentScheduleDto {

    private Long awardPaymentScheduleId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date dueDate;
    private ScaleTwoDecimal amount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date submitDate;
    private String submittedBy;
    private String invoiceNumber;
    private String statusDescription;
    private String status;
    private Integer overdue;
    private String reportStatusCode;
    private String submittedByPersonId;
    private String awardReportTermDescription;

    public Long getAwardPaymentScheduleId() {
        return awardPaymentScheduleId;
    }

    public void setAwardPaymentScheduleId(Long awardPaymentScheduleId) {
        this.awardPaymentScheduleId = awardPaymentScheduleId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public ScaleTwoDecimal getAmount() {
        return amount;
    }

    public void setAmount(ScaleTwoDecimal amount) {
        this.amount = amount;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public String getReportStatusCode() {
        return reportStatusCode;
    }

    public void setReportStatusCode(String reportStatusCode) {
        this.reportStatusCode = reportStatusCode;
    }

    public String getSubmittedByPersonId() {
        return submittedByPersonId;
    }

    public void setSubmittedByPersonId(String submittedByPersonId) {
        this.submittedByPersonId = submittedByPersonId;
    }

    public String getAwardReportTermDescription() {
        return awardReportTermDescription;
    }

    public void setAwardReportTermDescription(String awardReportTermDescription) {
        this.awardReportTermDescription = awardReportTermDescription;
    }
}
