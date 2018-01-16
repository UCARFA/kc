/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.question;

import org.kuali.coeus.common.questionnaire.framework.question.Question;

/**
 * The Question Service provides a set of methods for
 * working with questions.
 */
public interface QuestionService {

    /**
     * Retrieve a question from the database based upon its questionRefId.
     * @param questionId of the question
     * @return the question or null if not found
     */
    Question getQuestionByQuestionId(Long questionId);

    /**
     * Retrieve a question from the database based upon its questionId.
     * @param questionSeqId of the question
     * @return the most recent active question or null if not found
     */
    Question getQuestionByQuestionSequenceId(Integer questionSeqId);
    
    /**
     * Check if the question is used in a questionnaire.
     * @param questionId of the question
     * @return true if question is used in an active questionnaire, false otherwise
     */
    boolean isQuestionUsed(Integer questionId);

}
