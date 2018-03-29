/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.instprop.impl.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.instprop.impl.api.dto.InstitutionalProposalDto;
import org.kuali.coeus.instprop.impl.api.dto.IpPersonDto;
import org.kuali.coeus.instprop.impl.api.service.InstitutionalProposalApiService;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLogger;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerDao;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerFactory;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.UnauthorizedAccessException;
import org.kuali.coeus.sys.framework.rest.UnprocessableEntityException;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.impl.controller.rest.audit.RestAuditLoggerFactoryImpl;
import org.kuali.coeus.sys.impl.controller.rest.audit.RestAuditLoggerImpl;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.FeatureFlagConstants;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.routeheader.service.RouteHeaderService;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class InstitutionalProposalDocumentControllerTest extends KcIntegrationTestBase{

    @Before
    public void setUp() throws Exception {
        updateParameterForTesting(Constants.MODULE_NAMESPACE_SYSTEM, ParameterConstants.DOCUMENT_COMPONENT,
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
    public void testCreateProposalGoodJson() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        // POST
        String jsonInString = getCorrectJson();
        ObjectMapper mapper = new ObjectMapper();

        InstitutionalProposalDto ipDto = mapper.readValue(jsonInString, InstitutionalProposalDto.class);
        String documentId = getDocumentController().createInstitutionalProposal(ipDto, true);
        InstitutionalProposalDocument document = (InstitutionalProposalDocument) getDocumentController().getCommonApiService().getDocumentFromDocId(Long.parseLong(documentId));
        final InstitutionalProposal institutionalProposal = document.getInstitutionalProposal();
        Assert.assertTrue(institutionalProposal.getProjectPersons().size() == 2);
        Assert.assertTrue(institutionalProposal.getProjectPersons().get(0).isPrincipalInvestigator());
        Assert.assertTrue(institutionalProposal.getProjectPersons().get(1).isCoInvestigator());
        Assert.assertTrue(institutionalProposal.getProjectPersons().get(0).getRolodexId() == 186);
        Assert.assertTrue(institutionalProposal.getProjectPersons().get(1).getRolodexId() == 180);
        Assert.assertTrue(institutionalProposal.getCustomDataList().size() == 2);
        Assert.assertTrue(institutionalProposal.getCustomDataList().get(0).getCustomAttributeId() == 1);
        Assert.assertTrue(institutionalProposal.getCustomDataList().get(1).getCustomAttributeId() == 2);
        Assert.assertTrue(institutionalProposal.getProposalNumber() != null);
        Calendar cal = Calendar.getInstance();
        Assert.assertTrue(institutionalProposal.getRequestedStartDateInitial().compareTo(getDate(2008, cal.JUNE, 1)) == 0);
        Assert.assertTrue(institutionalProposal.getRequestedStartDateTotal().compareTo(getDate(2008, cal.JUNE, 1)) == 0);
        Assert.assertTrue(institutionalProposal.getRequestedEndDateInitial().compareTo(getDate(2009, cal.MAY, 31)) == 0);
        Assert.assertTrue(institutionalProposal.getRequestedEndDateTotal().compareTo(getDate(2009, cal.MAY, 31)) == 0);
        Assert.assertTrue(institutionalProposal.getCreateTimestamp().compareTo(getDate(2008, cal.MARCH, 11)) == 0);

        // GET
        InstitutionalProposalDto ipFetched = getDocumentController().getInstitutionalProposal(Long.parseLong(documentId));
        Assert.assertTrue(ipFetched.getProjectPersons().size() == 2);
        Assert.assertTrue(ipFetched.getProjectPersons().get(0).getRoleCode() == ContactRole.PI_CODE);
        Assert.assertTrue(ipFetched.getProjectPersons().get(0).getRolodexId() == 186);
        Assert.assertTrue(ipFetched.getProjectPersons().get(1).getRolodexId() == 180);
        Assert.assertTrue(ipFetched.getInstitutionalProposalCustomDataList().size() == 2);
        Assert.assertTrue(ipFetched.getInstitutionalProposalCustomDataList().get(0).getCustomAttributeId() == 1);
        Assert.assertTrue(ipFetched.getInstitutionalProposalCustomDataList().get(1).getCustomAttributeId() == 2);
        Assert.assertTrue(ipFetched.getProposalNumber() != null);
        Assert.assertTrue(ipFetched.getDocStatus().equalsIgnoreCase("SAVED"));

        // ROUTE
        try {
            getDocumentController().routeDocument(Long.parseLong(documentId));
        }
        catch(Exception e) {
            //Graduate student count
            Assert.assertTrue(UnprocessableEntityException.class.isAssignableFrom(e.getClass()));
        }

        // DELETE
        getDocumentController().deleteInstitutionalProposal(Long.parseLong(documentId));
        InstitutionalProposalDto deletedIpDto = getDocumentController().getInstitutionalProposal(Long.parseLong(documentId));
        Assert.assertTrue(deletedIpDto.getDocStatus().equalsIgnoreCase("CANCELED"));

    }

    @Test
    public void testCreateProposalPersonsEndpoint() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        String jsonInString = getCorrectJson();
        ObjectMapper mapper = new ObjectMapper();
        InstitutionalProposalDto ipDto = mapper.readValue(jsonInString, InstitutionalProposalDto.class);

        ipDto.setProjectPersons(null);
        ipDto.setInstitutionalProposalCustomDataList(null);
        String documentId = getDocumentController().createInstitutionalProposal(ipDto, true);
        InstitutionalProposalDocument document = (InstitutionalProposalDocument) getDocumentController().getCommonApiService().getDocumentFromDocId(Long.parseLong(documentId));
        final InstitutionalProposal institutionalProposal = document.getInstitutionalProposal();
        Assert.assertTrue(institutionalProposal.getProjectPersons().size() == 0);
        Assert.assertTrue(institutionalProposal.getCustomDataList().size() == 0);
        Assert.assertTrue(institutionalProposal.getProposalNumber() != null);
        Calendar cal = Calendar.getInstance();
        Assert.assertTrue(institutionalProposal.getRequestedStartDateInitial().compareTo(getDate(2008, cal.JUNE, 1)) == 0);
        Assert.assertTrue(institutionalProposal.getRequestedStartDateTotal().compareTo(getDate(2008, cal.JUNE, 1)) == 0);
        Assert.assertTrue(institutionalProposal.getRequestedEndDateInitial().compareTo(getDate(2009, cal.MAY, 31)) == 0);
        Assert.assertTrue(institutionalProposal.getRequestedEndDateTotal().compareTo(getDate(2009, cal.MAY, 31)) == 0);
        Assert.assertTrue(institutionalProposal.getCreateTimestamp().compareTo(getDate(2008, cal.MARCH, 11)) == 0);

        // POST
        String personJson = getGoodPersonsJson();
        ObjectMapper personMapper = new ObjectMapper();
        List<IpPersonDto> persons = personMapper.readValue(personJson, personMapper.getTypeFactory().constructCollectionType(List.class, IpPersonDto.class) );
        getDocumentController().addProposalPersons(persons, Long.parseLong(documentId));

        //GET
        List<IpPersonDto> personsDto = getDocumentController().getAllProposalPersons(Long.parseLong(documentId));
        Assert.assertTrue(personsDto.size() == 2);
        Assert.assertTrue(personsDto.get(0).getRoleCode().equalsIgnoreCase(ContactRole.PI_CODE));
        Assert.assertTrue(personsDto.get(0).getRolodexId().toString().equalsIgnoreCase("186"));
        Assert.assertTrue(personsDto.get(1).getRoleCode().equalsIgnoreCase(ContactRole.COI_CODE));
        Assert.assertTrue(personsDto.get(1).getRolodexId().toString().equalsIgnoreCase("180"));

        Long personId = personsDto.get(1).getInstitutionalProposalContactId();
        getDocumentController().deleteProposalPerson(Long.parseLong(documentId), personId);
        personsDto = getDocumentController().getAllProposalPersons(Long.parseLong(documentId));

        Assert.assertTrue(personsDto.size() == 1);

    }

    @Test(expected = ResourceNotFoundException.class)
    public void deleteInstitutionalProposal() throws IntrospectionException, WorkflowException {
        useAuthorizedUser();
        getDocumentController().deleteInstitutionalProposal(11L);
    }

    @Test(expected = UnprocessableEntityException.class)
    public void testCreateProposalMissingData() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        String jsonInString = getBadJson();
        ObjectMapper mapper = new ObjectMapper();

        InstitutionalProposalDto ipDto = mapper.readValue(jsonInString, InstitutionalProposalDto.class);
        getDocumentController().createInstitutionalProposal(ipDto, true);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void testCreateProposalUnauthorizedUser() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().createInstitutionalProposal(null, true);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void deleteInstitutionalProposalUnauthorizedUser() throws IntrospectionException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().deleteInstitutionalProposal(1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void getInstitutionalProposalUnauthorizedUser() throws IntrospectionException {
        useUnauthorizedUser();
        getDocumentController().getInstitutionalProposal(1L);

    }

    @Test(expected = UnauthorizedAccessException.class)
    public void addProposalPersonsUnauthorizedUser() throws IntrospectionException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().addProposalPersons(null, 1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void getAllProposalPersonsUnauthorizedUser() throws IntrospectionException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().getAllProposalPersons(1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void deleteProposalPersonUnauthorizedUser() throws IntrospectionException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().deleteProposalPerson(1L, 1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void getProposalPersonUnauthorizedUser() throws IntrospectionException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().deleteProposalPerson(1L, 1L);
    }

    @Test(expected = UnauthorizedAccessException.class)
    public void routeDocumentUnauthorizedUser() throws IntrospectionException, WorkflowException {
        useUnauthorizedUser();
        getDocumentController().routeDocument(1L);
    }


    public String getGoodPersonsJson() {
        return "      [\n" +
                "         {\n" +
                "            \"rolodexId\":\"186\",\n" +
                "            \"roleCode\":\"PI\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"rolodexId\":\"180\",\n" +
                "            \"roleCode\":\"COI\"\n" +
                "         }\n" +
                "      ]\n";
    }

    public String getBadJson() {
        return "{\n" +
                "      \"primeSponsorCode\":null,\n" +
                "      \"createTimestamp\":\"3/11/2008\",\n" +
                "      \"unitNumber\":\"000001\",\n" +
                "      \"title\":\"Characterizing Sensorimotor Control and Its Deficits in Persons with MS\",\n" +
                "      \"documentDescription\":\"Characterizing Sensorimotor Control and Its Deficits in Persons with MS\",\n" +
                "      \"sponsorCode\":\"001067\",\n" +
                "      \"activityTypeCode\":\"1\",\n" +
                "      \"requestedStartDateInitial\":\"6/1/2008\",\n" +
                "      \"requestedStartDateTotal\":\"6/1/2008\",\n" +
                "      \"requestedEndDateInitial\":\"5/31/2009\",\n" +
                "      \"requestedEndDateTotal\":\"5/31/2009\",\n" +
                "      \"totalDirectCostInitial\":\"40000\",\n" +
                "      \"totalDirectCostTotal\":\"40000\",\n" +
                "      \"totalIndirectCostInitial\":\"4000\",\n" +
                "      \"totalIndirectCostTotal\":\"4000\",\n" +
                "      \"statusCode\":\"5\",\n" +
                "      \"persons\":[\n" +
                "         {\n" +
                "            \"rolodexId\":\"186\",\n" +
                "            \"roleCode\":\"PI\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"rolodexId\":\"180\",\n" +
                "            \"roleCode\":\"COI\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"customData\":[\n" +
                "         {\n" +
                "            \"customAttributeId\":\"1\",\n" +
                "            \"value\":\"0\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"customAttributeId\":\"2\",\n" +
                "            \"value\":\"0\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"ipReviewActivityIndicator\":\"A\"\n" +
                "   }";
    }

    public String getCorrectJson() {
        return "{\n" +
                "      \"primeSponsorCode\":null,\n" +
                "      \"proposalTypeCode\":\"1\",\n" +
                "      \"createTimestamp\":\"3/11/2008\",\n" +
                "      \"unitNumber\":\"000001\",\n" +
                "      \"title\":\"Characterizing Sensorimotor Control and Its Deficits in Persons with MS\",\n" +
                "      \"documentDescription\":\"Characterizing Sensorimotor Control and Its Deficits in Persons with MS\",\n" +
                "      \"sponsorCode\":\"001067\",\n" +
                "      \"activityTypeCode\":\"1\",\n" +
                "      \"requestedStartDateInitial\":\"6/1/2008\",\n" +
                "      \"requestedStartDateTotal\":\"6/1/2008\",\n" +
                "      \"requestedEndDateInitial\":\"5/31/2009\",\n" +
                "      \"requestedEndDateTotal\":\"5/31/2009\",\n" +
                "      \"totalDirectCostInitial\":\"40000\",\n" +
                "      \"totalDirectCostTotal\":\"40000\",\n" +
                "      \"totalIndirectCostInitial\":\"4000\",\n" +
                "      \"totalIndirectCostTotal\":\"4000\",\n" +
                "      \"statusCode\":\"5\",\n" +
                "      \"persons\":[\n" +
                "         {\n" +
                "            \"rolodexId\":\"186\",\n" +
                "            \"roleCode\":\"PI\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"rolodexId\":\"180\",\n" +
                "            \"roleCode\":\"COI\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"customData\":[\n" +
                "         {\n" +
                "            \"customAttributeId\":\"1\",\n" +
                "            \"value\":\"0\"\n" +
                "         },\n" +
                "         {\n" +
                "            \"customAttributeId\":\"2\",\n" +
                "            \"value\":\"0\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"ipReviewActivityIndicator\":\"A\"\n" +
                "   }";
    }

    public InstitutionalProposalDocumentController getDocumentController() throws IntrospectionException {
        InstitutionalProposalDocumentController ipDocumentController = new InstitutionalProposalDocumentController() {

            @Override
            public RestAuditLoggerFactory getRestAuditLoggerFactory() {
                return new RestAuditLoggerTest();
            }

            @Override
            public RouteHeaderService getRouteHeaderService() {
                return KcServiceLocator.getService(RouteHeaderService.class);
            }

            @Override
            public InstitutionalProposalApiService getInstitutionalProposalApiService() {
                return KcServiceLocator.getService(InstitutionalProposalApiService.class);
            }

            @Override
            public CommonApiService getCommonApiService() {
                return KcServiceLocator.getService(CommonApiService.class);
            }

            public PermissionService getPermissionService() {
                return KcServiceLocator.getService(PermissionService.class);
            }

            public GlobalVariableService getGlobalVariableService() {
                return KcServiceLocator.getService(GlobalVariableService.class);
            }

            public boolean isApiAuthEnabled() {
                return true;
            }

            @Override
            public DocumentService getDocumentService() {
                return KcServiceLocator.getService(DocumentService.class);
            }

        };
        return ipDocumentController;
    }

    class RestAuditLoggerTest extends RestAuditLoggerFactoryImpl {
        @Override
        public RestAuditLogger getNewAuditLogger(Class<?> dataObjectClass, List<String> propertiesToLog) {
            return new RestAuditLoggerImplTest("admin",
                    dataObjectClass, propertiesToLog, null);
        }
    }

    public class RestAuditLoggerImplTest extends RestAuditLoggerImpl {
        public RestAuditLoggerImplTest(String username, Class<?> dataObjectClass, List<String> propertiesToTrack,
                                       RestAuditLoggerDao restAuditLoggerDao) {
            super(username, dataObjectClass, propertiesToTrack, restAuditLoggerDao, null);
        }

        @Override
        public void addModifiedItem(Object currentItem, Object updatedItem) {
        }

        @Override
        public void saveAuditLog() {}

        @Override
        public void addNewItem(Object newItem) {}

        @Override
        public void addDeletedItem(Object deletedItem) {}

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
