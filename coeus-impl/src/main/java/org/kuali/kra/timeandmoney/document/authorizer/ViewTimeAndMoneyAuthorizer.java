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
 * The View Time and Money Authorizer determines if a user has the right
 * to view a specific Time and Money document.
 */
public class ViewTimeAndMoneyAuthorizer extends TimeAndMoneyAuthorizer {

    @Override
    public boolean isAuthorized(String userId, TimeAndMoneyTask task) {
        return hasPermission(userId, task.getTimeAndMoneyDocument(), AwardPermissionConstants.VIEW_AWARD.getAwardPermission());
    }
}
