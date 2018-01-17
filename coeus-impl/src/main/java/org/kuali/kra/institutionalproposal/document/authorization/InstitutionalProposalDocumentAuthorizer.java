/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.document.authorization;

import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.coeus.sys.framework.model.KcTransactionalDocumentBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.institutionalproposal.document.InstitutionalProposalDocument;
import org.kuali.kra.kim.bo.KcKimAttributes;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.document.authorization.TransactionalDocumentAuthorizer;
import org.kuali.rice.kns.document.authorization.TransactionalDocumentAuthorizerBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.Map;
import java.util.Set;

/**
 * This class is the Institutional Proposal Document Authorizer.  It determines the edit modes and
 * document actions for all institutional proposal documents.
 */
public class InstitutionalProposalDocumentAuthorizer extends TransactionalDocumentAuthorizerBase 
    implements TransactionalDocumentAuthorizer {
    
    public static final String ALLOW_INIT_FOR_DISAPPROVED_PD_SESSION_KEY = "DISAPPROVED_PD_WITH_LINKED_IP";

    @Override
    public Set<String> getDocumentActions(Document document, Person user, Set<String> documentActions) {
        Set<String> actions = super.getDocumentActions(document, user, documentActions);

        InstitutionalProposalDocument institutionalProposalDocument = (InstitutionalProposalDocument) document;
        if (canMaintainInstitutionalProposal(user, institutionalProposalDocument)) {
            actions.add(Constants.CAN_MAINTAIN_IP_ATTACHMENTS);
        }
        if (actions.contains(Constants.CAN_MAINTAIN_IP_ATTACHMENTS) ||
                canViewInstitutionalProposalAttachments(user, institutionalProposalDocument)) {
            actions.add(Constants.CAN_VIEW_IP_ATTACHMENTS);
        }

        return actions;
    }
    @Override
    protected void addRoleQualification(
            Object primaryBusinessObjectOrDocument,
            Map<String, String> attributes) {
        super.addRoleQualification(primaryBusinessObjectOrDocument, attributes);
        InstitutionalProposalDocument institutionalProposalDocument = (InstitutionalProposalDocument) primaryBusinessObjectOrDocument;
        if (institutionalProposalDocument.getInstitutionalProposal() != null 
                && institutionalProposalDocument.getInstitutionalProposal().getLeadUnit() != null) {
            attributes.put(KcKimAttributes.UNIT_NUMBER, institutionalProposalDocument.getInstitutionalProposal().getLeadUnit().getUnitNumber());
        } else {
            attributes.put(KcKimAttributes.UNIT_NUMBER, "*");
        }
    }    
    
    @Override
    public boolean canInitiate(String documentTypeName, Person user) {
        if (GlobalVariables.getUserSession().getObjectMap().get(ALLOW_INIT_FOR_DISAPPROVED_PD_SESSION_KEY) != null) {
            GlobalVariables.getUserSession().removeObject(ALLOW_INIT_FOR_DISAPPROVED_PD_SESSION_KEY);
            return true;
        } else {
            return super.canInitiate(documentTypeName, user);
        }
    }

    @Override
    public boolean canBlanketApprove(Document document, Person user) {
        return !((KcTransactionalDocumentBase)document).isViewOnly() && super.canBlanketApprove(document, user);
    }

    @Override
    public boolean canRoute(Document document, Person user) {
        return !((KcTransactionalDocumentBase)document).isViewOnly() && super.canRoute(document, user);
    }

    @Override
    public boolean canCancel(Document document, Person user) {
        return !((KcTransactionalDocumentBase)document).isViewOnly() && super.canCancel(document,user);
    }

    private boolean canViewInstitutionalProposalAttachments(Person user, InstitutionalProposalDocument document) {
        return getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.VIEW_PROPOSAL) ||
                getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.CANCEL_INSTITUTIONAL_PROPOSAL) ||
                getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.SAVE_INSTITUTIONAL_PROPOSAL) ||
                getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.SUBMIT_INSTITUTIONAL_PROPOSAL) ||
                getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.INITIATE_DOCUMENT);
    }

    private boolean canMaintainInstitutionalProposal(Person user, InstitutionalProposalDocument document) {
        return getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.CREATE_INSTITUTIONAL_PROPOSAL) ||
                getKcAuthorizationService().hasPermission(user.getPrincipalId(), document, PermissionConstants.EDIT_INSTITUTE_PROPOSAL);
    }

    private KcAuthorizationService getKcAuthorizationService() {
        return KcServiceLocator.getService(KcAuthorizationService.class);
    }

}
