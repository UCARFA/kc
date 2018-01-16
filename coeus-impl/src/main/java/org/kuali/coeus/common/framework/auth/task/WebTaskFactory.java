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
 * A Web Task Factory is responsible for building a Task.
 */
public interface WebTaskFactory {
    
    /**
     * Create a Task.
     * @param form the form
     * @param request the HTTP request
     * @return the new Task
     */
    public Task createTask(ActionForm form, HttpServletRequest request);
}
