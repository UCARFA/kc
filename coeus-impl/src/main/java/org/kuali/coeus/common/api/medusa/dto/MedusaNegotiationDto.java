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

public class MedusaNegotiationDto {

    public MedusaNegotiationDto() {

    }

    private String documentNumber;
    private Long negotiationId;
    @Property(source = "mvel:?negotiationStatus.?description")
    private String negotiationStatus;
    @Property(source = "mvel:?negotiator.?userName")
    private String negotiator;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date negotiationStartDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date negotiationEndDate;
    @Property(source = "mvel:?negotiationAgreementType.?description")
    private String agreementType;
    private int negotiationAge;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public Long getNegotiationId() {
        return negotiationId;
    }

    public String getNegotiationStatus() {
        return negotiationStatus;
    }

    public String getNegotiator() {
        return negotiator;
    }

    public Date getNegotiationStartDate() {
        return negotiationStartDate;
    }

    public Date getNegotiationEndDate() {
        return negotiationEndDate;
    }

    public String getAgreementType() {
        return agreementType;
    }

    public int getNegotiationAge() {
        return negotiationAge;
    }
}
