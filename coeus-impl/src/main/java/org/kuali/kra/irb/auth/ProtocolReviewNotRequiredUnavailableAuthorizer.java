/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolActionType;


public class ProtocolReviewNotRequiredUnavailableAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        Protocol protocol = task.getProtocol();
        boolean hasPermission = hasPermission(userId, protocol, PermissionConstants.REVIEW_NOT_REQUIRED);
        boolean canExecuteAction = canExecuteAction(task.getProtocol(), ProtocolActionType.IRB_REVIEW_NOT_REQUIRED);
        return hasPermission && !canExecuteAction;
    }

}
