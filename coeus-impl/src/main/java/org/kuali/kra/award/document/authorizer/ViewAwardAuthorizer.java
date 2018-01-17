/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.document.authorizer;

import org.kuali.kra.award.document.authorization.AwardTask;
import org.kuali.kra.award.infrastructure.AwardPermissionConstants;

/**
 * The View Award Authorizer determines if a user has the right
 * to view a specific award.
 */
public class ViewAwardAuthorizer extends AwardAuthorizer {

    @Override
    public boolean isAuthorized(String userId, AwardTask task) {
        return hasPermission(userId, task.getAward(), AwardPermissionConstants.VIEW_AWARD.getAwardPermission());
    }
}
