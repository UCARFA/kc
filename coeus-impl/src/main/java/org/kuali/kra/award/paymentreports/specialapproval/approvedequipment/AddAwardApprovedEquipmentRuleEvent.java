/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.approvedequipment;

import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class is for rule validation when adding new item. It's NOT used by the rule framework
 */
public class AddAwardApprovedEquipmentRuleEvent extends AwardApprovedEquipmentRuleEvent {

    /**
     * Constructs a AddAwardApprovedEquipmentRuleEvent.java.
     * @param errorPathPrefix
     * @param awardDocument
     * @param approvedEquipmentItem
     * @param minimumCapitalization
     */
    public AddAwardApprovedEquipmentRuleEvent(String errorPathPrefix, AwardDocument awardDocument, Award award,
            AwardApprovedEquipment approvedEquipmentItem, MinimumCapitalizationInfo minimumCapitalization) {
        super(errorPathPrefix, awardDocument, award, approvedEquipmentItem, minimumCapitalization);
    }

    /**
     * The rule impl is used here because the rule doesn't define the Add behavior
     * 
     * @see org.kuali.kra.award.paymentreports.specialapproval.approvedequipment.AwardApprovedEquipmentRuleEvent
     *  #invokeRuleMethod(org.kuali.core.rule.BusinessRule)
     */
    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AwardApprovedEquipmentRuleImpl)rule).processAddAwardApprovedEquipmentBusinessRules(this);
    }
}
