/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.maintenance;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.maintenance.KraMaintainableImpl;
import org.kuali.rice.krad.bo.DocumentHeader;

public class CoiDisclosureEventTypeMaintainableImpl extends KraMaintainableImpl {

    private static final long serialVersionUID = -316878223662581136L;
    private transient CoiDisclosureEventTypeToCoeusSubModuleSynchronizerService synchronizerService;
    
    @Override
    public void doRouteStatusChange(DocumentHeader documentHeader) {
        executeAsLastActionUser(() -> {
            CoiDisclosureEventTypeToCoeusSubModuleSynchronizerService synchronizer = getSynchronizerService();
            synchronizer.synchronizeCoeusSubModulesWithActiveCoiDisclosureEventTypes();
            return null;
        });
    }
    
    public CoiDisclosureEventTypeToCoeusSubModuleSynchronizerService getSynchronizerService() {
        if(synchronizerService == null) {
            setSynchronizerService(KcServiceLocator.getService(CoiDisclosureEventTypeToCoeusSubModuleSynchronizerService.class));
        }
        return synchronizerService;
    }

    public void setSynchronizerService(CoiDisclosureEventTypeToCoeusSubModuleSynchronizerService synchronizerService) {
        this.synchronizerService = synchronizerService;
    }


    

}
