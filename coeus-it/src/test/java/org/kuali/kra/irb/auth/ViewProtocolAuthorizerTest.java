/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.junit.Test;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.ProtocolDocument;

/**
 * Test the View Protocol Authorizer.
 */
public class ViewProtocolAuthorizerTest extends ProtocolAuthorizerTestBase {
    
    @Test
    public void testHasPermission() throws Exception {
        runActionAuthorizerTest(PROTOCOL_NUMBER, true, true, true);
    }
    
    @Test
    public void testNoPermission() throws Exception {
        runActionAuthorizerTest(PROTOCOL_NUMBER, false, true, false);
    }
    
    @Override
    protected ProtocolAuthorizer createProtocolAuthorizer(ProtocolDocument protocolDocument, boolean hasPermission, boolean isActionAllowed, boolean isInWorkflow) {
        ViewProtocolAuthorizer authorizer = new ViewProtocolAuthorizer();
        authorizer.setKraAuthorizationService(buildKraAuthorizationService(protocolDocument, PermissionConstants.VIEW_PROTOCOL, hasPermission));
        authorizer.setKraWorkflowService(buildKraWorkflowService(protocolDocument, false));

        return authorizer;
    }
    
    @Override
    protected String getTaskName() {
        return TaskName.VIEW_PROTOCOL;
    }
    
}
