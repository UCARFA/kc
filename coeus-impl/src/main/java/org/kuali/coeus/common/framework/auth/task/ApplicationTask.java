/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.auth.task;

/**
 * An Application Task is a task that is global to the application.
 * In other words,it doesn't correspond to any existing object
 * in the system, such as a proposal.
 */
public final class ApplicationTask extends Task {

    public static final String APPLICATION = "application";

    /**
     * Constructs an ApplicationTask.
     * @param taskName the name of the task
     */
    public ApplicationTask(String taskName) {
        super(APPLICATION, taskName);
    }
}
