/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.questionnaire.question;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.version.VersioningService;
import org.kuali.coeus.common.impl.version.VersioningServiceImpl;
import org.kuali.coeus.common.questionnaire.framework.question.Question;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;

import static org.junit.Assert.assertEquals;

public class QuestionVersioningTest extends KcIntegrationTestBase {
    
    private transient VersioningService versioningService;
    private Question originalQuestion;
    
    @Before
    public void setUp() {
        versioningService  = new VersioningServiceImpl();
        originalQuestion = createQuestion(1, "What is your first name?");        
    }

    @After
    public void tearDown() {
        versioningService = null;
        originalQuestion = null;
    }
    
    @Test 
    public void testQuestionVersioning() throws Exception {
        Question versionedQuestion = (Question) versioningService.createNewVersion(originalQuestion);

        verifyVersioning(originalQuestion, versionedQuestion);
    }
    
    private Question createQuestion(Integer questionId, String questionText) {
        Question question = new Question();
        question.setQuestionSeqId(questionId);
        question.setQuestion(questionText);
        return question;
    }

    private void verifyVersioning(Question originalQuestion, Question versionedQuestion) {
        // Question
        assertEquals(originalQuestion.getQuestionSeqId(), versionedQuestion.getQuestionSeqId());
        assertEquals(originalQuestion.getQuestion(), versionedQuestion.getQuestion());
        Integer expectedSequenceNumber = originalQuestion.getSequenceNumber() + 1;
        assertEquals(expectedSequenceNumber, versionedQuestion.getSequenceNumber());
    }

}
