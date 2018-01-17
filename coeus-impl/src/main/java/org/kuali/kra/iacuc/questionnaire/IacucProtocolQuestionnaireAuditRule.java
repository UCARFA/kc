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
import org.kuali.kra.iacuc.actions.amendrenew.IacucProtocolModule;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;
import org.kuali.kra.protocol.questionnaire.ProtocolQuestionnaireAuditRuleBase;

public class IacucProtocolQuestionnaireAuditRule extends ProtocolQuestionnaireAuditRuleBase {
    
    @Override
    protected String getModuleCodeHook() {
        return CoeusModule.IACUC_PROTOCOL_MODULE_CODE;
    }

    @Override
    protected ProtocolModuleQuestionnaireBeanBase getProtocolModuleQuestionnaireBean(ProtocolBase protocol) {
        return new IacucProtocolModuleQuestionnaireBean((IacucProtocol) protocol);
    }

    @Override
    protected ProtocolModuleQuestionnaireBeanBase getProtocolModuleQuestionnaireBean(String moduleItemCode, String moduleItemKey, String moduleSubItemCode, String moduleSubItemKey, boolean finalDoc) {
        return new IacucProtocolModuleQuestionnaireBean(moduleItemCode, moduleItemKey, moduleSubItemCode, moduleSubItemKey, finalDoc);
    }

    @Override
    protected String getQuestionnaireModuleCodeHook() {
        return IacucProtocolModule.QUESTIONNAIRE;
    }

}
