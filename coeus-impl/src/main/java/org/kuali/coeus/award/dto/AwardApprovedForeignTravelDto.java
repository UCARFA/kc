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

public class AwardApprovedForeignTravelDto {

    private Long approvedForeignTravelId;

    private String personId;

    private Integer rolodexId;

    private String travelerName;

    private String destination;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.SERIALIZED_SQL_DATE_FORMAT)
    private Date endDate;

    private ScaleTwoDecimal amount;

    public Long getApprovedForeignTravelId() {
        return approvedForeignTravelId;
    }

    public void setApprovedForeignTravelId(Long approvedForeignTravelId) {
        this.approvedForeignTravelId = approvedForeignTravelId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Integer getRolodexId() {
        return rolodexId;
    }

    public void setRolodexId(Integer rolodexId) {
        this.rolodexId = rolodexId;
    }

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ScaleTwoDecimal getAmount() {
        return amount;
    }

    public void setAmount(ScaleTwoDecimal amount) {
        this.amount = amount;
    }
}
