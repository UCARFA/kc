/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.foreigntravel;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface defines the rule processing method
 */
public interface AwardApprovedForeignTravelRule extends BusinessRule {
    String APPROVED_FOREIGN_TRAVEL_LIST_ERROR_KEY = "approvedForeignTravel";
    String ERROR_AWARD_APPROVED_FOREIGN_INVALID_FIELD = "error.award.approvedforeigntravel.field.invalid";
    String ERROR_AWARD_APPROVED_FOREIGN_TRAVEL_NOT_UNIQUE = "error.award.approvedforeigntravel.duplicaterow";
    String ERROR_AWARD_APPROVED_FOREIGN_TRAVEL_END_DATE_BEFORE_START_DATE = "error.award.approvedforeigntravel.enddate.before.startdate";
    
    /**
     * This method is used to validate AwardApprovedForeignTravel in an Award
     * @param event
     * @return
     */
    boolean processAwardApprovedForeignTravelBusinessRules(AwardApprovedForeignTravelRuleEvent event);
}
