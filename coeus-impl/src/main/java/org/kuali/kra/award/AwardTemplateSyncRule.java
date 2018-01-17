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
 * 
 * This interface declares the rule method associated with <code>AwardApprovedSubaward</code> 
 * Business Object.
 */
public interface AwardTemplateSyncRule extends BusinessRule {
    /**
     * Rule invoked upon syncing an Award Template
     * <code>{@link org.kuali.kra.award.AwardTemplateSyncEvent}</code>
     *
     * @return boolean
     */
    public boolean processAwardTemplateSyncRules(AwardTemplateSyncEvent awardTemplateSyncEvent);
}
