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
import org.kuali.kra.timeandmoney.AwardHierarchyNode;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.kra.timeandmoney.history.TransactionDetail;
import org.kuali.rice.kew.api.exception.WorkflowException;

import java.util.List;
import java.util.Map;

public interface TimeAndMoneyService {

    TimeAndMoneyDocument setupTimeAndMoneyDocument(String rootAwardNumber, Award currentAward) throws WorkflowException;
    Award populateAwardHierarchyItems(TimeAndMoneyDocument timeAndMoneyDocument, String rootAwardNumber, List<String> order);
    void captureDateChangeTransactions(TimeAndMoneyDocument timeAndMoneyDocument, List<AwardHierarchyNode> awardHierarchyNodeItems) throws WorkflowException;
    AwardAmountInfo getNewAwardAmountInfoForDateChangeTransaction(AwardAmountInfo awardAmountInfo,  Award award, String documentNumber);
    TransactionDetail createTransDetailForDateChanges(String sourceAwardNumber, String destinationAwardNumber, Integer sequenceNumber,
                                                             String currentAwardNumber, String documentNumber, String commentsString);
    boolean captureMoneyChanges(List<AwardHierarchyNode> awardHierarchyNodeItems, TimeAndMoneyDocument timeAndMoneyDocument, List<TransactionDetail> moneyTransactionDetailItems,
                                       Map.Entry<String, AwardHierarchyNode> awardHierarchyNode);

    void updateAwardAmountTransactions(TimeAndMoneyDocument timeAndMoneyDocument);
    void addPostEntry(Long awardId, String awardNumber, String documentNumber);
    
    }
