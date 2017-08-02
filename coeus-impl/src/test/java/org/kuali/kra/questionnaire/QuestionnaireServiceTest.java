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
package org.kuali.kra.questionnaire;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.Assert;
import org.junit.Test;
import org.kuali.coeus.common.questionnaire.framework.core.Questionnaire;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireQuestion;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireUsage;
import org.kuali.coeus.common.questionnaire.impl.core.QuestionnaireServiceImpl;
import org.kuali.rice.krad.service.BusinessObjectService;


import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuestionnaireServiceTest {
    
        private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};

        @Test
        public void testCopyQuestionnaire() {

            final QuestionnaireServiceImpl questionnaireService = new QuestionnaireServiceImpl();
            Questionnaire srcQuestionnaire = setupSourceQuestionnaire();
            Questionnaire destQuestionnaire = new Questionnaire();
            questionnaireService.copyQuestionnaire(srcQuestionnaire, destQuestionnaire);
            List<QuestionnaireQuestion> questionnaireQuestions = destQuestionnaire.getQuestionnaireQuestions();
            List<QuestionnaireUsage> questionnaireUsages = destQuestionnaire.getQuestionnaireUsages();
            assertTrue(questionnaireQuestions.size() == 2);
            Assert.assertNull(questionnaireQuestions.get(0).getQuestionnaireId());
            Assert.assertNull(questionnaireQuestions.get(1).getQuestionnaireId());
            Assert.assertNull(questionnaireQuestions.get(0).getId());
            Assert.assertNull(questionnaireQuestions.get(1).getId());
            assertEquals(questionnaireQuestions.get(0).getQuestionId(), (Object)1000L);

            
            assertTrue(questionnaireUsages.size() == 2);
            assertEquals(questionnaireUsages.get(0).getQuestionnaireLabel(), "test 1");
            assertEquals(questionnaireUsages.get(1).getQuestionnaireLabel(), "test 2");
            Assert.assertNull(questionnaireUsages.get(0).getQuestionnaireId());
            Assert.assertNull(questionnaireUsages.get(1).getQuestionnaireId());
            Assert.assertNull(questionnaireUsages.get(0).getId());
            Assert.assertNull(questionnaireUsages.get(1).getId());
        }

        private Questionnaire setupSourceQuestionnaire() {
            Questionnaire questionnaire = new Questionnaire();
            questionnaire.setQuestionnaireRefIdFromLong(1L);
            
            QuestionnaireQuestion questionnaireQuestion = new QuestionnaireQuestion();
            questionnaireQuestion.setQuestionnaireId(1L);
            questionnaireQuestion.setQuestionId(1L);
            questionnaireQuestion.setId(1L);
            questionnaireQuestion.setQuestionId(1000L);
            questionnaire.getQuestionnaireQuestions().add(questionnaireQuestion);
            
            questionnaireQuestion = new QuestionnaireQuestion();
            questionnaireQuestion.setQuestionnaireId(1L);
            questionnaireQuestion.setQuestionId(2L);
            questionnaireQuestion.setId(2L);
            questionnaireQuestion.setQuestionId(1001L);
            questionnaire.getQuestionnaireQuestions().add(questionnaireQuestion);
            
            QuestionnaireUsage questionnaireUsage = new QuestionnaireUsage();
            questionnaireUsage.setQuestionnaireId(1L);
            questionnaireUsage.setQuestionnaireLabel("test 1");
            questionnaireUsage.setId(1L);
            questionnaire.getQuestionnaireUsages().add(questionnaireUsage);
            
            questionnaireUsage = new QuestionnaireUsage();
            questionnaireUsage.setQuestionnaireId(1L);
            questionnaireUsage.setQuestionnaireLabel("test 2");
            questionnaireUsage.setId(2L);
            questionnaire.getQuestionnaireUsages().add(questionnaireUsage);
            
            
            return questionnaire;
            
        }
        
        @Test
        public void testIsQuestionnaireNameExistTrue() {

            final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
            final QuestionnaireServiceImpl questionnaireService = new QuestionnaireServiceImpl();
            questionnaireService.setBusinessObjectService(businessObjectService);
            final Questionnaire questionnaire = new Questionnaire();
            questionnaire.setQuestionnaireSeqId("1");
            questionnaire.setName("exist name");
            final List<Questionnaire> questionnaires = new ArrayList<>();
            questionnaires.add(questionnaire);
            final Map<String, Object> fieldValues = new HashMap<>();
            fieldValues.put("name", "exist name");
            context.checking(new Expectations() {{
                one(businessObjectService).findMatching(Questionnaire.class, fieldValues);
                will(returnValue(questionnaires));
            }});

            assertTrue(questionnaireService.isQuestionnaireNameExist(null, "exist name"));

            context.assertIsSatisfied();
                        
        }

        @Test
        public void testIsQuestionnaireNameExistFalse() {

            final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
            final QuestionnaireServiceImpl questionnaireService = new QuestionnaireServiceImpl();
            questionnaireService.setBusinessObjectService(businessObjectService);
            final Questionnaire questionnaire = new Questionnaire();
            questionnaire.setQuestionnaireSeqId("1");
            questionnaire.setName("exist name");
            final List<Questionnaire> questionnaires = new ArrayList<>();
            questionnaires.add(questionnaire);
            final Map<String, Object> fieldValues = new HashMap<>();
            fieldValues.put("name", "exist name");
            context.checking(new Expectations() {{
                one(businessObjectService).findMatching(Questionnaire.class, fieldValues);
                will(returnValue(questionnaires));
            }});

            assertTrue(!questionnaireService.isQuestionnaireNameExist("1", "exist name"));

            context.assertIsSatisfied();
                        
        }
        
        @Test
        public void testIsQuestionnaireNameExistFalseNoMatch() {

            final BusinessObjectService businessObjectService = context.mock(BusinessObjectService.class);
            final QuestionnaireServiceImpl questionnaireService = new QuestionnaireServiceImpl();
            questionnaireService.setBusinessObjectService(businessObjectService);
            final Map<String, Object> fieldValues = new HashMap<>();
            fieldValues.put("name", "not exist name");
            final List<Questionnaire> questionnaires = new ArrayList<>();
            context.checking(new Expectations() {{
                one(businessObjectService).findMatching(Questionnaire.class, fieldValues);
                will(returnValue(questionnaires));
            }});

            assertTrue(!questionnaireService.isQuestionnaireNameExist("1", "not exist name"));

            context.assertIsSatisfied();
                        
        }
        
    }


