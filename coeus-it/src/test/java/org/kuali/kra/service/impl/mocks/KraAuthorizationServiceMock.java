/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.mocks;

import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.common.framework.auth.perm.Permissionable;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KraAuthorizationServiceMock implements KcAuthorizationService {

    private boolean hasPermission;
    
    public KraAuthorizationServiceMock(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }
    @Override
    public void addDocumentLevelRole(String username, String roleName, Permissionable permissionable) {
     
    }
    @Override
    public List<String> getPrincipalsInRole(String roleName, Permissionable permissionable) {
        return null;
    }

    @Override
    public boolean hasPermission(String username, Permissionable permissionable, String permissionName) {
        return hasPermission;
    }
    @Override
    public <P extends Permissionable> Collection<P> filterForPermission(String userId, Collection<P> permissionables, String permissionNamespace, String permissionName) {
        return hasPermission ? permissionables : Collections.emptyList();
    }
    @Override
    public boolean hasDocumentLevelRole(String username, String roleName, Permissionable permissionable) {
        return false;
    }
    @Override
    public void removeDocumentLevelRole(String username, String roleName, Permissionable permissionable) {
        
    }
}
