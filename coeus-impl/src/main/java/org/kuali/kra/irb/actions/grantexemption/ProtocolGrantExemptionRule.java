/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.grantexemption;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * Encapsulates the rules for granting an exemption on a Protocol.
 */
public class ProtocolGrantExemptionRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ProtocolGrantExemptionEvent> {
    
    private static final String APPROVAL_DATE_FIELD = "approvalDate";
    private static final String ACTION_DATE_FIELD = "actionDate";
    
    @Override
    public boolean processRules(ProtocolGrantExemptionEvent event) {
        boolean isValid = true;
        
        if (event.getProtocolGrantExemptionBean().getApprovalDate() == null) {
            isValid = false;
            reportError(APPROVAL_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_APPROVAL_DATE_REQUIRED);  
        }
        
        if (event.getProtocolGrantExemptionBean().getActionDate() == null) {
            isValid = false;
            reportError(ACTION_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_GENERIC_ACTION_DATE_REQUIRED);  
        }
        
        return isValid;
    }
}
