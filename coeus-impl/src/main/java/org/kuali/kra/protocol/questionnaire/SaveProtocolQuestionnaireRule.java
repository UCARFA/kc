/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.questionnaire;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;

public class SaveProtocolQuestionnaireRule  implements KcBusinessRule<SaveProtocolQuestionnaireEvent> {
    private final ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
    

    @Override
    public boolean processRules(SaveProtocolQuestionnaireEvent event) {
        boolean valid = true;
        // check if any of the answer headers from the event has the "not updated" flag set 
        int answerHeaderIndex = 0;
        for(AnswerHeader header: event.getAnswerHeaders()) {
            if(header.isNotUpdated()){
                valid = false;
                String propertyName = "questionnaireHelper.answerHeaders[" + answerHeaderIndex + "]";
                errorReporter.reportError(propertyName, KeyConstants.ERROR_QUESTIONNAIRE_NOT_UPDATED);
            }            
            answerHeaderIndex++;
        }
        return valid;
    }

}
