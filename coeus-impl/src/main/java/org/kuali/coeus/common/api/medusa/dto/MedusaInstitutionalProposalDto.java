/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.api.medusa.dto;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;
import java.util.List;

public class MedusaInstitutionalProposalDto {

    public MedusaInstitutionalProposalDto() {

    }

    @Property(source = "mvel:?institutionalProposalDocument.?documentHeader.?documentNumber")
    private String documentNumber;
    private String proposalNumber;
    private String leadUnitNumber;
    private String leadUnitName;
    private String title;
    @Property(source = "mvel:?proposalStatus.?description")
    private String proposalStatus;
    @Property(source = "mvel:?proposalType.?description")
    private String proposalType;
    private String sponsorProposalNumber;
    private String currentAccountNumber;
    @Property(source = "mvel:?activityType.?description")
    private String activityType;
    @Property(source = "mvel:?nsfCodeBo.?description")
    private String nsfCode;
    @Property(source = "mvel:?noticeOfOpportunity.?description")
    private String noticeOfOpportunity;
    private String sponsorCode;
    private String sponsorName;
    @Property(source = "mvel:?primeSponsor.?sponsorCode")
    private String primeSponsorCode;
    @Property(source = "mvel:?primeSponsor.?sponsorName")
    private String primeSponsorName;
    @Property(source = "mvel:costSharingIndicator == '1'")
    private boolean costSharing;
    @Property(source = "mvel:idcRateIndicator == '1'")
    private boolean unrecoveredFandA;
    @Property(source = "mvel:specialReviewIndicator == '1'")
    private boolean specialReview;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date requestedStartDateInitial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date requestedStartDateTotal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date requestedEndDateInitial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date requestedEndDateTotal;
    private ScaleTwoDecimal totalDirectCostInitial;
    private ScaleTwoDecimal totalDirectCostTotal;
    private ScaleTwoDecimal totalIndirectCostInitial;
    private ScaleTwoDecimal totalIndirectCostTotal;
    private ScaleTwoDecimal totalInitialCost;
    private ScaleTwoDecimal totalCost;

    @CollectionProperty(source = "projectPersons", itemClass = MedusaInvestigatorDto.class)
    private List<MedusaInvestigatorDto> investigators;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public String getLeadUnitNumber() {
        return leadUnitNumber;
    }

    public String getLeadUnitName() {
        return leadUnitName;
    }

    public String getTitle() {
        return title;
    }

    public String getProposalStatus() {
        return proposalStatus;
    }

    public String getProposalType() {
        return proposalType;
    }

    public String getSponsorProposalNumber() {
        return sponsorProposalNumber;
    }

    public String getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getNsfCode() {
        return nsfCode;
    }

    public String getNoticeOfOpportunity() {
        return noticeOfOpportunity;
    }

    public String getSponsorCode() {
        return sponsorCode;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public String getPrimeSponsorCode() {
        return primeSponsorCode;
    }

    public String getPrimeSponsorName() {
        return primeSponsorName;
    }

    public boolean isCostSharing() {
        return costSharing;
    }

    public boolean isUnrecoveredFandA() {
        return unrecoveredFandA;
    }

    public boolean isSpecialReview() {
        return specialReview;
    }

    public Date getRequestedStartDateInitial() {
        return requestedStartDateInitial;
    }

    public Date getRequestedStartDateTotal() {
        return requestedStartDateTotal;
    }

    public Date getRequestedEndDateInitial() {
        return requestedEndDateInitial;
    }

    public Date getRequestedEndDateTotal() {
        return requestedEndDateTotal;
    }

    public ScaleTwoDecimal getTotalDirectCostInitial() {
        return totalDirectCostInitial;
    }

    public ScaleTwoDecimal getTotalDirectCostTotal() {
        return totalDirectCostTotal;
    }

    public ScaleTwoDecimal getTotalIndirectCostInitial() {
        return totalIndirectCostInitial;
    }

    public ScaleTwoDecimal getTotalIndirectCostTotal() {
        return totalIndirectCostTotal;
    }

    public ScaleTwoDecimal getTotalInitialCost() {
        return totalInitialCost;
    }

    public ScaleTwoDecimal getTotalCost() {
        return totalCost;
    }

    public List<MedusaInvestigatorDto> getInvestigators() {
        return investigators;
    }
}
