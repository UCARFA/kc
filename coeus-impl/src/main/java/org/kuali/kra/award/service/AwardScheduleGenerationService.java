/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service;

import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 
 * This is the AwardScheduleGenerationService interface.
 */
public interface AwardScheduleGenerationService {

    /**
     * 
     * This method generates a schedule of dates.
     * 
     * @param award
     * @param awardReportTerms
     * @return
     * @throws ParseException
     */
    List<Date> generateSchedules(Award award, List<AwardReportTerm> awardReportTerms, boolean isThisNotPaymentPanel) throws ParseException;
    
}
