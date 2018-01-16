/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.withdraw;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.org.jmock.lib.legacy.ClassImposteriser;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.ProtocolVersionService;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolStatus;
import org.kuali.kra.irb.actions.assignagenda.ProtocolAssignToAgendaService;
import org.kuali.kra.irb.actions.correspondence.ProtocolActionCorrespondenceGenerationService;
import org.kuali.kra.irb.actions.submit.*;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReviewService;
import org.kuali.kra.irb.test.ProtocolFactory;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Test the ProtocolWithdrawService implementation.
 */
public class ProtocolWithdrawServiceTest extends KcIntegrationTestBase {

    private static final String REASON = "my test reason";
    
    private ProtocolWithdrawServiceImpl service;
    private ProtocolSubmitActionService protocolSubmitActionService;
    
    private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
        setThreadingPolicy(new Synchroniser());
    }};
    
    @Before
    public void setUp() throws Exception {

        service = new ProtocolWithdrawServiceImpl();
        service.setProtocolActionService(KcServiceLocator.getService(ProtocolActionService.class));
        service.setProtocolOnlineReviewService(getMockOnlineReviewService());
        service.setBusinessObjectService(getMockBusinessObjectService());
        service.setDocumentService(KcServiceLocator.getService(DocumentService.class));
        service.setProtocolVersionService(KcServiceLocator.getService(ProtocolVersionService.class));
        service.setProtocolAssignToAgendaService(getMockProtocolAssignToAgendaService());
        service.setProtocolActionCorrespondenceGenerationService(getMockActionCorrespondenceGenerationService());
        
        protocolSubmitActionService = KcServiceLocator.getService(ProtocolSubmitActionService.class);
    }

    @After
    public void tearDown() throws Exception {
        service = null;
        protocolSubmitActionService = null;
        
    }
    
    @Test
    public void testWithdrawal() throws Exception {
        ProtocolDocument oldProtocolDocument = ProtocolFactory.createProtocolDocument();
        
        protocolSubmitActionService.submitToIrbForReview(oldProtocolDocument, getMockSubmitAction(), null);
        assertEquals(ProtocolStatus.SUBMITTED_TO_IRB, oldProtocolDocument.getProtocol().getProtocolStatusCode());
        
        ProtocolDocument newProtocolDocument = (ProtocolDocument) service.withdraw(oldProtocolDocument.getProtocol(), getMockProtocolWithdrawBean());
    
        assertTrue(oldProtocolDocument.getDocumentHeader().getWorkflowDocument().isCanceled());
        assertEquals(ProtocolStatus.WITHDRAWN, newProtocolDocument.getProtocol().getProtocolStatusCode());
        
        ProtocolAction protocolAction = oldProtocolDocument.getProtocol().getLastProtocolAction();
        assertNotNull(protocolAction);
        assertEquals(REASON, protocolAction.getComments());
        
        ProtocolSubmission submission = oldProtocolDocument.getProtocol().getProtocolSubmission();
        assertEquals(ProtocolSubmissionStatus.WITHDRAWN, submission.getSubmissionStatusCode());
    }
    
    private ProtocolOnlineReviewService getMockOnlineReviewService() {
        final ProtocolOnlineReviewService service = context.mock(ProtocolOnlineReviewService.class);
        
        context.checking(new Expectations() {{
            ignoring(service);
        }});
        
        return service;
    }
    
    private BusinessObjectService getMockBusinessObjectService() {
        final BusinessObjectService service = context.mock(BusinessObjectService.class);
        
        context.checking(new Expectations() {{
            ignoring(service);
        }});
        
        return service;
    }
    
    
    private ProtocolAssignToAgendaService getMockProtocolAssignToAgendaService() {
        final ProtocolAssignToAgendaService service = context.mock(ProtocolAssignToAgendaService.class);
        
        context.checking(new Expectations() {{
            allowing(service).getAssignedToAgendaProtocolAction(with(any(Protocol.class)));
            will(returnValue(null));
        }});
        
        return service;
    }
    
    private ProtocolActionCorrespondenceGenerationService getMockActionCorrespondenceGenerationService() {
        final ProtocolActionCorrespondenceGenerationService service = context.mock(ProtocolActionCorrespondenceGenerationService.class);
        
        context.checking(new Expectations() {{
            ignoring(service);
        }});
        
        return service;
    }
    
    private ProtocolSubmitAction getMockSubmitAction() {
        final ProtocolSubmitAction action = context.mock(ProtocolSubmitAction.class);
        
        context.checking(new Expectations() {{
            allowing(action).getSubmissionTypeCode();
            will(returnValue(ProtocolSubmissionType.INITIAL_SUBMISSION));
            
            allowing(action).getProtocolReviewTypeCode();
            will(returnValue(ProtocolReviewType.FULL_TYPE_CODE));
            
            allowing(action).getSubmissionQualifierTypeCode();
            will(returnValue(ProtocolSubmissionQualifierType.ANNUAL_SCHEDULED_BY_IRB));
            
            allowing(action).getNewCommitteeId();
            will(returnValue(Constants.EMPTY_STRING));
            
            allowing(action).getNewScheduleId();
            will(returnValue(Constants.EMPTY_STRING));
            
            allowing(action).getReviewers();
            will(returnValue(new ArrayList<ProtocolReviewerBean>()));
        }});
        
        return action;
    }
    
    private ProtocolWithdrawBean getMockProtocolWithdrawBean() {
        final ProtocolWithdrawBean bean = context.mock(ProtocolWithdrawBean.class);
        
        context.checking(new Expectations() {{
            allowing(bean).getReason();
            will(returnValue(REASON));
            
            allowing(bean).getCorrespondence();
            will(returnValue(new WithdrawCorrespondence()));
        }});
        
        return bean;
    }
    
}
