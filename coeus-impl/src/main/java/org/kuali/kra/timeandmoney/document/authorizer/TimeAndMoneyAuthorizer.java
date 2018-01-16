/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.document.authorizer;

import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizerBase;
import org.kuali.kra.timeandmoney.document.TimeAndMoneyDocument;
import org.kuali.kra.timeandmoney.document.authorization.TimeAndMoneyTask;

/**
 * An Time And Money Authorizer determines if a user can perform a given task on a Time and Money document.  
 */
public abstract class TimeAndMoneyAuthorizer extends TaskAuthorizerBase {
    
    private KcAuthorizationService kraAuthorizationService;
    
    @Override
    public final boolean isAuthorized(String userId, Task task) {
        return isAuthorized(userId, (TimeAndMoneyTask) task);
    }

    /**
     * Is the user authorized to execute the given Time and Money task?
     * @param username the user's unique username
     * @param task the Time And Money task
     * @return true if the user is authorized; otherwise false
     */
    public abstract boolean isAuthorized(String userId, TimeAndMoneyTask task);
    
    /**
     * Set the Kra Authorization Service.  Usually injected by the Spring Framework.
     * @param kraAuthorizationService
     */
    public void setKraAuthorizationService(KcAuthorizationService kraAuthorizationService) {
        this.kraAuthorizationService = kraAuthorizationService;
    }
    
    /**
     * Does the given user has the permission for this Time And Money?
     * @param username the unique username of the user
     * @param timeAndMoneyDocument the Time And Money
     * @param permissionName the name of the permission
     * @return true if the person has the permission; otherwise false
     */
    protected final boolean hasPermission(String userId, TimeAndMoneyDocument timeAndMoneyDocument, String permissionName) {
        return kraAuthorizationService.hasPermission(userId, timeAndMoneyDocument, permissionName);
    }
}
