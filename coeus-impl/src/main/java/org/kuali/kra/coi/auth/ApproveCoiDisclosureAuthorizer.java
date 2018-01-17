/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.auth;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.infrastructure.PermissionConstants;

public class ApproveCoiDisclosureAuthorizer extends CoiDisclosureAuthorizer {

    @Override
    public boolean isAuthorized(String userId, CoiDisclosureTask task) {
        return hasPermission(userId, task.getCoiDisclosure(), PermissionConstants.APPROVE_COI_DISCLOSURE) && isSubmitted(task);
    }

    protected boolean isSubmitted(CoiDisclosureTask task) {
        CoiDisclosure disclosure = task.getCoiDisclosure();
        
        if (disclosure.getCoiDisclosureDocument().getDocumentHeader().hasWorkflowDocument() &&
            disclosure.getCoiDisclosureDocument().getDocumentHeader().getWorkflowDocument().isEnroute()) {
            return true;
        }
        return false;
    }
}
