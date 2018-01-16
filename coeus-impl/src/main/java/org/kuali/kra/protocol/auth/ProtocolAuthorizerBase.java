/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.auth;

import org.kuali.coeus.common.framework.auth.SystemAuthorizationService;
import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizerBase;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolSpecialVersion;
import org.kuali.kra.protocol.actions.submit.ProtocolActionService;
import org.kuali.kra.protocol.actions.submit.ProtocolSubmissionBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.document.authorization.PessimisticLock;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * A ProtocolBase Authorizer determines if a user can perform
 * a given task on a protocol.  
 */
public abstract class ProtocolAuthorizerBase extends TaskAuthorizerBase {
    
    protected KcAuthorizationService kraAuthorizationService;

    protected SystemAuthorizationService systemAuthorizationService;
    private ProtocolActionService protocolActionService;
    
    /**
     * Set the ProtocolBase Action Service.
     * @param protocolActionService
     */
    public final void setProtocolActionService(ProtocolActionService protocolActionService) {
        this.protocolActionService = protocolActionService;
    }

    @Override
    public final boolean isAuthorized(String userId, Task task) {
        return isAuthorized(userId, (ProtocolTaskBase) task);
    }

    /**
     * Is the user authorized to execute the given protocol task?
     * @param userId the user's unique username
     * @param task the protocol task
     * @return true if the user is authorized; otherwise false
     */
    public abstract boolean isAuthorized(String userId, ProtocolTaskBase task);
    
    /**
     * Set the Kra Authorization Service.  Usually injected by the Spring Framework.
     * @param kraAuthorizationService
     */
    public void setKraAuthorizationService(KcAuthorizationService kraAuthorizationService) {
        this.kraAuthorizationService = kraAuthorizationService;
    }
    
    /**
     * Does the given user has the permission for this protocol?
     * @param userId the unique username of the user
     * @param protocol the protocol
     * @param permissionName the name of the permission
     * @return true if the person has the permission; otherwise false
     */
    protected final boolean hasPermission(String userId, ProtocolBase protocol, String permissionName) {
        return kraAuthorizationService.hasPermission(userId, protocol, permissionName);
    }

    /**
     * Is the protocol an amendment or renewal protocol?
     * Including continuation here - since continuation is similar to renewal 
     * @param protocol the protocol
     * @return true if the protocol is an amendment or renewal; otherwise false
     */
    protected final boolean isAmendmentOrRenewal(ProtocolBase protocol) {
        return protocol.getProtocolNumber() != null &&
               (protocol.getProtocolNumber().contains(ProtocolSpecialVersion.AMENDMENT.getCode()) ||
                protocol.getProtocolNumber().contains(ProtocolSpecialVersion.RENEWAL.getCode()) ||
                protocol.getProtocolNumber().contains(ProtocolSpecialVersion.CONTINUATION.getCode()) ||
                protocol.getProtocolNumber().contains(ProtocolSpecialVersion.FYI.getCode()));
    }
    
    /**
     * Can the user on the current thread execute the given action for the given protocol?
     * @param protocol
     * @param protocolActionTypeCode
     * @return true if the action can be executed; otherwise false
     */
    protected final boolean canExecuteAction(ProtocolBase protocol, String protocolActionTypeCode) {
        return protocol.isActive() &&
               !protocol.getProtocolDocument().isViewOnly() &&
               protocolActionService.isActionAllowed(protocolActionTypeCode, protocol);
    }
    
    protected boolean isPessimisticLocked(Document document) {
        boolean isLocked = false;
        for (PessimisticLock lock : document.getPessimisticLocks()) {
            // if lock is owned by current user, do not display message for it
            if (!lock.isOwnedByUser(GlobalVariables.getUserSession().getPerson())) {
                isLocked = true;
            }
        }
        return isLocked;
    }

    protected boolean isAdmin(String userId, String namespace, String role) {
        return systemAuthorizationService.hasRole(userId, namespace, role);
    }
    
    protected boolean isRequestForSuspension(ProtocolSubmissionBase submission, String submissionType) {
        if (submission != null && submissionType.equals(submission.getSubmissionTypeCode())) {
            return true;
        }
        return false;
    }

    public SystemAuthorizationService getSystemAuthorizationService() {
        return systemAuthorizationService;
    }

    public void setSystemAuthorizationService(SystemAuthorizationService systemAuthorizationService) {
        this.systemAuthorizationService = systemAuthorizationService;
    }
}
