/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.noreview;

import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * This class managed the business rules of marking a protocol as not required.
 */
public abstract class ProtocolReviewNotRequiredRuleBase extends KcTransactionalDocumentRuleBase implements ExecuteProtocolReviewNotRequiredRule {

    @Override
    public boolean processReviewNotRequiredRule(ProtocolDocumentBase document, ProtocolReviewNotRequiredBean actionBean) {
        boolean valid = true;
        String fieldNameStarter = "actionHelper.protocolReviewNotRequiredBean.";
        if (actionBean.getActionDate() == null) {
            valid = false;
            GlobalVariables.getMessageMap().putError(fieldNameStarter + "actionDate", KeyConstants.ERROR_PROTOCOL_APPROVAL_DATE_REQUIRED);
        }
        
        if (actionBean.getDecisionDate() == null) {
            valid = false;
            GlobalVariables.getMessageMap().putError(fieldNameStarter + "decisionDate", KeyConstants.ERROR_PROTOCOL_APPROVAL_DATE_REQUIRED);
        }
        
        return valid;
    }


}
