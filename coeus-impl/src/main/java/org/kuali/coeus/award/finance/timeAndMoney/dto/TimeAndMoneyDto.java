/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.award.finance.timeAndMoney.dto;

import com.codiform.moo.annotation.CollectionProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kuali.kra.award.home.AwardAmountInfoDto;

import java.util.List;

public class TimeAndMoneyDto {

    private String awardId;
    private String timeAndMoneyDocumentNbr;
    private String timeAndMoneyDocumentStatus;

    @JsonProperty(value="awardAmountTransactions")
    @CollectionProperty(source="awardAmountTransactions", itemClass= AwardAmountTransactionDto.class)
    private List<AwardAmountTransactionDto> awardAmountTransactions;

    @JsonProperty(value="transactionDetails")
    @CollectionProperty(source="transactionDetails", itemClass= TransactionDetailDto.class)
    private List<TransactionDetailDto> transactionDetails;

    @JsonProperty(value="awardAmountInfos")
    @CollectionProperty(source = "awardAmountInfos", itemClass=AwardAmountInfoDto.class)
    private List<AwardAmountInfoDto> awardAmountInfos;


    public List<AwardAmountTransactionDto> getAwardAmountTransactions() {
        return awardAmountTransactions;
    }

    public void setAwardAmountTransactions(List<AwardAmountTransactionDto> awardAmountTransactions) {
        this.awardAmountTransactions = awardAmountTransactions;
    }

    public List<TransactionDetailDto> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetailDto> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public List<AwardAmountInfoDto> getAwardAmountInfos() {
        return awardAmountInfos;
    }

    public void setAwardAmountInfos(List<AwardAmountInfoDto> awardAmountInfos) {
        this.awardAmountInfos = awardAmountInfos;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

   public String getTimeAndMoneyDocumentNbr() {
        return timeAndMoneyDocumentNbr;
    }

    public void setTimeAndMoneyDocumentNbr(String documentNbr) {
        this.timeAndMoneyDocumentNbr = documentNbr;
    }

    public String getTimeAndMoneyDocumentStatus() {
        return timeAndMoneyDocumentStatus;
    }

    public void setTimeAndMoneyDocumentStatus(String documentStatus) {
        this.timeAndMoneyDocumentStatus = documentStatus;
    }
}
