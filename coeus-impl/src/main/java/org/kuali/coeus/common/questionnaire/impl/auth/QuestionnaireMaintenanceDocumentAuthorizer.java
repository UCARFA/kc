/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.questionnaire.impl.auth;

import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.document.MaintenanceDocumentBase;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizerBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.exception.AuthorizationException;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * This the document authorizer class of questionnaire maintenance.
 * Based on user permission and document routing status; the documentactions set is created.
 */
public class QuestionnaireMaintenanceDocumentAuthorizer extends MaintenanceDocumentAuthorizerBase {

    @Override
    public Set<String> getDocumentActions(Document document, Person user, Set<String> documentActions) {
        super.getDocumentActions(document, user, documentActions);
        return getDocumentActions(document);
    }

    protected Set<String> getDocumentActions(Document document) {
        Set<String> documentActions = new HashSet<String>();
        boolean hasModifyPermission = getQuestionnaireAuthorizationService().hasPermission(
                PermissionConstants.MODIFY_QUESTIONNAIRE);
        boolean hasViewPermission = hasModifyPermission
                || getQuestionnaireAuthorizationService().hasPermission(
                        PermissionConstants.VIEW_QUESTIONNAIRE);
        if (hasModifyPermission) {
            documentActions = getDocumentActionsWithModifyPermission(document);
        }
        else if (hasViewPermission) {
            documentActions = getDocumentActionsWithViewPermission(document);
        }
        else {
            throw new AuthorizationException(GlobalVariables.getUserSession().getPerson().getPrincipalName(), "Edit/View", "Questionnaire");
        }
        return documentActions;
    }

    private QuestionnaireAuthorizationService getQuestionnaireAuthorizationService() {
        return KcServiceLocator.getService(QuestionnaireAuthorizationService.class);
    }
    
    private Set<String> getDocumentActionsWithModifyPermission(Document document) {
        Set<String> documentActions = new HashSet<String>();
        if (document.getDocumentHeader().getWorkflowDocument().getStatus().getCode().equals("I")
                || document.getDocumentHeader().getWorkflowDocument().getStatus().getCode().equals("S")) {
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_EDIT);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_EDIT_DOCUMENT_OVERVIEW);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_SAVE);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_CLOSE);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_CANCEL);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_BLANKET_APPROVE);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_ROUTE);
        }
        else {
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_RELOAD);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_CLOSE);
        }
        return documentActions;

    }

    private Set<String> getDocumentActionsWithViewPermission(Document document) {
        Set<String> documentActions = new HashSet<String>();
        String maintAction = ((MaintenanceDocumentBase) document).getNewMaintainableObject().getMaintenanceAction();
        if (document.getDocumentHeader().getWorkflowDocument().getStatus().getCode().equals("I")) {
            if (maintAction.equals(KRADConstants.MAINTENANCE_COPY_ACTION)) {
                throw new AuthorizationException(GlobalVariables.getUserSession().getPerson().getPrincipalName(), "Copy", "Questionnaire");
            }
            else if (maintAction.equals(KRADConstants.MAINTENANCE_NEW_ACTION)) {
                throw new AuthorizationException(GlobalVariables.getUserSession().getPerson().getPrincipalName(), "Create", "Questionnaire");
            }
            else {
                documentActions.add(KRADConstants.KUALI_ACTION_CAN_RELOAD);
                documentActions.add(KRADConstants.KUALI_ACTION_CAN_CLOSE);
            }
        }
        else {
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_RELOAD);
            documentActions.add(KRADConstants.KUALI_ACTION_CAN_CLOSE);
        }
        return documentActions;

    }

}
