/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service;

import org.kuali.kra.bo.FundingSourceType;

public interface FundingSourceTypeService {
    
    /**
     * 
     * This method returns the FundingSourceType for a 
     * particular sourcetypeId
     *  
     * @param sourcetypeId
     * @return
     */
    public FundingSourceType getFundingSourceType(String sourceTypeId);

}
