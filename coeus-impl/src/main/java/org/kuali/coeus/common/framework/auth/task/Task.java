/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

/**
 * A Task represents a single operation that can be performed by
 * a user.  This base class can be used as is or extended in order 
 * to provide more data pertaining to the actual task.
 */
public class Task {

    private String groupName;
    private String taskName; 
    private String genericTaskName;
    
    /**
     * Constructs a Task.
     * @param groupName the name of the group
     * @param taskName the name of the task
     */
    public Task(String groupName, String taskName) {
        this.groupName = groupName;
        this.taskName = taskName;
    }
    
    public Task(String groupName, String taskName, String genericTaskName) {
        this(groupName, taskName);
        this.genericTaskName = genericTaskName;
    }
    
    /**
     * Get the name of the group.
     * @return the task's group name
     */
    public String getGroupName() {
        return groupName;
    }
    
    /**
     * Get the name of the task.
     * @return the task's name
     */
    public String getTaskName() {
        return taskName;
    }
    
    public String getGenericTaskName(){
        return this.genericTaskName;
    }
    
    @Override
    public String toString() {
        return groupName + "." + taskName;
    }
}
