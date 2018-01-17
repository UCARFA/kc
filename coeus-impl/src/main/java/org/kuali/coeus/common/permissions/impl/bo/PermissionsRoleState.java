/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.bo;

import org.kuali.coeus.common.permissions.impl.web.bean.Role;
import org.kuali.rice.krad.bo.BusinessObjectBase;

/**
 * The PermissionsRoleState is used by the Permissions Edit Role 
 * feature.  The Edit Role form gives a list of role names along
 * with a checkbox for each currently selected role for the user. 
 * An instance of this class is used for each role.  That boolean
 * "state" attribute indicates whether the checkbox has been
 * selected or not. 
 */
@SuppressWarnings("serial")
public class PermissionsRoleState extends BusinessObjectBase {

    private Role role;
    private Boolean state = false;
    
    public PermissionsRoleState(Role role) {
        this.role = role;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }
    
    @Override
    public void refresh() {
        // do nothing
    }
}
