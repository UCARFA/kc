/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;

import org.kuali.coeus.common.framework.version.VersionException;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.kew.api.exception.WorkflowException;


public interface AwardSyncService {    
    
    /**
     * Run all validation checks against the award in the hierarchy and the sync changes attached to the specified award
     * @param award
     * @return
     * @throws WorkflowException 
     */
    void validateHierarchyChanges(Award award);
    
    /**
     * Apply the sync changes queued on the specified award against the award hierarchy  
     * @param award
     * @param logs 
     * @return
     * @throws VersionException 
     * @throws WorkflowException 
     */
    void applyAwardSyncChangesToHierarchy(Award award); 
    
    /**
     * Checks to see if the award hierarchy is locked for the given principal.
     * Hierarchy is locked if there is an award higher in the hierarchy enroute with
     * award hierarchy descendant sync and the principal is not who routed the parent document.
     * @param awardDocument
     * @param principalId
     * @return the award document responsible for the lock
     */
    AwardDocument getAwardLockingHierarchyForSync(AwardDocument awardDocument, String principalId);
}
