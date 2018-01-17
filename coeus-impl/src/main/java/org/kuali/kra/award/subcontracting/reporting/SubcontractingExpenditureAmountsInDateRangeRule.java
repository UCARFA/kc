/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.subcontracting.reporting;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.rice.kns.service.DictionaryValidationService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.util.GlobalVariables;

import java.sql.Date;

@SuppressWarnings("deprecation")
public class SubcontractingExpenditureAmountsInDateRangeRule {
    
    private static final String RANGE_START_DATE = "rangeStartDate";
    private static final String RANGE_END_DATE = "rangeEndDate";
    
    private DictionaryValidationService dictionaryValidationService;
    
    public boolean validateDateRange(Date rangeStartDate, Date rangeEndDate) {
        boolean rulePassed = false;
        String ddEntryName = SubcontractingExpenditureCategoryAmountsInDateRange.class.getSimpleName();
        // first check that both the range end points have been supplied 
        this.getDictionaryValidationService().validateAttributeRequired(ddEntryName, RANGE_START_DATE, rangeStartDate, false, RANGE_START_DATE);        
        this.getDictionaryValidationService().validateAttributeRequired(ddEntryName, RANGE_END_DATE, rangeEndDate, false, RANGE_END_DATE);
        rulePassed = GlobalVariables.getMessageMap().hasNoErrors();
            
        if (rulePassed) {
            // check that the start date is before the end date
            if(rangeEndDate.before(rangeStartDate)) {
                rulePassed = false;
                // report the error by putting the message in global map
                ErrorReporter reporter = KcServiceLocator.getService(ErrorReporter.class);
                reporter.reportError(RANGE_START_DATE, KeyConstants.EXPENDITURES_RANGE_START_DATE_AFTER_END_DATE);
            }
        }
        
        return rulePassed;
    }
    
    public DictionaryValidationService getDictionaryValidationService() {
        if (this.dictionaryValidationService == null) {
            this.dictionaryValidationService = KNSServiceLocator.getKNSDictionaryValidationService();
        }
        return this.dictionaryValidationService;
    }
    
    public void setDictionaryValidationService(DictionaryValidationService dictionaryValidationService) {
        this.dictionaryValidationService = dictionaryValidationService;
    }

}
