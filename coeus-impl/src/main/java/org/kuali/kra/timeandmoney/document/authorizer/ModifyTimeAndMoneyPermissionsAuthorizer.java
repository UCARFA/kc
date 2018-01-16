/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.document.authorizer;

import org.kuali.kra.award.infrastructure.AwardPermissionConstants;
import org.kuali.kra.timeandmoney.document.authorization.TimeAndMoneyTask;

/**
 * The Modify Time and Money Permissions Authorizer checks to see if the user has 
 * permission to maintain Time and Money access, i.e. assign Users to Time and Money Roles.
 */
public class ModifyTimeAndMoneyPermissionsAuthorizer extends TimeAndMoneyAuthorizer {

    @Override
    public boolean isAuthorized(String userId, TimeAndMoneyTask task) {
        return hasPermission(userId, task.getTimeAndMoneyDocument(), AwardPermissionConstants.MODIFY_AWARD.getAwardPermission());
    }
}
