/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports;

import java.sql.Date;

public interface GenericAwardReportTerm {
    /**
     * Gets the reportClassCode attribute. 
     * @return Returns the reportClassCode.
     */
    String getReportClassCode();
    
    /**
     * Gets the reportCode attribute. 
     * @return Returns the reportCode.
     */
    String getReportCode();

    /**
     * Gets the frequencyCode attribute. 
     * @return Returns the frequencyCode.
     */
    String getFrequencyCode();
    
    /**
     * Gets the frequencyBaseCode attribute. 
     * @return Returns the frequencyBaseCode.
     */
    String getFrequencyBaseCode();

    /**
     * Gets the ospDistributionCode attribute. 
     * @return Returns the ospDistributionCode.
     */
    String getOspDistributionCode();
    
    /**
     * Gets the dueDate attribute. 
     * @return Returns the dueDate.
     */
    Date getDueDate();
    
    boolean equalsInitialFields(GenericAwardReportTerm awardReportTerm);
}
