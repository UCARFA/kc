/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.goalsAndExpenditures;

import org.kuali.kra.award.subcontracting.reporting.SubcontractingExpenditureCategoryAmounts;

public interface AwardSubcontractingGoalsExpendituresService {
    
    // return the existing BO instance for the award number if found in the data store, or else return a 'fresh' instance of the BO
    public AwardSubcontractingBudgetedGoals getBudgetedGoalsBOForAward(String awardNumber);
   
    public void saveBudgetedGoalsBO(AwardSubcontractingBudgetedGoals goalsExpendituresBO);

    
    // return the existing BO instance for the award number if found in the data store, or else return a 'fresh' instance of the BO
    public SubcontractingExpenditureCategoryAmounts getExpenditureAmountsBOForAward(String awardNumber);
}
