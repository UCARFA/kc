/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolStatus;

/**
 * Is the user allowed to delete a protocol, amendment or renewal?
 */
public class ProtocolAmendRenewDeleteAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return !task.getProtocol().getProtocolDocument().isViewOnly() &&
               inProgress(task.getProtocol()) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.DELETE_PROTOCOL);
    }
    
    private boolean inProgress(Protocol protocol) {
        return StringUtils.equals(protocol.getProtocolStatusCode(), ProtocolStatus.IN_PROGRESS) ||
               StringUtils.equals(protocol.getProtocolStatusCode(), ProtocolStatus.AMENDMENT_IN_PROGRESS) ||
               StringUtils.equals(protocol.getProtocolStatusCode(), ProtocolStatus.RENEWAL_IN_PROGRESS) ||
               StringUtils.equals(protocol.getProtocolStatusCode(), ProtocolStatus.FYI_IN_PROGRESS);
    }
}
