/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.framework.core;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.kim.api.KimConstants;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizerBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.HashMap;
import java.util.Map;

public class AccountDocumentAuthorizer extends MaintenanceDocumentAuthorizerBase {
    public static final String PERMISSION_MAINTAIN_ACCOUNT = "Create Account Document";
    public static final String KC_SYS = "KC-SYS";


    @Override
    public boolean canInitiate(String documentTypeName, Person user) {
        Map<String, String> permissionDetails = new HashMap<>();
        permissionDetails.put(KimConstants.AttributeConstants.DOCUMENT_TYPE_NAME, documentTypeName);

        boolean retVal = getPermissionService().isAuthorized(user.getPrincipalId(), Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, PERMISSION_MAINTAIN_ACCOUNT, permissionDetails);
        return retVal;
    }

    @Override
    public boolean canMaintain(Object dataObject, Person user) {
        Map<String, String> permissionDetails = new HashMap<String, String>(2);
        permissionDetails.put(KimConstants.AttributeConstants.DOCUMENT_TYPE_NAME,
                getDocumentDictionaryService().getMaintenanceDocumentTypeName(
                        dataObject.getClass()));
        permissionDetails.put(KRADConstants.MAINTENANCE_ACTN, KC_SYS);
        return !permissionExistsByTemplate(KC_SYS,
                KimConstants.PermissionTemplateNames.INITIATE_DOCUMENT,
                permissionDetails)
                || isAuthorizedByTemplate(
                dataObject,
                KC_SYS,
                KimConstants.PermissionTemplateNames.INITIATE_DOCUMENT,
                user.getPrincipalId(), permissionDetails, null);
    }

    @Override
    public boolean canCopy(Document document, Person user) {
        return canInitiate(document.getDocumentHeader().getWorkflowDocument().getDocumentTypeName(), user);
    }
}