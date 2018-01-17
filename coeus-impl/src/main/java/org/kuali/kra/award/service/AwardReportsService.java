/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.kra.award.home.Award;

import java.util.Map;

/**
 * 
 * This is the AwardReportsService interface.
 */
public interface AwardReportsService {
    
    /**
     * 
     * This method prepares the AwardReportTerm and related objects for the display of UI.
     * This should get called every time Payment, Reports and Terms page is loaded.
     * 
     * @param award
     * @return
     */
    Map<String, Object> initializeObjectsForReportsAndPayments(Award award);
    
    /**
     * 
     * This method gets called from the DWR script to populate to update frequency based on
     * Report Class and Type.
     * 
     * @param reportClassCode
     * @param reportCode
     * @return
     */
    String getFrequencyCodes(String reportClassCode, String reportCode);
    
    /**
     * 
     * This method gets called from the DWR script to populate Frequency Base based on
     * Frequency
     * 
     * @param frequencyCode
     * @return
     */
    String getFrequencyBaseCodes(String frequencyCode);    
}
