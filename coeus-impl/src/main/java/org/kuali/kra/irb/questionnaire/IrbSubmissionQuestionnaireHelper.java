/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.questionnaire;


import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.questionnaire.ProtocolModuleQuestionnaireBeanBase;
import org.kuali.kra.protocol.questionnaire.ProtocolSubmissionQuestionnaireHelper;

public class IrbSubmissionQuestionnaireHelper extends ProtocolSubmissionQuestionnaireHelper {

    private static final long serialVersionUID = 4076949768477025326L;

    public IrbSubmissionQuestionnaireHelper(ProtocolBase protocol, String actionTypeCode, String submissionNumber, boolean readOnlyView) {
        super(protocol, actionTypeCode, submissionNumber, readOnlyView);
    }

    @Override
    public String getModuleCode() {
        return CoeusModule.IRB_MODULE_CODE;
    }

    @Override
    public ProtocolModuleQuestionnaireBeanBase getBaseProtocolModuleQuestionnaireBean(String sequenceNumber) {
        return new ProtocolModuleQuestionnaireBean(CoeusModule.IRB_MODULE_CODE, getProtocol().getProtocolNumber(), CoeusSubModule.ZERO_SUBMODULE, sequenceNumber, 
                getProtocol().getProtocolDocument().getDocumentHeader().getWorkflowDocument().isApproved());
    }

}
