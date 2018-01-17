/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * Determine if a user can assign a protocol to a committee/schedule.
 */
public class IacucManageReviewCommentsAuthorizer extends IacucProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String username, IacucProtocolTask task) {
        IacucProtocol protocol = task.getProtocol();
        
        boolean isWorkflowed = kraWorkflowService.isInWorkflow(protocol.getProtocolDocument());
        boolean hasPermission = hasPermission(username, protocol, PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
        boolean canExecute = canExecuteAction(protocol, IacucProtocolActionType.MANAGE_REVIEW_COMMENTS);
        
        return isWorkflowed && hasPermission && canExecute;
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
