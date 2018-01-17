/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.web.bean;

import java.io.Serializable;

/**
 * Each RoleState corresponds to one specific user and one specific role.  
 * It stores the current state of the database, i.e. if "saved" is true, then
 * the user is assigned to this role in the database.  It also stores what
 * the end-user wants the role assignment to be in the "assigned" property.
 * If "assigned" is set to true, the end-user wants this user-role assignment
 * to exists in the database; otherwise it should not be in the database.
 * 
 * When the Permissions web page is viewed for the first time, the "saved"
 * and "assigned" flags will have the same value.  The end-user can then
 * edit the roles for the users which will result in the "assigned" flags
 * changing in value.  
 * 
 * When the document is saved, the "saved" and "assigned" flags are checked
 * to see what roles need to be added and/or removed.
 */
public class RoleState implements Serializable {

    private Role role;
    private boolean saved = false;
    private boolean assigned = false;
    
    public RoleState(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
    
    public boolean isSaved() {
        return saved;
    }

    /**
     * When save state is set, the assigned state must be given
     * the same value.  The saveState() is invoked under two scenarios.
     * The first is when the user-role assignments are read from the
     * database and the roleState is created.  The second is when the
     * database is updated with new user-role assignments.  In both
     * cases, the saved and assigned must be the same to reflect what
     * is in the database.  The end-user is then free to change the
     * assigned value to indicate what should be changed for the next
     * database save.
     * @param saved
     */
    public void setSaved(boolean saved) {
        this.saved = saved;
        this.assigned = saved;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
    
    /**
     * Does this role have to be added to the database?
     * @return true if needs to be added; otherwise false
     */
    public boolean needsToBeAdded() {
        return !saved && assigned;
    }
    
    /**
     * Does this role have to be removed from the database?
     * @return true if needs to be removed; otherwise false
     */
    public boolean needsToBeRemoved() {
        return saved && !assigned;
    }
}
