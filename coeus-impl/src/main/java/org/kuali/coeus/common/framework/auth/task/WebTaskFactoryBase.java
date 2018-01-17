/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

/**
 * Base implementation class for Test Factories.
 */
public abstract class WebTaskFactoryBase implements WebTaskFactory {

    private String taskName;
    
    /**
     * Set the name of the Task.  Injected by the Spring Framework.
     * @param taskName the name of the task
     */
    public final void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    /**
     * Get the name of the task.
     * @return the task's name
     */
    public final String getTaskName() {
        return taskName;
    }
    
    /**
     * Get the name of the task's group.
     * @return the task's group name
     */
    public abstract String getTaskGroupName();

}
