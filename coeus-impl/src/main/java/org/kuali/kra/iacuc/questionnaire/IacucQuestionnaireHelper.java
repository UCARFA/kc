/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.questionnaire;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolFinderDao;
import org.kuali.kra.iacuc.actions.amendrenew.IacucProtocolModule;
import org.kuali.kra.iacuc.auth.IacucProtocolTask;
import org.kuali.kra.infrastructure.TaskName;
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
public class IacucQuestionnaireHelper extends QuestionnaireHelperBase {

    private static final long serialVersionUID = -7998778375503716988L;

    /**
     * 
     * Constructs an IacucProtocolQuestionnaireHelper.java. To hook up with protocol form.
     * @param form
     */
    public IacucQuestionnaireHelper(ProtocolFormBase form) {
        super(form);
    }

    /*
     * authorization check.
     */
    @Override
    protected ProtocolTaskBase getModifyQnnrTaskHook(ProtocolBase protocol) {
        return new IacucProtocolTask(TaskName.MODIFY_IACUC_PROTOCOL_QUESTIONNAIRE, (IacucProtocol)protocol);
    }
    
    @Override
    public String getModuleCode() {
        return CoeusModule.IACUC_PROTOCOL_MODULE_CODE;
    }

    @Override
    protected ProtocolModuleQuestionnaireBeanBase getProtocolModuleQuestionnaireBeanHook(ProtocolBase protocol) {
        return new IacucProtocolModuleQuestionnaireBean((IacucProtocol) protocol);
    }

    @Override
    protected String getProtocolModuleCodeForQuestionnaireHook() {
        return IacucProtocolModule.QUESTIONNAIRE;
    }

    @Override
    protected Class<? extends ProtocolFinderDao> getProtocolFinderDaoClassHook() {
        return IacucProtocolFinderDao.class;
    }

}
