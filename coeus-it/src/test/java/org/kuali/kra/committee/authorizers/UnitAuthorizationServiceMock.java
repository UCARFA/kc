/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.authorizers;

import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;

import java.util.List;

public class UnitAuthorizationServiceMock implements UnitAuthorizationService {
    
    private boolean hasPermission;
    
    public UnitAuthorizationServiceMock(boolean hasPermission) {
        this.hasPermission = hasPermission;
    }

    public List<Unit> getUnits(String userId, String namespaceCode, String permissionName) {
        return null;
    }

    @Override
    public boolean hasPermission(String userId, String namespaceCode, String permissionName) {
        return hasPermission;
    }

    @Override
    public boolean hasPermission(String userId, String unitNumber, String namespaceCode, String permissionName) {
        return false;
    }
    public boolean hasMatchingQualifiedUnits(String userId, String namespaceCode, String permissionName, String unitNumber) {
        return false;
    }
    
}
