/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog;

import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.kns.document.authorization.DocumentPresentationController;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentPresentationControllerBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.Set;

/**
 * Determines read-only fields on the Proposal Log maintenance document.
 */
public class ProposalLogDocumentPresentationController extends MaintenanceDocumentPresentationControllerBase
    implements DocumentPresentationController {
    
    @Override
    public Set<String> getConditionallyReadOnlyPropertyNames(
            MaintenanceDocument document) {
        Set<String> fields = super.getConditionallyReadOnlyPropertyNames(document);
        if (isValidDocument(document)) {
            ProposalLog proposalLog = (ProposalLog) document.getOldMaintainableObject().getDataObject();
            if (isStatusMerged(proposalLog) || isNew(proposalLog) || isCopy(document)) {
                fields.add(ProposalLog.LOG_STATUS);
            }
            if (isEdit(document) || isSaved(document)) {
                fields.add(ProposalLog.PROPOSAL_LOG_TYPE_CODE);
            }
        }
        return fields;
    }

    @Override
    public boolean canEdit(Document document) {
        boolean canEdit = super.canEdit(document);
        if (canEdit) {
            ProposalLog proposalLog = (ProposalLog) ((MaintenanceDocument) document).getOldMaintainableObject().getDataObject();
            if (proposalLog.isSubmitted() && !"Copy".equals(((MaintenanceDocument) document).getNewMaintainableObject().getMaintenanceAction())) {
                canEdit = false;
            }
        }
        return canEdit;
    }
    
    private boolean isValidDocument(MaintenanceDocument document) {
        return document.getOldMaintainableObject() != null 
            && document.getOldMaintainableObject().getDataObject() != null
            && document.getOldMaintainableObject().getDataObject() instanceof ProposalLog;
    }
    
    private boolean isNew(ProposalLog proposalLog) {
        return proposalLog.getProposalNumber() == null;
    }
    
    private boolean isEdit(MaintenanceDocument document) {
        return document.getNewMaintainableObject() != null 
            && KRADConstants.MAINTENANCE_EDIT_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction());
    }
    
    private boolean isSaved(MaintenanceDocument document) {
        return document.getDocumentHeader().getWorkflowDocument().getStatus().getCode().equals(
                KewApiConstants.ROUTE_HEADER_SAVED_CD);
    }
    
    private boolean isCopy(MaintenanceDocument document) {
        return document.getNewMaintainableObject() != null 
            && KRADConstants.MAINTENANCE_COPY_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction());
    }
    
    private boolean isStatusMerged(ProposalLog proposalLog) {
        return ProposalLogUtils.getProposalLogMergedStatusCode().equals(proposalLog.getLogStatus());
    }

}
