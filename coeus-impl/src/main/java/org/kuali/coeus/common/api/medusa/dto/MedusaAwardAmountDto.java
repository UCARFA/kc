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

import com.fasterxml.jackson.annotation.JsonFormat;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;

public class MedusaAwardAmountDto {

    public MedusaAwardAmountDto() {

    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date currentFundEffectiveDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date finalExpirationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date obligationExpirationDate;
    private ScaleTwoDecimal anticipatedTotalAmount;
    private ScaleTwoDecimal amountObligatedToDate;

    public Date getCurrentFundEffectiveDate() {
        return currentFundEffectiveDate;
    }

    public Date getFinalExpirationDate() {
        return finalExpirationDate;
    }

    public Date getObligationExpirationDate() {
        return obligationExpirationDate;
    }

    public ScaleTwoDecimal getAnticipatedTotalAmount() {
        return anticipatedTotalAmount;
    }

    public ScaleTwoDecimal getAmountObligatedToDate() {
        return amountObligatedToDate;
    }
}
