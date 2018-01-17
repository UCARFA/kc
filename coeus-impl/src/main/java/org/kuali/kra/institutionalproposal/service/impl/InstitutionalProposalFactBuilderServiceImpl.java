/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.service.impl;

import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.Facts.Builder;

public class InstitutionalProposalFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {
    private DocumentService documentService;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
        String documentNumber = getElementValue(docContent, "//documentNumber");
        try {
            InstitutionalProposalDocument institutionalProposalDocument = (InstitutionalProposalDocument)getDocumentService().getByDocumentHeaderId(documentNumber);
            addFacts(factsBuilder, institutionalProposalDocument);
        }catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, KrmsRulesContext document) {
        InstitutionalProposalDocument institutionalProposalDocument = (InstitutionalProposalDocument)document;
        InstitutionalProposal institutionalProposal = institutionalProposalDocument.getInstitutionalProposal();
        addProposalFacts(factsBuilder,institutionalProposal);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_CODE, CoeusModule.INSTITUTIONAL_PROPOSAL_MODULE_CODE);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_ITEM_KEY, institutionalProposal.getProposalNumber());
        factsBuilder.addFact(QuestionnaireConstants.MODULE_SUB_ITEM_KEY, institutionalProposal.getSequenceNumber());
    }
    
    private void addProposalFacts(Builder factsBuilder, InstitutionalProposal institutionalProposal) {
        addObjectMembersAsFacts(factsBuilder,institutionalProposal,KcKrmsConstants.InstitutionalProposal.INSTITUTIONAL_PROPOSAL_CONTEXT_ID,Constants.MODULE_NAMESPACE_INSITUTIONAL_PROPOSAL);
        factsBuilder.addFact(KcKrmsConstants.InstitutionalProposal.INSTITUTIONAL_PROPOSAL, institutionalProposal);
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

}
