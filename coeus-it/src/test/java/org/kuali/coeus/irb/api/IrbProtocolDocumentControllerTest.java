/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.irb.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.irb.api.dto.IrbProtocolActionDto;
import org.kuali.coeus.irb.api.dto.IrbProtocolDto;
import org.kuali.coeus.irb.api.dto.IrbProtocolSubmissionDto;
import org.kuali.coeus.sys.framework.rest.UnauthorizedAccessException;
import org.kuali.coeus.sys.framework.rest.UnprocessableEntityException;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.FeatureFlagConstants;
import org.kuali.kra.irb.actions.ProtocolStatus;
import org.kuali.kra.irb.actions.submit.ProtocolReviewType;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionType;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

public class IrbProtocolDocumentControllerTest extends KcIntegrationTestBase {

    @Before
    public void setUp() throws Exception {
        updateParameterForTesting(Constants.MODULE_NAMESPACE_GEN, ParameterConstants.DOCUMENT_COMPONENT,
                FeatureFlagConstants.ENABLE_API_AUTHORIZATION, "true");
    }

    public void useAuthorizedUser() {
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap<>());
        final UserSession userSession = new UserSession("admin");
        userSession.setKualiSessionId(UUID.randomUUID().toString());
        GlobalVariables.setUserSession(userSession);

    }

    public void useUnauthorizedUser() {
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap<>());
        final UserSession userSession = new UserSession("quickstart");
        userSession.setKualiSessionId(UUID.randomUUID().toString());
        GlobalVariables.setUserSession(userSession);

    }

    @Test
    public void testProtocolExpeditedLifecycleGoodJson() throws Exception {
        useAuthorizedUser();
        // POST
        IrbProtocolDto irbProtocolDto = createProtocol();
        ObjectMapper mapper;

        // GET
        IrbProtocolDto protocolRetrieved = getDocumentController().getProtocol(Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(protocolRetrieved.getTitle().equalsIgnoreCase("protocol1"));
        Assert.assertTrue(protocolRetrieved.getReferenceNumber1().equalsIgnoreCase("HR-2775"));
        Assert.assertTrue(protocolRetrieved.getProtocolTypeCode().equalsIgnoreCase("2"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().size() == 3);
        Assert.assertTrue(protocolRetrieved.getDocNbr() != null);
        Assert.assertTrue(protocolRetrieved.getDocNbr() != "1756575F");
        Assert.assertTrue(protocolRetrieved.getLeadUnitNumber().equalsIgnoreCase("000001"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getPersonId().equalsIgnoreCase("10000000018"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.PI_CODE));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getAffiliationTypeCode().toString().equalsIgnoreCase("1"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getPersonId() == null);
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getRolodexId().toString().equalsIgnoreCase("186"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.COI_CODE));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getAffiliationTypeCode().toString().equalsIgnoreCase("5"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(2).getPersonId().equalsIgnoreCase("10000000030"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(2).getProtocolPersonRoleId().equalsIgnoreCase("SP"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(2).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));

        // Action - SUBMIT EXPEDITED
        String actionString = getExpeditedActionJson();
        mapper = new ObjectMapper();
        IrbProtocolActionDto actionDto = mapper.readValue(actionString, IrbProtocolActionDto.class);
        IrbProtocolSubmissionDto submissionDto = getDocumentController().takeAction(actionDto, Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(submissionDto.getSubmissionStatusCode().equalsIgnoreCase(ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE));
        Assert.assertTrue(submissionDto.getProtocolReviewTypeCode().equalsIgnoreCase(ProtocolReviewType.EXPEDITED_REVIEW_TYPE_CODE));
        Assert.assertTrue(submissionDto.getSubmissionTypeCode().equalsIgnoreCase(ProtocolSubmissionType.INITIAL_SUBMISSION));
        Calendar cal = Calendar.getInstance();
        Assert.assertTrue(submissionDto.getSubmissionDate().compareTo(getDate(2011, cal.SEPTEMBER, 30)) == 0);
        Assert.assertTrue(submissionDto.getCommitteeId().equalsIgnoreCase("KC001"));


        IrbProtocolActionDto approveActionDto = mapper.readValue(getApprovalJson(), IrbProtocolActionDto.class);
        submissionDto = getDocumentController().takeAction(approveActionDto, Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(submissionDto.getCommitteeId().equalsIgnoreCase("KC001"));
        Assert.assertTrue(submissionDto.getSubmissionStatusCode().equalsIgnoreCase(ProtocolSubmissionStatus.APPROVED));
        Assert.assertTrue(submissionDto.getProtocolReviewTypeCode().equalsIgnoreCase(ProtocolReviewType.EXPEDITED_REVIEW_TYPE_CODE));

    }

    @Test
    public void deleteProtocolTest() throws IllegalAccessException, WorkflowException, IntrospectionException, IOException {
        useAuthorizedUser();
        // POST
        IrbProtocolDto irbProtocolDto = createProtocol();

        // DELETE
        getDocumentController().deleteProtocol(Long.parseLong(irbProtocolDto.getDocNbr()));
        IrbProtocolDto deletedProtocol = getDocumentController().getProtocol(Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(deletedProtocol.getStatus().equalsIgnoreCase(ProtocolStatus.DELETED));

        // GET
        IrbProtocolDto protocolRetrieved = getDocumentController().getProtocol(Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(protocolRetrieved.getStatus().equalsIgnoreCase(ProtocolStatus.DELETED));
    }

    @Test
    public void testProtocolExemptLifecycleGoodJson() throws Exception {
        useAuthorizedUser();
        // POST
        IrbProtocolDto irbProtocolDto = createProtocol();

        // GET
        IrbProtocolDto protocolRetrieved = getDocumentController().getProtocol(Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(protocolRetrieved.getTitle().equalsIgnoreCase("protocol1"));
        Assert.assertTrue(protocolRetrieved.getReferenceNumber1().equalsIgnoreCase("HR-2775"));
        Assert.assertTrue(protocolRetrieved.getProtocolTypeCode().equalsIgnoreCase("2"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().size() == 3);
        Assert.assertTrue(protocolRetrieved.getDocNbr() != null);
        Assert.assertTrue(protocolRetrieved.getDocNbr() != "1756575F");
        Assert.assertTrue(protocolRetrieved.getLeadUnitNumber().equalsIgnoreCase("000001"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getPersonId().equalsIgnoreCase("10000000018"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.PI_CODE));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getAffiliationTypeCode().toString().equalsIgnoreCase("1"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getPersonId() == null);
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getRolodexId().toString().equalsIgnoreCase("186"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.COI_CODE));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getAffiliationTypeCode().toString().equalsIgnoreCase("5"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(2).getPersonId().equalsIgnoreCase("10000000030"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(2).getProtocolPersonRoleId().equalsIgnoreCase("SP"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(2).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));

        // Action - SUBMIT EXEMPT
        String actionString = getExemptActionJson();
        ObjectMapper mapper = new ObjectMapper();
        IrbProtocolActionDto actionDto = mapper.readValue(actionString, IrbProtocolActionDto.class);
        IrbProtocolSubmissionDto submissionDto = getDocumentController().takeAction(actionDto, Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(submissionDto.getSubmissionStatusCode().equalsIgnoreCase(ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE));
        Assert.assertTrue(submissionDto.getProtocolReviewTypeCode().equalsIgnoreCase(ProtocolReviewType.EXEMPT_STUDIES_REVIEW_TYPE_CODE));
        Assert.assertTrue(submissionDto.getSubmissionTypeCode().equalsIgnoreCase(ProtocolSubmissionType.INITIAL_SUBMISSION));
        Calendar cal = Calendar.getInstance();
        Assert.assertTrue(submissionDto.getSubmissionDate().compareTo(getDate(2011, cal.SEPTEMBER, 30)) == 0);
        Assert.assertTrue(submissionDto.getCommitteeId().equalsIgnoreCase("KC001"));

        // Approve
        IrbProtocolActionDto approveActionDto = mapper.readValue(getApprovalJson(), IrbProtocolActionDto.class);
        submissionDto = getDocumentController().takeAction(approveActionDto, Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(submissionDto.getCommitteeId().equalsIgnoreCase("KC001"));
        Assert.assertTrue(submissionDto.getSubmissionStatusCode().equalsIgnoreCase(ProtocolSubmissionStatus.APPROVED));
        Assert.assertTrue(submissionDto.getProtocolReviewTypeCode().equalsIgnoreCase(ProtocolReviewType.EXEMPT_STUDIES_REVIEW_TYPE_CODE));
    }

    @Test(expected = UnprocessableEntityException.class)
    public void testProtocolAuditErrors() throws Exception {
        useAuthorizedUser();
        // POST
        IrbProtocolDto irbProtocolDto = createBadProtocol();

        // GET
        IrbProtocolDto protocolRetrieved = getDocumentController().getProtocol(Long.parseLong(irbProtocolDto.getDocNbr()));
        Assert.assertTrue(protocolRetrieved.getTitle().equalsIgnoreCase("protocol1"));
        Assert.assertTrue(protocolRetrieved.getReferenceNumber1().equalsIgnoreCase("HR-2775"));
        Assert.assertTrue(protocolRetrieved.getProtocolTypeCode().equalsIgnoreCase("2"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().size() == 2);
        Assert.assertTrue(protocolRetrieved.getDocNbr() != null);
        Assert.assertTrue(protocolRetrieved.getDocNbr() != "1756575F");
        Assert.assertTrue(protocolRetrieved.getLeadUnitNumber().equalsIgnoreCase("000001"));

        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getPersonId().equalsIgnoreCase("10000000018"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.PI_CODE));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(0).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));


        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getPersonId().equalsIgnoreCase("10000000030"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getProtocolPersonRoleId().equalsIgnoreCase("SP"));
        Assert.assertTrue(protocolRetrieved.getProtocolPersons().get(1).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));

        // Action - SUBMIT EXEMPT
        String actionString = getExemptActionJson();
        ObjectMapper mapper = new ObjectMapper();
        IrbProtocolActionDto actionDto = mapper.readValue(actionString, IrbProtocolActionDto.class);
        IrbProtocolSubmissionDto submissionDto = getDocumentController().takeAction(actionDto, Long.parseLong(irbProtocolDto.getDocNbr()));
    }

    public ConfigurationService getConfigurationService() {
        return KcServiceLocator.getService(ConfigurationService.class);
    }

    public IrbProtocolDto createBadProtocol() throws IOException, WorkflowException, IllegalAccessException, IntrospectionException {
        useAuthorizedUser();
        String jsonInString = getJsonWithPersonIssues();
        ObjectMapper mapper = new ObjectMapper();

        IrbProtocolDto irbDto = mapper.readValue(jsonInString, IrbProtocolDto.class);

        IrbProtocolDto irbProtocolDto = getDocumentController().createProtocol(irbDto);
        Assert.assertTrue(irbProtocolDto.getTitle().equalsIgnoreCase("protocol1"));
        Assert.assertTrue(irbProtocolDto.getReferenceNumber1().equalsIgnoreCase("HR-2775"));
        Assert.assertTrue(irbProtocolDto.getProtocolTypeCode().equalsIgnoreCase("2"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().size() == 2);
        Assert.assertTrue(irbProtocolDto.getDocNbr() != null);
        Assert.assertTrue(irbProtocolDto.getDocNbr() != "1756575F");
        Assert.assertTrue(irbProtocolDto.getLeadUnitNumber().equalsIgnoreCase("000001"));
        Assert.assertTrue(irbProtocolDto.getSummary().equalsIgnoreCase("HOORAY"));

        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(0).getPersonId().equalsIgnoreCase("10000000018"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(0).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.PI_CODE));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(0).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));

        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getPersonId().equalsIgnoreCase("10000000030"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getProtocolPersonRoleId().equalsIgnoreCase("SP"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));
        return irbProtocolDto;
    }

    public IrbProtocolDto createProtocol() throws IOException, WorkflowException, IllegalAccessException, IntrospectionException {
        useAuthorizedUser();
        String jsonInString = getCorrectJson();
        ObjectMapper mapper = new ObjectMapper();

        IrbProtocolDto irbDto = mapper.readValue(jsonInString, IrbProtocolDto.class);
        IrbProtocolDto irbProtocolDto = getDocumentController().createProtocol(irbDto);
        Assert.assertTrue(irbProtocolDto.getTitle().equalsIgnoreCase("protocol1"));
        Assert.assertTrue(irbProtocolDto.getReferenceNumber1().equalsIgnoreCase("HR-2775"));
        Assert.assertTrue(irbProtocolDto.getProtocolTypeCode().equalsIgnoreCase("2"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().size() == 3);
        Assert.assertTrue(irbProtocolDto.getDocNbr() != null);
        Assert.assertTrue(irbProtocolDto.getDocNbr() != "1756575F");
        Assert.assertTrue(irbProtocolDto.getLeadUnitNumber().equalsIgnoreCase("000001"));
        Assert.assertTrue(irbProtocolDto.getSummary().equalsIgnoreCase("HOORAY"));

        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(0).getPersonId().equalsIgnoreCase("10000000018"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(0).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.PI_CODE));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(0).getAffiliationTypeCode().toString().equalsIgnoreCase("1"));

        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getPersonId() == null);
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getRolodexId().toString().equalsIgnoreCase("186"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getProtocolPersonRoleId().equalsIgnoreCase(ContactRole.COI_CODE));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(1).getAffiliationTypeCode().toString().equalsIgnoreCase("5"));

        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(2).getPersonId().equalsIgnoreCase("10000000030"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(2).getProtocolPersonRoleId().equalsIgnoreCase("SP"));
        Assert.assertTrue(irbProtocolDto.getProtocolPersons().get(2).getAffiliationTypeCode().toString().equalsIgnoreCase("4"));

        return irbProtocolDto;
    }


    @Test(expected = UnauthorizedAccessException.class)
    public void testCreateProtocolUnauthorizedUser() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().createProtocol(null);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testDeleteProtocolUnauthorizedUser() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().deleteProtocol(null);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testGetProtocolUnauthorizedUser() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().getProtocol(null);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testTakeActionUnauthorizedUser() throws Exception {
        useUnauthorizedUser();
        getDocumentController().takeAction(null, 123L);
    }

    public String getApprovalJson() {
        String approvalJson = "{\n" +
                "    \"actionCode\":\"205\",\n" +
                "    \"approvalDate\":\"6/1/2008\",\n" +
                "    \"actionDate\":\"5/12/2016\"\n" +
                "}";
        return approvalJson;
    }

    public String getExemptActionJson() {
        String actionJson = "{\n" +
                "    \"actionCode\":\"101\",\n" +
                "    \"actionDate\":\"9/30/2011\",\n" +
                "    \"protocolReviewTypeCode\":\"3\",\n" +
                "    \"submissionTypeCode\":\"100\",\n" +
                "    \"initialSubmissionDate\":\"9/30/2011\",\n" +
                "    \"committeeId\":\"KC001\",\n" +
                "    \"reviewers\": [\n" +
                "        {\n" +
                "            \"personId\":\"10000000007\",\n" +
                "            \"reviewerTypeCode\":\"1\"\n" +
                "        }\n" +
                "        ]\n" +
                "}";
        return actionJson;
    }

    public String getExpeditedActionJson() {
        String actionJson = "{\n" +
                "    \"actionCode\":\"101\",\n" +
                "    \"actionDate\":\"9/30/2011\",\n" +
                "    \"protocolReviewTypeCode\":\"2\",\n" +
                "    \"submissionTypeCode\":\"100\",\n" +
                "    \"initialSubmissionDate\":\"9/30/2011\",\n" +
                "    \"committeeId\":\"KC001\",\n" +
                "    \"reviewers\": [\n" +
                "        {\n" +
                "            \"personId\":\"10000000007\",\n" +
                "            \"reviewerTypeCode\":\"1\"\n" +
                "        }\n" +
                "        ]\n" +
                "}";
        return actionJson;
    }

    public String getCorrectJson() {
        String jsonString = "{\n" +
                "    \"title\":\"protocol1\",\n" +
                "    \"referenceNumber1\":\"HR-2775\",\n" +
                "    \"summary\":\"HOORAY\",\n" +
                "    \"protocolTypeCode\":\"2\",\n" +
                "    \"docNbr\":\"1756575F\",\n" +
                "    \"protocolPersons\": [\n" +
                "         {\n" +
                "        \"personId\" : \"10000000018\",\n" +
                "        \"protocolPersonRoleId\": \"PI\",\n" +
                "        \"affiliationTypeCode\":\"1\"\n" +
                "         },\n" +
                "         {\n" +
                "        \"rolodexId\" : \"186\",\n" +
                "        \"protocolPersonRoleId\": \"COI\",\n" +
                "        \"affiliationTypeCode\":\"5\"\n" +
                "         },\n" +
                "         {\n" +
                "        \"personId\" : \"10000000030\",\n" +
                "        \"protocolPersonRoleId\": \"SP\",\n" +
                "        \"affiliationTypeCode\":\"4\"\n" +
                "         }\n" +
                "    ]\n" +
                "}";
        return jsonString;
    }

    public String getJsonWithPersonIssues() {
        String jsonString = "{\n" +
                "    \"title\":\"protocol1\",\n" +
                "    \"referenceNumber1\":\"HR-2775\",\n" +
                "    \"summary\":\"HOORAY\",\n" +
                "    \"protocolTypeCode\":\"2\",\n" +
                "    \"docNbr\":\"1756575F\",\n" +
                "    \"protocolPersons\": [\n" +
                "         {\n" +
                "        \"personId\" : \"10000000018\",\n" +
                "        \"protocolPersonRoleId\": \"PI\",\n" +
                "        \"affiliationTypeCode\":\"4\"\n" +
                "         },\n" +
                "         {\n" +
                "        \"personId\" : \"10000000030\",\n" +
                "        \"protocolPersonRoleId\": \"SP\",\n" +
                "        \"affiliationTypeCode\":\"4\"\n" +
                "         }\n" +
                "    ]\n" +
                "}";
        return jsonString;
    }

    public IrbProtocolDocumentController getDocumentController() throws IntrospectionException {
        IrbProtocolDocumentController controller = KcServiceLocator.getService(IrbProtocolDocumentController.class);
        return controller;
    }

    public Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set( cal.YEAR, year );
        cal.set( cal.MONTH, month);
        cal.set( cal.DATE, day);

        cal.set( cal.HOUR_OF_DAY, 0 );
        cal.set( cal.MINUTE, 0 );
        cal.set( cal.SECOND, 0 );
        cal.set( cal.MILLISECOND, 0 );

        return new java.sql.Date( cal.getTime().getTime() );
    }

}
