/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireQuestion;
import org.kuali.coeus.common.questionnaire.framework.answer.Answer;

public class QuestionDTO implements Serializable {

    private static final long serialVersionUID = 1493906565877782493L;
    
    private List<Answer> answers;
    private QuestionnaireQuestion questionnaireQuestion;
    private boolean isChildMatched;
    private boolean isRuleMatched;
    private List<Answer> parentAnswers;
    
    public QuestionDTO(QuestionnaireQuestion questionnaireQuestion) {
        this.questionnaireQuestion = questionnaireQuestion;
        this.answers = new ArrayList<Answer>();
        this.parentAnswers = new ArrayList<Answer>();
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public QuestionnaireQuestion getQuestionnaireQuestion() {
        return questionnaireQuestion;
    }
    public void setQuestionnaireQuestion(QuestionnaireQuestion questionnaireQuestion) {
        this.questionnaireQuestion = questionnaireQuestion;
    }

    public boolean isChildMatched() {
        return isChildMatched;
    }

    public void setChildMatched(boolean isChildMatched) {
        this.isChildMatched = isChildMatched;
    }

    public boolean isRuleMatched() {
        return isRuleMatched;
    }

    public void setRuleMatched(boolean isRuleMatched) {
        this.isRuleMatched = isRuleMatched;
    }

    public List<Answer> getParentAnswers() {
        return parentAnswers;
    }

    public void setParentAnswers(List<Answer> parentAnswers) {
        this.parentAnswers = parentAnswers;
    }
    
    
}
