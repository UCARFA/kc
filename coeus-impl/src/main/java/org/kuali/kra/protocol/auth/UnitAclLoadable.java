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
 * This interface defines a document class to be load able with a unit access control list.
 */
public interface UnitAclLoadable extends Permissionable {
    /**
     * Returns the unit number of the unit to which the document belongs to.
     * 
     * @return unitNumber of document
     */
    String getDocumentUnitNumber();
    
    /**
     * Returns the type code of the document (i.e. Proposal, Protocol, etc).
     * 
     * @return typeCode of document
     */
    @Override
    String getDocumentRoleTypeCode();
}
