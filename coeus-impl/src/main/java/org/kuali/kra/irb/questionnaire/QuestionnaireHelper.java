/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.amendrenew.ProtocolModule;
import org.kuali.kra.irb.auth.ProtocolTask;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolFinderDao;
import org.kuali.kra.protocol.ProtocolFormBase;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;
import org.kuali.kra.protocol.questionnaire.QuestionnaireHelperBase;

/**
 * 
 * This is Helper class for protocol questionnaire.
 */
public class QuestionnaireHelper extends QuestionnaireHelperBase {



    private static final long serialVersionUID = -8923292365833681926L;

    public QuestionnaireHelper(ProtocolFormBase form) {
        super(form);
    }

    @Override
    protected ProtocolTaskBase getModifyQnnrTaskHook(ProtocolBase protocol) {
        return new ProtocolTask(TaskName.ANSWER_PROTOCOL_QUESTIONNAIRE, (Protocol)protocol);
    }

    @Override
    public String getModuleCode() {
        return CoeusModule.IRB_MODULE_CODE;
    }

    @Override
    protected ProtocolModuleQuestionnaireBeanBase getProtocolModuleQuestionnaireBeanHook(ProtocolBase protocol) {
        return new ProtocolModuleQuestionnaireBean((Protocol) protocol);
    }

    @Override
    protected Class<? extends ProtocolFinderDao> getProtocolFinderDaoClassHook() {
        return org.kuali.kra.irb.ProtocolFinderDao.class;
    }

    @Override
    protected String getProtocolModuleCodeForQuestionnaireHook() {
        return ProtocolModule.QUESTIONNAIRE;
    }
}
