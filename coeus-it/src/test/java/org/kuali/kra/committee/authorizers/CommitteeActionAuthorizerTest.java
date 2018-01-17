/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.authorizers;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.committee.document.authorizer.CommitteeActionAuthorizer;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.committee.test.CommitteeFactory;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.service.impl.mocks.KraAuthorizationServiceMock;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.UserSession;
import org.kuali.rice.krad.util.GlobalVariables;

import static org.junit.Assert.assertEquals;
/**
 * Test the Committee Action Authorizer.
 */
public class CommitteeActionAuthorizerTest extends KcIntegrationTestBase {

    private static final String USERNAME = "quickstart";
    private static final String COMMITTEE_ID = "Actn Auth Test";
    
    private CommitteeDocument committeeDocument;
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};

    @Before
    public void setUp() throws Exception {
        GlobalVariables.setUserSession(new UserSession("quickstart"));
        committeeDocument = CommitteeFactory.createCommitteeDocument("Actn Auth Test");
    }
    
    @After
    public void tearDown() throws Exception {
        GlobalVariables.setUserSession(null);
    }
    
    @Test
    public void testPerformActionsPermission() throws WorkflowException {
        CommitteeActionAuthorizer authorizer = new CommitteeActionAuthorizer();
        
        final Committee committee = committeeDocument.getCommittee();
        final CommitteeService committeeService = context.mock(CommitteeService.class);
        context.checking(new Expectations() {{
            allowing(committeeService).getCommitteeById(COMMITTEE_ID); will(returnValue(committee));
        }});
        authorizer.setCommitteeService(committeeService);

        final KraAuthorizationServiceMock kraAuthorizationService = new KraAuthorizationServiceMock(true);
        authorizer.setKraAuthorizationService(kraAuthorizationService);
        
        committeeDocument.getDocumentHeader().getWorkflowDocument().route("");
        CommitteeTaskBase<Committee> task = new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, TaskName.PERFORM_COMMITTEE_ACTIONS, committeeDocument.getCommittee()) {};
        assertEquals(true, authorizer.isAuthorized(USERNAME, task));
    }
    
    @Test
    public void testNoPerformActionsPermissionBasedOnPermission() throws WorkflowException {
        CommitteeActionAuthorizer authorizer = new CommitteeActionAuthorizer();
        
        final Committee committee = committeeDocument.getCommittee();
        final CommitteeService committeeService = context.mock(CommitteeService.class);
        context.checking(new Expectations() {{
            allowing(committeeService).getCommitteeById(COMMITTEE_ID); will(returnValue(committee));
        }});
        authorizer.setCommitteeService(committeeService);

        final KraAuthorizationServiceMock kraAuthorizationService = new KraAuthorizationServiceMock(false);
        authorizer.setKraAuthorizationService(kraAuthorizationService);

        committeeDocument.getDocumentHeader().getWorkflowDocument().route("");
        CommitteeTaskBase<Committee> task = new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, TaskName.PERFORM_COMMITTEE_ACTIONS, committeeDocument.getCommittee()) {};
        assertEquals(false, authorizer.isAuthorized(USERNAME, task));
    }
    
    @Test
    public void testNoPerformActionsPermissionBasedOnDocumentStatus() throws WorkflowException {
        CommitteeActionAuthorizer authorizer = new CommitteeActionAuthorizer();
        
        final Committee committee = committeeDocument.getCommittee();
        final CommitteeService committeeService = context.mock(CommitteeService.class);
        context.checking(new Expectations() {{
            allowing(committeeService).getCommitteeById(COMMITTEE_ID); will(returnValue(committee));
        }});
        authorizer.setCommitteeService(committeeService);

        final KraAuthorizationServiceMock kraAuthorizationService = new KraAuthorizationServiceMock(true);
        authorizer.setKraAuthorizationService(kraAuthorizationService);
        
        CommitteeTaskBase<Committee> task = new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, TaskName.PERFORM_COMMITTEE_ACTIONS, committeeDocument.getCommittee()) {};
        assertEquals(false, authorizer.isAuthorized(USERNAME, task));
    }
    
    @Test
    public void testNoPerformActionsPermissionBasedOnVersion() throws WorkflowException {
        CommitteeActionAuthorizer authorizer = new CommitteeActionAuthorizer();
        
        final Committee committee = new Committee();
        committee.setId(1L);
        final CommitteeService committeeService = context.mock(CommitteeService.class);
        context.checking(new Expectations() {{
            allowing(committeeService).getCommitteeById(COMMITTEE_ID); will(returnValue(committee));
        }});
        authorizer.setCommitteeService(committeeService);

        final KraAuthorizationServiceMock kraAuthorizationService = new KraAuthorizationServiceMock(true);
        authorizer.setKraAuthorizationService(kraAuthorizationService);
        
        committeeDocument.getDocumentHeader().getWorkflowDocument().route("");
        CommitteeTaskBase<Committee> task = new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, TaskName.PERFORM_COMMITTEE_ACTIONS, committeeDocument.getCommittee()) {};
        assertEquals(false, authorizer.isAuthorized(USERNAME, task));
    }
    
}
