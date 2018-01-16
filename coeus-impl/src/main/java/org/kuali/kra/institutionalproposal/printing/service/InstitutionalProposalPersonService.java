/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.printing.service;

import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.kra.institutionalproposal.contacts.InstitutionalProposalPerson;

import java.util.List;

/**
 * These class have different methods to provide service like pass proposal
 * number get the list of proposal persons.
 */
public interface InstitutionalProposalPersonService {
	/**
	 * This method will return the list of proposal persons if proposal person
	 * find in development proposal.
	 * 
	 * @param proposalNumber
	 *            is a number used to get the proposal persons for this proposal
	 *            number.
	 * @return list of proposal persons
	 */
	public List<ProposalPerson> getInvestigatorsFromDevelopmentProposal(
			String proposalNumber);

    Boolean isCreditSplitOptInEnabled();

    Boolean generateCreditSplitForPerson(InstitutionalProposalPerson person);

    List<InstitutionalProposalPerson> getPersonsSelectedForCreditSplit(List<InstitutionalProposalPerson> projectPersons);
}
