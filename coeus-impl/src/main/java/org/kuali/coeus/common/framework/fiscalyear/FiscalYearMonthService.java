/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.fiscalyear;

import java.util.Calendar;


public interface FiscalYearMonthService {
    
    /**
     * 
     * This method returns the Integer value of the current month in the fiscal year.  January is 0, December is 11.
     * @return
     */
    Integer getCurrentFiscalMonth();
    
    /**
     * 
     * This method returns the Integer value of the current month in the fiscal year.  January is 1, December is 12.
     * @return
     */
    Integer getCurrentFiscalMonthForDisplay();
    
    /**
     * 
     * This method returns the current fiscal year.
     * @return
     */
    Integer getCurrentFiscalYear();
    
    /**
     * 
     * This method calculates what fiscal year the passed in date is in.  For example July 13 2012 is in fiscal year 2013 if
     * the fiscal starting month is less than July, but not January.
     * @param date
     * @return
     */
    Integer getFiscalYearFromDate(Calendar date);
    
    /**
     * 
     * This method determines the date the passed in fiscal year started on.
     * @param fiscalYear
     * @return
     */
    Calendar getFiscalYearStartDate(Integer fiscalYear);
    
    /**
     * 
     * This method  determines the date the passed in fiscal year ended on.
     * @param fiscalYear
     * @return
     */
    Calendar getFiscalYearEndDate(Integer fiscalYear);
    
}
