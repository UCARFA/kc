/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.dao;

import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.kra.timeandmoney.history.TimeAndMoneyActionSummary;
import org.kuali.kra.timeandmoney.history.TransactionDetail;

import java.util.List;

public interface TimeAndMoneyDao {
    
    List<TimeAndMoneyActionSummary> buildTimeAndMoneyActionSummaryForAward(String awardNumber);
    
    List<TimeAndMoneyDocument> getTimeAndMoneyDocumentForAwards(List<Long> awardIds);

    List<TransactionDetail> getTransactionDetailsForDocument(String documentNumber);

    TimeAndMoneyDocument getTimeAndMoneyDocument(String documentNumber);

}
