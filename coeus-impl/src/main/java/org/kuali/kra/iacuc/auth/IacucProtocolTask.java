/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;

public final class IacucProtocolTask  extends ProtocolTaskBase {
    
    public static final String CREATE_PROPOSAL_FOR_IACUC_PROTOCOL = "createProposalForIacucProtocol";
    
    /**
     * Constructs a ProtocolTaskBase.
     * @param taskName the name of the task
     * @param protocol the IacucProtocol
     */
    public IacucProtocolTask(String taskName, IacucProtocol protocol) {
        super(TaskGroupName.IACUC_PROTOCOL, taskName, protocol);
    }
    
    public IacucProtocolTask(String taskName, IacucProtocol protocol, String genericTaskName) {
        super(TaskGroupName.IACUC_PROTOCOL, taskName, protocol, genericTaskName);
    }

    @Override
    public IacucProtocol getProtocol() {
        return (IacucProtocol)super.getProtocol();
    }

}
