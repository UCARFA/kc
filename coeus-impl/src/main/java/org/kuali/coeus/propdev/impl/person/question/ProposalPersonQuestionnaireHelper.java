/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.question;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireHelperBase;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireService;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;


public class ProposalPersonQuestionnaireHelper extends QuestionnaireHelperBase {


    private static final long serialVersionUID = -5090730280279711495L;
    
    private transient ProposalPerson proposalPerson;
    
    private transient QuestionnaireService questionnaireService;

    public ProposalPersonQuestionnaireHelper(ProposalPerson proposalPerson) {
        this.setProposalPerson(proposalPerson);
    }
    
    
    public ProposalPerson getProposalPerson() {
        return proposalPerson;
    }


    public void setProposalPerson(ProposalPerson proposalPerson) {
        this.proposalPerson = proposalPerson;
    }

    @Override
    public ModuleQuestionnaireBean getModuleQnBean() {
        return new ProposalPersonModuleQuestionnaireBean(getProposalPerson().getDevelopmentProposal(), getProposalPerson());
    }

    @Override
    public String getModuleCode() {
        return CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE;
    }
    public String getNamespaceCd() {
        return Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT;
    }
    
    @Override
    public void populateAnswers() {
        super.populateAnswers();
        if (getAnswerHeaders().size() > 1) {
            //if we have more than 1 questionnaire make sure the first one is the one with the current usage.
            AnswerHeader mostCurrentHeader = getAnswerHeaders().get(0);
            for (AnswerHeader header : getAnswerHeaders()) {
                //should only be 1 header that is the current questionnaire and has the usage for certification
                if (getQuestionnaireService().isCurrentQuestionnaire(header.getQuestionnaire()) &&
                        header.getQuestionnaire().hasUsageFor(getModuleCode(), CoeusSubModule.PROPOSAL_PERSON_CERTIFICATION)) {
                    mostCurrentHeader = header;
                }
            }
            getAnswerHeaders().remove(mostCurrentHeader);
            getAnswerHeaders().add(0, mostCurrentHeader);
        }
    }


    protected QuestionnaireService getQuestionnaireService() {
        if (questionnaireService == null) {
            questionnaireService = KcServiceLocator.getService(QuestionnaireService.class);
        }
        return questionnaireService;
    }


    public void setQuestionnaireService(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }
}
