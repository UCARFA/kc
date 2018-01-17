/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.maintenance;

public interface CoiDisclosureEventTypeToCoeusSubModuleSynchronizerService {
    
    
    
    /**
     * This method ensures that the Coeus submodule entries for the coi module
     * correspond exactly to the set of all active coi disclosure event types.
     * 
     * So if a pre-existing active disclosure event type is deactivated or deleted before this 
     * method runs, then the corresponding coeus submodule code entry (i.e. the one matching 
     * the event type code) will be deleted. If a pre-existing active disclosure event type's
     * description is changed, then the corresponding coeus submodule code entry's description 
     * will also be updated accordingly. Finally if a new active disclosure event type is added
     * then a new corresponding coeus submodule code entry will be inserted.  
     * 
     */
    public void synchronizeCoeusSubModulesWithActiveCoiDisclosureEventTypes();

}
