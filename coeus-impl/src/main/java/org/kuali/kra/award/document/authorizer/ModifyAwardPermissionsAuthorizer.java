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
 * The Modify Award Permissions Authorizer checks to see if the user has 
 * permission to maintain award access, i.e. assign Users to Award Roles.
 */
public class ModifyAwardPermissionsAuthorizer extends AwardAuthorizer {

    @Override
    public boolean isAuthorized(String userId, AwardTask task) {
        return !task.getAward().getAwardDocument().isViewOnly() &&
               hasPermission(userId, task.getAward(), AwardPermissionConstants.MODIFY_AWARD.getAwardPermission());
    }
}
