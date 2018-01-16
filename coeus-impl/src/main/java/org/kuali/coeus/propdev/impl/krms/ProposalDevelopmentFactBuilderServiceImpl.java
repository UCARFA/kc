/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.krms;

import org.kuali.coeus.common.framework.krms.KrmsRulesContext;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.krms.KcKrmsConstants;
import org.kuali.coeus.common.impl.krms.KcKrmsFactBuilderServiceHelper;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.propdev.impl.attachment.Narrative;
import org.kuali.rice.core.api.exception.RiceRuntimeException;
import org.kuali.rice.core.api.util.xml.XmlHelper;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.rule.xmlrouting.XPathHelper;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krms.api.engine.Facts;
import org.kuali.rice.krms.api.engine.Facts.Builder;
import org.w3c.dom.Document;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("proposalDevelopmentFactBuilderService")
public class ProposalDevelopmentFactBuilderServiceImpl extends KcKrmsFactBuilderServiceHelper {

    private static final String COMPLETE = "C";
    public static final String DOCUMENT_NUMBER = "//document/documentNumber";
    @Autowired
	@Qualifier("documentService")
	private DocumentService documentService;
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, String docContent) {
        String documentNumber = getElementValue(docContent, DOCUMENT_NUMBER);
        try {
            ProposalDevelopmentDocument proposalDevelopmentDocument = (ProposalDevelopmentDocument)getDocumentService().getByDocumentHeaderId(documentNumber);
            addFacts(factsBuilder, proposalDevelopmentDocument);
        }catch (WorkflowException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void addFacts(Facts.Builder factsBuilder, KrmsRulesContext document) {
        ProposalDevelopmentDocument proposalDevelopmentDocument = (ProposalDevelopmentDocument)document;
        DevelopmentProposal developmentProposal = proposalDevelopmentDocument.getDevelopmentProposal();
        addBudgetFacts(factsBuilder,proposalDevelopmentDocument);
        addProposalFacts(factsBuilder,developmentProposal);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_CODE, CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE);
        factsBuilder.addFact(QuestionnaireConstants.MODULE_ITEM_KEY, developmentProposal.getProposalNumber());
        factsBuilder.addFact(QuestionnaireConstants.MODULE_SUB_ITEM_KEY, 0);
    }
    
    private void addBudgetFacts(Builder factsBuilder, ProposalDevelopmentDocument proposalDevelopmentDocument) {
        Budget budget =  proposalDevelopmentDocument.getDevelopmentProposal().getFinalBudget();
        addObjectMembersAsFacts(factsBuilder,budget,KcKrmsConstants.ProposalDevelopment.PROPOSAL_DEVELOPMENT_CONTEXT_ID,
                                Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT);
    }
    
    private void addProposalFacts(Builder factsBuilder, DevelopmentProposal developmentProposal) {
        addObjectMembersAsFacts(factsBuilder,developmentProposal,KcKrmsConstants.ProposalDevelopment.PROPOSAL_DEVELOPMENT_CONTEXT_ID,
                                Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT);
        factsBuilder.addFact(KcKrmsConstants.ProposalDevelopment.DEVELOPMENT_PROPOSAL, developmentProposal);
        factsBuilder.addFact(KcKrmsConstants.ProposalDevelopment.PROPOSAL_NARRATIVES_COMPLETE, isProposalNarrativesComplete(developmentProposal));
    }
    
    
    protected boolean isProposalNarrativesComplete(DevelopmentProposal developmentProposal) {
        for (Narrative narrative : developmentProposal.getNarratives()) {
            if (narrative.getNarrativeStatus() != null && !COMPLETE.equals(narrative.getNarrativeStatus().getCode())) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected String getElementValue(String docContent, String xpathExpression) {
        try (InputStream stream = new ByteArrayInputStream(docContent.getBytes())) {
            Document document = XmlHelper.trimXml(stream);
            XPath xpath = XPathHelper.newXPath();

            return (String) xpath.evaluate(xpathExpression, document, XPathConstants.STRING);
        } catch (Exception e) {
            throw new RiceRuntimeException();
        }
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
}
