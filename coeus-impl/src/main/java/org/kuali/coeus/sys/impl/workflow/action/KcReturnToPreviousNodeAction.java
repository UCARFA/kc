/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.workflow.action;

import java.util.Collections;
import java.util.List;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentConstants.KewConstants;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kew.actionrequest.ActionRequestFactory;
import org.kuali.rice.kew.actionrequest.ActionRequestValue;
import org.kuali.rice.kew.actions.ReturnToPreviousNodeAction;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.action.ActionRequestPolicy;
import org.kuali.rice.kew.engine.node.RouteNode;
import org.kuali.rice.kew.engine.node.RouteNodeInstance;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValue;
import org.kuali.rice.kim.api.identity.principal.Principal;
import org.kuali.rice.kim.api.role.Role;
import org.kuali.rice.kim.api.role.RoleMembership;
import org.kuali.rice.kim.api.role.RoleService;

public class KcReturnToPreviousNodeAction extends ReturnToPreviousNodeAction {

    public KcReturnToPreviousNodeAction(DocumentRouteHeaderValue routeHeader, Principal principal, String annotation, String destinationNodeName, boolean b) {
        super(routeHeader, principal, annotation, destinationNodeName, b);
    }

    @Override
    public void processReturnToInitiator(RouteNodeInstance newNodeInstance) {
        RouteNode initialNode = newNodeInstance.getRouteNode().getDocumentType().getPrimaryProcess().getInitialRouteNode();
        if (initialNode != null) {
            if (newNodeInstance.getRouteNode().getRouteNodeId().equals(initialNode.getRouteNodeId())) {
                LOG.debug("Document was returned to initiator");
                ActionRequestFactory arFactory = new ActionRequestFactory(getRouteHeader(), newNodeInstance);
                String actionRequestCode = getReturnToInitiatorActionRequestType().getCode();

                Role aggregatorRole = getRoleService().getRoleByNamespaceCodeAndName(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, RoleConstants.AGGREGATOR_DOCUMENT_LEVEL);
                List<RoleMembership> memberships = getRoleService().getRoleMembers(Collections.singletonList(
                        aggregatorRole.getId()), Collections.singletonMap(KcKimAttributes.DOCUMENT_NUMBER, newNodeInstance.getDocumentId()));

                if (memberships != null && !memberships.isEmpty()) {
                    ActionRequestValue roleMemberRequest = arFactory.addKimRoleRequest(actionRequestCode, 1, aggregatorRole,
                            memberships, KewConstants.AGGREGATORS_REQUEST_FOR_REVIEW_ANNOTATION, KewApiConstants.MACHINE_GENERATED_RESPONSIBILITY_ID,
                            true, ActionRequestPolicy.FIRST.getCode(), null, false);
                    roleMemberRequest.setAnnotation(KewConstants.AGGREGATORS_REQUEST_FOR_REVIEW_ANNOTATION);
                    roleMemberRequest.getChildrenRequests().forEach(actionRequest -> actionRequest.setAnnotation(KewConstants.AGGREGATORS_REQUEST_FOR_REVIEW_ANNOTATION));
                    getActionRequestService().activateRequest(roleMemberRequest);
                }
            }
        }
    }
    
    protected RoleService getRoleService() {
    	return KcServiceLocator.getService(RoleService.class);
    }
}
