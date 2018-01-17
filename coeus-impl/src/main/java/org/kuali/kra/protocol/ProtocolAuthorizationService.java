/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;

import org.kuali.coeus.common.framework.auth.perm.Permissionable;
import org.kuali.kra.bo.RolePersons;

import java.util.List;

public interface ProtocolAuthorizationService {

    /**
     * Get the list of all of the award roles and the persons in those
     * roles for a given Protocol.
     * @param permissionable the Protocol
     * @return the list of all roles and the people in those roles
     */
    public List<RolePersons> getAllRolePersons(Permissionable permissionable);
}
