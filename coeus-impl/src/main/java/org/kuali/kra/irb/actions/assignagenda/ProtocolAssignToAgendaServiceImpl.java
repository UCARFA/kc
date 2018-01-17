/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assignagenda;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.assigncmtsched.ProtocolAssignCmtSchedService;
import org.kuali.kra.irb.actions.expeditedapprove.ProtocolExpeditedApproveBean;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaServiceImplBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.rice.core.api.util.KeyValue;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * This class implements ProtocolAssignToAgendaService.
 */
public class ProtocolAssignToAgendaServiceImpl extends ProtocolAssignToAgendaServiceImplBase implements ProtocolAssignToAgendaService {

    private ProtocolAssignCmtSchedService protocolAssignCmtSchedService;
    
    public void setProtocolAssignCmtSchedService(ProtocolAssignCmtSchedService protocolAssignCmtSchedService) {
        this.protocolAssignCmtSchedService = protocolAssignCmtSchedService;        
    }
    
    @Override
    protected String getProtocolSubmissionStatusSubmittedToCommitteeCodeHook() {
        return ProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE;
    }

    @Override
    protected String getProtocolSubmissionStatusPendingCodeHook() {
        return ProtocolSubmissionStatus.PENDING;
    }

    @Override
    protected ProtocolActionBase getNewProtocolAssignToAgendaActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission) {
        return new ProtocolAction((Protocol) protocol, (ProtocolSubmission) submission, ProtocolActionType.ASSIGN_TO_AGENDA);
    }

    @Override
    public void assignToAgenda(Protocol protocol, ProtocolExpeditedApproveBean actionBean) throws Exception {

        ProtocolSubmission submission = (ProtocolSubmission) findSubmission(protocol);
        // add a new protocol action
        ProtocolAction protocolAction = new ProtocolAction(protocol, submission, ProtocolActionType.ASSIGN_TO_AGENDA);
        protocolAction.setComments(actionBean.getComments());
        protocolAction.setActionDate(new Timestamp(actionBean.getActionDate().getTime()));
        protocol.getProtocolActions().add(protocolAction);
        getProtocolActionService().updateProtocolStatus(protocolAction, protocol);
        getDocumentService().saveDocument(protocol.getProtocolDocument());    
    }
    
    @Override
    protected String getProtocolSubmissionStatusInAgendaCodeHook() {
        return ProtocolSubmissionStatus.IN_AGENDA;
    }
    
    @Override
    protected String getProtocolActionTypeAssignToAgendaCodeHook() {
        return ProtocolActionType.ASSIGN_TO_AGENDA;
    }

    @Override
    public String getAssignedCommitteeId(ProtocolBase protocol) {
        String committeeID = this.protocolAssignCmtSchedService.getAssignedCommitteeId((Protocol) protocol);
        return committeeID;
    }

    @Override
    public String getAssignedScheduleDate(ProtocolBase protocol) {
        String scheduleId = this.protocolAssignCmtSchedService.getAssignedScheduleId((Protocol) protocol);
        List<KeyValue> keyPair = this.getCommitteeService().getAvailableCommitteeDates(getAssignedCommitteeId(protocol));
        for (KeyValue kp : keyPair) {
            if (kp.getKey().equals(scheduleId)) {
                return kp.getValue();
            }
        }
        return null;
    }
}
