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
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.ProtocolActionType;

/**
 * Test the Notify IRB Authorizer.
 */
public class NotifyIrbAuthorizerTest extends ProtocolAuthorizerTestBase {
    
    @Test
    public void testHasPermission() throws Exception {
        runActionAuthorizerTest(PROTOCOL_NUMBER, true, true, true);
    }
    
    @Test
    public void testNotAProtocol() throws Exception {
        runActionAuthorizerTest(PROTOCOL_NUMBER + "A001", true, true, false);
    }
    
    @Test
    public void testNoPermission() throws Exception {
        runActionAuthorizerTest(PROTOCOL_NUMBER, false, true, false);
    }
    
    @Test
    public void testActionNotAllowed() throws Exception {
        runActionAuthorizerTest(PROTOCOL_NUMBER, true, false, false);
    }
    
    @Override
    protected ProtocolAuthorizer createProtocolAuthorizer(ProtocolDocument protocolDocument, boolean hasPermission, boolean isActionAllowed, boolean isInWorkflow) {
        ProtocolAuthorizer authorizer = new NotifyIrbAuthorizer();
        authorizer.setKraAuthorizationService(buildKraAuthorizationService(protocolDocument, PermissionConstants.SUBMIT_PROTOCOL, hasPermission, RoleConstants.IRB_ADMINISTRATOR, true));
        authorizer.setSystemAuthorizationService(buildSystemAuthorizationService(protocolDocument, PermissionConstants.SUBMIT_PROTOCOL, hasPermission, RoleConstants.IRB_ADMINISTRATOR, true));
        authorizer.setProtocolActionService(buildProtocolActionService(ProtocolActionType.NOTIFY_IRB, protocolDocument, isActionAllowed));
        return authorizer;
    }
    
    @Override
    protected String getTaskName() {
        return TaskName.NOTIFY_IRB;
    }

}
