/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.iacuc.actions.IacucProtocolStatus;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.ProtocolBase;

/**
 * Is the user allowed to delete a protocol, amendment or renewal?
 */
public class IacucProtocolAmendRenewDeleteAuthorizer extends IacucProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return !task.getProtocol().getProtocolDocument().isViewOnly() &&
               inProgress(task.getProtocol()) 
               && (hasPermission(userId, task.getProtocol(), PermissionConstants.DELETE_IACUC_PROTOCOL));
    }
    
    private boolean inProgress(ProtocolBase protocol) {
        return StringUtils.equals(protocol.getProtocolStatusCode(), IacucProtocolStatus.IN_PROGRESS) ||
               StringUtils.equals(protocol.getProtocolStatusCode(), IacucProtocolStatus.FYI_IN_PROGRESS);
    }
}
