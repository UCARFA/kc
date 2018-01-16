/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.instprop.impl.api;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Property;

import org.kuali.coeus.sys.framework.summary.FundingProposalSummaryDto;
import org.kuali.coeus.common.api.unit.UnitDto;
import org.kuali.coeus.common.framework.sponsor.SponsorDto;
import org.kuali.coeus.sys.framework.summary.InvestigatorDto;

import java.util.Date;
import java.util.List;

public class InstitutionalProposalSummaryDto {
	private Long proposalId;
    private String proposalNumber;
    private Integer sequenceNumber;
    @Property(source = "instProposalNumber")
    private String proposalLogProposalNumber;
    private Date updateTimestamp;
    @Property(translate = true)
    private InvestigatorDto principalInvestigator;
    @Property(translate = true)
    private SponsorDto sponsor;
    @CollectionProperty(source = "allFundingProposals", itemClass=FundingProposalSummaryDto.class)
    private List<FundingProposalSummaryDto> fundingProposals;
	@Property(translate = true)
	private UnitDto leadUnit;

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public InvestigatorDto getPrincipalInvestigator() {
        return principalInvestigator;
    }

    public void setPrincipalInvestigator(InvestigatorDto principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }

    public SponsorDto getSponsor() {
        return sponsor;
    }

    public void setSponsor(SponsorDto sponsor) {
        this.sponsor = sponsor;
    }

    public List<FundingProposalSummaryDto> getFundingProposals() {
        return fundingProposals;
    }

    public void setFundingProposals(List<FundingProposalSummaryDto> fundingProposals) {
        this.fundingProposals = fundingProposals;
    }

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public UnitDto getLeadUnit() {
		return leadUnit;
	}

	public void setLeadUnit(UnitDto leadUnit) {
		this.leadUnit = leadUnit;
	}

	public Long getProposalId() {
		return proposalId;
	}

	public void setProposalId(Long proposalId) {
		this.proposalId = proposalId;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getProposalLogProposalNumber() {
		return proposalLogProposalNumber;
	}

	public void setProposalLogProposalNumber(String proposalLogProposalNumber) {
		this.proposalLogProposalNumber = proposalLogProposalNumber;
	}
}
