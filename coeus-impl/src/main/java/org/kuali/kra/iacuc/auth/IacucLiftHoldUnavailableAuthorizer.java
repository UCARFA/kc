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
import org.kuali.kra.protocol.ProtocolBase;

/**
 * Determine if a user can assign a protocol to a committee/schedule.
 */
public class IacucLiftHoldUnavailableAuthorizer extends IacucProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String username, IacucProtocolTask task) {
        ProtocolBase protocol = task.getProtocol();
        return !canExecuteAction(protocol, IacucProtocolActionType.LIFT_HOLD)
                && hasPermission(username, protocol, PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }
}
