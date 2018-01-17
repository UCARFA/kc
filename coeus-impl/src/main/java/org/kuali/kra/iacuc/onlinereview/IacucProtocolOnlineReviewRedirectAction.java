/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.onlinereview;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewRedirectActionBase;
import org.kuali.kra.protocol.onlinereview.ProtocolOnlineReviewService;

public class IacucProtocolOnlineReviewRedirectAction extends ProtocolOnlineReviewRedirectActionBase{

    @Override
    protected Class<IacucProtocol> getProtocolClass() {
        return IacucProtocol.class;
    }
    
    @Override
    protected String getAdminRoleName() {
        return "IACUC Administrator";
    }

    @Override
    protected Class<? extends ProtocolOnlineReviewService> getProtocolOnlineReviewServiceClassHook() {
        return IacucProtocolOnlineReviewService.class;
    }

    @Override
    protected String getProtocolOnlineReviewActionIdHook() {
        return "iacucProtocolOnlineReview";
    }
  

}
