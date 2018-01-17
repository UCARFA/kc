/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.apache.commons.io.IOUtils;
import org.kuali.coeus.common.framework.type.ProposalType;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.NarrativeAttachment;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.core.api.util.ClassLoaderUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PHS398ResTrainProgPlanV4_0GeneratorTest extends S2STestBase {

    @Override
    protected String getFormGeneratorName() {
        return PHS398ResTrainProgPlanV4_0Generator.class.getSimpleName();
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
        ProposalType type = new ProposalType();
        type.setCode("5");
        document.getDevelopmentProposal().setProposalType(type);
        List<Narrative> naList = new ArrayList<>();

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader());
        Resource attResource = resourceLoader.getResource(S2STestConstants.ATT_PACKAGE + "/Project_Abstract-V1.1_exercise1.pdf");
        InputStream attStream = attResource.getInputStream();
        BufferedInputStream attBis = new BufferedInputStream(attStream);

        Narrative narrative1 = createNarrative("114");
        narrative1.setDevelopmentProposal(document.getDevelopmentProposal());
        NarrativeAttachment na = new NarrativeAttachment();
        na.setName("blah");
        na.setType("application/pdf");
        na.setNarrative(narrative1);
        na.setData(IOUtils.toByteArray(attBis));
        narrative1.setNarrativeAttachment(na);
        naList.add(narrative1);
        document.getDevelopmentProposal().getNarratives().add(narrative1);
    }

}
