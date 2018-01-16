/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;

import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncPendingChangeBean;
import org.kuali.kra.award.awardhierarchy.sync.AwardSyncXmlExport;
import org.kuali.kra.award.home.Award;

public interface AwardSyncCreationService {
    
    /**
     * Generate a AwardSyncChange BO from the sync type, the attr name and the syncable bo.
     * @param syncType
     * @param syncableObject
     * @param attrName
     * @return
     * @throws Exception 
     */
    AwardSyncChange createAwardSyncChange(AwardSyncPendingChangeBean pendingChange) throws Exception;

    /**
     * 
     * Create and add a new award hierarchy sync object to the award, checking for and replacing any duplicates found
     * @param award
     * @param syncType
     * @param syncableObject
     * @param attrName
     * @throws Exception 
     */
    void addAwardSyncChange(Award award, AwardSyncPendingChangeBean pendingChange) throws Exception;
    
    /**
     * 
     * Add a new award hierarchy sync object to the award, 
     * checking for and replacing any duplicates found.
     * @param award
     * @param syncChange
     */
    void addAwardSyncChange(Award award, AwardSyncChange syncChange); 
    
    /**
     * 
     * Returns the {@link AwardSyncXmlExport} from reading the xml included in change.
     * @param change
     * @return
     */
    AwardSyncXmlExport getXmlExport(AwardSyncChange change);   

}
