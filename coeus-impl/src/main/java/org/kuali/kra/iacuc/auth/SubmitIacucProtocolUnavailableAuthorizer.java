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
 * Is the user allowed to submit a protocol to the IACUC for review and the action is currently not available?
 */
public class SubmitIacucProtocolUnavailableAuthorizer extends IacucProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        
        return !canExecuteAction(task.getProtocol(), IacucProtocolActionType.SUBMITTED_TO_IACUC) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_IACUC_PROTOCOL);
    }
}
