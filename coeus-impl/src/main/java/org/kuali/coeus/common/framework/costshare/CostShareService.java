/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.costshare;

/**
 * 
 * This class handles the service calls for getting shared cost share related information. 
 */
public interface CostShareService {
    
    /**
     * 
     * This method checks the parameter service for the cost share label and returns the string.
     * @return
     */
    String getCostShareLabel();
    
    
    /**
     * 
     * This method returns true if the project period label is "Fiscal Year"
     * @return
     */
    boolean validateProjectPeriodAsFiscalYear();
    
    /**
     * 
     * This method returns true if the project period label is "Project Period"
     * @return
     */
    boolean validateProjectPeriodAsProjectPeriod();

}
