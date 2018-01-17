/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth;

/**
 * The Unit Authorization Service handles users and their permissions
 * within units.  
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface UnitAuthorizationService {
    
    /**
     * Does the user have the given permission?
     * If the user has the permission in the global space, this method will 
     * return true.  Likewise, true will be returned in the user has this
     * permission in any qualified role.
     * @param userId the user's username
     * @param permissionName the name of the permission
     * @return true if the user has permission; otherwise false
     */
    public boolean hasPermission(String userId, String namespaceCode, String permissionName);
    
    /**
     * Does the user have the given permission in the specified unit?  
     * Along with checking the specific unit, if the user has the permission
     * in the global space, this method will also return true.
     * @param userId the user's username
     * @param unitNumber the Unit's unique number
     * @param permissionName the name of the permission
     * @return true if the user has permission; otherwise false
     */
    public boolean hasPermission(String userId, String unitNumber, String namespaceCode, String permissionName);
     
}
