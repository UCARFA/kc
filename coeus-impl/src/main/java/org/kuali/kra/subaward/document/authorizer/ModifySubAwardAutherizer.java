/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.subaward.document.authorizer;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.subaward.bo.SubAward;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.kra.subaward.document.authorization.SubAwardTask;

/**
 * This class checks the authorization for modifySubAward...
 */
public class ModifySubAwardAutherizer extends SubAwardAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, SubAwardTask task) {

        SubAwardDocument subAwardDocument = task.getSubAwardDocument();
        if (subAwardDocument.getSubAward().getSubAwardId() != null) {

            if (hasPermission(userId, task.getSubAwardDocument().
            getSubAward(), PermissionConstants.MODIFY_SUBAWARD)) {
                subAwardDocument.getSubAward().setEditSubAward(true);
            }
            return !subAwardDocument.isViewOnly()
            && hasPermission(userId, task.getSubAwardDocument().
            getSubAward(), PermissionConstants.MODIFY_SUBAWARD)
           && !kraWorkflowService.isInWorkflow(subAwardDocument);
        } else {
            return canUserCreateSubAward(
            userId, subAwardDocument.getSubAward());

        }
    }

    /**.
     * This method is for checking whether user can create subAward
     *@param award the SubAward
     *@param userId the userId
     *@return boolean
     */
 protected boolean canUserCreateSubAward(String userId, SubAward award) {
        return hasUnitPermission(userId, Constants.
        MODULE_NAMESPACE_SUBAWARD, PermissionConstants.CREATE_SUBAWARD);
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
