/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.perm;

import java.util.List;
import java.util.Map;

public interface Permissionable {
    
    /**
     * 
     * This method returns the appropriate document number for implementing documents
     * For award it would be awardNumber and for PDD it would be proposal Number.
     */
    String getDocumentNumberForPermission();
    
    /**
     * 
     * This method returns unique key for implementing document.
     */
    String getDocumentKey();
    
    /**
     * 
     * This method gets all the role names for particular document.
     */
    List<String> getRoleNames();
    
    String getNamespace();
    
    String getLeadUnitNumber();
    
    String getDocumentRoleTypeCode();
    
    /**
     * Allows a permissionable to set additional qualified role attributes that may be needed by 
     * kim services to resolve the role members.
     */
    void populateAdditionalQualifiedRoleAttributes( Map<String, String> qualifiedRoleAttributes );
    
    
    
}
