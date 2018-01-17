/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.personfinancialentity.FinancialEntityService;
import org.kuali.kra.coi.personfinancialentity.PersonFinIntDisclosure;
import org.kuali.kra.coi.questionnaire.DisclosureModuleQuestionnaireBean;
import org.kuali.kra.coi.service.CoiJavaFunctionKrmsTermService;
import org.kuali.coeus.common.impl.krms.KcKrmsJavaFunctionTermServiceBase;
import org.kuali.coeus.common.questionnaire.framework.answer.Answer;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.QuestionnaireAnswerService;

import java.util.List;

public class CoiJavaFunctionKrmsTermServiceImpl extends KcKrmsJavaFunctionTermServiceBase implements CoiJavaFunctionKrmsTermService {

    private QuestionnaireAnswerService questionnaireAnswerService;
    private FinancialEntityService financialEntityService;

    @Override
    public Integer getScreeningQuestionYesAnswerCount(CoiDisclosure coiDisclosure) {
        List<AnswerHeader> answerHeaders = getQuestionnaireAnswerService().getQuestionnaireAnswer(new DisclosureModuleQuestionnaireBean(coiDisclosure, CoeusSubModule.COI_SCREENING_SUBMODULE));
        int count = 0;
        for (AnswerHeader answerHeader : answerHeaders) {
            for (Answer answer : answerHeader.getAnswers()) {
                if (StringUtils.equalsIgnoreCase(answer.getAnswer(), "Y")) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Integer getReporterActiveFinancialEntityCount(CoiDisclosure coiDisclosure) {
        String personId = coiDisclosure.getPersonId();
        List<PersonFinIntDisclosure> finEnts = getFinancialEntityService().getFinancialEntities(personId, true);
        return finEnts != null ? finEnts.size() : 0;
    }
    
    public QuestionnaireAnswerService getQuestionnaireAnswerService() {
        return questionnaireAnswerService;
    }

    public void setQuestionnaireAnswerService(QuestionnaireAnswerService questionnaireAnswerService) {
        this.questionnaireAnswerService = questionnaireAnswerService;
    }

    public FinancialEntityService getFinancialEntityService() {
        return financialEntityService;
    }

    public void setFinancialEntityService(FinancialEntityService financialEntityService) {
        this.financialEntityService = financialEntityService;
    }
}
