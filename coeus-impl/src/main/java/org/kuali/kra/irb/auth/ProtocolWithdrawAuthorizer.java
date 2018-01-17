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
import org.kuali.kra.irb.actions.ProtocolActionType;

/**
 * Is the user allowed to withdraw the protocol?
 */
public class ProtocolWithdrawAuthorizer extends ProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return kraWorkflowService.isInWorkflow(task.getProtocol().getProtocolDocument()) &&
               kraWorkflowService.isDocumentOnNode(task.getProtocol().getProtocolDocument(), Constants.PROTOCOL_IRBREVIEW_ROUTE_NODE_NAME) &&
               canExecuteAction(task.getProtocol(), ProtocolActionType.WITHDRAWN) &&
               hasPermission(userId, task.getProtocol(), PermissionConstants.SUBMIT_PROTOCOL);
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
