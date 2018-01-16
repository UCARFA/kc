/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney;

import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.timeandmoney.history.TransactionDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AwardAmountInfoHistory implements Serializable {

    private static final long serialVersionUID = -3741486339602358742L;
    
    private AwardAmountInfo awardAmountInfo;
    private String transactionType;
    private String dateFieldChanged;
    private TransactionDetail dateDetail;
    private TransactionDetail primaryDetail;
    private List<TransactionDetail> intermediateDetails;
    
    public AwardAmountInfoHistory() {
        intermediateDetails = new ArrayList<TransactionDetail>();
    }

    public AwardAmountInfo getAwardAmountInfo() {
        return awardAmountInfo;
    }

    public void setAwardAmountInfo(AwardAmountInfo awardAmountInfo) {
        this.awardAmountInfo = awardAmountInfo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDateFieldChanged() {
        return dateFieldChanged;
    }

    public void setDateFieldChanged(String dateFieldChanged) {
        this.dateFieldChanged = dateFieldChanged;
    }

    public TransactionDetail getDateDetail() {
        return dateDetail;
    }

    public void setDateDetail(TransactionDetail dateDetail) {
        this.dateDetail = dateDetail;
    }

    public TransactionDetail getPrimaryDetail() {
        return primaryDetail;
    }

    public void setPrimaryDetail(TransactionDetail primaryDetail) {
        this.primaryDetail = primaryDetail;
    }

    public List<TransactionDetail> getIntermediateDetails() {
        return intermediateDetails;
    }

    public void setIntermediateDetails(List<TransactionDetail> intermediateDetails) {
        this.intermediateDetails = intermediateDetails;
    }
    
    public String getTransactionDetailTableSize() {
        int returnValue = intermediateDetails.size() + 1;
        return Integer.toString(returnValue);
    }
}
