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
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.infrastructure.AwardPermissionConstants;
import org.kuali.kra.infrastructure.Constants;

/**
 * The Modify Award Authorizer checks to see if the user has 
 * permission to modify a award. Authorization depends upon whether
 * the award is being created or modified.  For creation, the
 * user needs the CREATE_AWARD permission.  If the award is being
 * modified, the user only needs to have the MODIFY_AWARD permission 
 * for that award.
 */
public class ModifyAwardAuthorizer extends AwardAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, AwardTask task) {
        
        AwardDocument doc = task.getAward().getAwardDocument();
        Award award = task.getAward();
        return award.isNew() ? canUserCreateAward(userId, award) : canUserModifyAward(userId, award, doc);
    }
    
    /**
     * 
     * We have to consider the case when we are saving the award for the first time.
     * 
     * @param userId
     * @param award
     * @return
     */
    protected boolean canUserCreateAward(String userId, Award award){
        return hasUnitPermission(userId, Constants.MODULE_NAMESPACE_AWARD, AwardPermissionConstants.CREATE_AWARD.getAwardPermission());
    }
    
    /**
     * 
     * After the initial save, the award can only be modified has the required permission.
     * 
     * @param userId
     * @param award
     * @return
     */
    protected boolean canUserModifyAward(String userId, Award award, AwardDocument doc){
        return !award.getAwardDocument().isViewOnly() &&
                   hasPermission(userId, award, AwardPermissionConstants.MODIFY_AWARD.getAwardPermission()) &&
                       !kraWorkflowService.isInWorkflow(doc);
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
