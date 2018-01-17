/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.correction;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * Validate admin correction.
 */
public abstract class ProtocolAdminCorrectionRuleBase extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ProtocolAdminCorrectionEventBase> {
   
    @Override
    public boolean processRules(ProtocolAdminCorrectionEventBase event) {
        boolean valid = true;
        if (StringUtils.isBlank(event.getAdminCorrectionBean().getComments())) {
            valid = false;
            reportError(event.getPropertyName(), KeyConstants.ERROR_PROTOCOL_ADMIN_CORRECTION_COMMENTS_REQUIRED);
        }
        return valid;
    }


}
