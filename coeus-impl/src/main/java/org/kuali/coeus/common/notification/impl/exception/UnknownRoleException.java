/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl.exception;

/**
 * This exception is thrown if the given role id is not known to the given context.
 */
public class UnknownRoleException extends RuntimeException {

    private static final long serialVersionUID = -1925770520412550327L;
    
    private final String roleId;
    private final String context;
    
    /**
     * Constructs an Unknown Role exception.
     * 
     * @param roleId
     * @param context
     */
    public UnknownRoleException(final String roleId, final String context) {
        super("Role " + roleId + " not recognized for context " + context);
        this.roleId = roleId;
        this.context = context;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getContext() {
        return context;
    }

}
