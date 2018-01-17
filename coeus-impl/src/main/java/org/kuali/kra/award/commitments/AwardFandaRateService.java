/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.kra.award.home.ValidRates;

import java.util.List;


/**
 * 
 * This is the AwardFandaRateService interface.
 */
public interface AwardFandaRateService {
    
    /**
     * 
     * This method returns the start and end dates for a given fiscal year.
     * The Start Date for a fiscal year would be 07/01/<fiscalYear-1> and 
     * End Date would be 06/30/<fiscalYear> 
     * @param fiscalYear
     * @return
     */
    public List<String> getStartAndEndDatesBasedOnFiscalYear(String fiscalYear);
    
    public List<ValidRates> getValidRates(AwardFandaRate awardFandaRate);
    
}
