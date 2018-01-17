/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award;

import org.kuali.coeus.award.finance.AccountStatus;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.io.Serializable;

public class AccountInformationBean implements Serializable {
    private String status;
    private ScaleTwoDecimal budgeted;
    private ScaleTwoDecimal pending;
    private ScaleTwoDecimal income;
    private ScaleTwoDecimal expense;
    private ScaleTwoDecimal available;
    private String comment;

    public AccountInformationBean() {
            this.status = AccountStatus.AVAILABLE.name();
            this.setIncome(ScaleTwoDecimal.ZERO);
            this.setPending(ScaleTwoDecimal.ZERO);
            this.setAvailable(ScaleTwoDecimal.ZERO);
            this.setExpense(ScaleTwoDecimal.ZERO);
            this.setBudgeted(ScaleTwoDecimal.ZERO);
            comment = "";
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
