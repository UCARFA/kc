/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.onlinereview.authorization;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;

/**
 * The Modify Protocol Online Review Authorizer checks to see if the user has 
 * permission to modify a protocol online review. 
 * 
 * Authorization depends on the users role.  If the user is a member of the IRB Administrator
 * role for the related protocol's unit, then that user is always authorized to alter the protocol online review.
 * If the user is the online reviewer, then they are allowed to edit the document provided that
 * they have an outstanding approve request on the document.
 *  
 */
public class RejectProtocolOnlineReviewAuthorizer extends ProtocolOnlineReviewAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, ProtocolOnlineReviewTask task) {
        boolean hasPermission = false;
        ProtocolOnlineReview protocolOnlineReview = task.getProtocolOnlineReview();
        
        if ( protocolOnlineReview.getProtocolOnlineReviewId() == null ) {
            //we never authorize edits on a review, the reviews are created
            //by the system on behalf of the users.
        } else {
            hasPermission = getKraAuthorizationService().hasPermission(userId, protocolOnlineReview.getProtocol(), PermissionConstants.MAINTAIN_ONLINE_REVIEWS);
            hasPermission &= !protocolOnlineReview.getProtocolOnlineReviewDocument().isViewOnly();
            hasPermission &= kraWorkflowService.isEnRoute(task.getProtocolOnlineReviewDocument());
            hasPermission &= kraWorkflowService.isUserApprovalRequested(task.getProtocolOnlineReviewDocument(), userId);
        }

        return hasPermission;
    }

    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}

