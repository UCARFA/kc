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
import org.kuali.kra.irb.actions.ProtocolStatus;

/**
 * Test the Protocol/Amendment/Renewal Delete Authorizer.
 */
public class ProtocolAmendRenewDeleteAuthorizerTest extends ProtocolAuthorizerTestBase {
    
    @Test
    public void testHasPermission() throws Exception {
        runStatusAuthorizerTest(PROTOCOL_NUMBER, ProtocolStatus.IN_PROGRESS, true, true);
    }
    
    @Test
    public void testNoPermission() throws Exception {
        runStatusAuthorizerTest(PROTOCOL_NUMBER, ProtocolStatus.IN_PROGRESS, false, false);
    }
    
    @Test
    public void testNotInProgress() throws Exception {
        runStatusAuthorizerTest(PROTOCOL_NUMBER, ProtocolStatus.SUBMITTED_TO_IRB, true, false);
    }
    
    @Override
    protected ProtocolAuthorizer createProtocolAuthorizer(ProtocolDocument protocolDocument, boolean hasPermission, boolean isActionAllowed, boolean isInWorkflow) {
        ProtocolAuthorizer authorizer = new ProtocolAmendRenewDeleteAuthorizer();
        authorizer.setKraAuthorizationService(buildKraAuthorizationService(protocolDocument, PermissionConstants.DELETE_PROTOCOL, hasPermission));
        return authorizer;
    }
    
    @Override
    protected String getTaskName() {
        return TaskName.PROTOCOL_AMEND_RENEW_DELETE;
    }
    
}
