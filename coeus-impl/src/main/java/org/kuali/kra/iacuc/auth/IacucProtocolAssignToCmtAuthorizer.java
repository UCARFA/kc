/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionStatus;
import org.kuali.kra.infrastructure.PermissionConstants;

public class IacucProtocolAssignToCmtAuthorizer extends IacucProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        IacucProtocol protocol = task.getProtocol();
        return kraWorkflowService.isInWorkflow(protocol.getProtocolDocument()) &&
                // this is where the drools are used, in the protocolActionService
               canExecuteAction(task.getProtocol(), IacucProtocolActionType.NOTIFIED_COMMITTEE) &&
               !StringUtils.equals(IacucProtocolSubmissionStatus.APPROVED, protocol.getProtocolSubmission().getSubmissionStatusCode()) &&
               hasPermission(userId, protocol, PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
   
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
