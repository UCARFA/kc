/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.core;

import org.kuali.coeus.common.questionnaire.api.core.QuestionnaireQuestionContract;
import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.questionnaire.framework.question.Question;

public class QuestionnaireQuestion extends KcPersistableBusinessObjectBase implements SequenceAssociate<Questionnaire>, QuestionnaireQuestionContract {

    private static final long serialVersionUID = 1699439856326521334L;

    private Long id;

    private Long questionnaireId;

    private Long questionId;

    private Integer questionNumber;

    private Integer parentQuestionNumber;

    private boolean conditionFlag;

    private String condition;

    private String conditionValue;

    private Integer questionSeqNumber;

    private String ruleId;

    @Override
    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    private Question question;

    private Questionnaire questionnaire;

    private Questionnaire sequenceOwner;

    private String deleted;
    private boolean isAllow; 

    public QuestionnaireQuestion() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    @Override
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Override
    public Integer getParentQuestionNumber() {
        return parentQuestionNumber;
    }

    public void setParentQuestionNumber(Integer parentQuestionNumber) {
        this.parentQuestionNumber = parentQuestionNumber;
    }

    @Override
    public boolean getConditionFlag() {
        return conditionFlag;
    }

    public void setConditionFlag(boolean conditionFlag) {
        this.conditionFlag = conditionFlag;
    }

    @Override
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    @Override
    public Integer getQuestionSeqNumber() {
        return questionSeqNumber;
    }

    public void setQuestionSeqNumber(Integer questionSeqNumber) {
        this.questionSeqNumber = questionSeqNumber;
    }

    @Override
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @Override
    public Questionnaire getSequenceOwner() {
        return this.getQuestionnaire();
    }

    @Override
    public void setSequenceOwner(Questionnaire newlyVersionedOwner) {
        setQuestionnaire(newlyVersionedOwner);
    }

    @Override
    public void resetPersistenceState() {
        this.setId(null);
    }

    @Override
    public Integer getSequenceNumber() {
        return this.sequenceOwner.getSequenceNumber();
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public boolean isAllow() {
        return isAllow;
    }
    
    public void setAllow(boolean isAllow) {
        this.isAllow = isAllow;
    }
    
}
