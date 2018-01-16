/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.processBillable;

import org.kuali.coeus.common.framework.auth.task.TaskAuthorizationService;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.auth.IacucProtocolTask;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.rice.krad.util.GlobalVariables;

public abstract class IacucProtocolProcessBillableService {

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
    public void processBillable(ProtocolBase protocol, boolean billable) {
        if (canUpdateBillableField(protocol)) {
            protocol.getProtocolSubmission().setBillable(billable);
        }
    }

    public void setTaskAuthorizationService(TaskAuthorizationService taskAuthorizationService) {
        this.taskAuthorizationService = taskAuthorizationService;
    }

    private boolean canUpdateBillableField(ProtocolBase protocol) {
        IacucProtocolTask task = new IacucProtocolTask(TaskName.MODIFY_IACUC_PROTOCOL_BILLABLE, (IacucProtocol)protocol);
        return getTaskAuthorizationService().isAuthorized(getUserIdentifier(), task);
    }
    
    private String getUserIdentifier() {
        return GlobalVariables.getUserSession().getPrincipalId();
   }

}
