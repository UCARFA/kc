/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.timeandmoney.AwardVersionHistory;
import org.kuali.kra.timeandmoney.TimeAndMoneyDocumentHistory;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.rice.kew.api.exception.WorkflowException;

import java.util.List;

public interface TimeAndMoneyHistoryService {

    List<AwardVersionHistory> buildTimeAndMoneyHistoryObjects(String awardNumber, boolean bounded) throws WorkflowException;
    
    public List<TimeAndMoneyDocumentHistory> getDocHistoryAndValidInfosAssociatedWithAwardVersion(List<TimeAndMoneyDocument> docs,
            List<AwardAmountInfo> awardAmountInfos, Award award) throws WorkflowException;

    public List<TimeAndMoneyDocument> buildTimeAndMoneyListForAwardDisplay(Award award, boolean bounded) throws WorkflowException;

}
