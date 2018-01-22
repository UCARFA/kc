/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.core;

import org.junit.Test;
import org.kuali.coeus.propdev.impl.person.KeyPersonnelService;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.proposaldevelopment.rules.ProposalDevelopmentRuleTestBase;
import org.kuali.rice.core.api.datetime.DateTimeService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;

import java.sql.Date;

public class ProposalDevelopmentServiceImplTest extends ProposalDevelopmentRuleTestBase {

    String SPONSOR_CODE = "000162";
    String ACTIVITY_TYPE_CODE = "1";
    String PROPOSAL_TYPE_CODE = "1";
    String PRIME_SPONSOR_CODE = "000120";
    String ORIGINAL_LEAD_UNIT = "000001";

    @Test
    public void testDeleteProposal() throws Exception {
        ProposalDevelopmentDocument document = saveDoc();
        final ProposalPerson personnel = getPersonnel();
        getKeyPersonnelService().addProposalPerson(personnel, document);
        getDocumentService().saveDocument(document);
        setCertDetails(document.getDevelopmentProposal().getProposalPerson(0));
        getDocumentService().saveDocument(document);
        getProposalDevelopmentService().deleteProposal(document);
    }

    @Test
    public void testDeleteProposalMultiplePersonnel() throws Exception {
        ProposalDevelopmentDocument document = saveDoc();
        getKeyPersonnelService().addProposalPerson(getPersonnel(), document);
        document = (ProposalDevelopmentDocument) getDocumentService().saveDocument(document);
        getKeyPersonnelService().addProposalPerson(getPersonnel2(), document);
        document = (ProposalDevelopmentDocument) getDocumentService().saveDocument(document);
        setCertDetails(document.getDevelopmentProposal().getProposalPerson(0));
        setCertDetails(document.getDevelopmentProposal().getProposalPerson(1));
        getDocumentService().saveDocument(document);
        getProposalDevelopmentService().deleteProposal(document);
    }

    protected void setCertDetails(ProposalPerson person) {
        getKeyPersonnelService().saveCertDetails(person, "admin", getDateTimeService().getCurrentTimestamp());
    }

    protected ProposalPerson getPersonnel() {
        ProposalPerson newProposalPerson = new ProposalPerson();
        newProposalPerson.setPersonId("10000000008");
        newProposalPerson.setFullName("Allyson Cate");
        newProposalPerson.setUserName("cate");
        newProposalPerson.setProposalPersonRoleId("PI");
        return newProposalPerson;
    }

    protected ProposalPerson getPersonnel2() {
        ProposalPerson newProposalPerson = new ProposalPerson();
        newProposalPerson.setPersonId("admin");
        newProposalPerson.setFullName("admin");
        newProposalPerson.setUserName("admin");
        newProposalPerson.setProposalPersonRoleId("COI");
        return newProposalPerson;
    }

    public KeyPersonnelService getKeyPersonnelService() {
        return KcServiceLocator.getService(KeyPersonnelService.class);
    }

    protected ProposalDevelopmentDocument saveDoc() throws Exception {
        ProposalDevelopmentDocument proposalDevelopmentDocument = (ProposalDevelopmentDocument) getDocumentService().saveDocument(createProposal());
        documentService.saveDocument(proposalDevelopmentDocument);
        return proposalDevelopmentDocument;
    }

    private DocumentService getDocumentService() {
        return KRADServiceLocatorWeb.getDocumentService();
    }

    private ProposalDevelopmentDocument createProposal() throws Exception {
        ProposalDevelopmentDocument document = getNewProposalDevelopmentDocument();
        Date requestedStartDateInitial = new Date(System.currentTimeMillis());
        Date requestedEndDateInitial = new Date(System.currentTimeMillis());


        document.getDocumentHeader().setDocumentDescription("Original document");
        document.getDevelopmentProposal().setSponsorCode(SPONSOR_CODE);
        document.getDevelopmentProposal().setTitle("project title");
        document.getDevelopmentProposal().setRequestedStartDateInitial(requestedStartDateInitial);
        document.getDevelopmentProposal().setRequestedEndDateInitial(requestedEndDateInitial);
        document.getDevelopmentProposal().setActivityTypeCode(ACTIVITY_TYPE_CODE);
        document.getDevelopmentProposal().setProposalTypeCode(PROPOSAL_TYPE_CODE);
        document.getDevelopmentProposal().setOwnedByUnitNumber(ORIGINAL_LEAD_UNIT);
        document.getDevelopmentProposal().setPrimeSponsorCode(PRIME_SPONSOR_CODE);

        getProposalDevelopmentService().initializeUnitOrganizationLocation(document);
        getProposalDevelopmentService().initializeProposalSiteNumbers(document);

        return document;
    }


    protected ProposalDevelopmentService getProposalDevelopmentService() {
        return KcServiceLocator.getService(ProposalDevelopmentService.class);
    }

    public DateTimeService getDateTimeService() {
        return KcServiceLocator.getService(DateTimeService.class);
    }
}
