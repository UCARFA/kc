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
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;

public class MedusaSubAwardDto {

    public MedusaSubAwardDto() {

    }

    @Property(source = "mvel:?subAwardDocument.?documentNumber")
    private String documentNumber;
    @Property(source = "subAwardCode")
    private String subAwardId;
    @Property(source = "statusDescription")
    private String status;
    private String accountNumber;
    @Property(source = "organizationName")
    private String subRecipient;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date endDate;
    @Property(source = "mvel:?subAwardType.?description")
    private String subAwardType;
    private String purchaseOrderNum;
    private String title;
    @Property(source = "mvel:?requisitioner.?fullName")
    private String requisitioner;
    @Property(source = "mvel:?unit.?unitNumber")
    private String requisitionerUnitNumber;
    @Property(source = "mvel:?unit.?unitName")
    private String requisitionerUnitName;
    private String vendorNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date closeoutDate;
    private String archiveLocation;
    private String comments;
    private ScaleTwoDecimal totalAnticipatedAmount;
    private ScaleTwoDecimal totalObligatedAmount;
    private ScaleTwoDecimal totalAmountReleased;
    private ScaleTwoDecimal totalAvailableAmount;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getSubAwardId() {
        return subAwardId;
    }

    public String getStatus() {
        return status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getSubRecipient() {
        return subRecipient;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getSubAwardType() {
        return subAwardType;
    }

    public String getPurchaseOrderNum() {
        return purchaseOrderNum;
    }

    public String getTitle() {
        return title;
    }

    public String getRequisitioner() {
        return requisitioner;
    }

    public String getRequisitionerUnitNumber() {
        return requisitionerUnitNumber;
    }

    public String getRequisitionerUnitName() {
        return requisitionerUnitName;
    }

    public String getVendorNumber() {
        return vendorNumber;
    }

    public Date getCloseoutDate() {
        return closeoutDate;
    }

    public String getArchiveLocation() {
        return archiveLocation;
    }

    public String getComments() {
        return comments;
    }

    public ScaleTwoDecimal getTotalAnticipatedAmount() {
        return totalAnticipatedAmount;
    }

    public ScaleTwoDecimal getTotalObligatedAmount() {
        return totalObligatedAmount;
    }

    public ScaleTwoDecimal getTotalAmountReleased() {
        return totalAmountReleased;
    }

    public ScaleTwoDecimal getTotalAvailableAmount() {
        return totalAvailableAmount;
    }
}
