/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.dto;

import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

public class AwardBudgetLimitDto {

    private Long budgetLimitId;

    private Long awardId;

    private Long budgetId;

    private String limitTypeCode;

    private ScaleTwoDecimal limit;


    public Long getBudgetLimitId() {
        return budgetLimitId;
    }

    public void setBudgetLimitId(Long budgetLimitId) {
        this.budgetLimitId = budgetLimitId;
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public String getLimitTypeCode() {
        return limitTypeCode;
    }

    public void setLimitTypeCode(String limitTypeCode) {
        this.limitTypeCode = limitTypeCode;
    }

    public ScaleTwoDecimal getLimit() {
        return limit;
    }

    public void setLimit(ScaleTwoDecimal limit) {
        this.limit = limit;
    }
}
