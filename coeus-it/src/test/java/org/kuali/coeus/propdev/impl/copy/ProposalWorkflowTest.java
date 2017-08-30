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
package org.kuali.coeus.propdev.impl.copy;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.custom.attr.CustomAttributeDocValue;
import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.common.questionnaire.framework.core.Questionnaire;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentService;
import org.kuali.coeus.propdev.impl.location.ProposalSite;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.s2s.S2sSubmissionService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.proposaldevelopment.rules.ProposalDevelopmentRuleTestBase;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.action.ActionRequest;
import org.kuali.rice.kew.api.action.RoutingReportCriteria;
import org.kuali.rice.kew.api.action.WorkflowDocumentActionsService;
import org.kuali.rice.kew.api.document.DocumentDetail;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProposalWorkflowTest extends ProposalDevelopmentRuleTestBase {
	ProposalCopyService proposalCopyService;
	ProposalDevelopmentDocument proposalDocument;

    String SPONSOR_CODE = "000340";
    String ACTIVITY_TYPE_CODE = "1";
    String PROPOSAL_TYPE_CODE = "1";
    String PRIME_SPONSOR_CODE = "000120";
    String ORIGINAL_LEAD_UNIT = "000001";
    String NEW_LEAD_UNIT = "BL-IIDC";
    public static final String FIRST_NAME = "althea";
    public static final String LAST_NAME = "burd";
    public static final String PERSON_ID = "10000000045";

    private ProposalDevelopmentDocument oldDocument;

    @Before
    @Override
	public void setUp() throws Exception {
        documentService = KRADServiceLocatorWeb.getDocumentService();
        updateParameterForTesting("KC-PD", "Document", "proposaldevelopment.creditsplit.enabled", "N");
        updateParameterForTesting("KC-PD", "Document", "KEY_PERSON_CERTIFICATION_DEFERRAL", "BA");
        Map<String, Object> questionnaireCriteria = new HashMap<>();
        questionnaireCriteria.put("questionnaireSeqId", "1009");
        List<Questionnaire> questionnaire = (List<Questionnaire>) getBusinessObjectService().findMatching(Questionnaire.class, questionnaireCriteria);
        questionnaire.get(0).setActive(Boolean.FALSE);
        getBusinessObjectService().save(questionnaire);
        saveDoc();
    }

    private ProposalDevelopmentDocument createProposal() throws Exception {
		ProposalDevelopmentDocument document = getNewProposalDevelopmentDocument();
		Date requestedStartDateInitial = new Date(System.currentTimeMillis());
		Date requestedEndDateInitial = new Date(System.currentTimeMillis());


		document.getDocumentHeader()
				.setDocumentDescription("Original document");
		document.getDevelopmentProposal().setSponsorCode(SPONSOR_CODE);
		document.getDevelopmentProposal().setTitle("project title");
		document.getDevelopmentProposal().setRequestedStartDateInitial(
                requestedStartDateInitial);
		document.getDevelopmentProposal().setRequestedEndDateInitial(
                requestedEndDateInitial);
		document.getDevelopmentProposal().setActivityTypeCode(ACTIVITY_TYPE_CODE);
		document.getDevelopmentProposal().setProposalTypeCode(PROPOSAL_TYPE_CODE);
		document.getDevelopmentProposal().setOwnedByUnitNumber(ORIGINAL_LEAD_UNIT);
		document.getDevelopmentProposal().setPrimeSponsorCode(PRIME_SPONSOR_CODE);

        getProposalDevelopmentService().initializeUnitOrganizationLocation(document);
        getProposalDevelopmentService().initializeProposalSiteNumbers(document);

        document.getDevelopmentProposal().getProposalYnqs();
        createCustomDocument(document);

        createEmpProposalPerson(document.getDevelopmentProposal(), Constants.PRINCIPAL_INVESTIGATOR_ROLE, FIRST_NAME, LAST_NAME, 1, PERSON_ID);


        return document;
	}

    private void createEmpProposalPerson(DevelopmentProposal developmentProposal, String role, String firstName, String lastName, int proposalPersonNumber, String personId) {
        ProposalPerson person = new ProposalPerson();
        person.setProposalPersonNumber(proposalPersonNumber);
        person.setProposalPersonRoleId(role);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName("middleName");
        setPersonData(person);
        person.setRolodexId(null);
        person.setDevelopmentProposal(developmentProposal);
        developmentProposal.getProposalPersons().add(person);
        person.setPersonId(personId);
    }

    public void setPersonData(ProposalPerson person) {
        person.setOfficePhone("321-321-1228");
        person.setEmailAddress("kcnotification@gmail.com");
        person.setFaxNumber("321-321-1289");
        person.setAddressLine1("addressLine1");
        person.setAddressLine2("addressLine2");
        person.setCity("Coeus");
        person.setPostalCode("53421");
        person.setCounty("UNITED STATES");
        person.setCountryCode("USA");
        person.setState("MA");
        person.setDirectoryTitle("directoryTitle");
        person.setDivision("division");
    }

    protected ProposalPerson getPersonnel() {
        ProposalPerson newProposalPerson = new ProposalPerson();
        newProposalPerson.setPersonId("10000000008");
        newProposalPerson.setFullName("Allyson Cate");
        newProposalPerson.setUserName("cate");
        newProposalPerson.setProposalPersonRoleId("PI");
        return newProposalPerson;
    }

    protected void createCustomDocument(ProposalDevelopmentDocument document) {
        CustomAttributeDocValue newDocValue = new CustomAttributeDocValue();
        newDocValue.setDocumentNumber(document.getDocumentNumber());
        newDocValue.setId(1L);
        newDocValue.setValue("34");
        document.getCustomDataList().add(newDocValue);
        newDocValue = new CustomAttributeDocValue();
        newDocValue.setDocumentNumber(document.getDocumentNumber());
        newDocValue.setId(4L);
        newDocValue.setValue("34");
        document.getCustomDataList().add(newDocValue);
    }

    protected BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }

    protected void setOrg(ProposalDevelopmentDocument document) {

        Unit ownedByUnit = document.getDevelopmentProposal().getOwnedByUnit();
        if (ownedByUnit != null) {
            String unitOrganizationId = ownedByUnit.getOrganizationId();
            for (ProposalSite proposalSite: document.getDevelopmentProposal().getProposalSites()) {
                // set location name to default from Organization
                proposalSite.setOrganizationId(unitOrganizationId);
                proposalSite.refreshReferenceObject("organization");
                proposalSite.setLocationName(proposalSite.getOrganization().getOrganizationName());
                proposalSite.setRolodexId(proposalSite.getOrganization().getContactAddressId());
                proposalSite.refreshReferenceObject("rolodex");
                proposalSite.initializeDefaultCongressionalDistrict();
            }
        }
    }

	@After
    @Override
	public void tearDown() throws Exception {
		proposalDocument = null;
		proposalCopyService = null;
        Map<String, Object> questionnaireCriteria = new HashMap<>();
        questionnaireCriteria.put("questionnaireSeqId", "1009");
        List<Questionnaire> questionnaire = (List<Questionnaire>) getBusinessObjectService().findMatching(Questionnaire.class, questionnaireCriteria);
        questionnaire.get(0).setActive(Boolean.TRUE);
        getBusinessObjectService().save(questionnaire);
        saveDoc();
	}

    protected void saveDoc() throws Exception {
        oldDocument = (ProposalDevelopmentDocument) getDocumentService().saveDocument(createProposal());
        getDocumentService().saveDocument(oldDocument);
    }

	@Test
	public void testWorkflow() throws Exception {
        oldDocument = (ProposalDevelopmentDocument) getDocumentService().saveDocument(oldDocument);
        ProposalCopyCriteria criteria = new ProposalCopyCriteria();
        criteria.setLeadUnitNumber(ORIGINAL_LEAD_UNIT);
        ProposalDevelopmentDocument copiedDocument = getProposalCopyService().copyProposal(oldDocument, criteria);

        RoutingReportCriteria.Builder reportCriteriaBuilder = RoutingReportCriteria.Builder.createByDocumentId(copiedDocument.getDocumentHeader().getWorkflowDocument().getDocumentId());
        DocumentDetail results1 = getWorkflowDocumentActionsService().executeSimulation(reportCriteriaBuilder.build());
        Assert.assertTrue(results1.getActionRequests().size() == 5);


        List<ActionRequest> peopleFlowRequests = results1.getActionRequests().stream().filter(actionRequest ->
                actionRequest.getNodeName().equalsIgnoreCase("PeopleFlows") &&
                actionRequest.getActionRequested().getCode().equalsIgnoreCase("A") &&
                actionRequest.getStatus().getCode().equals(KewApiConstants.ActionRequestStatusVals.INITIALIZED)).collect(Collectors.toList());

        Assert.assertTrue(peopleFlowRequests.size() == 3);

        List<ActionRequest>  ospOffice = results1.getActionRequests().stream().filter(actionRequest ->
                actionRequest.getNodeName().equalsIgnoreCase("OSPOfficeRouting") &&
                        actionRequest.getActionRequested().getCode().equalsIgnoreCase("A") &&
                        actionRequest.getStatus().getCode().equals(KewApiConstants.ActionRequestStatusVals.INITIALIZED)).collect(Collectors.toList());
        Assert.assertTrue(ospOffice.size() == 1);

    }

    public WorkflowDocumentActionsService getWorkflowDocumentActionsService() {
        return KcServiceLocator.getService(WorkflowDocumentActionsService.class);
    }

    protected Organization getOrgForUnit(String unitNumber) {
       UnitService unitService = KcServiceLocator.getService(UnitService.class);
       Unit unit = unitService.getUnit(unitNumber);
       return unit.getOrganization();
    }


    protected DocumentService getDocumentService() {
        return KcServiceLocator.getService(DocumentService.class);
    }

    protected ProposalCopyService getProposalCopyService() {
        return KcServiceLocator.getService(ProposalCopyService.class);
    }

    protected ProposalDevelopmentService getProposalDevelopmentService() {
        return KcServiceLocator.getService(ProposalDevelopmentService.class);
    }

    protected DataObjectService getDataObjectService() {
        return KcServiceLocator.getService(DataObjectService.class);
    }


    public S2sSubmissionService getS2sSubmissionService() {
        return KcServiceLocator.getService(S2sSubmissionService.class);
    }
}
