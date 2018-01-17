/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl;

public interface KcNotificationAuthorizationService {
    
    /**
     * Checks if the user has the permission "permissionName".
     * @param permissionName
     * @return
     */
    boolean hasPermission(String permissionName);

}
