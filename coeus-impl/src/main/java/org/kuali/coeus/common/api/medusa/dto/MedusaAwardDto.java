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

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Ignore;
import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;
import java.util.List;

public class MedusaAwardDto {

    public MedusaAwardDto() {

    }

    @Property(source = "mvel:?document.?documentHeader.?documentNumber")
    private String documentNumber;
    private String awardNumber;
    @Property(source = "mvel:?awardType.?description")
    private String awardType;
    private String sponsorAwardNumber;
    @Property(source = "mvel:?activityType.?description")
    private String activityType;
    private String modificationNumber;
    @Property(source = "mvel:?awardStatus.?description")
    private String awardStatus;
    private String accountNumber;
    private String accountTypeDescription;
    private String title;
    private String sponsorCode;
    private String sponsorName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date awardEffectiveDate;
    @Property(source = "mvel:awardApprovedSubawards != empty")
    private boolean approvedSubaward;
    @Property(source = "mvel:paymentScheduleItems != empty")
    private boolean paymentSchedule;
    @Property(source = "mvel:approvedEquipmentItems != empty")
    private boolean approvedEquipment;
    @Property(source = "mvel:awardTransferringSponsors != empty")
    private boolean sponsorFundingTransferred;
    @Property(source = "mvel:approvedForeignTravelTrips != empty")
    private boolean approvedForeignTravel;
    @Property(source = "mvel:awardCostShares != empty")
    private boolean costShare;
    @Property(source = "mvel:awardFandaRate != empty")
    private boolean awardFandA;

    @CollectionProperty(source = "projectPersons", itemClass = MedusaInvestigatorDto.class)
    private List<MedusaInvestigatorDto> investigators;

    @Ignore
    private MedusaAwardAmountDto awardAmountInfo;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public String getAwardType() {
        return awardType;
    }

    public String getSponsorAwardNumber() {
        return sponsorAwardNumber;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getModificationNumber() {
        return modificationNumber;
    }

    public String getAwardStatus() {
        return awardStatus;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountTypeDescription() {
        return accountTypeDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getSponsorCode() {
        return sponsorCode;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public Date getAwardEffectiveDate() {
        return awardEffectiveDate;
    }

    public boolean isApprovedSubaward() {
        return approvedSubaward;
    }

    public boolean isPaymentSchedule() {
        return paymentSchedule;
    }

    public boolean isApprovedEquipment() {
        return approvedEquipment;
    }

    public boolean isSponsorFundingTransferred() {
        return sponsorFundingTransferred;
    }

    public boolean isApprovedForeignTravel() {
        return approvedForeignTravel;
    }

    public boolean isCostShare() {
        return costShare;
    }

    public boolean isAwardFandA() {
        return awardFandA;
    }

    public List<MedusaInvestigatorDto> getInvestigators() {
        return investigators;
    }

    public MedusaAwardAmountDto getAwardAmountInfo() {
        return awardAmountInfo;
    }

    public void setAwardAmountInfo(MedusaAwardAmountDto awardAmountInfo) {
        this.awardAmountInfo = awardAmountInfo;
    }
}
