/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.rpt.cust;

import org.kuali.coeus.common.framework.auth.UnitAuthorizationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kns.document.authorization.MaintenanceDocumentAuthorizerBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.util.GlobalVariables;

public class CustReportRightDocumentAuthorizer extends MaintenanceDocumentAuthorizerBase{
    
    private static final long serialVersionUID = 1L;
    
    public static final String PERMISSION_NAME = "MAINTAIN CUSTOM REPORTS";
    public static final String NAME_SPACE = "KC-UNT";
    private UnitAuthorizationService unitAuthorizationService;
    
    @Override
    public boolean canCreate(Class boClass, Person user) {
        boolean retVal = super.canCreate(boClass, user);
        String userId = GlobalVariables.getUserSession().getPrincipalId();
        retVal = getUnitAuthorizationService().hasPermission(userId, NAME_SPACE, PERMISSION_NAME);
        return retVal;
    }

    @Override
    public boolean canEdit(Document document, Person user) {
        boolean retVal = super.canEdit(document, user);
        String userId = GlobalVariables.getUserSession().getPrincipalId();
        retVal = getUnitAuthorizationService().hasPermission(userId, NAME_SPACE, PERMISSION_NAME);
        return retVal;
    }

    @Override
    public boolean canMaintain(Object dataObject, Person user) {
        boolean retVal = super.canMaintain(dataObject, user);
        String userId = GlobalVariables.getUserSession().getPrincipalId();
        retVal = getUnitAuthorizationService().hasPermission(userId, NAME_SPACE, PERMISSION_NAME);
        return retVal;
    }

    /**
     * Gets the unitAuthorizationService attribute. 
     * @return Returns the unitAuthorizationService.
     */
    public UnitAuthorizationService getUnitAuthorizationService() {
        if (unitAuthorizationService == null) {
            unitAuthorizationService = KcServiceLocator.getService(UnitAuthorizationService.class);
        }
        return unitAuthorizationService;
    }

    /**
     * Sets the unitAuthorizationService attribute value.
     * @param unitAuthorizationService The unitAuthorizationService to set.
     */
    public void setUnitAuthorizationService(UnitAuthorizationService unitAuthorizationService) {
        this.unitAuthorizationService = unitAuthorizationService;
    }
}
