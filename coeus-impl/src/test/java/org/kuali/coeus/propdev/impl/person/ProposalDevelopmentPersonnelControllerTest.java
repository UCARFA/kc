package org.kuali.coeus.propdev.impl.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.propdev.impl.person.attachment.PropPerDocType;
import org.kuali.coeus.propdev.impl.person.attachment.ProposalPersonBiography;
//import org.kuali.coeus.propdev.impl.person.attachment.ProposalPersonBiographyServiceImpl;
import org.kuali.kra.bo.DocumentNextvalue;
import org.kuali.kra.infrastructure.Constants;

import java.util.ArrayList;
import java.util.List;

public class ProposalDevelopmentPersonnelControllerTest {
//    private ProposalPersonBiographyServiceImpl proposalPersonBiographyService;
    private ProposalDevelopmentPersonnelController proposalDevelopmentPersonnelController;
    private Mockery context;
    private ProposalDevelopmentDocument proposalDocument;
    private ProposalDevelopmentDocumentForm proposalDocumentForm;

    @Before
    public void setUp() {
        context = new JUnit4Mockery() {
            {
                setThreadingPolicy(new Synchroniser());
            }
        };
        proposalDocumentForm = new ProposalDevelopmentDocumentForm() {
            @Override
            protected void instantiateDocument() { setDocument(new ProposalDevelopmentDocument()); }
        };
        proposalDevelopmentPersonnelController = new ProposalDevelopmentPersonnelController();
        proposalDocument = createProposal();
        proposalDocumentForm.setDocument(proposalDocument);
    }

    @Test
    public void test_deletePerson(){
        final String SELECTED_COLLECTION_PATH ="document.developmentProposal.proposalPersons";
        final String SELECTED_LINE_INDEX = "0";
        ProposalPerson deletedPerson = proposalDocument.getDevelopmentProposal().getProposalPerson(Integer.parseInt(SELECTED_LINE_INDEX));
        try {
            proposalDevelopmentPersonnelController.deletePerson(proposalDocumentForm, SELECTED_COLLECTION_PATH, SELECTED_LINE_INDEX);
        }
        catch (Exception e){
            //No exception is explicitly thrown from deletePerson method.
        }
        ProposalPerson currentPerson = proposalDocument.getDevelopmentProposal().getProposalPerson(Integer.parseInt(SELECTED_LINE_INDEX));
        assertNotEquals(deletedPerson,currentPerson);
    }
    public ProposalDevelopmentDocument createProposal() {
        ProposalDevelopmentDocument document = new ProposalDevelopmentDocument();
        document.getDevelopmentProposal().setProposalNumber("11");
        List<ProposalPersonBiography> biographies = new ArrayList<ProposalPersonBiography>();
        ProposalPersonBiography proposalPersonBiography = createPersonBiography(document);
        biographies.add(proposalPersonBiography);
        ProposalPersonBiography proposalRolodexBiography = createRolodexBiography(document);
        biographies.add(proposalRolodexBiography);
        document.getDevelopmentProposal().setPropPersonBios(biographies);
        return document;
    }

    public ProposalPersonBiography createPersonBiography(
            ProposalDevelopmentDocument proposalDevelopmentDocument) {
        final ProposalPersonBiography proposalPersonBiography = new ProposalPersonBiography() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {
            }
        };
        proposalPersonBiography
                .setDevelopmentProposal(proposalDevelopmentDocument
                        .getDevelopmentProposal());
        proposalPersonBiography.setBiographyNumber(proposalDevelopmentDocument
                .getDocumentNextValue(Constants.PROP_PERSON_BIO_NUMBER));
        proposalPersonBiography.setPropPerDocType(new PropPerDocType());
        proposalPersonBiography.setProposalPersonNumber(11);
        final ProposalPerson person = new ProposalPerson();
        person.setProposalPersonNumber(11);
        person.setPersonId("11");
        proposalDevelopmentDocument.getDevelopmentProposal()
                .addProposalPerson(person);
        proposalPersonBiography.setPersonId(person.getPersonId());
        proposalPersonBiography.setDocumentTypeCode("11");
        proposalPersonBiography.getPropPerDocType().setCode(
                proposalPersonBiography.getDocumentTypeCode());
        final List<DocumentNextvalue> documentNextvalues = new ArrayList<>();
        final DocumentNextvalue nextvalue = new DocumentNextvalue();
        nextvalue.setPropertyName(Constants.PROP_PERSON_BIO_NUMBER);
        nextvalue.setNextValue(12);
        documentNextvalues.add(nextvalue);
        proposalDevelopmentDocument.setDocumentNextvalues(documentNextvalues);
        return proposalPersonBiography;
    }
    public ProposalPersonBiography createRolodexBiography(
            ProposalDevelopmentDocument proposalDevelopmentDocument) {
        final ProposalPersonBiography proposalPersonBiography = new ProposalPersonBiography() {
            @Override
            public void refreshReferenceObject(String referenceObjectName) {
            }
        };
        proposalPersonBiography
                .setDevelopmentProposal(proposalDevelopmentDocument
                        .getDevelopmentProposal());
        proposalPersonBiography.setBiographyNumber(proposalDevelopmentDocument
                .getDocumentNextValue(Constants.PROP_PERSON_BIO_NUMBER));
        proposalPersonBiography.setPropPerDocType(new PropPerDocType());
        proposalPersonBiography.setProposalPersonNumber(12);
        final ProposalPerson person = new ProposalPerson();
        person.setProposalPersonNumber(12);
        person.setRolodexId(12);
        proposalDevelopmentDocument.getDevelopmentProposal()
                .addProposalPerson(person);
        proposalPersonBiography.setRolodexId(person.getRolodexId());
        proposalPersonBiography.setDocumentTypeCode("11");
        proposalPersonBiography.getPropPerDocType().setCode(
                proposalPersonBiography.getDocumentTypeCode());
        final List<DocumentNextvalue> documentNextvalues = new ArrayList<DocumentNextvalue>();
        final DocumentNextvalue nextvalue = new DocumentNextvalue();
        nextvalue.setPropertyName(Constants.PROP_PERSON_BIO_NUMBER);
        nextvalue.setNextValue(13);
        documentNextvalues.add(nextvalue);
        proposalDevelopmentDocument.setDocumentNextvalues(documentNextvalues);
        return proposalPersonBiography;
    }
}
