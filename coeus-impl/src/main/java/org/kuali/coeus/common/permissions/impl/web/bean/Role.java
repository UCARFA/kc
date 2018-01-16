/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.web.bean;

import org.kuali.rice.kim.api.permission.Permission;

import java.io.Serializable;
import java.util.List;

/**
 * A role which consists of its unique name, its display name, and
 * its set of permissions.  In some cases, the display name is different
 * from the role's name.  For example, the "Protocol Aggregator" role
 * name is displayed as "Aggregator".
 */
public class Role implements Serializable {

    private String name;
    private String displayName;
    private transient List<Permission> permissions;
    
    public Role(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }
    
    public Role(String name, String displayName, List<Permission> permissions) {
        this(name, displayName);
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }
    
    public List<Permission> getPermissions() {
        return permissions;
    }
}
