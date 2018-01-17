/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.auth;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.infrastructure.PermissionConstants;

/**
 * 
 * This class is to check if user has permission to view coi disclosure
 */
public class ViewCoiDisclosureAuthorizer extends CoiDisclosureAuthorizer {

    @Override
    public boolean isAuthorized(String userId, CoiDisclosureTask task) {
        CoiDisclosure coiDisclosure = task.getCoiDisclosure();
        return hasPermission(userId, coiDisclosure, PermissionConstants.VIEW_COI_DISCLOSURE)
                || hasPermission(userId, coiDisclosure, PermissionConstants.MAINTAIN_COI_DISCLOSURE)
                || StringUtils.equals(userId, coiDisclosure.getPersonId());

    }
        
}
