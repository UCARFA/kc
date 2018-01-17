/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import static org.junit.Assert.*;

import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.ProposalPersonUnit;

public class ProposalAllUnitAdministratorDerivedRoleTypeServiceTest {

	private static final String CARD_UNIT = "IN-CARD";
	private static final String MED_UNIT = "IN-MED";
	private static final String UNIV_UNIT = "000001";

	@Test
	public void testGetApplicableUnits() {
		DevelopmentProposal proposal = new DevelopmentProposal();
		proposal.getProposalPersons().add(generateTestProposalPerson(UNIV_UNIT));
		proposal.getProposalPersons().add(generateTestProposalPerson(MED_UNIT, UNIV_UNIT));
		proposal.getProposalPersons().add(generateTestProposalPerson(CARD_UNIT));
		ProposalAllUnitAdministratorDerivedRoleTypeServiceImpl proposalAllUnitAdminService = new ProposalAllUnitAdministratorDerivedRoleTypeServiceImpl();
		Set<String> unitNumbers = proposalAllUnitAdminService.getApplicableUnits(proposal);
		assertEquals(3, unitNumbers.size());
		assertThat(unitNumbers, CoreMatchers.hasItem(UNIV_UNIT));
		assertThat(unitNumbers, CoreMatchers.hasItem(MED_UNIT));
		assertThat(unitNumbers, CoreMatchers.hasItem(CARD_UNIT));
	}
	
	ProposalPerson generateTestProposalPerson(String... unitNumbers) {
		ProposalPerson person = new ProposalPerson();
		for (String unitNumber : unitNumbers) {
			ProposalPersonUnit unit = new ProposalPersonUnit() {
				@Override
				public void refreshReferenceObject(String value) {
					
				}
			};
			final Unit newUnit = new Unit();
			newUnit.setUnitNumber(unitNumber);
			unit.setUnit(newUnit);
			unit.setUnitNumber(unitNumber);
			person.addUnit(unit);
		}
		return person;
	}
}
