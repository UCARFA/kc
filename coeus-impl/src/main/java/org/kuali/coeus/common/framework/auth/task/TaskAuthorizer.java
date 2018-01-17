/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

/**
 * A Task Authorizer determines if a user can execute a specific task.
 */
public interface TaskAuthorizer {
    
    /**
     * Get the name of the task.
     * @return the task's name
     */
    public String getTaskName();
    
    /**
     * Is the user authorized to execute the given task?
     * @param userId the user's unique username
     * @param task the task
     * @return true if the user is authorized; otherwise false
     */
    public boolean isAuthorized(String userId, Task task);
}
