/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.auth;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.infrastructure.TaskGroupName;

public class CoiDisclosureTask extends Task {
    
    private CoiDisclosure coiDisclosure;
    
    /**
     * Constructs a CoiDisclosureTask.
     * @param taskName the name of the task
     * @param coiDisclosure the coiDisclosure
     */
    public CoiDisclosureTask(String taskName, CoiDisclosure coiDisclosure) {
        super(TaskGroupName.COIDISCLOSURE, taskName);
        this.coiDisclosure = coiDisclosure;
    }
    
    public CoiDisclosureTask(String taskName, CoiDisclosure coiDisclosure, String genericTaskName) {
        super(TaskGroupName.COIDISCLOSURE, taskName, genericTaskName);
        this.coiDisclosure = coiDisclosure;
    }

    /**
     * Get the CoiDisclosure.
     * @return the CoiDisclosure
     */
    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

}
