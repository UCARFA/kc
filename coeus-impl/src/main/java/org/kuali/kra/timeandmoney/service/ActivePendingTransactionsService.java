/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.service;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.kra.timeandmoney.history.TransactionDetail;
import org.kuali.kra.timeandmoney.transactions.AwardAmountTransaction;

import java.util.List;
import java.util.Map;

public interface ActivePendingTransactionsService {
    
    /**
     * 
     * This method will approve all pending transactions and accordingly update the awardAmountInfo numbers for all awards.
     * @param document
     * @param newAwardAmountTransaction
     */
    void approveTransactions(TimeAndMoneyDocument document, AwardAmountTransaction newAwardAmountTransaction);
    
    List<AwardAmountTransaction> processTransactions(TimeAndMoneyDocument doc, AwardAmountTransaction newAwardAmountTransaction, Map<String
            , AwardAmountTransaction> awardAmountTransactionItems, List<Award> awardItems, List<TransactionDetail> transactionDetailItems, Boolean refreshFlag);

    List<Award> processTransactionsForAddRuleProcessing(TimeAndMoneyDocument doc, AwardAmountTransaction newAwardAmountTransaction, Map<String
            , AwardAmountTransaction> awardAmountTransactionItems, List<Award> awardItems, List<TransactionDetail> transactionDetailItems);

}
