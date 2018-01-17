/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import java.util.Collection;

public interface AwardTemplateReportTermService {

    /**
     * 
     * This method is to get the report types of the ValidClassReportFrequency based on the reportClasscode and converted to string separated by ",".
     */
    String getReportTypeForAjaxCall(String reportClassCode);
    
    /**
     * 
     * This method is to get the report types of the ValidClassReportFrequency based on the reportClasscode.
     */
    Collection<String> getReportTypesUsingReportClassCode(String reportClassCode);
    
    /**
     * 
     * This method is to get the frequency based on reportCode and converted to string separated by ",".
     */
    String getFrequencyForAjaxCall(String reportCode, String reportClass);

    /**
     * 
     * This method is to get the frequency based on the reportCode.
     */
    Collection<String> getFrequencyUsingReportCodeAndClass(String reportCode, String reportClass);
    /**
     * 
     * This method is to get frequency bases based on frequencyCode and converted to string separated by ",".
     */
    String getFrequencyBaseForAjaxCall(String frequencyCode);
    /**
     * 
     * This method is to get the frequency bases based on the frequencyCode.
     */
    Collection<String> getFrequencyBaseUsingFrequencyCode(String frequencyCode);

}
