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
package org.kuali.kra.timeandmoney.service;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.timeandmoney.AwardHierarchyNode;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.kra.timeandmoney.history.TransactionDetail;
import org.kuali.kra.timeandmoney.transactions.AwardAmountTransaction;
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
