/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.auth.CoiDisclosureTask;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireHelperBase;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

public class DisclosureQuestionnaireHelper extends QuestionnaireHelperBase {


    private static final long serialVersionUID = -8685872555239368202L;
    
    private CoiDisclosure coiDisclosure;
    private boolean questionnairesLoaded;
    
    public DisclosureQuestionnaireHelper(CoiDisclosure coiDisclosure) {
        this.setAnswerHeaders(new ArrayList<AnswerHeader>());
        this.coiDisclosure = coiDisclosure;
    }

    @Override
    public String getModuleCode() {
        return CoeusModule.COI_DISCLOSURE_MODULE_CODE;
    }

    @Override
    public ModuleQuestionnaireBean getModuleQnBean() {
        return new DisclosureModuleQuestionnaireBean(getCoiDisclosure());
    }
    
    
    public void prepareView(boolean reload) {
        initializePermissions(getCoiDisclosure());
        this.populateQuestionnaires(reload);
    }
    
    /*
     * authorization check.
     */
    protected void initializePermissions(CoiDisclosure CoiDisclosure) {
        CoiDisclosureTask task = new CoiDisclosureTask(TaskName.ANSWER_COI_DISCLOSURE_QUESTIONNAIRE, CoiDisclosure);
        setAnswerQuestionnaire(getTaskAuthorizationService().isAuthorized(getUserIdentifier(), task));
    }
    
    
    protected void populateQuestionnaires(boolean reload) {
        boolean refreshed = false;
        if(!questionnairesLoaded || reload) {
            populateAnswers();
            refreshed = true;
        } 
        // have to update the child indicator, otherwise, the questionnaire may be hidden
        if (!refreshed && !CollectionUtils.isEmpty(this.getAnswerHeaders())) {
            for (AnswerHeader answerHeader : this.getAnswerHeaders()) {
                    getQuestionnaireAnswerService().setupChildAnswerIndicator(answerHeader);
                }

        }
    }
    
    @Override
    public void populateAnswers() {
        super.populateAnswers();
        questionnairesLoaded = true;
    }
    
    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }
    
    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }
    
    @Override
    public void preSave() {
        for (AnswerHeader answerHeader : this.getAnswerHeaders()) {
            answerHeader.setModuleItemKey(getCoiDisclosure().getCoiDisclosureId().toString());
        }
        super.preSave();
    }
}
