/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.actions.ProtocolActionType;

/**
 * Is the user allowed to submit a protocol to the IRB for review and the action is currently not available?
 */
public class SubmitProtocolUnavailableAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        
        return !canExecuteAction(task.getProtocol(), ProtocolActionType.SUBMIT_TO_IRB) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_PROTOCOL);
    }
}
