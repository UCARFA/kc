/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.propdev.impl.abstrct.ProposalAbstract;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.location.CongressionalDistrict;

import java.util.ArrayList;
import java.util.List;

public class RRSF424V1_1GeneratorTest extends RRSF424BaseGeneratorTest {

	@Override
	protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
		super.prepareData(document);

		final ProposalAbstract abstrct = new ProposalAbstract();
		abstrct.setProposalNumber(document.getDevelopmentProposal().getProposalNumber());
		abstrct.setAbstractTypeCode("16");
		abstrct.refreshReferenceObject("abstractType");
		abstrct.setAbstractDetails("A Location");
		document.getDevelopmentProposal().getProposalAbstracts().add(abstrct);


		CongressionalDistrict congressionalDistrict = new CongressionalDistrict();
		congressionalDistrict.setCongressionalDistrict("CONDI");
		congressionalDistrict.setProposalSite(document.getDevelopmentProposal().getPerformingOrganization());
		List<CongressionalDistrict> congressionalDistricts = new ArrayList<>();
		congressionalDistricts.add(congressionalDistrict);
		document.getDevelopmentProposal().getPerformingOrganization()
				.setCongressionalDistricts(congressionalDistricts);
	}

	@Override
	protected String getFormGeneratorName() {
		return RRSF424V1_1Generator.class.getSimpleName();
	}

	@Override
	String getFormName() {
		return "RR_SF424-V1.1";
	}

	@Override
	String getNamespace() {
		return "http://apply.grants.gov/forms/RR_SF424-V1.1";
	}
}
