/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

public class PHS398CareerDevelopmentAwardSupV1_2GeneratorTest extends
		PHS398CareerDevelopmentAwardSupBaseGeneratorTest {

	@Override
	protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
		super.prepareData(document);

		document.getDevelopmentProposal().refreshReferenceObject("proposalType");
	}

	@Override
	protected String getFormGeneratorName() {
		return PHS398CareerDevelopmentAwardSupV1_2Generator.class.getSimpleName();
	}
}
