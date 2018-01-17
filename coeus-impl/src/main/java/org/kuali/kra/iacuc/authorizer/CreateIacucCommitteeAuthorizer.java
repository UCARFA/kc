/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.authorizer;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizerBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * The Create Committee Authorizer checks to see if the user has 
 * permission to create a committee. The user must have the ADD_COMMITTEE
 * permission in any of the units in order to create a committee.
 */
public class CreateIacucCommitteeAuthorizer extends TaskAuthorizerBase {

    @Override
    public boolean isAuthorized(String userId, Task task) {
        return hasUnitPermission(userId, Constants.MODULE_NAMESPACE_IACUC, PermissionConstants.ADD_IACUC_COMMITTEE);
    }
}
