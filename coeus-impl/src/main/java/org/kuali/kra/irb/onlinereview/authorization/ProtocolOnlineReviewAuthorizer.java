/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview.authorization;

import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizerBase;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReviewService;

/**
 * A Protocol Authorizer determines if a user can perform
 * a given task on a protocol.  
 */
public abstract class ProtocolOnlineReviewAuthorizer extends TaskAuthorizerBase {
    
    private KcAuthorizationService kraAuthorizationService;
    private ProtocolOnlineReviewService protocolOnlineReviewService;
   
    
    @Override
    public final boolean isAuthorized(String userId, Task task) {
        return isAuthorized(userId, (ProtocolOnlineReviewTask) task);
    }

    
    /**
     * Is the user authorized to execute the given protocol task?
     * @param username the user's unique username
     * @param task the protocol task
     * @return true if the user is authorized; otherwise false
     */
    public abstract boolean isAuthorized(String userId, ProtocolOnlineReviewTask task);
    
    /**
     * Set the Kra Authorization Service.  Usually injected by the Spring Framework.
     * @param kraAuthorizationService
     */
    public void setKraAuthorizationService(KcAuthorizationService kraAuthorizationService) {
        this.kraAuthorizationService = kraAuthorizationService;
    }
    
    /**
     * Does the given user have the permission for this protocol?
     * @param username the unique username of the user
     * @param protocol the protocol
     * @param permissionName the name of the permission
     * @return true if the person has the permission; otherwise false
     */
    protected final boolean hasPermission(String userId, ProtocolOnlineReview protocolOnlineReview, String permissionName) {
        return kraAuthorizationService.hasPermission(userId, protocolOnlineReview, permissionName);
    }


    /**
     * Gets the protocolOnlineReviewService attribute. 
     * @return Returns the protocolOnlineReviewService.
     */
    public ProtocolOnlineReviewService getProtocolOnlineReviewService() {
        return protocolOnlineReviewService;
    }


    /**
     * Sets the protocolOnlineReviewService attribute value.
     * @param protocolOnlineReviewService The protocolOnlineReviewService to set.
     */
    public void setProtocolOnlineReviewService(ProtocolOnlineReviewService protocolOnlineReviewService) {
        this.protocolOnlineReviewService = protocolOnlineReviewService;
    }


    /**
     * Gets the kraAuthorizationService attribute. 
     * @return Returns the kraAuthorizationService.
     */
    public KcAuthorizationService getKraAuthorizationService() {
        return kraAuthorizationService;
    }


}
