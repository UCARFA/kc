/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.kra.award.document.AwardDocument;

/**
 * This class is used for sync AwardSponsorTemplate details to different Award Details Objects.
 */
public interface AwardTemplateSyncService {

    /**
     * 
     * This method is to sync a particular syncable list from award template
     * @param award
     * @param syncPropertyName is the name of member variable to represent syncable list
     * @return true if successful
     */
    public boolean syncAwardToTemplate(AwardDocument awardDocument, AwardTemplateSyncScope[] scopes);
    
    /**
     * Method checks if a scope sync will alter existing data within the award when called with a specific scope.
     * 
     * @param awardDocument The award document to check.
     * @param scope The scope to check.
     * @return true if existing data will be lost, false otherwise.
     * 
     */
    public boolean syncWillAlterData( AwardDocument awardDocument, AwardTemplateSyncScope scope );
 
    /**
     * Method returns true if the award's award template contains data that would
     * be synchronized in the provided scope.
     * 
     * @param awardDocument The award document to check.
     * @param scope The scope to check.
     * @return true if the template contains data that would be synchronized.
     * 
     */
    public boolean templateContainsScopedData( AwardDocument awardDocument, AwardTemplateSyncScope scope );
 
    
    
    
    
}
