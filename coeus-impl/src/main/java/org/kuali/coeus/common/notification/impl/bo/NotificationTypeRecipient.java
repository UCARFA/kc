/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.bo;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.service.NotificationRoleSubQualifierFinders;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Defines the recipients for a {@code NotificationType}.
 */
public class NotificationTypeRecipient extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = -1455607096529901879L;
    
    private Long notificationTypeRecipientId;
    private Long notificationTypeId;
    private String roleName;
    private String roleSubQualifier;
    
    // Non-persistent field for tracking the qualifier value.
    private Map<String,String> roleQualifiers;
    
    // Fields for ad-hoc notifications
    private String personId;
    private String rolodexId;
    private String fullName;

    public Long getNotificationTypeRecipientId() {
        return notificationTypeRecipientId;
    }

    public void setNotificationTypeRecipientId(Long notificationTypeRecipientId) {
        this.notificationTypeRecipientId = notificationTypeRecipientId;
    }

    public Long getNotificationTypeId() {
        return notificationTypeId;
    }

    public void setNotificationTypeId(Long notificationTypeId) {
        this.notificationTypeId = notificationTypeId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Map<String,String> getRoleQualifiers() {
        return roleQualifiers;
    }

    public void setRoleQualifiers(Map<String,String> roleQualifiers) {
        this.roleQualifiers = roleQualifiers;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRolodexId() {
        return rolodexId;
    }

    public void setRolodexId(String rolodexId) {
        this.rolodexId = rolodexId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((notificationTypeId == null) ? 0 : notificationTypeId.hashCode());
        result = prime * result + ((notificationTypeRecipientId == null) ? 0 : notificationTypeRecipientId.hashCode());
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NotificationTypeRecipient other = (NotificationTypeRecipient) obj;
        if (notificationTypeId == null) {
            if (other.notificationTypeId != null) {
                return false;
            }
        } else if (!notificationTypeId.equals(other.notificationTypeId)) {
            return false;
        }
        if (notificationTypeRecipientId == null) {
            if (other.notificationTypeRecipientId != null) {
                return false;
            }
        } else if (!notificationTypeRecipientId.equals(other.notificationTypeRecipientId)) {
            return false;
        }
        if (roleName == null) {
            if (other.roleName != null) {
                return false;
            }
        } else if (!roleName.equals(other.roleName)) {
            return false;
        }

        return true;
    }

    public String getRoleSubQualifier() {
        return roleSubQualifier;
    }

    public void setRoleSubQualifier(String roleSubQualifier) {
        this.roleSubQualifier = roleSubQualifier;
    }
    
    public List<KeyValue> getSubQualifierValues() {
        if (StringUtils.isNotBlank(getRoleName())) {
            return KcServiceLocator.getService(NotificationRoleSubQualifierFinders.class).getKeyValuesForRole(getRoleName());
        } else {
            return new ArrayList<KeyValue>();
        }
    }
    
}
