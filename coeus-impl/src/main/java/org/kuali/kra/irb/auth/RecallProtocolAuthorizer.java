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

/**
 * The Modify Protocol Authorizer checks to see if the user has 
 * permission to modify a protocol. Authorization depends upon whether
 * the protocol is being created or modified.  For creation, the
 * user needs the CREATE_PROTOCOL permission.  If the protocol is being
 * modified, the user only needs to have the MODIFY_PROTOCOL permission 
 * for that protocol.
 */
public class RecallProtocolAuthorizer extends ProtocolAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        boolean hasPermission = true;
        Protocol protocol = task.getProtocol();
        hasPermission = !isPessimisticLocked(protocol.getProtocolDocument())
                && protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument().isEnroute()
                && !protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument().getCurrentNodeNames().contains("IRBReview")
                && hasPermission(userId, protocol, PermissionConstants.RECALL_DOCUMENT);
        return hasPermission;
    }
    
}
