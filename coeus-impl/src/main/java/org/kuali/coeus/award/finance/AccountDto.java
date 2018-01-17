/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.finance;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountDto {

    private Long id;
    private String accountNumber;
    @Digits(integer = 22, fraction=0)
    private Long createdByAwardId;
    @Size(min = 1, max = 15)
    @Pattern(regexp = "[a-zA-Z]+")
    private String status;
    @Digits(integer = 10, fraction = 2)
    private ScaleTwoDecimal budgeted;
    @Digits(integer = 10, fraction = 2)
    private ScaleTwoDecimal pending;
    @Digits(integer = 10, fraction = 2)
    private ScaleTwoDecimal income;
    @Digits(integer = 10, fraction = 2)
    private ScaleTwoDecimal expense;
    @Digits(integer = 10, fraction = 2)
    private ScaleTwoDecimal available;
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCreatedByAwardId() {
        return createdByAwardId;
    }

    public void setCreatedByAwardId(Long createdByAwardId) {
        this.createdByAwardId = createdByAwardId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ScaleTwoDecimal getBudgeted() {
        return budgeted;
    }

    public void setBudgeted(ScaleTwoDecimal budgeted) {
        this.budgeted = budgeted;
    }

    public ScaleTwoDecimal getPending() {
        return pending;
    }

    public void setPending(ScaleTwoDecimal pending) {
        this.pending = pending;
    }

    public ScaleTwoDecimal getIncome() {
        return income;
    }

    public void setIncome(ScaleTwoDecimal income) {
        this.income = income;
    }

    public ScaleTwoDecimal getExpense() {
        return expense;
    }

    public void setExpense(ScaleTwoDecimal expense) {
        this.expense = expense;
    }

    public ScaleTwoDecimal getAvailable() {
        return available;
    }

    public void setAvailable(ScaleTwoDecimal available) {
        this.available = available;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
