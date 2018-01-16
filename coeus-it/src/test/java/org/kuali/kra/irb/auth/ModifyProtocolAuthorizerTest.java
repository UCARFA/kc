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
 * Test the Modify Protocol Authorizer.
 */
public class ModifyProtocolAuthorizerTest extends ProtocolAuthorizerTestBase {
    
    @Test
    public void testCreatePermission() throws Exception {
        runModifyProtocolAuthorizerTest(PROTOCOL_NUMBER, true, false, true, false, true);
    }
    
    @Test
    public void testNotCreatePermission() throws Exception {
        runModifyProtocolAuthorizerTest(PROTOCOL_NUMBER, true, false, false, false, false);
    }
    
    
    @Test
    public void testModifyPermission() throws Exception {
        runModifyProtocolAuthorizerTest(PROTOCOL_NUMBER, false, false, true, false, true);
    }
    
    @Test
    public void testNotModifyPermission() throws Exception {
        runModifyProtocolAuthorizerTest(PROTOCOL_NUMBER, false, false, false, false, false);
    }
    
    @Test
    public void testViewOnly() throws Exception {
        runModifyProtocolAuthorizerTest(PROTOCOL_NUMBER, false, true, true, false, false);
    }
    
    @Test
    public void testInWorkflow() throws Exception {
        runModifyProtocolAuthorizerTest(PROTOCOL_NUMBER, false, false, false, true, false);
    }
    
    @Override
    protected ProtocolAuthorizer createProtocolAuthorizer(ProtocolDocument protocolDocument, boolean hasPermission, boolean isActionAllowed, boolean isInWorkflow) {
        ModifyProtocolAuthorizer authorizer = new ModifyProtocolAuthorizer();
        authorizer.setUnitAuthorizationService(buildUnitAuthorizationService(PermissionConstants.CREATE_PROTOCOL, hasPermission));
        authorizer.setKraAuthorizationService(buildKraAuthorizationService(protocolDocument, PermissionConstants.MODIFY_PROTOCOL, hasPermission));
        authorizer.setKraWorkflowService(buildKraWorkflowService(protocolDocument, isInWorkflow));
        return authorizer;
    }
    
    @Override
    protected String getTaskName() {
        return TaskName.MODIFY_PROTOCOL;
    }

}
