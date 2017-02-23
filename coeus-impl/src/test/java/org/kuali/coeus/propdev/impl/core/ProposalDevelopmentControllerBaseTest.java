/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2016 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kuali.coeus.propdev.impl.core;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.questionnaire.framework.answer.Answer;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ProposalDevelopmentControllerBaseTest {

    ProposalDevelopmentController pdController;

    class ProposalDevelopmentController extends ProposalDevelopmentControllerBase {}

    @Before
    public void setup() {
        pdController = new ProposalDevelopmentController();
    }

    @Test
    public void testSubmitAnswers() {
        AnswerHeader newAnswerHeader = null;
        AnswerHeader currentAnswerHeader = null;
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));

        currentAnswerHeader = new AnswerHeader();
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));

        newAnswerHeader = new AnswerHeader();
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));

        List<Answer> newAnswers = new ArrayList<>();
        Answer answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer("Y");
        Answer answer2 = new Answer();
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(false);
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());
        currentAnswerHeader.setAnswers(new ArrayList<>());

        List<Answer> currentAnswers = new ArrayList<>();
        Answer currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer("Y");
        Answer currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1.setQuestionId(1L);
        answer1.setAnswer("Y");
        answer2.setQuestionId(2L);
        answer2.setAnswer("Y");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());


        newAnswers = new ArrayList<>();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(false);
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(false);
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = null;
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer(null);
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer(null);
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer("Y");
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        newAnswers.add(answer1);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswers = new ArrayList<>();
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer(null);
        currentAnswers.add(currentAnswer1);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        newAnswers.add(answer1);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswers = new ArrayList<>();
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer("Y");
        currentAnswers.add(currentAnswer1);
        currentAnswerHeader.setAnswers(currentAnswers);
        Assert.assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());
    }
}
