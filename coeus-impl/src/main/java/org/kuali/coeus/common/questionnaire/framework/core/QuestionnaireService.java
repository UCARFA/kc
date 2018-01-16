/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.framework.core;

import java.util.List;

public interface QuestionnaireService {

    /**
     * 
     * This method is called to copy the source questionnaire to target questionnaire and save to DB
     * @param src : source questionnaire
     * @param dest : target questionnaire
     */
    public void copyQuestionnaire(Questionnaire src, Questionnaire dest);
    /**
     * 
     * This method is to check whether questionnaire name has been used
     * @param questionnaireId
     * @param name
     * @return
     */
    public boolean isQuestionnaireNameExist(String questionnaireId, String name);
    /**
     * 
     * This method the modules code that the user has permission to associate to questionnaire
     * @return
     */
    public  List<String>  getAssociateModules();
    
    /**
     * Returns true if the usage passed in is unique. Determined by checking for matching coeus module and coeus sub module codes.
     * @param usage
     * @return
     */
    public boolean isUniqueUsage(Questionnaire questionnaire, QuestionnaireUsage usage);
    
    /**
     * Returns true of the questionnaire is the newest version of the questionnaire.
     * @param questionnaire
     * @return
     */
    public boolean isCurrentQuestionnaire(Questionnaire questionnaire);

}
