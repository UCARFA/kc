/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.commitments;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This interface defines methods that must be supplied in AwardBenefitsRatesRuleImpl
 */
public interface AwardBenefitsRatesRule extends BusinessRule {

    /**
     * This method is called to process business rules in any implementing class.
     * @param awardBenefitsRatesRuleEvent
     * @return
     */
    public boolean processBenefitsRatesBusinessRules(AwardBenefitsRatesRuleEvent 
            awardBenefitsRatesRuleEvent);
}
