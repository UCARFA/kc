/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * 
 * This class allows a relationship between role names and role qualifiers to be defined.
 */
public class NotificationModuleRoleQualifier extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 19728350917756271L;

    private Long notificationModuleRoleQualifierId;

    private Long notificationModuleRoleId;

    private String qualifier;

    public Long getNotificationModuleRoleQualifierId() {
        return notificationModuleRoleQualifierId;
    }

    public void setNotificationModuleRoleQualifierId(Long notificationModuleRoleQualifierId) {
        this.notificationModuleRoleQualifierId = notificationModuleRoleQualifierId;
    }

    public Long getNotificationModuleRoleId() {
        return notificationModuleRoleId;
    }

    public void setNotificationModuleRoleId(Long notificationModuleRoleId) {
        this.notificationModuleRoleId = notificationModuleRoleId;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }
}
