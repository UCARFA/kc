/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.resubmit;

import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * Validates the options for Proposal Development resubmission.
 */
public interface ResubmissionPromptRule extends BusinessRule {
    
    /**
     * Validates the options for Proposal Development resubmission.
     * 
     * @param resubmissionRuleEvent the event for which this rule is run
     * @return true if one option is selected, false otherwise
     */
    boolean processResubmissionPromptBusinessRules(ResubmissionRuleEvent resubmissionRuleEvent);

}
