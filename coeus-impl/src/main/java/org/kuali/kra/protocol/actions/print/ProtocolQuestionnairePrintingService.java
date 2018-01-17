/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.print;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;

import java.util.List;

public interface ProtocolQuestionnairePrintingService {

    /**
     * This method is to set up the questionnaire print list.  Then sorted it.
     * @param answerHeaders
     * @param protocol
     * @param questionnairesToPrints
     */
    public void setupQnPrintOption(List<AnswerHeader> answerHeaders, ProtocolBase protocol, List<QuestionnairePrintOption> questionnairesToPrints);

}
