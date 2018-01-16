/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * Determine if a user can table a protocol.
 */
public class IacucProtocolTableAuthorizer extends IacucProtocolTableAuthorizerBase {

  
    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return canExecuteAction(task.getProtocol(), IacucProtocolActionType.TABLED) &&
               checkIfSubmissionCanBeBumped(task.getProtocol()) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }
}
