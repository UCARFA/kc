/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireHelperBase;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;

public class ProposalDevelopmentQuestionnaireHelper extends QuestionnaireHelperBase {

    private static final long serialVersionUID = 8595107639632039291L;

    private ProposalDevelopmentDocumentForm proposalDevelopmentDocumentForm;
    private ProposalDevelopmentDocument document;

    public ProposalDevelopmentQuestionnaireHelper(ProposalDevelopmentDocumentForm form) {
        this.proposalDevelopmentDocumentForm = form;
        this.document = form.getProposalDevelopmentDocument();
    }
    
    public ProposalDevelopmentQuestionnaireHelper(ProposalDevelopmentDocument document) {
        this.document = document;
    }
    
    @Override
    public String getModuleCode() {
        return CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE;
    }

    @Override
    public ModuleQuestionnaireBean getModuleQnBean() {
        return new ProposalDevelopmentModuleQuestionnaireBean(document.getDevelopmentProposal());
    }

    protected ProposalDevelopmentDocument getDocument() {
        return document;
    }

    public void setDocument(ProposalDevelopmentDocument document) {
        this.document = document;
    }

    public ProposalDevelopmentDocumentForm getProposalDevelopmentDocumentForm() {
        return proposalDevelopmentDocumentForm;
    }

    public void setProposalDevelopmentForm(ProposalDevelopmentDocumentForm proposalDevelopmentDocumentForm) {
        this.proposalDevelopmentDocumentForm = proposalDevelopmentDocumentForm;
    }
}
