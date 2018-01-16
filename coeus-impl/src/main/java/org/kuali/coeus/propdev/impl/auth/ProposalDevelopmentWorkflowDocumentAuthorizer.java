/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.auth;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.common.framework.auth.KcWorkflowDocumentAuthorizerBase;
import org.kuali.coeus.common.framework.auth.perm.Permissionable;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kew.routeheader.DocumentRouteHeaderValue;

public class
        ProposalDevelopmentWorkflowDocumentAuthorizer extends KcWorkflowDocumentAuthorizerBase {

    @Override
    protected Permissionable getPermissionable(String documentId) {
        try {
            return (ProposalDevelopmentDocument) getDocumentService().getByDocumentHeaderId(documentId);
        }
        catch (WorkflowException e) {
            LOG.warn("Unable to load ProposalDevelopmentDocument - " + documentId + " for workflow authorizer", e);
        }
        return null;
    }

    @Override
    public boolean canReturnToPreviousRouteNode(String principalId, DocumentRouteHeaderValue document) {
        return getPermissionService().hasPermission(principalId, Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT,
                PermissionConstants.RETURN_PROPOSAL_DEVELOPMENT_DOCUMENT);
    }

}
