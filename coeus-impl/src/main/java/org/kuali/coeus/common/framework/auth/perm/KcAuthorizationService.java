/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.perm;

import java.util.Collection;
import java.util.List;

/**
 * The Authorization Service handles access to Documents.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface KcAuthorizationService {
    
    /**
     * Add a user to a role within an Permissionable. The passed in role must be a document
     * level type.
     * @param userId the user's userId
     * @param roleName the name of the Role
     * @param permissionable the Permissionable
     */
    public void addDocumentLevelRole(String userId, String roleName, Permissionable permissionable);
    
    /**
     * Remove a user from a role within a Permissionable. The passed in role must be a document
     * level type.
     * @param userId the user's userId
     * @param roleName the name of the Role
     * @param permissionable the Permissionable
     */
    public void removeDocumentLevelRole(String userId, String roleName, Permissionable permissionable);

    /**
     * Remove a user from a role within a Permissionable. The passed in role must be a document
     * level type.
     * @param userId the user's userId
     * @param roleName the name of the Role
     * @param permissionable the Permissionable
     */
    public boolean hasDocumentLevelRole(String userId, String roleName, Permissionable permissionable);
    
    /**
     * Does the user have the given permission for the given Permissionable?
     * @param userId the user's userId
     * @param permissionable the Permissionable
     * @param permissionName the name of the Permission
     * @return true if the user has permission; otherwise false
     */
    public boolean hasPermission(String userId, Permissionable permissionable, String permissionName);

    /**
     * Takes a collection of Permissionables and returns only those for which a user has the given permission
     * @param userId the user's userId
     * @param permissionables a collection of Permissionables
     * @param permissionName the name of the Permission
     * @return the filtered collection of Permissionables for which the userId has the requested permission
     */
    public <P extends Permissionable> Collection<P> filterForPermission(String userId, Collection<P> permissionables, String permissionNamespace, String permissionName);

    /**
     * Get the list of principal ids in a specific role for a given permissionable.
     * @param roleName the name of the role
     * @param permissionable the Permissionable
     * @return the list of principal ids in the role for the permissionable
     */
    public List<String> getPrincipalsInRole(String roleName, Permissionable permissionable);
}
