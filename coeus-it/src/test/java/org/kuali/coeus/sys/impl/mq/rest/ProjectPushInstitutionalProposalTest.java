/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.mq.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.coi.framework.Project;
import org.kuali.coeus.coi.framework.ProjectRetrievalService;
import org.kuali.coeus.common.api.document.service.CommonApiService;
import org.kuali.coeus.instprop.impl.api.InstitutionalProposalDocumentController;
import org.kuali.coeus.instprop.impl.api.dto.InstitutionalProposalDto;
import org.kuali.coeus.instprop.impl.api.service.InstitutionalProposalApiService;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLogger;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerDao;
import org.kuali.coeus.sys.framework.controller.rest.audit.RestAuditLoggerFactory;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.impl.controller.rest.audit.RestAuditLoggerFactoryImpl;
import org.kuali.coeus.sys.impl.controller.rest.audit.RestAuditLoggerImpl;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.routeheader.service.RouteHeaderService;
import org.kuali.rice.kim.api.permission.PermissionService;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import javax.jms.ObjectMessage;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ProjectPushInstitutionalProposalTest extends ProjectPushTestBase {

    public void useAuthorizedUser() {
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap<>());
        final UserSession userSession = new UserSession("admin");
        userSession.setKualiSessionId(UUID.randomUUID().toString());
        GlobalVariables.setUserSession(userSession);

    }

    public static final String INST_PROP_PROJECT_RETRIEVAL_SERVICE = "instPropProjectRetrievalService";
    InstitutionalProposalDocument ipDocument;
    InstitutionalProposal institutionalProposal;
    private ProjectRetrievalService instPropProjectRetrievalService;

    @Before
    public void setUp() throws IOException, IntrospectionException, IllegalAccessException, InvocationTargetException, WorkflowException {
        useAuthorizedUser();
        String jsonInString = getIpJson();
        ObjectMapper mapper = new ObjectMapper();

        InstitutionalProposalDto ipDto = mapper.readValue(jsonInString, InstitutionalProposalDto.class);
        String documentId = getDocumentController().createInstitutionalProposal(ipDto, true);
        ipDocument = (InstitutionalProposalDocument) getDocumentController().getCommonApiService().getDocumentFromDocId(Long.parseLong(documentId));
        institutionalProposal = ipDocument.getInstitutionalProposal();
    }

    @Test
	public void test() throws Exception {
        final Project project = getProjectRetrievalService().retrieveProject(getDocumentIdentifier());
        if(isCoiEnabled()) {
            ObjectMessage message = getMessageFromProject(project);
            getRestMessageConsumer().onMessage(message);
        }
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

    protected String getIpJson() {
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

    @Override
    public String getDocumentIdentifier() {
        return institutionalProposal.getProposalNumber();
    }

    @Override
    public ProjectRetrievalService getProjectRetrievalService() {
        if (instPropProjectRetrievalService == null) {
            instPropProjectRetrievalService = KcServiceLocator.getService(INST_PROP_PROJECT_RETRIEVAL_SERVICE);
        }
        return instPropProjectRetrievalService;
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

}
