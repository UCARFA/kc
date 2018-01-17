/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface declares the rule method associated with <code>AwardSponsorTerm</code> 
 * Business Object.
 */
public interface AwardSponsorTermRule extends BusinessRule {
    
    /**
     * This method is called to process all rules for Sponsor term on save.
     * @param awardSponsorTermRuleEvent
     * @return
     */
    public boolean processAddSponsorTermBusinessRules(AwardSponsorTermRuleEvent 
            awardSponsorTermRuleEvent);
}
