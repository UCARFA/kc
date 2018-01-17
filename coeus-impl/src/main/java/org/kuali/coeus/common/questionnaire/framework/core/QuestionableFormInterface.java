/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.core;

/**
 * 
 * This class determines what functions must be present on a form that uses questionnaire.
 * KraTransactionalFormBase.populateFalseCheckboxes will call these function to determine if a field is
 * associated with a questionnaire answer field.
 */
public interface QuestionableFormInterface {
    public static final String DEFAULT_MIDDLE = "].answers[";
    public static final String DEFAULT_END = "].answer";
    
    public String getQuestionnaireFieldStarter();
    public String getQuestionnaireFieldMiddle();
    public String getQuestionnaireFieldEnd();
    public String getQuestionnaireExpression();
}
