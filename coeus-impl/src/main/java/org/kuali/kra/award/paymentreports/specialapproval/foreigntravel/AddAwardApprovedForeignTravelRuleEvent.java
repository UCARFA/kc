/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.foreigntravel;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class is for rule validation when adding new item
 */
public class AddAwardApprovedForeignTravelRuleEvent extends AwardApprovedForeignTravelRuleEvent {

    /**
     * Constructs a AddAwardApprovedEquipmentRuleEvent
     * 
     * This event is NOT used by the rule framework, but is used to support adding
     *  
     * @param errorPathPrefix
     * @param awardDocument
     * @param approvedEquipmentItem
     * @param minimumCapitalization
     */
    public AddAwardApprovedForeignTravelRuleEvent(String errorPathPrefix, AwardDocument awardDocument, Award award,
                                                    AwardApprovedForeignTravel approvedForeignTravel) {
        super(errorPathPrefix, awardDocument, award, approvedForeignTravel);
    }

    /**
     * @see org.kuali.kra.award.paymentreports.specialapproval.foreigntravel.AwardApprovedForeignTravelRuleEvent
     *  #invokeRuleMethod(org.kuali.core.rule.BusinessRule)
     */
    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AwardApprovedForeignTravelRuleImpl) rule).processAddAwardApprovedForeignTravelBusinessRules(this);
    }
}
