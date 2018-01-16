/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.genericactions;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.ProtocolStatus;
import org.kuali.kra.irb.actions.submit.ProtocolSubmission;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionStatus;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionServiceImplBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.rice.kew.api.WorkflowDocument;

/**
 * This class handles the generic actions that can be made to a protocol.  A generic action contain a comment, action date, and a 
 * state change.
 */
public class ProtocolGenericActionServiceImpl extends ProtocolGenericActionServiceImplBase implements ProtocolGenericActionService {
    
    @Override
    public void close(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        if (ProtocolActionType.REQUEST_TO_CLOSE.equals(protocol.getLastProtocolAction().getProtocolActionType().getProtocolActionTypeCode())) {
          //if previous action is request to close then the new status is closed by investigator
            performGenericAction(protocol, actionBean, ProtocolActionType.CLOSED_ADMINISTRATIVELY_CLOSED, ProtocolStatus.CLOSED_BY_INVESTIGATOR);
        } else {
          //else closed administratively
            performGenericAction(protocol, actionBean, ProtocolActionType.CLOSED_ADMINISTRATIVELY_CLOSED, ProtocolStatus.CLOSED_ADMINISTRATIVELY);
        }
    }
    
    @Override
    public void closeEnrollment(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.CLOSED_FOR_ENROLLMENT, ProtocolStatus.ACTIVE_CLOSED_TO_ENROLLMENT);
    }
    
    @Override
    public void defer(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.DEFERRED, ProtocolStatus.DEFERRED);
    }
    
    @Override
    public void disapprove(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.DISAPPROVED, ProtocolStatus.DISAPPROVED);
        performDisapprove(protocol);
    }
    
    @Override
    public void expire(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.EXPIRED, ProtocolStatus.EXPIRED);
    }
    
    @Override
    public void irbAcknowledgement(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.IRB_ACKNOWLEDGEMENT);
    }

    @Override
    public void permitDataAnalysis(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.DATA_ANALYSIS_ONLY, ProtocolStatus.ACTIVE_DATA_ANALYSIS_ONLY);
    }

    @Override
    public void reopenEnrollment(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.REOPEN_ENROLLMENT, ProtocolStatus.ACTIVE_OPEN_TO_ENROLLMENT);
    }
    
    @Override
    public ProtocolDocument returnForSMR(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.SPECIFIC_MINOR_REVISIONS_REQUIRED, ProtocolStatus.SPECIFIC_MINOR_REVISIONS_REQUIRED);
        return getReturnedVersionedDocument(protocol);
    }
    
    @Override
    public ProtocolDocument returnForSRR(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.SUBSTANTIVE_REVISIONS_REQUIRED, ProtocolStatus.SUBSTANTIVE_REVISIONS_REQUIRED);
        return getReturnedVersionedDocument(protocol);
    }
    
    @Override
    public ProtocolDocument returnToPI(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.RETURNED_TO_PI, ProtocolStatus.RETURN_TO_PI);
        return getReturnedVersionedDocument(protocol);
    }     
    
    @Override
    public void suspend(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        if (ProtocolActionType.REQUEST_FOR_SUSPENSION.equals(protocol.getLastProtocolAction().getProtocolActionType().getProtocolActionTypeCode())) {
            //if previous action is request to suspend then the new status is suspend by investigator
            performGenericAction(protocol, actionBean, ProtocolActionType.SUSPENDED, ProtocolStatus.SUSPENDED_BY_PI);
        } else {
            //else suspend by IRB
            performGenericAction(protocol, actionBean, ProtocolActionType.SUSPENDED, ProtocolStatus.SUSPENDED_BY_IRB);
        }
    }
    
    @Override
    public void suspendByDsmb(Protocol protocol, ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.SUSPENDED_BY_DSMB, ProtocolStatus.SUSPENDED_BY_DSMB);
    }
    
    @Override
    public void terminate(ProtocolBase protocol, org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean actionBean) throws Exception {
        performGenericAction(protocol, actionBean, ProtocolActionType.TERMINATED, ProtocolStatus.TERMINATED_BY_IRB);
    }
        
    private void performGenericAction(Protocol protocol, ProtocolGenericActionBean actionBean, String protocolActionType) throws Exception {
        ProtocolAction protocolAction = (ProtocolAction) createProtocolActionAndAttach(protocol, actionBean, protocolActionType);
        
        if (protocol.getNotifyIrbSubmissionId() == null) {
            getProtocolActionService().updateProtocolStatus(protocolAction, protocol);
        } else {
            for (ProtocolSubmissionBase submission : protocol.getProtocolSubmissions()) {
                if (submission.getSubmissionId().equals(protocol.getNotifyIrbSubmissionId())) {
                    submission.setSubmissionStatusCode(ProtocolSubmissionStatus.IRB_ACKNOWLEDGEMENT);
                }
            }
        }
        
        protocol.refreshReferenceObject("protocolStatus"); 
        protocol.refreshReferenceObject("protocolSubmission");
        getDocumentService().saveDocument(protocol.getProtocolDocument());
    }
        
    @Override
    protected ProtocolActionBase getNewProtocolActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission, String protocolActionType) {
        return new ProtocolAction( (Protocol) protocol, (ProtocolSubmission) submission, protocolActionType);
    }
    
    @Override
    protected ProtocolActionsCorrespondenceBase getNewProtocolActionsCorrespondenceHook(String protocolActionType) {
        return new ProtocolGenericCorrespondence(protocolActionType);
    }
    
    @Override
    protected void performDisapprove(ProtocolBase protocol) throws Exception {
        if (protocol.getProtocolDocument() != null) {
            WorkflowDocument currentWorkflowDocument = protocol.getProtocolDocument().getDocumentHeader().getWorkflowDocument();
            if (currentWorkflowDocument != null) {
                currentWorkflowDocument.disapprove("Protocol document disapproved after committee decision");
            }
        }
        getProtocolOnlineReviewService().cancelOnlineReviews(protocol.getProtocolSubmission(), "Protocol Review cancelled - protocol has been disapproved.");
    }
    
    @Override
    public ProtocolDocument getDeferredVersionedDocument(Protocol protocol) throws Exception {
        getDocumentService().cancelDocument(protocol.getProtocolDocument(), "Protocol document cancelled - protocol has been deferred.");
        getProtocolOnlineReviewService().cancelOnlineReviews(protocol.getProtocolSubmission(), "Protocol Review cancelled - protocol has been deferred.");
        
        ProtocolDocument newDocument = (ProtocolDocument) getVersionedDocument(protocol);
        setReferencesForProtocolCorrespondence(newDocument);

        ProtocolAction assignToAgendaProtocolAction = (ProtocolAction) getProtocolAssignToAgendaService().getAssignedToAgendaProtocolAction((Protocol) newDocument.getProtocol());
        if (assignToAgendaProtocolAction != null) {
            newDocument.getProtocol().getProtocolActions().remove(assignToAgendaProtocolAction);
            getBusinessObjectService().delete(assignToAgendaProtocolAction);
        }
        newDocument.getProtocol().refreshReferenceObject("protocolStatus");
        getDocumentService().saveDocument(newDocument);
        
        return newDocument;
    }
    
    protected void setReferencesForProtocolCorrespondence(ProtocolDocument newDocument) {
    	Protocol newProtocol = newDocument.getProtocol();
    	newProtocol.getProtocolActions().forEach(protocolAction -> {
    		protocolAction.setSequenceNumber(newProtocol.getSequenceNumber());
    		protocolAction.getProtocolCorrespondences().forEach(protocolCorrespondence -> {
    			protocolCorrespondence.setProtocolId(newProtocol.getProtocolId());
    			protocolCorrespondence.setSequenceNumber(newProtocol.getSequenceNumber());
            });
        });
    }
    
    @Override
    protected ProtocolDocument getReturnedVersionedDocument(ProtocolBase protocol) throws Exception {
        getDocumentService().cancelDocument(protocol.getProtocolDocument(), "Protocol document cancelled - protocol has been returned for revisions.");
        getProtocolOnlineReviewService().finalizeOnlineReviews(protocol.getProtocolSubmission(), 
                "Protocol Review finalized - protocol has been returned for revisions.");
        
        return (ProtocolDocument) getVersionedDocument(protocol);
    }

    @Override
    protected String getProtocolPendingInProgressStatusCodeHook() {
        return ProtocolStatus.IN_PROGRESS;
    }

    @Override
    protected String getProtocolSubmissionStatusRejectedInRoutingCodeHook() {
        return ProtocolSubmissionStatus.RETURNED_IN_ROUTING;
    }

    @Override
    protected ProtocolActionBase getNewDisapprovedInRoutingProtocolActionInstanceHook(ProtocolBase protocol) {
        return new ProtocolAction( (Protocol) protocol, null, ProtocolActionType.RETURNED_IN_ROUTING);
    }

    @Override
    protected String getDisapprovedProtocolStatusCodeHook() {
        return ProtocolStatus.DISAPPROVED;
    }

    @Override
    protected String getRecallProtocolActionTypeCodeHook() {
        return ProtocolActionType.RECALLED_IN_ROUTING;
    }
}
