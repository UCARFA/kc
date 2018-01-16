/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.resubmit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.propdev.impl.resubmit.ResubmissionPromptRule;
import org.kuali.coeus.propdev.impl.resubmit.ResubmissionRuleEvent;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;

/**
 * Implements {@code ResubmissionPromptRule}.
 */
public class ProposalDevelopmentResubmissionPromptRule extends KcTransactionalDocumentRuleBase implements ResubmissionPromptRule {

    private static final String REBUSMISSION_OPTION = "resubmissionOption";
    
    @Override
    public boolean processResubmissionPromptBusinessRules(ResubmissionRuleEvent resubmissionRuleEvent) {
        boolean rulePassed = true;
        
        if (StringUtils.isBlank(resubmissionRuleEvent.getResubmissionOption())) {
            rulePassed = false;
            reportError(REBUSMISSION_OPTION, KeyConstants.ERROR_PROPOSAL_DEVELOPMENT_RESUBMISSION_PROMPT_OPTION_REQUIRED);
        }
        
        return rulePassed;
    }

}
