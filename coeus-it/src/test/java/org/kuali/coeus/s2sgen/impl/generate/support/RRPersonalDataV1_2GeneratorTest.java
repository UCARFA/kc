/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is used to test RRPersonalDataV1_1 form
 */
public class RRPersonalDataV1_2GeneratorTest extends
		S2STestBase {

	@Override
	protected String getFormGeneratorName() {
		return RRPersonalDataV1_2Generator.class.getSimpleName();
	}

	@Override
	protected void prepareData(ProposalDevelopmentDocument document)
			throws Exception {
		ProposalPerson proposalPerson = new ProposalPerson();
		proposalPerson.setProposalPersonRoleId("PI");
		proposalPerson.setFirstName("Philip");
		proposalPerson.setLastName("Berg");
		proposalPerson.setSocialSecurityNumber("1234");
		proposalPerson.setGender("F");
		proposalPerson.setRace("Asian");
		proposalPerson.setHandicapType("Hearing");
		proposalPerson.setCountryOfCitizenship("USA");
		proposalPerson.setOptInCertificationStatus(true);
		proposalPerson.setOptInUnitStatus(true);
		proposalPerson.setProposalPersonNumber(1001);
		proposalPerson.setRace("English");
        proposalPerson.setDevelopmentProposal(document.getDevelopmentProposal());


        ProposalPerson keyPerson = new ProposalPerson();
		keyPerson.setProposalPersonRoleId("COI");
		keyPerson.setFirstName("Terry");
		keyPerson.setLastName("Durkin");
		keyPerson.setSocialSecurityNumber("9876");
		keyPerson.setGender("M");
		keyPerson.setRace("American Indian or Alaska Native");
		keyPerson.setHandicapType("Visual");
		keyPerson.setCountryOfCitizenship("USA");
		keyPerson.setOptInCertificationStatus(true);
		keyPerson.setOptInUnitStatus(true);
		keyPerson.setProposalPersonNumber(1002);
		keyPerson.setRace("English");
        keyPerson.setDevelopmentProposal(document.getDevelopmentProposal());

		List<ProposalPerson> proposalPersonList = new ArrayList<ProposalPerson>();
		proposalPersonList.add(proposalPerson);
		proposalPersonList.add(keyPerson);
		document.getDevelopmentProposal()
				.setProposalPersons(proposalPersonList);
	}
}
