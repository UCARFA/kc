/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.proccessbillable;

import org.kuali.coeus.common.framework.auth.task.TaskAuthorizationService;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.auth.ProtocolTask;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * This class should be extended by an service implementation that needs to set the billable field of the protocol submission.
 */
public abstract class ProtocolProccessBillableService {
    
    private TaskAuthorizationService taskAuthorizationService;
    
    public TaskAuthorizationService getTaskAuthorizationService() {
        return taskAuthorizationService;
    }
    
    /**
     * 
     * This method does a permission check to make sure the logged in user can perform the action.  
     * Then sets the billable field as appropriate.
     * @param protocol
     * @param billable
     */
    public void proccessBillable(Protocol protocol, boolean billable) {
        if (canUpdateBillableField(protocol)) {
            protocol.getProtocolSubmission().setBillable(billable);
        }
    }

    public void setTaskAuthorizationService(TaskAuthorizationService taskAuthorizationService) {
        this.taskAuthorizationService = taskAuthorizationService;
    }

    private boolean canUpdateBillableField(Protocol protocol) {
        ProtocolTask task = new ProtocolTask(TaskName.MODIFY_PROTOCOL_BILLABLE, protocol);
        return getTaskAuthorizationService().isAuthorized(getUserIdentifier(), task);
    }
    
    private String getUserIdentifier() {
        return GlobalVariables.getUserSession().getPrincipalId();
   }

}
