/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;

/**
 * The Web Authorization Service is used by the Struts Actions to determine if a
 * user can execute a specific task.  
 */
public interface WebAuthorizationService {

    /**
     * Can the user execute the requested task.  
     * @param userId the unique username of the user
     * @param actionClass the name of the Struts Action class
     * @param methodName the name of the Struts Action Method to be invoked (corresponds to the task)
     * @param form the form
     * @param request the HTTP request
     * @return true if the user is authorized; otherwise false
     */
    public boolean isAuthorized(String userId, Class actionClass, String methodName, ActionForm form, HttpServletRequest request);
}
