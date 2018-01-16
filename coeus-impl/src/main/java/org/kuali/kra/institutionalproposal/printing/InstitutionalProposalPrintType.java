/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.institutionalproposal.printing;

/**
 * This class represents different types of reports for Institutional Proposal
 * Printing
 */
public enum InstitutionalProposalPrintType {
	INSTITUTIONAL_PROPOSAL_REPORT("Institutional Proposal Report");

	private final String institutionalProposalPrintType;

	InstitutionalProposalPrintType(String institutionalProposalPrintType) {
		this.institutionalProposalPrintType = institutionalProposalPrintType;
	}

	public String getInstitutionalProposalPrintType() {
		return institutionalProposalPrintType;
	}
}
