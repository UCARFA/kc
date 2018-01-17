/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.coeus.sys.framework.workflow.KcWorkflowService;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.irb.ProtocolDocument;

/**
 * Is the user allowed to approve protocols?
 */
public class ProtocolApproveOtherAuthorizer extends ProtocolAuthorizer {

    private KcWorkflowService kraWorkflowService;

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        ProtocolDocument protocolDocument = (ProtocolDocument) task.getProtocol().getProtocolDocument();

        return kraWorkflowService.isUserActionRequested(protocolDocument, userId) && 
            (!kraWorkflowService.isDocumentOnNode(protocolDocument, Constants.PROTOCOL_IRBREVIEW_ROUTE_NODE_NAME) || 
                    (kraWorkflowService.isUserAdHocRequestRecipient(protocolDocument, userId, null) && !kraWorkflowService.isUserRouteRespRequestRecipient(protocolDocument, userId, null))
            );
    }


    public KcWorkflowService getKraWorkflowService() {
        return kraWorkflowService;
    }

    public void setKraWorkflowService(KcWorkflowService kraWorkflowService) {
        this.kraWorkflowService = kraWorkflowService;
    }
}
