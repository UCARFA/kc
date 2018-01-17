/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.Constants;
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
public class ModifyProtocolAuthorizer extends ProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        boolean hasPermission = true;
        Protocol protocol = task.getProtocol();
        Long protocolId = protocol.getProtocolId();
        if (protocolId == null) {
            
            // We have to consider the case when we are saving the protocol for the first time.
            
            hasPermission = hasUnitPermission(userId, Constants.MODULE_NAMESPACE_IRB, PermissionConstants.CREATE_PROTOCOL);
        } 
        else {
            /*
             * After the initial save, the protocol can only be modified has the required permission.
             */
            hasPermission = !protocol.getProtocolDocument().isViewOnly() && 
                            !isPessimisticLocked(protocol.getProtocolDocument()) &&
                            (!kraWorkflowService.isInWorkflow(protocol.getProtocolDocument()) || protocol.isCorrectionMode()) &&
                            hasPermission(userId, protocol, PermissionConstants.MODIFY_PROTOCOL);

        }
        return hasPermission;
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
