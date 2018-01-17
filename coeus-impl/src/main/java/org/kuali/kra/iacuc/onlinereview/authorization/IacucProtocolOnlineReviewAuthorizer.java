/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview.authorization;

import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizerBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewBase;

public abstract class IacucProtocolOnlineReviewAuthorizer extends TaskAuthorizerBase {
    private KcAuthorizationService kraAuthorizationService;
   
    
    @Override
    public final boolean isAuthorized(String userId, Task task) {
        return isAuthorized(userId, (IacucProtocolOnlineReviewTask) task);
    }

    public abstract boolean isAuthorized(String userId, IacucProtocolOnlineReviewTask task);

        /**
     * Set the Kra Authorization Service.  Usually injected by the Spring Framework.
     * @param kraAuthorizationService
     */
    public void setKraAuthorizationService(KcAuthorizationService kraAuthorizationService) {
        this.kraAuthorizationService = kraAuthorizationService;
    }
    
    /**
     * Does the given user have the permission for this protocol?
     * @param userId the unique username of the user
     * @param protocolOnlineReview the protocol
     * @param permissionName the name of the permission
     * @return true if the person has the permission; otherwise false
     */
    protected final boolean hasPermission(String userId, ProtocolOnlineReviewBase protocolOnlineReview, String permissionName) {
        return kraAuthorizationService.hasPermission(userId, protocolOnlineReview, permissionName);
    }


    /**
     * Gets the kraAuthorizationService attribute. 
     * @return Returns the kraAuthorizationService.
     */
    public KcAuthorizationService getKraAuthorizationService() {
        return kraAuthorizationService;
    }
}
