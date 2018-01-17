/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.common.framework.type.ProposalType;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.attachment.Narrative;

import java.util.ArrayList;
import java.util.List;

public class PHS398ResearchPlanV1_1GeneratorTest extends S2STestBase {

    @Override
    protected String getFormGeneratorName() {
        return PHS398ResearchPlanV1_1Generator.class.getSimpleName();
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {

        ProposalType type = new ProposalType();
        type.setCode("5");
        document.getDevelopmentProposal().setProposalType(type);
        List<Narrative> naList = new ArrayList<>();

        Narrative narrative1 = createNarrative("20");

        narrative1.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative1);
        document.getDevelopmentProposal().setNarratives(naList);
    }
}
