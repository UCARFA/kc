/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.permissions;

import org.kuali.coeus.common.permissions.impl.rules.PermissionsRuleBase;
import org.kuali.kra.award.infrastructure.AwardRoleConstants;

/**
 * Business Rule to determine the legality of modifying the access
 * to a Protocol Document.
 * 
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public class AwardPermissionsRule extends PermissionsRuleBase {
    
    @Override
    protected String getAdministratorRoleName() {
        return AwardRoleConstants.AWARD_MODIFIER.getAwardRole();
    }   
}
