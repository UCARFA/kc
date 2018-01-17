/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * 
 * This class is the authorizer for all the generic actions and the action is currently not available.
 */
public class GenericProtocolUnavailableAuthorizer extends GenericProtocolAuthorizer {
    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return !canExecuteAction(task.getProtocol(), super.convertGenericTaskNameToProtocolActionType()) 
            && hasPermission(userId, task.getProtocol(), PermissionConstants.MAINTAIN_PROTOCOL_SUBMISSIONS);
    }
    
}
