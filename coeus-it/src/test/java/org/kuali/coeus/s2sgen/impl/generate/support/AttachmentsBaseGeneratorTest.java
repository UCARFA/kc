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

import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.NarrativeAttachment;
import org.kuali.coeus.propdev.impl.attachment.NarrativeType;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.core.api.util.ClassLoaderUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AttachmentsBaseGeneratorTest extends S2STestBase {

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {

        NarrativeAttachment narrativeAttachment = new NarrativeAttachment();
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader(
                ClassLoaderUtils.getDefaultClassLoader());
        Resource resource = resourceLoader
                .getResource(S2STestConstants.ATT_PACKAGE + "/exercise2.pdf");
        InputStream inputStream = resource.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        byte[] narrativePdf = new byte[bis.available()];
        narrativeAttachment.setData(narrativePdf);
        narrativeAttachment.setName("exercise1");

        Narrative narrative = new Narrative();
        List<Narrative> naList = new ArrayList<>();
        narrative.setDevelopmentProposal(document.getDevelopmentProposal());
        narrative.setModuleNumber(1);
        narrative.setModuleTitle("A title");
        narrative.setModuleSequenceNumber(1);
        narrative.setModuleStatusCode("C");
        narrative.setNarrativeTypeCode("61");
        narrative.setNarrativeAttachment(narrativeAttachment);
        narrative.setObjectId("12345678890abcd");
        narrative.setName("exercise1");
        NarrativeType narrativeType = new NarrativeType();
        narrativeType.setCode("61");
        narrativeType.setAllowMultiple(false);
        narrativeType.setSystemGenerated(false);
        narrativeType.setDescription("Testing for Attachments Attachment");
        narrative.setNarrativeType(narrativeType);
        naList.add(narrative);

        document.getDevelopmentProposal().setNarratives(naList);
    }
}
