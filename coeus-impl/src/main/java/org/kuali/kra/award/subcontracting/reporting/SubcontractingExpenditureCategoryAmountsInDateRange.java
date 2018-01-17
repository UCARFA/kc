/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.reporting;

import java.sql.Date;

public class SubcontractingExpenditureCategoryAmountsInDateRange extends SubcontractingExpenditureCategoryAmountsBase {


    private static final long serialVersionUID = 4702488408295836126L;
    
    private Date rangeStartDate;
    private Date rangeEndDate;
    
    public SubcontractingExpenditureCategoryAmountsInDateRange() {
        super();
    }
    
    public SubcontractingExpenditureCategoryAmountsInDateRange(String awardNumber, Date rangeStartDate, Date rangeEndDate) {
        this();
        // set the PK
        this.setAwardNumber(awardNumber);
        // set the range limits
        this.setRangeStartDate(rangeStartDate);
        this.setRangeEndDate(rangeEndDate);        
    }
    
    public void setRangeStartDate(Date rangeStartDate) {
        this.rangeStartDate = rangeStartDate;
    }
    public Date getRangeStartDate() {
        return rangeStartDate;
    }
    public void setRangeEndDate(Date rangeEndDate) {
        this.rangeEndDate = rangeEndDate;
    }
    public Date getRangeEndDate() {
        return rangeEndDate;
    }

}
