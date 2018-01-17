/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.kuali.coeus.common.framework.auth.task.TaskAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.auth.ProtocolTaskBase;
import org.kuali.rice.krad.util.GlobalVariables;

public abstract class ProtocolCorrespondenceAuthorizationServiceImplBase implements ProtocolCorrespondenceAuthorizationService {
    
    private static final String VIEW_PROTOCOL_CORRESPONDENCE_TASK_NAME = "viewProtocolCorrespondence";
    private static final String MODIFY_PROTOCOL_CORRESPONDENCE_TASK_NAME = "modifyProtocolCorrespondence";
    private static final String CREATE_PROTOCOL_CORRESPONDENCE_TASK_NAME = "createProtocolCorrespondence";
    
    protected TaskAuthorizationService taskAuthorizationService;

    protected boolean hasPermission(String taskName, ProtocolBase protocol) {
        ProtocolTaskBase task = getNewProtocolTaskInstanceHook(taskName, protocol);
        return getTaskAuthorizationService().isAuthorized(getUserIdentifier(), task);
    }
    
    public void setTaskAuthorizationService(TaskAuthorizationService taskAuthorizationService) {
        this.taskAuthorizationService = taskAuthorizationService;
    }
    
    protected TaskAuthorizationService getTaskAuthorizationService() {
        if (this.taskAuthorizationService == null) {
            this.taskAuthorizationService = KcServiceLocator.getService(TaskAuthorizationService.class);
        }
        return this.taskAuthorizationService;
    }
    
    /**
     * Get the userName of the user for the current session.
     * @return the current session's userName
     */
    protected String getUserIdentifier() {
         return GlobalVariables.getUserSession().getPrincipalId();
    }
    

    protected abstract ProtocolTaskBase getNewProtocolTaskInstanceHook(String taskName, ProtocolBase protocol);

    @Override
    public boolean isAllowedToViewProtocolCorrespondence(ProtocolBase protocol) {
        return hasPermission(VIEW_PROTOCOL_CORRESPONDENCE_TASK_NAME, protocol) || isAllowedToUpdateProtocolCorrespondence(protocol);
    }

    @Override
    public boolean isAllowedToUpdateProtocolCorrespondence(ProtocolBase protocol) {
        return hasPermission(MODIFY_PROTOCOL_CORRESPONDENCE_TASK_NAME, protocol) || isAllowedToRegenerateProtocolCorrespondence(protocol);
    }

    @Override
    public boolean isAllowedToRegenerateProtocolCorrespondence(ProtocolBase protocol) {
        return hasPermission(CREATE_PROTOCOL_CORRESPONDENCE_TASK_NAME, protocol);
    }

}
