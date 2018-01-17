/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.home.approvedsubawards;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * 
 * This interface declares the rule method associated with <code>AwardApprovedSubaward</code> 
 * Business Object.
 */
public interface AwardApprovedSubawardRule extends BusinessRule {
    /**
     * Rule invoked upon adding a Award Report Term Recipient
     * <code>{@link org.kuali.kra.award.document.AwardDocument}</code>
     *
     * @return boolean
     */
    boolean processApprovedSubawardBusinessRules(AwardApprovedSubawardRuleEvent 
                                                    awardApprovedSubawardRuleEvent);
}
