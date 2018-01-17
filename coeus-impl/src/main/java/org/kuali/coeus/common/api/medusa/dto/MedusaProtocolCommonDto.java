/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.medusa.dto;

import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;

public abstract class MedusaProtocolCommonDto {
    @Property(source = "mvel:?protocolDocument.?documentHeader.?documentNumber")
    private String documentNumber;
    private Long protocolId;
    private String protocolNumber;
    @Property(source = "mvel:?protocolStatus.?description")
    private String protocolStatus;
    @Property(source = "mvel:?protocolType.?description")
    private String protocolType;
    @Property(source = "mvel:?protocolSubmission.?submissionStatus.?description")
    private String submissionStatus;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date approvalDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date lastApprovalDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date initialSubmissionDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date expirationDate;
    private String referenceNumber1;
    private String referenceNumber2;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public String getProtocolStatus() {
        return protocolStatus;
    }

    public String getProtocolType() {
        return protocolType;
    }

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public String getTitle() {
        return title;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public Date getLastApprovalDate() {
        return lastApprovalDate;
    }

    public Date getInitialSubmissionDate() {
        return initialSubmissionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getReferenceNumber1() {
        return referenceNumber1;
    }

    public String getReferenceNumber2() {
        return referenceNumber2;
    }

}
