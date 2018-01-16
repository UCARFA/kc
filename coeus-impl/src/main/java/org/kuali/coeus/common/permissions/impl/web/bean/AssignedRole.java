/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.web.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * An AssignedRole is a mapping of a single role with the users who 
 * are assigned to that role.  This is used for the Assigned Roles
 * panel in the Permissions tab web page.  
 */
public class AssignedRole {
    
    private Role role;
    private List<String> userNames = new ArrayList<String>();
    private List<User> users = new ArrayList<User>();
    
    public AssignedRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public List<String> getUserNames() {
        return userNames;
    }
    
    /**
     * Add a userName to the list of users for the role.
     * The userName is added in alphabetical order.
     * @param userName the userName to add
     */
    public void add(User user) {
        int index = users.size();
        for (int i = 0; i < users.size(); i++) {
            if (user.getPerson().getLastName().compareTo(users.get(i).getPerson().getLastName())  < 0) {
                index = i;
                break;
            }
        }
        users.add(index, user);
        userNames.add(index, user.getPerson().getFullName());
    }
}
