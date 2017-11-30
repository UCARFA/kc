/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2017 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
