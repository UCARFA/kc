/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.closeout;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface defines the rule processing method
 */
public interface AwardCloseoutRule extends BusinessRule {
    
    String CLOSEOUT_ITEMS_LIST_ERROR_KEY = "closeoutItems";
    
    /**
     * This method is used to validate AwardCloseout items in an Award
     * @param event
     * @return
     */
    boolean processAwardCloseoutBusinessRules(AwardCloseoutRuleEvent event);
    
    /**
     * 
     * This method is used to validate a new AwardCloseout to be added to an Award
     * @param event
     * @return
     */
    boolean processAddAwardCloseoutBusinessRules(AddAwardCloseoutRuleEvent event);
}
