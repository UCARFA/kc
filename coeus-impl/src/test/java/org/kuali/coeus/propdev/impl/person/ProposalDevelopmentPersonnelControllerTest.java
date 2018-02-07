/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.propdev.impl.person.attachment.PropPerDocType;
import org.kuali.coeus.propdev.impl.person.attachment.ProposalPersonBiography;
import org.kuali.kra.bo.DocumentNextvalue;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.rice.krad.web.service.CollectionControllerService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

public class ProposalDevelopmentPersonnelControllerTest {
    private ProposalDevelopmentPersonnelController proposalDevelopmentPersonnelController;
    private ProposalDevelopmentDocument proposalDocument;
    private ProposalDevelopmentDocumentForm proposalDocumentForm;

    @Before
    public void setUp() {
        proposalDocumentForm = new ProposalDevelopmentDocumentForm() {
            @Override
            protected void instantiateDocument() { setDocument(new ProposalDevelopmentDocument()); }
        };
        proposalDevelopmentPersonnelController = new ProposalDevelopmentPersonnelController();
        proposalDevelopmentPersonnelController.setCollectionControllerService(new CollectionControllerService() {
            @Override
            public ModelAndView addLine(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView addBlankLine(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView retrieveEditLineDialog(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView editLine(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView closeEditLineDialog(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView saveLine(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView deleteLine(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView retrieveCollectionPage(UifFormBase form) {
                return null;
            }

            @Override
            public ModelAndView tableJsonRetrieval(UifFormBase form) {
                return null;
            }
        });
        proposalDocument = createProposal();
        proposalDocumentForm.setDocument(proposalDocument);
    }

    @Test
    public void test_deletePersonBio(){
        final String SELECTED_COLLECTION_PATH ="document.developmentProposal.proposalPersons";
        final String SELECTED_LINE_INDEX = "0";
        final String REMAINING_LINE_INDEX = "0";
        ProposalPersonBiography deletedProposalPersonBios = proposalDocument.getDevelopmentProposal().getPropPersonBio(Integer.parseInt(SELECTED_LINE_INDEX));
        proposalDevelopmentPersonnelController.deletePerson(proposalDocumentForm, SELECTED_COLLECTION_PATH, SELECTED_LINE_INDEX);
        ProposalPersonBiography remainingProposalPersonBios = proposalDocument.getDevelopmentProposal().getPropPersonBio(Integer.parseInt(REMAINING_LINE_INDEX));
        assertNotEquals(deletedProposalPersonBios,remainingProposalPersonBios);
    }
    @Test
    public void test_deleteRolodexBio(){
        final String SELECTED_COLLECTION_PATH ="document.developmentProposal.proposalPersons";
        final String SELECTED_LINE_INDEX = "1";
        final String REMAINING_LINE_INDEX = "0";
        ProposalPersonBiography deletedProposalPersonBios = proposalDocument.getDevelopmentProposal().getPropPersonBio(Integer.parseInt(SELECTED_LINE_INDEX));
        proposalDevelopmentPersonnelController.deletePerson(proposalDocumentForm, SELECTED_COLLECTION_PATH, SELECTED_LINE_INDEX);
        ProposalPersonBiography remainingProposalPersonBios = proposalDocument.getDevelopmentProposal().getPropPersonBio(Integer.parseInt(REMAINING_LINE_INDEX));
        assertNotEquals(deletedProposalPersonBios,remainingProposalPersonBios);
    }
    public ProposalDevelopmentDocument createProposal() {
        ProposalDevelopmentDocument document = new ProposalDevelopmentDocument();
        document.getDevelopmentProposal().setProposalNumber("11");
        List<ProposalPersonBiography> biographies = new ArrayList<>();
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
        final List<DocumentNextvalue> documentNextvalues = new ArrayList<>();
        final DocumentNextvalue nextvalue = new DocumentNextvalue();
        nextvalue.setPropertyName(Constants.PROP_PERSON_BIO_NUMBER);
        nextvalue.setNextValue(13);
        documentNextvalues.add(nextvalue);
        proposalDevelopmentDocument.setDocumentNextvalues(documentNextvalues);
        return proposalPersonBiography;
    }
}
