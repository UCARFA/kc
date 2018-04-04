/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.document;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.AwardFixtureFactory;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.fundingproposal.AwardFundingProposal;
import org.kuali.kra.institutionalproposal.InstitutionalProposalFixtureFactory;
import org.kuali.kra.institutionalproposal.ProposalStatus;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.institutionalproposal.service.InstitutionalProposalVersioningService;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kew.api.document.DocumentStatus;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.bo.PersistableBusinessObject;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.Collections;

import static org.junit.Assert.assertNotNull;
public class AwardDocumentIntegrationTest extends KcIntegrationTestBase {

    private BusinessObjectService businessObjectService;

    private DocumentService documentService;

    private InstitutionalProposalVersioningService ipVersioningService;

    @Before
    public void setup() {
        businessObjectService = KNSServiceLocator.getBusinessObjectService();
        documentService = KRADServiceLocatorWeb.getDocumentService();
        ipVersioningService = KcServiceLocator.getService(InstitutionalProposalVersioningService.class);
    }

    @After
    public void tearDown() {
        businessObjectService = null;
        documentService = null;
        ipVersioningService = null;
    }

    @Test
    public void testSavingDocument() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));

        AwardDocument doc = (AwardDocument) documentService.getNewDocument(AwardDocument.class);
        assertNotNull(doc);
    }

    @Test
    public void testDefundingProposalsOnCancel() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));

        InstitutionalProposalDocument ipDoc = (InstitutionalProposalDocument) documentService.getNewDocument(InstitutionalProposalDocument.class);
        InstitutionalProposal ip = InstitutionalProposalFixtureFactory.createInstitutionalProposalFixture();
        ipDoc.setInstitutionalProposal(ip);
        documentService.saveDocument(ipDoc);
        documentService.routeDocument(ipDoc, "Routing to final", Collections.emptyList());
        Assert.assertEquals(DocumentStatus.FINAL, ipDoc.getDocumentHeader().getWorkflowDocument().getStatus());
        InstitutionalProposal activeVersion = ipVersioningService.getActiveInstitutionalProposalVersion(ip.getProposalNumber());
        Assert.assertEquals(1, activeVersion.getSequenceNumber().intValue());
        Assert.assertEquals(ProposalStatus.PENDING, activeVersion.getStatusCode());

        AwardDocument awardDoc = (AwardDocument) documentService.getNewDocument(AwardDocument.class);
        Award award = AwardFixtureFactory.createAwardFixture();
        award.add(ip);
        awardDoc.setAward(award);
        documentService.saveDocument(awardDoc);
        businessObjectService.save(award);
        Assert.assertEquals(DocumentStatus.SAVED, awardDoc.getDocumentHeader().getWorkflowDocument().getStatus());
        Assert.assertEquals(1, countMatching(AwardFundingProposal.class, "awardId", award.getAwardId()));
        activeVersion = ipVersioningService.getActiveInstitutionalProposalVersion(ip.getProposalNumber());
        Assert.assertEquals(2, activeVersion.getSequenceNumber().intValue());
        Assert.assertEquals(ProposalStatus.FUNDED, activeVersion.getStatusCode());

        documentService.cancelDocument(awardDoc, "Canceling award");
        Assert.assertEquals(DocumentStatus.CANCELED, awardDoc.getDocumentHeader().getWorkflowDocument().getStatus());
        Assert.assertEquals(0, countMatching(AwardFundingProposal.class,"awardId", award.getAwardId()));
        activeVersion = ipVersioningService.getActiveInstitutionalProposalVersion(ip.getProposalNumber());
        Assert.assertEquals(3, activeVersion.getSequenceNumber().intValue());
        Assert.assertEquals(ProposalStatus.PENDING, activeVersion.getStatusCode());
    }

    private <T extends PersistableBusinessObject> int countMatching(Class<T> clazz, String key, Object value) {
        return businessObjectService.findMatching(clazz, Collections.singletonMap(key, value)).size();
    }
}
