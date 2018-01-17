/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.document.authorizer;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.subaward.document.authorization.SubAwardTask;

/**
 * This class is using for checking the authorization
 * for viewing subAward ...
 */
public class ViewSubAwardAuthorizer extends SubAwardAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, SubAwardTask task) {
        return this.kraWorkflowService.hasWorkflowPermission(userId, task.getSubAwardDocument()) ||
                hasPermission(userId, task.getSubAwardDocument().getSubAward(), PermissionConstants.VIEW_SUBAWARD);

    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
