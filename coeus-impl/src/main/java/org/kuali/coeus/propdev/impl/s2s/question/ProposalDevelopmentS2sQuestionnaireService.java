/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.s2s.question;

import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireUsage;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;

import java.util.List;

/**
 * This service is responsible for getting the questionnaires and answer headers
 * for a proposal based on the proposals gg opportunity.
 * 
 */
public interface ProposalDevelopmentS2sQuestionnaireService {
    
    /**
     * Get AnswerHeaders for all of the questionnaires associated with the development proposals opportunity.
     * @param developmentProposal
     * @return
     */
    List<AnswerHeader> getProposalS2sAnswerHeaders(DevelopmentProposal developmentProposal);
    
    /**
     * Get the QuestionnaireUsage records that match a form.
     * @param oppNameSpace the nameSpace of the opportunity form
     * @param formName the name of the form
     * @return
     */
    List<QuestionnaireUsage> getQuestionnaireUsages(String oppNameSpace, String formName, DevelopmentProposal proposal);
    
    /**
     * Get the AnswerHeaders for a specific proposal's form. 
     * @param proposal  The proposal you are interested in
     * @param oppNameSpace the name space of the opportunity form
     * @param formName the name of the form
     * @return
     */
    List<AnswerHeader> getProposalAnswerHeaderForForm(DevelopmentProposal proposal, String oppNameSpace, String formName);
}
