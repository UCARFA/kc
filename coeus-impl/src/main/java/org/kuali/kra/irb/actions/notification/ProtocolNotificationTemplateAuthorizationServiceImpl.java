/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * This class is to implement the detail of permission check for modify/view notification template.
 */
public class ProtocolNotificationTemplateAuthorizationServiceImpl implements ProtocolNotificationTemplateAuthorizationService {
    private UnitAuthorizationService unitAuthorizationService;
    private KcPersonService kcPersonService;


    @Override
    public boolean hasPermission(String permissionName) {
        KcPerson person = kcPersonService.getKcPersonByUserName(getUserName());
        return unitAuthorizationService.hasPermission(person.getPersonId(), "KC-PROTOCOL", permissionName);

    }

    protected String getUserName() {
        return GlobalVariables.getUserSession().getPerson().getPrincipalName();
    }

    /**
     * 
     * This method inject UnitAuthorizationService.
     * 
     * @param unitAuthorizationService
     */
    public void setUnitAuthorizationService(UnitAuthorizationService unitAuthorizationService) {
        this.unitAuthorizationService = unitAuthorizationService;
    }

    /**
     * 
     * This method inject KcPersonService.
     * 
     * @param kcPersonService
     */
    public void setKcPersonService(KcPersonService kcPersonService) {
        this.kcPersonService = kcPersonService;
    }

}
