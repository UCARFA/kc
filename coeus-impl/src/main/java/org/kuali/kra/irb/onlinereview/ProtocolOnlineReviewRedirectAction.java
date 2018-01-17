/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewRedirectActionBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;

public class ProtocolOnlineReviewRedirectAction extends ProtocolOnlineReviewRedirectActionBase  {

    @Override
    protected Class<? extends ProtocolBase> getProtocolClass() {
        return Protocol.class;
    }

    @Override
    protected Class<? extends ProtocolOnlineReviewService> getProtocolOnlineReviewServiceClassHook() {
        return org.kuali.kra.irb.onlinereview.ProtocolOnlineReviewService.class;
    }

    @Override
    protected String getAdminRoleName() {
        return "IRB Administrator";
    }

    @Override
    protected String getProtocolOnlineReviewActionIdHook() {
        return "protocolOnlineReview";
    }
}
