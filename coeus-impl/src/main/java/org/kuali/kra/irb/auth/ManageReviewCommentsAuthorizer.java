/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolActionType;

/**
 * Determine if a user can assign a protocol to a committee/schedule.
 */
public class ManageReviewCommentsAuthorizer extends ProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String username, ProtocolTask task) {
        Protocol protocol = task.getProtocol();
        boolean isWorklowed = kraWorkflowService.isInWorkflow(protocol.getProtocolDocument());
        boolean hasPermission = hasPermission(username, protocol, PermissionConstants.PERFORM_IRB_ACTIONS_ON_PROTO);
        boolean canExecute = canExecuteAction(protocol, ProtocolActionType.MANAGE_REVIEW_COMMENTS);
        return isWorklowed && hasPermission && canExecute;
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
