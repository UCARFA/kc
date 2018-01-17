/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

public class CreateIrbProtocolCorrespondenceAuthorizer extends ProtocolAuthorizer {

    private static final String CREATE_IRB_CORRESPONDENCE_PERMISSION_NAME = "Create IRB Correspondence";

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        return hasPermission(userId, task.getProtocol(), CREATE_IRB_CORRESPONDENCE_PERMISSION_NAME);
    }

}
