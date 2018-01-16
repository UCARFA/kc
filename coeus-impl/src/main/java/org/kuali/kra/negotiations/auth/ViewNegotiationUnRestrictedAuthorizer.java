/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.negotiations.auth;

import org.kuali.kra.infrastructure.PermissionConstants;

public class ViewNegotiationUnRestrictedAuthorizer extends NegotiationAuthorizer {

    @Override
    public boolean isAuthorized(String userId, NegotiationTask task) {
        
        boolean retVal = hasPermission(userId, task.getNegotiationDocument().getNegotiation(), PermissionConstants.NEGOTIATION_VIEW_NEGOTIATION_UNRESTRICTED);
        return retVal;
    }

}
