/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.rule;

import org.kuali.coeus.common.permissions.impl.bo.PermissionsUser;
import org.kuali.coeus.common.permissions.impl.bo.PermissionsUserEditRoles;
import org.kuali.coeus.common.permissions.impl.web.bean.User;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

import java.util.List;

/**
 * Defines the Business Rule for processing Permissions.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface PermissionsRule extends BusinessRule {
    
    /**
     * Determines the legality of adding a user with a given role to a document.
     * 
     * @param document the document.
     * @param users the current list of users who have a role in the document
     * @param newUser the new user to add to the document
     * @return true if the addition is valid; otherwise false.
     */
    public boolean processAddPermissionsUserBusinessRules(Document document,
                                                          List<User> users,
                                                          PermissionsUser newUser);
    /**
     * Determines the legality of deleting a user from the given document.
     * 
     * @param document the document.
     * @param users list of current users who have a role in the document
     * @param index the index into "users" of the user to delete
     * @return true if the deletion is valid; otherwise false.
     */
    public boolean processDeletePermissionsUserBusinessRules(Document document,
                                                             List<User> users,
                                                             int index);
    
    /**
     * Determines if it is legal to edit the roles for a user.
     * 
     * @param document the document.
     * @param users list of current users who have a role in the document
     * @param editRoles the new set of roles for the user
     * @return true if the role change is valid; otherwise false.
     */
    public boolean processEditPermissionsUserRolesBusinessRules(Document document,
                                                                List<User> users,
                                                                PermissionsUserEditRoles editRoles);
}
