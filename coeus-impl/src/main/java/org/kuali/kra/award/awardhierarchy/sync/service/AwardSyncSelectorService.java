/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.awardhierarchy.sync.service;

import org.kuali.kra.award.awardhierarchy.sync.AwardSyncChange;
import org.kuali.kra.award.home.Award;

import java.util.List;

public interface AwardSyncSelectorService {

    /**
     * 
     * Returns true is at least one change is applicable to this award.
     * @param award
     * @param changes
     * @return
     */
    boolean isAwardInvolvedInSync(Award award, List<AwardSyncChange> changes);
    
    /**
     * 
     * Using the award sync selector service decide if the change is applicable to the award
     * matching active status and fabricated and cost sharing account selectors.
     * @param award
     * @param change
     * @return
     */
    boolean isChangeApplicableToAward(Award award, AwardSyncChange change);
    
    
    /**
     * 
     * Returns true is an award status matches a value found in the
     * Active Award Status Codes parameter
     * @param award
     * @return
     */
    boolean isAwardActive(Award award);
    
    /**
     * 
     * Returns true if the award is a fabricated account award
     * @param award
     * @return
     */
    boolean isFabricatedAccount(Award award);
    
    /**
     * 
     * Returns true if the award is a cost sharing account
     * @param award
     * @return
     */
    boolean isCostShareAccount(Award award);
}
