/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.version.history;

import org.kuali.coeus.common.framework.version.sequence.owner.SequenceOwner;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.kra.award.home.Award;

import java.util.List;

public interface VersionHistoryService {

    /**
     * Update or create the version history to the appropriate status. If versionStatus is Active, then all other
     * active versions are set to archived.
     * @param sequenceOwner
     * @param versionStatus
     * @param userId
     * @return
     */
    VersionHistory updateVersionHistory(SequenceOwner<? extends SequenceOwner<?>> sequenceOwner, VersionStatus versionStatus, String userId);
    
    /**
     * Find the active VersionHistory for a given SequenceOwner type and version name
     * @param klass
     * @param versionName
     * @return
     */
    VersionHistory findActiveVersion(Class<? extends SequenceOwner> klass, String versionName);
    
    /**
     * Find the complete version history for a given SequenceOwner implementation and the version name,
     * where version name is the common "name" the versions are known by. In Award, this would be the awardNumber. 
     * In Protocol, it's the protocolNumber.
     * 
     * Note: The associated SequenceOwners are NOT eagerly fetched. Use the version name and sequence numbers from the 
     * VersionHistory to fetch the SequenceOwner associated to that VersionHistory 
     * 
     * @param klass
     * @param versionName
     * @return
     */
    List<VersionHistory> loadVersionHistory(Class<? extends SequenceOwner> klass, String versionName);
    
    /**
     * Find the pending VersionHistory for a given SequenceOwner type and version name with a specific sequence number
     * @param klass
     * @param versionName
     * @return
     */
    VersionHistory findPendingVersion(Class<? extends SequenceOwner> klass, String versionName, String sequenceNumber);
    
    /**
     * Find the pending version for a given SequenceOwner
     * @param klass
     * @param versionName
     * @return
     */
    VersionHistory findPendingVersion(Class<? extends SequenceOwner> klass, String versionName);

    VersionHistory findPendingVersion(Award award);


        /**
         * Find version histories without fetching the sequence owner. If you need sequence owner included in history list, use loadVersionHistory() method.
         * @param klass
         * @param versionName
         * @return
         */
    List<VersionHistory> findVersionHistory(Class<? extends SequenceOwner> klass, String versionName);

    /**
     * 
     * This method will load the appropriate sequenceOwner to the VersionHistory
     * @param versionHistory
     */
    void loadSequenceOwner(Class<? extends SequenceOwner> klass,VersionHistory versionHistory);
    
    /**
     * Finds the active(current FINAL version) or the newest version of the sequence owner if an active version does not exist.
     * @param klass
     * @param versionName
     * @return
     */
    VersionHistory getActiveOrNewestVersion(Class<? extends SequenceOwner> klass, String versionName);
}
