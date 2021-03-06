package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.common.framework.type.ProposalType;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import java.util.ArrayList;
import java.util.List;

public class PHS398ResearchPlan_2_0V2_0GeneratorTest extends S2STestBase {

    @Override
    protected String getFormGeneratorName() {
        return PHS398ResearchPlan_2_0V2_0Generator.class.getSimpleName();
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
        DevelopmentProposal developmentProposal = document.getDevelopmentProposal();
        ProposalType type = new ProposalType();
        type.setCode("5");
        developmentProposal.setProposalType(type);
        List<Narrative> naList = new ArrayList<>();

        Narrative narrative1 = createNarrative("20");

        narrative1.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative1);

        Narrative narrative4 = createNarrative("111");

        narrative4.setDevelopmentProposal(document.getDevelopmentProposal());
        naList.add(narrative4);
        developmentProposal.setNarratives(naList);
        document.setDevelopmentProposal(developmentProposal);
    }
}
