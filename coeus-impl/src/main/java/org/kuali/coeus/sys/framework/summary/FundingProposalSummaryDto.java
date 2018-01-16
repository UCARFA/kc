/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.summary;

import com.codiform.moo.annotation.Property;

public class FundingProposalSummaryDto {
	@Property(source = "mvel:award.awardId")
	private Long awardId;
	@Property(source = "mvel:proposal.proposalId")
	private Long proposalId;
	@Property(source = "mvel:proposal.proposalNumber")
	private String proposalNumber;
	@Property(source = "mvel:proposal.sequenceNumber")
	private Integer proposalSequenceNumber;
	@Property(source = "mvel:award.awardNumber")
	private String awardNumber;
	@Property(source = "mvel:award.sequenceNumber")
	private Integer awardSequenceNumber;

	public String getProposalNumber() {
		return proposalNumber;
	}

	public void setProposalNumber(String proposalNumber) {
		this.proposalNumber = proposalNumber;
	}

	public Integer getProposalSequenceNumber() {
		return proposalSequenceNumber;
	}

	public void setProposalSequenceNumber(Integer proposalSequenceNumber) {
		this.proposalSequenceNumber = proposalSequenceNumber;
	}

	public String getAwardNumber() {
		return awardNumber;
	}

	public void setAwardNumber(String awardNumber) {
		this.awardNumber = awardNumber;
	}

	public Integer getAwardSequenceNumber() {
		return awardSequenceNumber;
	}

	public void setAwardSequenceNumber(Integer awardSequenceNumber) {
		this.awardSequenceNumber = awardSequenceNumber;
	}

	public Long getAwardId() {
		return awardId;
	}

	public void setAwardId(Long awardId) {
		this.awardId = awardId;
	}

	public Long getProposalId() {
		return proposalId;
	}

	public void setProposalId(Long proposalId) {
		this.proposalId = proposalId;
	}
}
