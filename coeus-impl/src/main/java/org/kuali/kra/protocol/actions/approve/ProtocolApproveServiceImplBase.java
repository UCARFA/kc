/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.approve;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.kra.protocol.actions.submit.ProtocolActionService;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;
import org.kuali.rice.krad.service.DocumentService;

import java.sql.Timestamp;

/**
 * Approves a protocol, either for a full, expedited, or response protocol submission.
 */
public abstract class ProtocolApproveServiceImplBase implements ProtocolApproveService {
    
    protected static final String RESPONSE_APPROVAL_FINALIZE_OLR_ANNOTATION = "Online Review finalized as part of response approval action on protocol.";
    private static final String ADMIN_APPROVAL_FINALIZE_OLR_ANNOTATION = "Online Review finalized as part of administrative approval action on protocol.";
    
    private DocumentService documentService;
    private ProtocolActionService protocolActionService;
         

    protected ProtocolOnlineReviewService protocolOnlineReviewService;
    
    @Override
    public void grantResponseApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception {
        generateProtocolActionAndAttach(protocolDocument.getProtocol(), actionBean, getProtocolActionTypeCodeForResponseApprovalHook());
        
        if (protocolDocument.getProtocol().getApprovalDate() == null) {
            protocolDocument.getProtocol().setApprovalDate(actionBean.getApprovalDate());
        }
        if (!protocolDocument.getProtocol().isNew()) {
            protocolDocument.getProtocol().setLastApprovalDate(actionBean.getApprovalDate());
        }
        protocolDocument.getProtocol().setExpirationDate(actionBean.getExpirationDate());
        
        finalizeReviewsAndSave(protocolDocument, getProtocolActionTypeCodeForResponseApprovalHook(), RESPONSE_APPROVAL_FINALIZE_OLR_ANNOTATION);
        
        protocolDocument.getProtocol().getProtocolDocument().getDocumentHeader().getWorkflowDocument().approve(actionBean.getComments());
    }   
    
    protected abstract String getProtocolActionTypeCodeForResponseApprovalHook();

    
    
    @Override
    public void grantAdminApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception {
        generateProtocolActionAndAttach(protocolDocument.getProtocol(), actionBean, getProtocolActionTypeCodeForAdminApprovalHook());
        
        if (protocolDocument.getProtocol().getApprovalDate() == null) {
            protocolDocument.getProtocol().setApprovalDate(actionBean.getApprovalDate());
        }
        if (!protocolDocument.getProtocol().isNew()) {
            protocolDocument.getProtocol().setLastApprovalDate(actionBean.getApprovalDate());
        }
        protocolDocument.getProtocol().setExpirationDate(actionBean.getExpirationDate());
        
        finalizeReviewsAndSave(protocolDocument, getProtocolActionTypeCodeForAdminApprovalHook(), ADMIN_APPROVAL_FINALIZE_OLR_ANNOTATION);
        
        protocolDocument.getProtocol().getProtocolDocument().getDocumentHeader().getWorkflowDocument().approve(actionBean.getComments());
    }


    protected abstract String getProtocolActionTypeCodeForAdminApprovalHook();



    protected void generateProtocolActionAndAttach(ProtocolBase protocol, ProtocolApproveBean actionBean, String protocolActionTypeCode) {
        ProtocolActionBase protocolAction = getNewProtocolActionInstanceHook(protocol, protocol.getProtocolSubmission(), protocolActionTypeCode);
        protocolAction.setComments(actionBean.getComments());
        protocolAction.setActionDate(new Timestamp(actionBean.getActionDate().getTime()));
        protocolAction.setSubmissionIdFk(protocol.getLastProtocolAction().getSubmissionIdFk());
        protocolAction.setSubmissionNumber(protocol.getLastProtocolAction().getSubmissionNumber());
        protocol.getProtocolActions().add(protocolAction);
        protocolActionService.updateProtocolStatus(protocolAction, protocol);
    }
    
    
    protected abstract ProtocolActionBase getNewProtocolActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission, String protocolActionTypeCode);
    
    protected abstract ProtocolActionsCorrespondenceBase getNewProtocolActionsCorrespondence(String protocolActionTypeCode);


    protected void finalizeReviewsAndSave(ProtocolDocumentBase protocolDocument, String protocolActionTypeCode, String reviewAnnotation) throws Exception {
        protocolDocument.refreshReferenceObject("protocolStatus");

        protocolOnlineReviewService.finalizeOnlineReviews(protocolDocument.getProtocol().getProtocolSubmission(), reviewAnnotation);
        
        documentService.saveDocument(protocolDocument);
         
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void setProtocolActionService(ProtocolActionService protocolActionService) {
        this.protocolActionService = protocolActionService;
    }

    public ProtocolOnlineReviewService getProtocolOnlineReviewService() {
        return protocolOnlineReviewService;
    }

    public void setProtocolOnlineReviewService(ProtocolOnlineReviewService protocolOnlineReviewService) {
        this.protocolOnlineReviewService = protocolOnlineReviewService;
    }

    protected DocumentService getDocumentService() {
        return documentService;
    }

    protected ProtocolActionService getProtocolActionService() {
        return protocolActionService;
    }
    
}
