/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.document.authorizer;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.subaward.document.authorization.SubAwardTask;

public class addInvoiceSubAwardAuthorizer extends SubAwardAuthorizer {

    @Override
    public boolean isAuthorized(String userId, SubAwardTask task) {
        return hasPermission(userId, task.getSubAwardDocument().getSubAward(), PermissionConstants.VIEW_SUBAWARD);
    }
}
