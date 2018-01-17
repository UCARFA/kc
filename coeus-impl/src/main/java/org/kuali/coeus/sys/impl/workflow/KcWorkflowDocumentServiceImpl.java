/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.workflow;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentConstants;
import org.kuali.coeus.sys.impl.workflow.action.KcRecallAction;
import org.kuali.coeus.sys.impl.workflow.action.KcReturnToPreviousNodeAction;
import org.kuali.rice.core.api.util.RiceKeyConstants;
import org.kuali.rice.kew.actions.RecallAction;
import org.kuali.rice.kew.actions.ReturnToPreviousNodeAction;
import org.kuali.rice.kew.api.exception.InvalidActionTakenException;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValue;
import org.kuali.rice.kew.routeheader.service.impl.WorkflowDocumentServiceImpl;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.krad.util.GlobalVariables;

public class KcWorkflowDocumentServiceImpl extends WorkflowDocumentServiceImpl {

    @Override
    public DocumentRouteHeaderValue returnDocumentToPreviousNode(String principalId, DocumentRouteHeaderValue routeHeader, String destinationNodeName, String annotation)
            throws InvalidActionTakenException {

        if (isProposalDevelopmentDocument(routeHeader)) {
            Principal principal = loadPrincipal(principalId);
            ReturnToPreviousNodeAction action = new KcReturnToPreviousNodeAction(routeHeader, principal, annotation, destinationNodeName, true);
            action.performAction();
            return finish(routeHeader);
        } else {
            return super.returnDocumentToPreviousNode(principalId, routeHeader, destinationNodeName, annotation);
        }
    }

    @Override
    public DocumentRouteHeaderValue recallDocument(String principalId, DocumentRouteHeaderValue routeHeader, String annotation, boolean cancel) throws InvalidActionTakenException {
        if (isProposalDevelopmentDocument(routeHeader)) {
            if (!routeHeader.isFinal() && !routeHeader.isProcessed()) {
                final Principal principal = loadPrincipal(principalId);
                final RecallAction action = new KcRecallAction(routeHeader, principal, annotation, cancel);
                action.performAction();
                indexForSearchAfterActionIfNecessary(routeHeader);
            } else {
                GlobalVariables.getMessageMap().putError("document", RiceKeyConstants.MESSAGE_RECALL_NOT_SUPPORTED);
            }
            return finish(routeHeader);
        } else {
            return super.recallDocument(principalId, routeHeader, annotation, cancel);
        }
    }

    protected boolean isProposalDevelopmentDocument(DocumentRouteHeaderValue routeHeader) {
        return routeHeader.getDocumentType() != null &&
                routeHeader.getDocumentType().getName().equalsIgnoreCase(ProposalDevelopmentConstants.KewConstants.PROPOSAL_DEVELOPMENT_DOCUMENT);
    }
}
