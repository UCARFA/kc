/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth;

import org.kuali.rice.kim.api.role.Role;
import org.kuali.rice.kim.api.type.KimType;

import java.util.List;

/**
 * The System Authorization Service handles authorization in the global space.
 * It can be used to determine if a user has permission in the global space.  Also,
 * since all Roles and Permissions are at the global space, this service also provides
 * methods for querying Roles and Permissions.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface SystemAuthorizationService {
    
    /**
     * Get all of the roles for a particular type.
     * @param namespaceCode the namespace of the role
     * @return the KIM roles
     */
    public List<Role> getRoles(String namespaceCode);
    
    public List<Role> getRolesForPermission(String permissionName, String namespaceCode);
    
    public List<String> getRoleNamesForPermission(String permissionName, String namespaceCode);
    
    public List<String> getRoleIdsForPermission(String permissionName, String namespaceCode);
    
    public KimType getKimTypeInfoForRole(Role role);

    public List<Role> getRolesByType(String roleNamespaceCode, String typeName, String typeNamespace);

    public boolean hasRole(String userId, String namespace, String roleName);
    
}
