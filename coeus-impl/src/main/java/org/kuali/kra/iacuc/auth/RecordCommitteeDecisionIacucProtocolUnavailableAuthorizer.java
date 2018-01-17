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
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
/**
 * Is the user allowed to record committee decisions for a protocol?
 */
public class RecordCommitteeDecisionIacucProtocolUnavailableAuthorizer extends IacucProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return 
               hasPermission(userId, task.getProtocol(), PermissionConstants.PERFORM_IACUC_ACTIONS_ON_PROTO) 
                   &&
               !( 
                  kraWorkflowService.isInWorkflow(task.getProtocol().getProtocolDocument()) &&
                  canExecuteAction(task.getProtocol(), IacucProtocolActionType.RECORD_COMMITTEE_DECISION) && 
                  canRecordCommitteeDecision(task.getProtocol().getLastProtocolAction()) 
               );
    }
    
    /**
     * 
     * record committee decision doesn't change the protocol status, after one record committee decision as approve, then
     * the approve screen comes up, this function prevents the record committee decision from remianing open after the action
     * has been done.
     * @param lastAction
     * @return
     */
    private boolean canRecordCommitteeDecision(ProtocolActionBase lastAction) {
        if(lastAction != null && !IacucProtocolActionType.RECORD_COMMITTEE_DECISION.equals(lastAction.getProtocolActionTypeCode())) {
            return true;
        }
                
        return false;
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
