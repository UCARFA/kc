/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.version.service;

import java.util.List;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;

/**
 * The Award Version Service
 */
public interface AwardVersionService {
    
    /**
     * This method returns the proper Award for displaying information in T&amp;M and Award documents.  Logic for canceled documents.
     * @param awardNumber
     * @return
     */
    public Award getWorkingAwardVersion(String awardNumber);

    public Award getActiveAwardVersion(String awardNumber);

    public Award getPendingAwardVersion(String awardNumber);
    
    public List<Award> getAllActiveAwardsForHierarchy(String awardNumber);
    
    public boolean isPendingAwardInAwardHierarchy(String awardNumber);
    
    public boolean isActiveAwardInAwardHierarchy(String awardNumber);

    AwardDocument createAndSaveNewAwardVersion(AwardDocument awardDocument) throws Exception;


    }
