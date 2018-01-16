/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.coeus.common.framework.unit.admin.UnitAdministratorType;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.rice.core.api.util.KeyValue;

import java.util.List;

/**
 * This class finds Award Unit Contact Project Roles
 */
public class AwardCentralAdminProjectRolesValuesFinder extends AwardContactsProjectRoleValuesFinder {

    @Override
    protected Class<? extends ContactRole> getRoleType() {
        return UnitAdministratorType.class;
    }    
    
    /**
     * Override to not inlude empty selection.
     * 
     * This is a hack to make the silly Rule API behave properly. Because CentralAdmin contacts and unit Contacts are stored 
     * in the same collection, the Rule API will use the UnitContact BO type to build the error path when an error occurs.
     * This causes the CentralAdmin errors to show up in the UnitContact tab panel.
     * 
     * The only user error that can occur not selecting a project role. By removing the blank from the selection list
     * we can force a contact role to be applied to the CentralAdmin, thus preventing the user error. 
     * 
     * The Rule API is so moronic, there are untold numbers of hacks in the system to satisfy this API. Yes, this is just another one.
     * 
     * @see org.kuali.kra.award.contacts.AwardContactsProjectRoleValuesFinder#addEmptyKeyValuePair(java.util.List)
     */
    @Override
    protected void addEmptyKeyValuePair(List<KeyValue> keyValues) {
        // intentionally do nothing
    }
    
}
