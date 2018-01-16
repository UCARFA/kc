/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.amendrenew;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * 
 * This class checks the summary for 'create renewal without amendment' is not empty
 */
public abstract class CreateRenewalRuleBase extends KcTransactionalDocumentRuleBase implements KcBusinessRule<CreateRenewalEventBase> {

    @Override
    public boolean processRules(CreateRenewalEventBase event) {
        
        boolean valid = true;
        
        if (StringUtils.isBlank(event.getRenewalSummary())) {
            valid = false;
            reportError(event.getPropertyName(), KeyConstants.ERROR_PROTOCOL_SUMMARY_IS_REQUIRED);
        }
                
        return valid;
    }
}
