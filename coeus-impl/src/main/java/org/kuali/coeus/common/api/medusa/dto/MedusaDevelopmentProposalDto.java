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
import org.kuali.coeus.sys.framework.json.JsonFormats;

import java.sql.Date;
import java.util.List;

public class MedusaDevelopmentProposalDto {

    public MedusaDevelopmentProposalDto() {

    }

    @Property(source = "mvel:?document.?documentHeader.?documentNumber")
    private String documentNumber;
    private String proposalNumber;
    @Property(source = "mvel:?proposalState.?description")
    private String proposalState;
    @Property(source = "ownedByUnitNumber")
    private String leadUnitNumber;
    @Property(source = "ownedByUnitName")
    private String leadUnitName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date requestedStartDateInitial;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = JsonFormats.DESERIALIZED_SQL_DATE_FORMAT)
    private Date requestedEndDateInitial;
    private String title;
    @Property(source = "mvel:?proposalType.?description")
    private String proposalType;
    @Property(source = "mvel:?nsfCodeBo.?description")
    private String nsfCode;
    private String sponsorCode;
    private String sponsorName;
    private String primeSponsorCode;
    @Property(source = "mvel:?primeSponsor.?sponsorName")
    private String primeSponsorName;
    private String sponsorProposalNumber;
    @Property(source = "mvel:?activityType.?description")
    private String activityType;
    @Property(source = "programAnnouncementTitle")
    private String programTitle;
    @Property(source = "programAnnouncementNumber")
    private String programNumber;
    @Property(source = "mvel:?noticeOfOpportunity.?description")
    private String noticeOfOpportunity;
    private String attachmentsStatus;
    @Property(source = "budgetStatusDescription")
    private String budgetStatus;

    @CollectionProperty(source = "proposalPersons", itemClass = MedusaInvestigatorDto.class)
    private List<MedusaInvestigatorDto> investigators;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public String getProposalState() {
        return proposalState;
    }

    public String getLeadUnitNumber() {
        return leadUnitNumber;
    }

    public String getLeadUnitName() {
        return leadUnitName;
    }

    public Date getRequestedStartDateInitial() {
        return requestedStartDateInitial;
    }

    public Date getRequestedEndDateInitial() {
        return requestedEndDateInitial;
    }

    public String getTitle() {
        return title;
    }

    public String getProposalType() {
        return proposalType;
    }

    public String getNsfCode() {
        return nsfCode;
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

    public String getSponsorProposalNumber() {
        return sponsorProposalNumber;
    }

    public String getActivityType() {
        return activityType;
    }

    public String getProgramTitle() {
        return programTitle;
    }

    public String getProgramNumber() {
        return programNumber;
    }

    public String getNoticeOfOpportunity() {
        return noticeOfOpportunity;
    }

    public String getAttachmentsStatus() {
        return attachmentsStatus;
    }

    public String getBudgetStatus() {
        return budgetStatus;
    }

    public List<MedusaInvestigatorDto> getInvestigators() {
        return investigators;
    }
}
