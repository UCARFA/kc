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
 * 
 * This interface declares the rule method associated with <code>AwardFandaRate</code> Business Object.
 */
public interface AddFandaRateRule extends BusinessRule {
    
    /**
     * Rule invoked upon adding a indirect cost rate
     * <code>{@link org.kuali.kra.award.document.AwardDocument}</code>
     *
     * @return boolean
     */
    public boolean processAddFandaRateBusinessRules(
            AddAwardFandaRateEvent addAwardFandaRateEvent);

}
