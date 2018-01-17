/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.permissions.impl.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * All Struts Action classes that support the Permissions tab web page
 * must implement this interface.  The Permissions Action class must
 * respond to the following action requests from the web page.
 */
public interface PermissionsAction {

    /**
     * Get the HTML Page for viewing the Rights (Permissions) for all of
     * the Protocol Roles (Aggregator, Viewer, etc.).
     */
    public ActionForward getPermissionsRoleRights(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * Add a new Protocol User to the list of users who can access a protocol.
     * The user may be assigned any of the roles or the special unassigned role.
     */
    public ActionForward addUser(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * Delete a Protocol User from the list of users who can access a protocol.
     */
    public ActionForward deleteUser(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * If the the end-user confirms that a user must be deleted from the list of
     * protocol users, then do so.
     */
    public ActionForward confirmDeletePermissionsUser(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * Display the Edit Roles HTML web page.  When the "edit role" button is pressed, the Edit Roles
     * web page is displayed.  The roles that the user is assigned to can then be modified.
     */
    public ActionForward editRoles(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response) throws Exception;
    
    /**
     * Set the roles for a user for a given protocol.  The setEditRoles() method works in conjunction
     * with the above editRoles() method.  The editRoles() method causes the Edit Roles web page to
     * be displayed.  The setEditRoles() is invoked when the user clicks on the save button.
     */
    public ActionForward setEditRoles(ActionMapping mapping, ActionForm form, 
                HttpServletRequest request, HttpServletResponse response) throws Exception;
}
