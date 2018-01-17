/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.budget;

import org.kuali.kra.award.AwardForm;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;

import java.io.Serializable;

public class AwardBudgetLimitsBean implements Serializable {
    
    private AwardForm awardForm;
    
    public AwardBudgetLimitsBean(AwardForm awardForm) {
        this.awardForm = awardForm;
    }

    public ScaleTwoDecimal getTotalCostBudgetLimit() {
        return getSpecificBudgetLimit(AwardBudgetLimit.LIMIT_TYPE.TOTAL_COST).getLimit();
    }
    public void setTotalCostBudgetLimit(ScaleTwoDecimal newLimit) {
        setSpecificBudgetLimit(newLimit, AwardBudgetLimit.LIMIT_TYPE.TOTAL_COST);
    }
    
    public ScaleTwoDecimal getDirectCostBudgetLimit() {
        return getSpecificBudgetLimit(AwardBudgetLimit.LIMIT_TYPE.DIRECT_COST).getLimit();
    }
    public void setDirectCostBudgetLimit(ScaleTwoDecimal newLimit) {
        setSpecificBudgetLimit(newLimit, AwardBudgetLimit.LIMIT_TYPE.DIRECT_COST);
    }
    
    public ScaleTwoDecimal getIndirectCostBudgetLimit() {
        return getSpecificBudgetLimit(AwardBudgetLimit.LIMIT_TYPE.INDIRECT_COST).getLimit();
    }
    public void setIndirectCostBudgetLimit(ScaleTwoDecimal newLimit) {
        setSpecificBudgetLimit(newLimit, AwardBudgetLimit.LIMIT_TYPE.INDIRECT_COST);
    }
    
    protected AwardBudgetLimit getSpecificBudgetLimit(AwardBudgetLimit.LIMIT_TYPE type) {
        for (AwardBudgetLimit limit : awardForm.getAwardDocument().getAward().getAwardBudgetLimits()) {
            if (limit.getLimitType() == type) {
                return limit;
            }
        }
        return new AwardBudgetLimit(type);
    }
    protected void setSpecificBudgetLimit(ScaleTwoDecimal newLimit, AwardBudgetLimit.LIMIT_TYPE type) {
        for (AwardBudgetLimit limit : awardForm.getAwardDocument().getAward().getAwardBudgetLimits()) {
            if (limit.getLimitType() == type) {
                limit.setLimit(newLimit);
                return;
            }
        }
        AwardBudgetLimit limit = new AwardBudgetLimit(type);
        limit.setLimit(newLimit);
        awardForm.getAwardDocument().getAward().getAwardBudgetLimits().add(limit);       
    }
}
