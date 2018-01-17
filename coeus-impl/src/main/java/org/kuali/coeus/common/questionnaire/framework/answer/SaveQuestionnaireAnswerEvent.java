/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.answer;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.document.Document;

import java.util.List;

/**
 * Encapsulates the Save Questionnaire Answer event.
 */
public class SaveQuestionnaireAnswerEvent extends KcDocumentEventBaseExtension {

    private List<AnswerHeader> answerHeaders;
    private String formProperty = "questionnaireHelper";
    
    /**
     * Constructs a QuestionnaireAnswerEvent.
     * @param description
     * @param errorPathPrefix
     * @param document
     */
    public SaveQuestionnaireAnswerEvent(Document document, List<AnswerHeader> answerHeaders) {
        super("Saving QuestionnaireAnswer to document" + getDocumentId(document), Constants.EMPTY_STRING, document);
        
        this.answerHeaders = answerHeaders;
    }
    
    /**
     * Constructs a QuestionnaireAnswerEvent.
     * @param description
     * @param errorPathPrefix
     * @param document
     */
    public SaveQuestionnaireAnswerEvent(Document document, List<AnswerHeader> answerHeaders, String formProperty) {
        super("Saving QuestionnaireAnswer to document" + getDocumentId(document), Constants.EMPTY_STRING, document);
        this.formProperty = formProperty;
        this.answerHeaders = answerHeaders;
    }
    

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new SaveQuestionnaireAnswerRule();
    }
    
    public List<AnswerHeader> getAnswerHeaders() {
        return answerHeaders;
    }
    
    /**
     * Gets the formProperty attribute. 
     * @return Returns the formProperty.
     */
    public String getFormProperty() {
        return formProperty;
    }

    /**
     * Sets the formProperty attribute value.
     * @param formProperty The formProperty to set.
     */
    public void setFormProperty(String formProperty) {
        this.formProperty = formProperty;
    }



}
