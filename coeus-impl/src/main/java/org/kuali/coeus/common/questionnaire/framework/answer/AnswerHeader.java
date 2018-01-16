/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.answer;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.common.questionnaire.framework.core.Questionnaire;
import org.kuali.coeus.common.questionnaire.framework.question.QuestionDTO;
import org.kuali.coeus.common.questionnaire.api.answer.AnswerHeaderContract;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.mo.common.active.Inactivatable;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds additional information related to a series of {@link org.kuali.coeus.common.questionnaire.framework.answer.Answer Answers}.
 */
public class AnswerHeader extends KcPersistableBusinessObjectBase implements Inactivatable, AnswerHeaderContract {

    private static final long serialVersionUID = 1L;

    private static final String NOT_SHOW_ANSWER = "N";

    private Long id;

    private String moduleItemCode;

    private String moduleItemKey;

    private String moduleSubItemCode;

    private String moduleSubItemKey;

    private Long questionnaireId;

    private boolean completed = false;

    private Questionnaire questionnaire;

    private List<Answer> answers;
    
    private List<QuestionDTO> questions;

    // Transient properties for questionnaire answer   
    private boolean newerVersionPublished = false;

    private String updateOption;

    private String showQuestions;
    
    private boolean hasVisibleQuestion = true;

    private boolean notUpdated = false;

    private boolean activeQuestionnaire = true;
    
    private String label;

    private transient QuestionnaireAnswerService questionnaireAnswerService;

    public AnswerHeader() {
        super();
        showQuestions = NOT_SHOW_ANSWER;
    }

    public AnswerHeader(ModuleQuestionnaireBean moduleQuestionnaireBean, Long questionnaireId) {
        this.moduleItemCode = moduleQuestionnaireBean.getModuleItemCode();
        this.moduleSubItemCode = moduleQuestionnaireBean.getModuleSubItemCode();
        this.moduleItemKey = moduleQuestionnaireBean.getModuleItemKey();
        this.moduleSubItemKey = moduleQuestionnaireBean.getModuleSubItemKey();
        this.questionnaireId = questionnaireId;
        answers = new ArrayList<Answer>();
        questions = new ArrayList<QuestionDTO>();
        showQuestions = NOT_SHOW_ANSWER;
    }

    public void setNewModuleQuestionnaireBeanReferenceData(ModuleQuestionnaireBean newModuleQuestionnaireBean) {
        this.moduleItemCode = newModuleQuestionnaireBean.getModuleItemCode();
        this.moduleItemKey = newModuleQuestionnaireBean.getModuleItemKey();
        this.moduleSubItemCode = newModuleQuestionnaireBean.getModuleSubItemCode();
        this.moduleSubItemKey = newModuleQuestionnaireBean.getModuleSubItemKey();
    }

    @Override
    public String getModuleItemCode() {
        return this.moduleItemCode;
    }

    public void setModuleItemCode(String moduleItemCode) {
        this.moduleItemCode = moduleItemCode;
    }

    @Override
    public String getModuleItemKey() {
        return this.moduleItemKey;
    }

    public void setModuleItemKey(String moduleItemKey) {
        this.moduleItemKey = moduleItemKey;
    }

    @Override
    public String getModuleSubItemCode() {
        return this.moduleSubItemCode;
    }

    public void setModuleSubItemCode(String moduleSubItemCode) {
        this.moduleSubItemCode = moduleSubItemCode;
    }

    @Override
    public String getModuleSubItemKey() {
        return this.moduleSubItemKey;
    }

    public void setModuleSubItemKey(String moduleSubItemKey) {
        this.moduleSubItemKey = moduleSubItemKey;
    }

    @Override
    public Long getQuestionnaireId() {
        return this.questionnaireId;
    }

    public void setQuestionnaireId(Long questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public List<Answer> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNewerVersionPublished() {
        return newerVersionPublished;
    }

    public void setNewerVersionPublished(boolean newerVersionPublished) {
        this.newerVersionPublished = newerVersionPublished;
    }

    public String getUpdateOption() {
        return updateOption;
    }

    public void setUpdateOption(String updateOption) {
        this.updateOption = updateOption;
    }

    public String getShowQuestions() {
        return showQuestions;
    }

    public void setShowQuestions(String showQuestions) {
        this.showQuestions = showQuestions;
    }

    public boolean isNotUpdated() {
        return notUpdated;
    }

    public void setNotUpdated(boolean notUpdated) {
        this.notUpdated = notUpdated;
    }

    public boolean isActiveQuestionnaire() {
        return activeQuestionnaire;
    }

    public void setActiveQuestionnaire(boolean activeQuestionnaire) {
        this.activeQuestionnaire = activeQuestionnaire;
    }

    /**
     * 
     * This method programatically checks to make sure all the answers have a value in the answer string.
     * @return
     */
    public boolean getAllQuestionsAnswered() {
        for (Answer answer : getAnswers()) {
            if (StringUtils.isEmpty(answer.getAnswer())) {
                return false;
            }
        }
        return true;
    }

    public boolean isHasVisibleQuestion() {
        return hasVisibleQuestion;
    }

    public void setHasVisibleQuestion(boolean hasVisibleQuestion) {
        this.hasVisibleQuestion = hasVisibleQuestion;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public boolean isActive() {
        return this.activeQuestionnaire && this.hasVisibleQuestion;
    }

    public boolean isQuestionnaireMandatory() {
        Integer questionniareSeqId = this.getQuestionnaire().getQuestionnaireSeqIdAsInteger();
        String coeusModuleCode = this.getModuleItemCode();
        String coeusSubModuleCode = this.getModuleSubItemCode();
        return getQuestionnaireAnswerService().checkIfQuestionnaireIsMandatoryForModule(questionniareSeqId, coeusModuleCode, coeusSubModuleCode);
    }

    public QuestionnaireAnswerService getQuestionnaireAnswerService() {
        if (questionnaireAnswerService == null) {
            questionnaireAnswerService = KcServiceLocator.getService(QuestionnaireAnswerService.class);
        }
        return questionnaireAnswerService;
    }

    protected void setQuestionnaireAnswerService(QuestionnaireAnswerService questionnaireAnswerService) {
        this.questionnaireAnswerService = questionnaireAnswerService;
    }
}
