/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignagenda;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.IacucProtocolAction;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.assignCmt.IacucProtocolAssignCmtService;
import org.kuali.kra.iacuc.actions.genericactions.IacucProtocolGenericActionBean;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmission;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionStatus;
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
public class IacucProtocolAssignToAgendaServiceImpl extends ProtocolAssignToAgendaServiceImplBase implements IacucProtocolAssignToAgendaService {
    
    private IacucProtocolAssignCmtService protocolAssignCmtService;

    
    public void setProtocolAssignCmtService(IacucProtocolAssignCmtService protocolAssignCmtService) {
        this.protocolAssignCmtService = protocolAssignCmtService;
    }


    @Override
    public String getAssignedCommitteeId(ProtocolBase protocol) {
        return this.protocolAssignCmtService.getAssignedCommitteeId(protocol);
    }

    @Override
    public String getAssignedScheduleDate(ProtocolBase protocol) {
        String scheduleId = this.protocolAssignCmtService.getAssignedScheduleId(protocol);
        List<KeyValue> keyPair = this.getCommitteeService().getAvailableCommitteeDates(getAssignedCommitteeId(protocol));
        for (KeyValue kp : keyPair) {
            if (kp.getKey().equals(scheduleId)) {
                return kp.getValue();
            }
        }
        return null;
    }
    
    @Override
    public void removeFromAgenda(IacucProtocol protocol, IacucProtocolGenericActionBean actionBean) throws Exception {

        IacucProtocolSubmission submission = (IacucProtocolSubmission) findLastSubmission(protocol);
        submission.setSubmissionStatusCode("102");
        // add a new protocol action
        ProtocolActionBase protocolAction = getNewProtocolRemoveFromAgendaActionInstanceHook(protocol, submission);
        protocolAction.setComments(actionBean.getComments());
        protocolAction.setActionDate(new Timestamp(actionBean.getActionDate().getTime()));
        protocol.getProtocolActions().add(protocolAction);
        getProtocolActionService().updateProtocolStatus(protocolAction, protocol);
        getDocumentService().saveDocument(protocol.getProtocolDocument());    
    }
    
    protected ProtocolSubmissionBase findLastSubmission(ProtocolBase protocol) {
        ProtocolSubmissionBase returnSubmission = null;
        for (ProtocolSubmissionBase submission : protocol.getProtocolSubmissions()) {
            if (returnSubmission == null || returnSubmission.getSequenceNumber() < submission.getSequenceNumber()) {
                returnSubmission = submission;
            }
        }
        return returnSubmission;
    }
    
    public ProtocolActionBase getNewProtocolRemoveFromAgendaActionInstanceHook(IacucProtocol protocol, IacucProtocolSubmission submission) {
        return new IacucProtocolAction( protocol, submission, IacucProtocolActionType.REMOVE_FROM_AGENDA);
    }
        

    @Override
    protected String getProtocolSubmissionStatusSubmittedToCommitteeCodeHook() {
        return IacucProtocolSubmissionStatus.SUBMITTED_TO_COMMITTEE;
    }
    

    @Override
    protected String getProtocolSubmissionStatusPendingCodeHook() {
        return IacucProtocolSubmissionStatus.PENDING;
    }
    

    @Override
    protected ProtocolActionBase getNewProtocolAssignToAgendaActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission) {
        return new IacucProtocolAction( (IacucProtocol)protocol, (IacucProtocolSubmission) submission, IacucProtocolActionType.ASSIGNED_TO_AGENDA);
    }

    @Override
    protected String getProtocolActionTypeAssignToAgendaCodeHook() {
        return IacucProtocolActionType.ASSIGNED_TO_AGENDA;
    }
    

    @Override
    protected String getProtocolSubmissionStatusInAgendaCodeHook() {
        return IacucProtocolSubmissionStatus.IN_AGENDA;
    }
    

}
