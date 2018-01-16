/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.questionnaire;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.rice.krad.document.Document;

import java.util.List;


public class SaveProtocolQuestionnaireEvent extends KcDocumentEventBaseExtension {
    private List<AnswerHeader> answerHeaders;

    public SaveProtocolQuestionnaireEvent(Document document, List<AnswerHeader> answerHeaders) {
        super("Saving ProtocolBase Questionnaires (and answers) to document" + getDocumentId(document), Constants.EMPTY_STRING, document);        
        this.answerHeaders = answerHeaders;
    }

    @Override
    public SaveProtocolQuestionnaireRule getRule() {
        return new SaveProtocolQuestionnaireRule();
    }
    
    public List<AnswerHeader> getAnswerHeaders() {
        return answerHeaders;
    }

}
