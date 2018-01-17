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

public class ModifyIacucProtocolSubmissionUnavailableAuthorizer extends IacucProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return hasPermission(userId, task.getProtocol(), PermissionConstants.MODIFY_IACUC_PROTO_SUBMISSION) 
        && !canExecuteAction(task.getProtocol(), IacucProtocolActionType.MODIFY_PROTOCOL_SUBMISSION);
    }

}
