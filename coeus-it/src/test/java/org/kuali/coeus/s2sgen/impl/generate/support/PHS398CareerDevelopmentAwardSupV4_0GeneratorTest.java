/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.coeus.common.framework.person.attr.CitizenshipType;
import org.kuali.coeus.common.framework.type.ProposalType;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;

import java.util.ArrayList;
import java.util.List;

public class PHS398CareerDevelopmentAwardSupV4_0GeneratorTest extends PHS398CareerDevelopmentAwardSupBaseGeneratorTest {

	@Override
	protected String getFormGeneratorName() {
		return PHS398CareerDevelopmentAwardSupV4_0Generator.class.getSimpleName();
	}

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
        ProposalPerson person = new ProposalPerson();
        person.setProposalPersonRoleId(PropAwardPersonRole.PRINCIPAL_INVESTIGATOR);
        person.setCitizenshipTypeCode(2);
        person.setPersonId("admin");
        CitizenshipType citizenshipType = new CitizenshipType();
        citizenshipType.setCode(2);
        person.setCitizenshipType(citizenshipType);
        DevelopmentProposal developmentProposal = document.getDevelopmentProposal();
        developmentProposal.addProposalPerson(person);
        ProposalType type = new ProposalType();
        type.setCode("5");
        developmentProposal.setProposalType(type);
        List<Narrative> naList = new ArrayList<>();

        Narrative narrative1 = createNarrative("128");

        narrative1.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative1);

        developmentProposal.setNarratives(naList);
        document.setDevelopmentProposal(developmentProposal);
    }

	@Override
    protected CitizenshipType getCitizenshipType() {
		CitizenshipType citizenshipType = new CitizenshipType();
		citizenshipType.setCode(2);
		return citizenshipType;
	}
}
