/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview.authorization;

import org.kuali.kra.infrastructure.PermissionConstants;

/*
 * Allows checks from the ProtocolOnlineReview for MAINTAIN_ONLINE_REVIEWS persmission on the parent Protocol.
 */
public class MaintainProtocolOnlineReviewsAuthorizer extends ProtocolOnlineReviewAuthorizer {

    @Override
    public boolean isAuthorized(String userId, ProtocolOnlineReviewTask task) {
        return getKraAuthorizationService().hasPermission(userId, task.getProtocolOnlineReview().getProtocol(),PermissionConstants.MAINTAIN_ONLINE_REVIEWS);
    }

}
