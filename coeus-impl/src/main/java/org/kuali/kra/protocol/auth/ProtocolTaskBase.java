/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.auth;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.kra.protocol.ProtocolBase;

public abstract class ProtocolTaskBase extends Task {
    
    private ProtocolBase protocol;
    
    
    /**
     * Constructs a ProtocolTaskBase.
     * @param taskName the name of the task
     * @param protocol the ProtocolBase
     */
    public ProtocolTaskBase(String taskGroupName, String taskName, ProtocolBase protocol) {
        super(taskGroupName, taskName);
        this.protocol = protocol;
    }
    
    public ProtocolTaskBase(String taskGroupName, String taskName, ProtocolBase protocol, String genericTaskName) {
        super(taskGroupName, taskName, genericTaskName);
        this.protocol = protocol;
    }

    
    /**
     * Get the ProtocolBase.
     * @return the ProtocolBase
     */
    public ProtocolBase getProtocol() {
        return protocol;
    }

}
