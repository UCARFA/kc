/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.maintenance;

import org.kuali.rice.kns.lookup.KualiLookupableImpl;


public class CoiDisclosureEventTypeLookupableImpl extends KualiLookupableImpl {
    
    private static final String MAINTENANCE = "maintenance.do";
    private static final String NEW_MAINTENANCE = "../maintenanceCoiDisclosureEvent.do";
    
    /**
     * new url goes to the custom coi disclosure event type maintenance action 
     * @see org.kuali.rice.kns.lookup.KualiLookupableImpl#getCreateNewUrl()
     */
    @Override
    public String getCreateNewUrl() {
        String originalURL = super.getCreateNewUrl();
        return originalURL.replace(MAINTENANCE, NEW_MAINTENANCE);    
    }
    
}
