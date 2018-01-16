/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.questionnaire;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.questionnaire.impl.QuestionnaireDao;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.kew.api.exception.WorkflowException;

import static org.junit.Assert.assertEquals;

/**
 * @author Kuali Rice Team (rice.collab@kuali.org)
 */
public class QuestionnaireDaoOjbTest extends KcIntegrationTestBase {
    private QuestionnaireDao questionnaireDao;

    private static final String QUESTIONNAIRE_SEQUENCE_ID = "1000";
    private static final Integer CURRENT_QUESTIONNAIRE_SEQUENCE_NUMBER = 2;

    @Before
    public void setUp() throws Exception {
        questionnaireDao = KcServiceLocator.getService("questionnaireDao");
    }


    @Test
    public void testFindProtocol() throws WorkflowException {
      assertEquals(CURRENT_QUESTIONNAIRE_SEQUENCE_NUMBER, questionnaireDao.getCurrentQuestionnaireSequenceNumber(QUESTIONNAIRE_SEQUENCE_ID));

    }
}
