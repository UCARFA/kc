/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.common.framework.type.ProposalType;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;

import java.util.ArrayList;
import java.util.List;

public class PHS398ResTrainProgPlanV3_0GeneratorTest extends S2STestBase {

    @Override
    protected String getFormGeneratorName() {
        return PHS398ResTrainProgPlanV1_0Generator.class.getSimpleName();
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
        ProposalType type = new ProposalType();
        type.setCode("5");
        document.getDevelopmentProposal().setProposalType(type);
        List<Narrative> naList = new ArrayList<>();

        Narrative narrative1 = createNarrative("1");

        narrative1.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative1);

        Narrative narrative2 = createNarrative("151");

        narrative2.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative2);

        Narrative narrative3 = createNarrative("152");

        narrative3.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative3);
        document.getDevelopmentProposal().setNarratives(naList);
        
    }

}
