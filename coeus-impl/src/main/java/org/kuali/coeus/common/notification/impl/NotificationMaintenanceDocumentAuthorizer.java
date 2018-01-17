/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.notification.impl;

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

public class NotificationMaintenanceDocumentAuthorizer extends MaintenanceDocumentAuthorizerBase {

    @Override
    public Set<String> getDocumentActions(Document document, Person user, Set<String> documentActions) {
        Set<String> actions = getDocumentActions(document);
        actions = super.getDocumentActions(document, user, actions);
        return actions;
    }

    protected Set<String> getDocumentActions(Document document) {
        Set<String> documentActions = new HashSet<String>();
        boolean hasModifyPermission = getKcNotificationAuthorizationService().hasPermission(
                PermissionConstants.MODIFY_NOTIFICATION);
        boolean hasViewPermission = hasModifyPermission
                || getKcNotificationAuthorizationService().hasPermission(
                        PermissionConstants.VIEW_NOTIFICATION);
        if (hasModifyPermission) {
            documentActions = getDocumentActionsWithModifyPermission(document);
        }
        else if (hasViewPermission) {
            documentActions = getDocumentActionsWithViewPermission(document);
        }
        else {
            throw new AuthorizationException(GlobalVariables.getUserSession().getPerson().getPrincipalName(), "Edit/View", "Notification");
        }
        return documentActions;
    }

    private KcNotificationAuthorizationService getKcNotificationAuthorizationService() {
        return KcServiceLocator.getService(KcNotificationAuthorizationService.class);
    }
    
    private Set<String> getDocumentActionsWithModifyPermission(Document document) {
        Set<String> documentActions = new HashSet<String>();
        if (document.getDocumentHeader().getWorkflowDocument().isInitiated()
                || document.getDocumentHeader().getWorkflowDocument().isSaved()) {
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
        if (document.getDocumentHeader().getWorkflowDocument().isInitiated()) {
            if (maintAction.equals(KRADConstants.MAINTENANCE_COPY_ACTION)) {
                throw new AuthorizationException(GlobalVariables.getUserSession().getPerson().getPrincipalName(), "Copy", "Notification");
            }
            else if (maintAction.equals(KRADConstants.MAINTENANCE_NEW_ACTION)) {
                throw new AuthorizationException(GlobalVariables.getUserSession().getPerson().getPrincipalName(), "Create", "Notification");
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
