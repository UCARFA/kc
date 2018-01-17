/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.questionnaire.print;

import org.kuali.coeus.common.framework.print.Printable;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.protocol.actions.print.QuestionnairePrintOption;

import java.util.List;

public interface QuestionnairePrintingService {
    /**
     * 
     * This method is to get the printables for the questions selected and printed with protocol summary.
     * @param printableBusinessObject
     * @param questionnairesToPrints
     * @return
     */
    List<Printable> getQuestionnairePrintable(KcPersistableBusinessObjectBase printableBusinessObject,
            List<QuestionnairePrintOption> questionnairesToPrints);

}
