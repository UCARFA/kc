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

/**
 * 
 * This class maintains the authorizations required to perform a modification to protocol submission.
 */
public class ModifyProtocolSubmissionAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        Protocol protocol = task.getProtocol();
        return hasPermission(userId, protocol, PermissionConstants.MODIFY_PROTOCOL_SUBMISSION) 
            && canExecuteAction(task.getProtocol(), ProtocolActionType.MODIFY_PROTOCOL_SUBMISISON);
    }
}
