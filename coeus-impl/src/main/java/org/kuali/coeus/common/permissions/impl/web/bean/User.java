/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.web.bean;

import org.kuali.coeus.common.framework.person.KcPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * A User is a mapping of a single Person to a list of Roles.  It
 * has two purposes.  First, it is used by the Users panel on the
 * Permissions tab web page.  Secondly, it is used by the Business
 * Rules, e.g. to verify that we don't add a duplicate user, etc.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class User {
    
    private KcPerson person;
    private List<Role> roles = new ArrayList<Role>();
    
    public User(KcPerson person) {
        this.person = person;
    }

    public KcPerson getPerson() { 
        return person;
    }
    
    public List<Role> getRoles() {
        return roles;
    }
    
    public void addRole(Role role) {
        roles.add(role);
    }
}
