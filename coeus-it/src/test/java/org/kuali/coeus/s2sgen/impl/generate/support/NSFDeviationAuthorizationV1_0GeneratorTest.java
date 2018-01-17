/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.abstrct.ProposalAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests the NSFDeviationAuthorizationV1_0 Generator
 */
public class NSFDeviationAuthorizationV1_0GeneratorTest extends S2STestBase {

    @Override
    protected String getFormGeneratorName() {
        return NSFDeviationAuthorizationV1_0Generator.class.getSimpleName();
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {

        ProposalAbstract propsAbstract = new ProposalAbstract();
        propsAbstract.setAbstractTypeCode("15");
        propsAbstract.setAbstractDetails("Deviation Authorization");
        List<ProposalAbstract> proList = new ArrayList<ProposalAbstract>();
        proList.add(propsAbstract);

        propsAbstract.setProposalNumber(document.getDevelopmentProposal().getProposalNumber());

        document.getDevelopmentProposal().setProposalAbstracts(proList);
    }
}
