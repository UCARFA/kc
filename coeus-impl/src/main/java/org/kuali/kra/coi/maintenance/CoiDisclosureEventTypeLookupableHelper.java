/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.maintenance;

import org.kuali.rice.kns.lookup.KualiLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;

import java.util.List;

public class CoiDisclosureEventTypeLookupableHelper extends KualiLookupableHelperServiceImpl {
    
    private static final String MAINTENANCE = "maintenance.do";
    private static final String NEW_MAINTENANCE = "../maintenanceCoiDisclosureEvent.do";
    
    
    /**
     * new url goes to the custom coi disclosure event type maintenance action 
     */
    @Override
    protected String getActionUrlHref(BusinessObject businessObject, String methodToCall, List pkNames) {
        String originalURL = super.getActionUrlHref(businessObject, methodToCall, pkNames);
        return originalURL.replace(MAINTENANCE, NEW_MAINTENANCE);
    }

}
