/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.specialapproval.approvedequipment;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface defines the rule processing method
 */
public interface AwardApprovedEquipmentRule extends BusinessRule {
    String APPROVED_EQUIPMENT_ITEMS_LIST_ERROR_KEY = "approvedEquipmentItems";
    
    /**
     * This method is used to validate AwardApprovedEquipment items in an Award
     * @param awardApprovedEquipmentRuleEvent
     * @return
     */
    boolean processAwardApprovedEquipmentBusinessRules(AwardApprovedEquipmentRuleEvent event);
}
