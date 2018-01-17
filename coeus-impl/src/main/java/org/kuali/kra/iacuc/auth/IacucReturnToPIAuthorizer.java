/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;


import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * Determine if a user can return a protocol to a principal investigator.
 */
public class IacucReturnToPIAuthorizer extends IacucProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String username, IacucProtocolTask task) {
        return kraWorkflowService.isInWorkflow(task.getProtocol().getProtocolDocument()) &&
               kraWorkflowService.isDocumentOnNode(task.getProtocol().getProtocolDocument(), Constants.IACUC_PROTOCOL_IACUCREVIEW_ROUTE_NODE_NAME) &&
               canExecuteAction(task.getProtocol(), IacucProtocolActionType.RETURNED_TO_PI) && 
               hasPermission(username, task.getProtocol(), PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
