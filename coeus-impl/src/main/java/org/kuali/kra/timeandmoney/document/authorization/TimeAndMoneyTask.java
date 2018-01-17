/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.document.authorization;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;

/**
 * An Award Task is a task that performs an action against a
 * Award.  To assist authorization, the Award is available.
 */
public final class TimeAndMoneyTask extends Task {
    
    private TimeAndMoneyDocument timeAndMoneyDocument;
    
    /**
     * Constructs an TimeAndMoneyTask.
     * @param taskName the name of the task
     * @param timeAndMoneyDocument the TimeAndMoneyDocument
     */
    public TimeAndMoneyTask(String taskName, TimeAndMoneyDocument timeAndMoneyDocument) {
        super(TaskGroupName.TIME_AND_MONEY, taskName);
        this.timeAndMoneyDocument = timeAndMoneyDocument;
    }

    /**
     * Get the Award.
     * @return the Award
     */
    public TimeAndMoneyDocument getTimeAndMoneyDocument() {
        return timeAndMoneyDocument;
    }
}
