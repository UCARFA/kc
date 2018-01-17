/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;

/**
 * A Protocol Task is a task that performs an action against a
 * Protocol.  To assist authorization, the Protocol is available.
 */
public final class ProtocolTask extends ProtocolTaskBase {
  public static final String CREATE_PROPOSAL_FOR_IRB_PROTOCOL = "createProposalForIrbProtocol";

    /**
     * Constructs a ProtocolTaskBase.
     * @param taskName the name of the task
     * @param protocol the Protocol
     */
    public ProtocolTask(String taskName, Protocol protocol) {
        super(TaskGroupName.PROTOCOL, taskName, protocol);
    }
    
    public ProtocolTask(String taskName, Protocol protocol, String genericTaskName) {
        super(TaskGroupName.PROTOCOL, taskName, protocol, genericTaskName);
    }

    @Override
    public Protocol getProtocol() {
        return (Protocol)super.getProtocol();
    }
}
