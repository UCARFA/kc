/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
