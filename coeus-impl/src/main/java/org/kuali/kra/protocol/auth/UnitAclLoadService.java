/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.auth;

import org.kuali.coeus.common.framework.auth.perm.Permissionable;

/**
 * This service loads the KraAuthorizationService with the proper access control list based on 
 * the documents unit.  The document must implement the UnitAclLoadable interface in order to utilize this
 * service.
 * 
 * Administrators can maintain the access control list by assigning users to document roles within a
 * specific unit.
 */
public interface UnitAclLoadService {
    
    /**
     * Loads the access control list of a specific unit into the document's authorization service.
     *
     */
    void loadUnitAcl(Permissionable permissionable, String creatorPrincipalId);
}
