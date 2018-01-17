/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.service;

import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRole;

import java.util.List;

public interface KcNotificationModuleRoleService {
    
    /**
     * This method retrieves all notification module roles for a given coeus module code.
     * @param moduleCode The module code as defined in the CoeusModule object
     * @return The list of matching notification modules roles for the given code
     * @see org.kuali.coeus.common.framework.module.CoeusModule
     */
    List<NotificationModuleRole> getNotificationModuleRoles(String moduleCode);
    
    /**
     * This method retrieves all notification module roles for a given coeus module code as a String.
     * @param moduleCode The module code as defined in the CoeusModule object
     * @return The String representation of the list of matching notification modules roles for the given code
     * @see org.kuali.coeus.common.framework.module.CoeusModule
     */
    String getNotificationModuleRolesString(String moduleCode);
    
    /**
     * This method retrieves all notification module roles for a given coeus module code and role name.
     * @param moduleCode The module code as defined in the CoeusModule object
     * @param roleName The KIM namespace and role name, combined with a semicolon, ie. namespace:rolename
     * @return The list of matching notification modules roles for the given code and role name
     * @see org.kuali.coeus.common.framework.module.CoeusModule
     */
    List<NotificationModuleRole> getNotificationModuleRolesForKimRole(String moduleCode, String roleName);
}
