/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.auth;

public class ModifyIacucProtocolCorrespondenceAuthorizer extends IacucProtocolAuthorizer {

    private static final String MODIFY_IACUC_CORRESPONDENCE_PERMISSION_NAME = "Modify IACUC Correspondence";

    @Override
    public boolean isAuthorized(String userId, IacucProtocolTask task) {
        return hasPermission(userId, task.getProtocol(), MODIFY_IACUC_CORRESPONDENCE_PERMISSION_NAME);
    }

}
