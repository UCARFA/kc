/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.service;

import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;

/**
 * Defines the service to fill in module role qualifier information.
 */
public interface KcNotificationRoleQualifierService {
    
    /**
     * Returns the appropriate value given the information in the passed in module role qualifier.
     * 
     * @param qualifier the module role qualifier
     * @return the associated value, or null if not found.
     */
    String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier);

}
