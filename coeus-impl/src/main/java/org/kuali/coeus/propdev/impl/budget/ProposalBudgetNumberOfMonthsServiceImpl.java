/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.budget;



import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Months;
import org.kuali.coeus.sys.api.model.ScaleTwoDecimal;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component("proposalBudgetNumberOfMonthsService")
public class ProposalBudgetNumberOfMonthsServiceImpl implements ProposalBudgetNumberOfMonthsService {

    @Override
    public double getNumberOfMonth(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || startDate.after(endDate)) {
            return 0.00;
        }

        final DateTime start = new DateTime(startDate);
    	final DateTime end = new DateTime(endDate).plusDays(1);

        final int daysInMonthForEndDate = end.dayOfMonth().getMaximumValue();
    	final int wholeMonths = Months.monthsBetween(start, end).getMonths();
    	final int daysRemaining = Days.daysBetween(start.plusMonths(wholeMonths), end).getDays();

        //casting to ensure we don't loose precision
    	final double numberOfMonths = wholeMonths + ((double) daysRemaining / (double) daysInMonthForEndDate);
    	
    	return new ScaleTwoDecimal(numberOfMonths).doubleValue();
    }
    
}
