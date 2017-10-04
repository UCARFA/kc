/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
