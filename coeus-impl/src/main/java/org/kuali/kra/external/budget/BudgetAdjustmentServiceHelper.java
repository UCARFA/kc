/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.external.budget;

import org.kuali.kra.award.budget.AwardBudgetExt;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.kuali.coeus.common.budget.framework.core.Budget;
import org.kuali.coeus.common.budget.framework.rate.RateType;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public interface BudgetAdjustmentServiceHelper {

    HashMap<String, ScaleTwoDecimal> getNonPersonnelCost(Budget currentBudget, AwardBudgetExt previousBudget);
    
    SortedMap<RateType, ScaleTwoDecimal> getNonPersonnelCalculatedDirectCost(Budget currentBudget, AwardBudgetExt previousBudget);
    
    Map<RateClassRateType, ScaleTwoDecimal> getIndirectCost(Budget currentBudget, AwardBudgetExt previousBudget);
    
    Map<RateClassRateType, ScaleTwoDecimal> getPersonnelCalculatedDirectCost(Budget currentBudget, AwardBudgetExt previousBudget);

    Map<RateClassRateType, ScaleTwoDecimal> getPersonnelFringeCost(Budget currentBudget, AwardBudgetExt previousBudget);
    
    SortedMap<String, ScaleTwoDecimal> getPersonnelSalaryCost(Budget currentBudget, AwardBudgetExt previousBudget) throws Exception;

}
