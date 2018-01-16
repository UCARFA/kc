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
 * Business rule for modifying  amendment sections.  The user is required to enter a summary.
 * For protocol amendments they must select at least one module which will be modified in the amendment.
 */
@SuppressWarnings("unchecked")
public abstract class ModifyAmendmentSectionsRuleBase extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ModifyAmendmentSectionsEventBase> {

    @Override
    public boolean processRules(ModifyAmendmentSectionsEventBase event) {
        
        boolean valid = true;
        
        if (StringUtils.isBlank(event.getAmendmentBean().getSummary())) {
            valid = false;
            reportError(event.getPropertyName(), KeyConstants.ERROR_PROTOCOL_SUMMARY_IS_REQUIRED);
        }
        
        if (event.isAmendment() && !event.getAmendmentBean().isSomeSelected()) {
            valid = false;
            reportError(event.getPropertyName(), KeyConstants.ERROR_PROTOCOL_SELECT_MODULE);
        }
        
        return valid;
    }
}
