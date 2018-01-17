/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.closeout;

import org.kuali.kra.award.home.Award;

/**
 * 
 * This class represents the AwardCloseoutService - which are related to Award Closeout panel on Payment Reports and Terms panel.
 * 
 */
public interface AwardCloseoutService {
    
    /**
     * 
     * Whenever a save occurs on Payment, Reports and Terms tab; This method gets called from the action upon save 
     * and updates the due dates for award closeout static reports.
     *
     * @param award
     */
    void updateCloseoutDueDatesBeforeSave(Award award);
}
