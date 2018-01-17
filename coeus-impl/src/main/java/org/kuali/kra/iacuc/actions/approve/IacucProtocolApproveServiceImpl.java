/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.approve;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.IacucProtocolAction;
import org.kuali.kra.iacuc.actions.IacucProtocolActionType;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmission;
import org.kuali.kra.iacuc.correspondence.IacucProtocolActionsCorrespondence;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.approve.ProtocolApproveBean;
import org.kuali.kra.protocol.actions.approve.ProtocolApproveServiceImplBase;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;

public class IacucProtocolApproveServiceImpl extends ProtocolApproveServiceImplBase implements IacucProtocolApproveService {

    private static final String FULL_APPROVAL_FINALIZE_OLR_ANNOTATION = "Online Review finalized as part of full approval action on protocol.";
    
    
    @Override
    public void grantFullApproval(ProtocolDocumentBase protocolDocument, ProtocolApproveBean actionBean) throws Exception {
        generateProtocolActionAndAttach(protocolDocument.getProtocol(), actionBean, IacucProtocolActionType.IACUC_APPROVED);

        if (protocolDocument.getProtocol().getApprovalDate() == null) {
            protocolDocument.getProtocol().setApprovalDate(actionBean.getApprovalDate());
        }              
        if (!protocolDocument.getProtocol().isNew()) {
            protocolDocument.getProtocol().setLastApprovalDate(actionBean.getApprovalDate());
        }
        protocolDocument.getProtocol().setExpirationDate(actionBean.getExpirationDate());
        
        finalizeReviewsAndSave(protocolDocument, IacucProtocolActionType.IACUC_APPROVED, FULL_APPROVAL_FINALIZE_OLR_ANNOTATION);
        protocolDocument.getDocumentHeader().getWorkflowDocument().approve(actionBean.getComments());
    }  

    
    @Override
    protected String getProtocolActionTypeCodeForAdminApprovalHook() {
        return IacucProtocolActionType.ADMINISTRATIVE_APPROVAL;
    }

    
    @Override
    protected String getProtocolActionTypeCodeForResponseApprovalHook() {
        return IacucProtocolActionType.RESPONSE_APPROVAL;
    }
    
    
    @Override
    protected ProtocolActionBase getNewProtocolActionInstanceHook(ProtocolBase protocol, ProtocolSubmissionBase submission, String protocolActionTypeCode) {
        return new IacucProtocolAction((IacucProtocol)protocol, (IacucProtocolSubmission) submission, protocolActionTypeCode);
    }


    @Override
    protected ProtocolActionsCorrespondenceBase getNewProtocolActionsCorrespondence(String protocolActionTypeCode) {
        return new IacucProtocolActionsCorrespondence(protocolActionTypeCode);
    }

    
}
