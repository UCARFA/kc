/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.s2sgen.impl.generate.support;

import org.junit.Test;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.rolodex.Rolodex;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.s2s.S2sOpportunity;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.coeus.propdev.impl.attachment.NarrativeAttachment;
import org.kuali.coeus.propdev.impl.location.ProposalSite;
import org.kuali.coeus.propdev.impl.s2s.S2sOppForms;
import org.kuali.coeus.s2sgen.api.print.FormPrintService;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.util.ClassLoaderUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to test the PDF Printing of Forms
 */
public class RRPerformanceSiteV1_0Generator_PrintFormTest extends KcIntegrationTestBase {

    @Test
    public void testPrint() throws IOException {
        ProposalDevelopmentDocument document = new ProposalDevelopmentDocument();
        Organization performOrganization = new Organization();
        performOrganization.setOrganizationName("Espace");
        Rolodex rolodex = new Rolodex();
        rolodex.setAddressLine1("1290 Avenue of the Americas");
        rolodex.setAddressLine2("Suite 550");
        rolodex.setCity("New York");
        rolodex.setCounty("County");
        rolodex.setPostalCode("10104");
        rolodex.setState("NY");
        rolodex.setCountryCode("USA");

        performOrganization.setRolodex(rolodex);
        
        ProposalSite performSite = new ProposalSite();
        performSite.setOrganization(performOrganization);
        document.getDevelopmentProposal().setPerformingOrganization(performSite);
        document.getDevelopmentProposal().setProposalNumber("123456");
        List<ProposalSite> proList = new ArrayList<ProposalSite>();
        ProposalSite proposalSite = new ProposalSite();
        proposalSite.setRolodex(rolodex);
        proList.add(proposalSite);
        document.getDevelopmentProposal().setOtherOrganizations(proList);

        Narrative narrative = new Narrative();
        narrative.setModuleNumber(123);
        List<Narrative> naList = new ArrayList<Narrative>();

        NarrativeAttachment narrativeAttachment = new NarrativeAttachment();
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader(ClassLoaderUtils.getDefaultClassLoader());
        Resource resource = resourceLoader.getResource(S2STestConstants.ATT_PACKAGE + "/exercise5.pdf");
        InputStream inStream = resource.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inStream);
        byte[] narrativePdf = new byte[bis.available()];
        bis.read(narrativePdf);
        narrativeAttachment.setData(narrativePdf);


        narrative.setNarrativeTypeCode("40");
        narrative.refreshReferenceObject("narrativeType");
        narrative.setNarrativeAttachment(narrativeAttachment);
        narrative.setName("OpportunityForm");
        naList.add(narrative);
        document.getDevelopmentProposal().setNarratives(naList);
        S2sOppForms forms = new S2sOppForms();
        forms.setS2sOppFormsId(new S2sOppForms.S2sOppFormsId());
        forms.getS2sOppFormsId().setOppNameSpace("http://apply.grants.gov/forms/RR_PerformanceSite-V1.0");
        List<S2sOppForms> oppForms = new ArrayList<S2sOppForms>();
        oppForms.add(forms);
        S2sOpportunity opportunity = new S2sOpportunity();
        opportunity.setS2sOppForms(oppForms);
        document.getDevelopmentProposal().setS2sOpportunity(opportunity);
        FormPrintService printService = KcServiceLocator.getService(FormPrintService.class);
        printService.printForm(document);
    }


}
