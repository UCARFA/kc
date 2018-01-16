/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

/**
 * The Task Authorization Service is responsible for determining
 * if a user has the authority to execute a given task.
 */
public interface TaskAuthorizationService {

    /**
     * Is the user authorized to perform the given task?
     * @param userId the user's unique username
     * @param task the task to perform
     * @return true if the user is authorized; otherwise false
     */
    boolean isAuthorized(String userId, Task task);

}
