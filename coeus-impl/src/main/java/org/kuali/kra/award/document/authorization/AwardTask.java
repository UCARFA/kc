/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.document.authorization;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.infrastructure.TaskGroupName;

/**
 * An Award Task is a task that performs an action against a
 * Award.  To assist authorization, the Award is available.
 */
public final class AwardTask extends Task {
    
    private Award award;
    
    /**
     * Constructs an AwardTask.
     * @param taskName the name of the task
     * @param award the Award
     */
    public AwardTask(String taskName, Award award) {
        super(TaskGroupName.AWARD, taskName);
        this.award = award;
    }

    /**
     * Get the Award.
     * @return the Award
     */
    public Award getAward() {
        return award;
    }
}
