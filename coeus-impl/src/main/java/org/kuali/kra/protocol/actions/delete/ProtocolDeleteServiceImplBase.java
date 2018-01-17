/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.delete;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

public abstract class ProtocolDeleteServiceImplBase implements ProtocolDeleteService {

    private DocumentService documentService;
    private BusinessObjectService businessObjectService;
    private ProtocolOnlineReviewService protocolOnlineReviewService;
    
    private static final String DELETE_FINALIZE_OLR_ANNOTATION = "Online Review finalized as part of withdraw action on protocol.";

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
    /**
     * Set the business object service.
     * @param businessObjectService the business object service
     */
    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }

    /**
     * We never delete documents from the database.  Rather, we simply mark
     * it as deleted.
     * @throws WorkflowException
     * @param protocolDocument
     */
    @Override
    public void delete(ProtocolDocumentBase protocolDocument) throws WorkflowException {
        protocolDocument.getProtocol().setProtocolStatusCode(getDeletedProtocolStatusCodeHook());
        protocolDocument.getProtocol().setActive(false);
        businessObjectService.save(protocolDocument);
        
        /*
         * By marking the protocol document as canceled, the protocol
         * is removed from the user's action list.
         */
        documentService.cancelDocument(protocolDocument, null);
        protocolOnlineReviewService.finalizeOnlineReviews(protocolDocument.getProtocol().getProtocolSubmission(), DELETE_FINALIZE_OLR_ANNOTATION);
    
    }

    protected abstract String getDeletedProtocolStatusCodeHook();

    public ProtocolOnlineReviewService getProtocolOnlineReviewService() {
        return protocolOnlineReviewService;
    }

    public void setProtocolOnlineReviewService(ProtocolOnlineReviewService protocolOnlineReviewService) {
        this.protocolOnlineReviewService = protocolOnlineReviewService;
    }

}
