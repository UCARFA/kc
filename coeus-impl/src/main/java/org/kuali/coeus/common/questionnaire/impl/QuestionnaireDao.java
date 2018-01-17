/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.questionnaire.impl;

import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;

import java.util.List;

/**
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public interface QuestionnaireDao {

    /**
     * Retrieve the sequence number for the questionnaire that is current.
     *
     * @param questionnaireSeqId the id of a specific questionnaire
     * @return the current sequence number for the questionnaire, null if not found
     */
    public Integer getCurrentQuestionnaireSequenceNumber(String questionnaireSeqId);

    public List<AnswerHeader> getQuestionnaireAnswers(String moduleCode, String moduleItemKey, String moduleSubItemKey);

    }
