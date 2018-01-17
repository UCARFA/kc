/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class allows a coeus module to be associated with specific role names.
 */
public class NotificationModuleRole extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -2991839907693163026L;

    private Long notificationModuleRoleId;

    private String moduleCode;

    private String roleName;

    private List<NotificationModuleRoleQualifier> roleQualifiers = new ArrayList<NotificationModuleRoleQualifier>();

    public Long getNotificationModuleRoleId() {
        return notificationModuleRoleId;
    }

    public void setNotificationModuleRoleId(Long notificationModuleRoleId) {
        this.notificationModuleRoleId = notificationModuleRoleId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<NotificationModuleRoleQualifier> getRoleQualifiers() {
        return roleQualifiers;
    }

    public void setRoleQualifiers(List<NotificationModuleRoleQualifier> roleQualifiers) {
        this.roleQualifiers = roleQualifiers;
    }

    @Override
    public List buildListOfDeletionAwareLists() {
        List deleteAwareList = super.buildListOfDeletionAwareLists();
        deleteAwareList.add(getRoleQualifiers());
        
        return deleteAwareList;
    }    
}
