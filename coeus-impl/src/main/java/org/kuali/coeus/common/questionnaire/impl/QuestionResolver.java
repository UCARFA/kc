/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl;

import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.common.questionnaire.framework.answer.Answer;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.rice.krms.api.engine.TermResolver;

import java.util.*;

public class QuestionResolver implements TermResolver<Object> {

    public static final String QUESTIONNAIRE_SEQ_ID = "Questionnaire Seq ID";
    public static final String QUESTION_SEQ_ID = "Question Seq ID";
    private String outputName;
    private Set<String> prereqs;
    private Set<String> params;
    private QuestionnaireDao questionnaireDao;
    
    public QuestionResolver(String outputName, Set<String> params) {
        this.outputName = outputName;
        this.prereqs = new HashSet<>();
        prereqs.add(QuestionnaireConstants.MODULE_CODE);
        prereqs.add(QuestionnaireConstants.MODULE_ITEM_KEY);
        prereqs.add(QuestionnaireConstants.MODULE_SUB_ITEM_KEY);
        if (params == null) {
            this.params = Collections.emptySet(); 
        } else {
            this.params = params;
        }
    }
    
    @Override
    public int getCost() { return 1; }
    
    @Override
    public String getOutput() { return outputName; }
    
    @Override
    public Set<String> getPrerequisites() {
        return this.prereqs;
    }
    
    @Override
    public Set<String> getParameterNames() {
        return params;
    }
    
    @Override
    public String resolve(Map<String, Object> resolvedPrereqs, Map<String, String> parameters) {
        String questionnaireId = parameters.get(QUESTIONNAIRE_SEQ_ID);
        String questionId = parameters.get(QUESTION_SEQ_ID);
        String moduleCode = (String) resolvedPrereqs.get(QuestionnaireConstants.MODULE_CODE);
        String moduleItemKey = (String) resolvedPrereqs.get(QuestionnaireConstants.MODULE_ITEM_KEY);
        String moduleSubItemKey = resolvedPrereqs.get(QuestionnaireConstants.MODULE_SUB_ITEM_KEY).toString();
        List<AnswerHeader> answerHeaders = getQuestionnaireDao().getQuestionnaireAnswers(moduleCode, moduleItemKey, moduleSubItemKey);
        for (AnswerHeader answerHeader : getLatestAnswerVersions(answerHeaders)) {
            if (answerHeader.getQuestionnaire().getQuestionnaireSeqId().equals(questionnaireId)) {
                for (Answer answer : answerHeader.getAnswers()) {
                    if (String.valueOf(answer.getQuestion().getQuestionSeqId()).equals(questionId)) {
                        return answer.getAnswer();
                    }
                }
            }
        }
        return "";
    }

    protected Collection<AnswerHeader> getLatestAnswerVersions(List<AnswerHeader> allAnswerHeaders) {
        Map<String, AnswerHeader> latestAnswerHeaders = new HashMap<>();
        for (AnswerHeader header : allAnswerHeaders) {
            AnswerHeader compHeader = latestAnswerHeaders.get(header.getQuestionnaire().getQuestionnaireSeqId());
            if (compHeader == null || header.getQuestionnaire().getSequenceNumber() > compHeader.getQuestionnaire().getSequenceNumber()) {
                latestAnswerHeaders.put(header.getQuestionnaire().getQuestionnaireSeqId(), header);
            }
        }
        return latestAnswerHeaders.values();
    }

    public QuestionnaireDao getQuestionnaireDao() {
        if (questionnaireDao == null) {
            questionnaireDao = KcServiceLocator.getService(QuestionnaireDao.class);
        }
        return questionnaireDao;
    }

}
