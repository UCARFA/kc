/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.document.authorizer;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.document.authorization.AwardTask;
import org.kuali.kra.award.infrastructure.AwardPermissionConstants;
import org.kuali.kra.infrastructure.Constants;

/**
 * The OpenAwardBudgetAuthorizer checks to see if the user has 
 * the necessary permission to open budgets.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class OpenAwardBudgetAuthorizer extends AwardAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, AwardTask task) {
        AwardDocument doc = task.getAward().getAwardDocument();
        
        return hasUnitPermission(userId, doc.getLeadUnitNumber(), Constants.MODULE_NAMESPACE_AWARD_BUDGET, 
                    AwardPermissionConstants.MODIFY_AWARD_BUDGET.getAwardPermission())
            || hasUnitPermission(userId, doc.getLeadUnitNumber(), Constants.MODULE_NAMESPACE_AWARD_BUDGET, 
                    AwardPermissionConstants.VIEW_AWARD_BUDGET.getAwardPermission())
            || kraWorkflowService.hasWorkflowPermission(userId, doc);       
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
