/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.document.authorizer;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.document.authorization.AwardTask;
import org.kuali.kra.award.infrastructure.AwardPermissionConstants;
import org.kuali.kra.infrastructure.Constants;

/**
 * The Create AwardBudget Authorizer checks to see if the user has 
 * permission to create an AwardBudget. The user must have the relevant
 * permission under the LeadUnit hierarchy in order to create an AwardBudget
 */
public class CreateAwardBudgetAuthorizer extends AwardAuthorizer {

    @Override
    public boolean isAuthorized(String userId, AwardTask task) {
        AwardDocument doc = task.getAward().getAwardDocument(); 
        
        return hasUnitPermission(userId, doc.getLeadUnitNumber(), Constants.MODULE_NAMESPACE_AWARD_BUDGET, AwardPermissionConstants.CREATE_AWARD_BUDGET.getAwardPermission());
    }
}
