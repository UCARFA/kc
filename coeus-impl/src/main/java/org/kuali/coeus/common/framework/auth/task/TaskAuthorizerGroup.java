/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * A Task Authorizer Group groups a set of Task Authorizers.
 */
public class TaskAuthorizerGroup {
    
    private String groupName;
    private List<TaskAuthorizer> taskAuthorizers = null;
    

    public TaskAuthorizerGroup() {
      
    }
    
    /**
     * Set the group name.
     * @param groupName the new group name
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    /**
     * Get the group name.
     * @return the group name
     */
    public String getGroupName() {
        return this.groupName;
    }
    
    /**
     * Sets the Task Authorizers.  Injected by the Spring Framework.
     * @param taskAuthorizers the list of Task Authorizers
     */
    public void setTaskAuthorizers(List<TaskAuthorizer> taskAuthorizers) {
        this.taskAuthorizers = taskAuthorizers;
    }
    
    /**
     * Get a Task Authorizer for the given task name.
     * @param taskName the name of the task
     * @return the task authorizer or null if not found
     */
    public TaskAuthorizer getTaskAuthorizer(String taskName) {
        for (TaskAuthorizer taskAuthorizer : taskAuthorizers) {
            if (StringUtils.equals(taskName, taskAuthorizer.getTaskName())) {
                return taskAuthorizer;
            }
        }
        return null;
    }
}
