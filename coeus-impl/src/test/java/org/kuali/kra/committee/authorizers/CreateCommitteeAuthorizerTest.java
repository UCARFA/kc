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
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;
import org.kuali.coeus.common.framework.auth.task.ApplicationTask;
import org.kuali.coeus.common.committee.impl.CreateCommitteeAuthorizer;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.infrastructure.TaskName;

import static org.junit.Assert.assertEquals;

/**
 * Test the Create Committee Authorizer.
 */
@RunWith(JMock.class)
public class CreateCommitteeAuthorizerTest {

    private static final String USERNAME = "quickstart";
    
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    
    @Test
    public void testHasPermission() {
        CreateCommitteeAuthorizer authorizer = new CreateCommitteeAuthorizer();
        
        final UnitAuthorizationService unitAuthorizationService = context.mock(UnitAuthorizationService.class);
        context.checking(new Expectations() {{
            oneOf(unitAuthorizationService).hasPermission(USERNAME, Constants.MODULE_NAMESPACE_IRB, PermissionConstants.ADD_COMMITTEE); will(returnValue(true));
        }});
        authorizer.setUnitAuthorizationService(unitAuthorizationService);
        
        ApplicationTask task = new ApplicationTask(TaskName.ADD_COMMITTEE);
        assertEquals(true, authorizer.isAuthorized(USERNAME, task));
    }
    
    @Test
    public void testDoesNotHavePermission() {
        CreateCommitteeAuthorizer authorizer = new CreateCommitteeAuthorizer();
        
        final UnitAuthorizationService unitAuthorizationService = context.mock(UnitAuthorizationService.class);
        context.checking(new Expectations() {{
            oneOf(unitAuthorizationService).hasPermission(USERNAME, Constants.MODULE_NAMESPACE_IRB, PermissionConstants.ADD_COMMITTEE); will(returnValue(false));
        }});
        authorizer.setUnitAuthorizationService(unitAuthorizationService);
        
        ApplicationTask task = new ApplicationTask(TaskName.ADD_COMMITTEE);
        assertEquals(false, authorizer.isAuthorized(USERNAME, task));
    }
}
