/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor.hierarchy;

import java.util.Iterator;
import java.util.List;

public interface SponsorHierarchyDao {
    
    /**
     * 
     * This method is to get the sposor hierarchy name for the drop down
     * @return
     */
    
    public Iterator getTopSponsorHierarchy();
    
    /**
     * 
     * This method is to load all sponsor codes for future duplicate code checking in sponsor hierarchy maint
     * @param hierarchyName
     * @return
     */
    public Iterator getAllSponsors(String hierarchyName);
    
    /**
     * Get the unique grouping names at specificed level in the specified hierarchy.
     * @param hierarchyName
     * @param depth
     * @return
     */
    List<String> getUniqueNamesAtLevel(String hierarchyName, int depth);


}
