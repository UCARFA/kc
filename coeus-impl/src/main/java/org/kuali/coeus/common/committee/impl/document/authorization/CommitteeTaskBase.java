/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.document.authorization;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.framework.auth.task.Task;

/**
 * A CommitteeBase Task is a task that performs an action against a
 * CommitteeBase.  To assist authorization, the CommitteeBase is available.
 */
public abstract class CommitteeTaskBase<CMT extends CommitteeBase<CMT, ?, ?>> extends Task {
    
    private CMT committee;
    
    /**
     * Constructs a CommitteeTaskBase.
     * @param taskGroupName the name of the task group
     * @param taskName the name of the task
     * @param committee the CommitteeBase
     */
    public CommitteeTaskBase(String taskGroupName, String taskName, CMT committee) {
        super(taskGroupName, taskName);
        this.committee = committee;
    }

    
    /**
     * Get the CommitteeBase.
     * @return the CommitteeBase
     */
    public CMT getCommittee() {
        return committee;
    }
}
