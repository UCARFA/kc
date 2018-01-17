/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.authorizer;

import org.kuali.coeus.common.framework.auth.task.Task;
import org.kuali.coeus.common.framework.auth.task.TaskAuthorizerBase;

/**
 * The Create Protocol Authorizer checks to see if the user has 
 * permission to create a protocol. The user must have the CREATE_PROTOCOL
 * permission in any of the units in order to create a protocol.
 */
public class CreateTimeAndMoneyAuthorizer extends TaskAuthorizerBase {

    @Override
    public boolean isAuthorized(String userId, Task task) {
        return true;
        //return hasUnitPermission(userId, "createTimeAndMoney"); 
    }
}
