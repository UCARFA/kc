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
import org.kuali.rice.kew.api.KewApiConstants;

/**
 * Determine if a user can assign a protocol to a committee/schedule and the action is currently not available.
 */
public class ProtocolDeferUnavailableAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IRB_ACTIONS_ON_PROTO) &&
               (!canExecuteAction(task.getProtocol(), ProtocolActionType.DEFERRED) ||
                task.getProtocol().getProtocolDocument().getDocumentHeader().getWorkflowDocument().getStatus().getCode()
                    .equals(KewApiConstants.ROUTE_HEADER_FINAL_CD));
    }
}
