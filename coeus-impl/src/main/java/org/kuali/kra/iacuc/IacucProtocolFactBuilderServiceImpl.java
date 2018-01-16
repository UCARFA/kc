/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc;


import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;

public class IacucProtocolFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {

    private DocumentService documentService;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
        String documentNumber = getElementValue(docContent, "//documentNumber");
        try {
            IacucProtocolDocument protocolDocument = (IacucProtocolDocument) getDocumentService().getByDocumentHeaderId(documentNumber);
            addFacts(factsBuilder, protocolDocument);
        }catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addFacts(Facts.Builder factsBuilder, KrmsRulesContext document) {
        IacucProtocolDocument  protocolDocument = (IacucProtocolDocument)document;
        IacucProtocol protocol = protocolDocument.getIacucProtocol();
        addObjectMembersAsFacts(factsBuilder,protocol,KcKrmsConstants.IacucProtocol.IACUC_PROTOCOL_CONTEXT_ID,Constants.MODULE_NAMESPACE_IACUC);
        factsBuilder.addFact(KcKrmsConstants.IacucProtocol.IACUC_PROTOCOL, protocol);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_CODE, CoeusModule.IACUC_PROTOCOL_MODULE_CODE);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_ITEM_KEY, protocol.getProtocolNumber());
        factsBuilder.addFact(QuestionnaireConstants.MODULE_SUB_ITEM_KEY, protocol.getSequenceNumber());
    }

    /**
     * Gets the documentService attribute. 
     * @return Returns the documentService.
     */
    public DocumentService getDocumentService() {
        return documentService;
    }

    /**
     * Sets the documentService attribute value.
     * @param documentService The documentService to set.
     */
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
}
