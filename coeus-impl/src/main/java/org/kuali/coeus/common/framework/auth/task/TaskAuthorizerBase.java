/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;

/**
 * Base implementation for all Task Authorizers.  The Unit and Proposal Authorization Services
 * and KRA Workflow Services are defined here because many derived classes make use of them.
 */
public abstract class TaskAuthorizerBase implements TaskAuthorizer {

    private String taskName;
    private UnitAuthorizationService unitAuthorizationService;

    /**
     * Set the name of the task.  Injected by the Spring Framework.
     * @param taskName the task's name
     */
    public final void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    /**
     * Set the Unit Authorization Service.  Injected by the Spring Framework.
     * @param unitAuthorizationService the Unit Authorization Service
     */
    public final void setUnitAuthorizationService(UnitAuthorizationService unitAuthorizationService) {
        this.unitAuthorizationService = unitAuthorizationService;
    }
    
    @Override
    public final String getTaskName() {
        return taskName;
    }
    
    /**
     * Does the given user has the permission for this proposal development document?
     * @param userId the unique username of the user
     * @param permissionName the name of the permission
     * @return true if the person has the permission; otherwise false
     */
    protected final boolean hasUnitPermission(String userId, String namespaceCode, String permissionName) {
        return unitAuthorizationService.hasPermission(userId, namespaceCode, permissionName);
    }
    
    protected final boolean hasUnitPermission(String userId, String unitNumber, String namespaceCode, String permissionName) {
        return unitAuthorizationService.hasPermission(userId, unitNumber, namespaceCode, permissionName);
    }
}
