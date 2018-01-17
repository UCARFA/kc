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
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

/**
 * Determine if a user can assign a protocol to a committee/schedule.
 */
public class IacucProtocolAssignToAgendaAuthorizer extends IacucProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String username, IacucProtocolTask task) {
        ProtocolBase protocol = task.getProtocol();
        return kraWorkflowService.isInWorkflow(protocol.getProtocolDocument())
                && kraWorkflowService.isCurrentNode(protocol.getProtocolDocument(), Constants.PROTOCOL_IACUCREVIEW_ROUTE_NODE_NAME)
                && canExecuteAction(protocol, IacucProtocolActionType.ASSIGNED_TO_AGENDA)
                && isAssignedToCommittee(protocol)
                && hasPermission(username, protocol, PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO);
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
    
    /**
     * Is the protocol's submission in a pending or submitted to committee status?
     * 
     * @param protocol
     * @return
     */
    private boolean isAssignedToCommittee(ProtocolBase protocol) {
        ProtocolSubmissionBase ps = findSubmission(protocol);
        return ps != null && ps.getCommitteeSchedule() != null && ps.getCommitteeSchedule().getScheduledDate() != null;
    }
}
