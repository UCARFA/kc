/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.timeandmoney.AwardHierarchyNode;

import java.text.ParseException;

/**
 * 
 * This interface declares services that would populate the Award Hierarchy in UI.
 */
public interface AwardHierarchyUIService {
   
    
    /**
     * 
     * This service is used to populate the root node of the award hierarchy UI.
     *  
     * @param awardNumber
     * @return
     * @throws ParseException
     */
    public String getRootAwardNode(String awardNumber, String currentAwardNumber, String currentSequenceNumber) throws ParseException;
    
    /**
     * 
     * This service is used to populate the all the non-root nodes of award hierarchy UI.
     * 
     * @return
     */
    public String getSubAwardHierarchiesForTreeView(String awardNumber, String currentAwardNumber, String currentSequenceNumber) throws ParseException;
    
    /**
     * 
     * This service is used to populate the all the non-root nodes of award hierarchy UI.
     * 
     * @return
     */
    public String getSubAwardHierarchiesForTreeViewTandM(String awardNumber, String currentAwardNumber, String currentSequenceNumber) throws ParseException;
    
    /**
     * 
     * This method retrieves the award details in a string form for a single award.
     * 
     * This will be used in AwardInquirable to show the custom inquiry results for Award.
     * 
     * @param award
     * @return
     * @throws ParseException
     */
    public String getAwardRecord(Award award) throws ParseException;
    

    /**
     * This method returns the root award node of the award
     * @param award
     * @return
     * @throws ParseException
     */
    public AwardHierarchyNode getRootAwardNode(Award award) throws ParseException;
    
}
