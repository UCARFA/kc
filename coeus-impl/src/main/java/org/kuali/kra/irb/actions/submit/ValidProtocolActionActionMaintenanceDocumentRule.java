/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.submit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;


/**
 * 
 * This class is the maintenance document rule for valid submission/review type table.
 */
public class ValidProtocolActionActionMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        ValidProtocolActionAction validProtocolActionAction = (ValidProtocolActionAction) document.getDocumentBusinessObject();
        return validate(validProtocolActionAction);
    }

    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        ValidProtocolActionAction validProtocolActionAction = (ValidProtocolActionAction) document.getDocumentBusinessObject();
        return validate(validProtocolActionAction);
    }

    private boolean validate(ValidProtocolActionAction validProtocolActionAction) {
       boolean result = true;
       result &= validatePromptUser(validProtocolActionAction);
       return result;
    }

    
    private boolean validatePromptUser(ValidProtocolActionAction validProtocolActionAction) {
        boolean result = true;
        if (validProtocolActionAction.getUserPromptFlag() && StringUtils.isBlank(validProtocolActionAction.getUserPrompt()) ) {
            GlobalVariables.getMessageMap().putError("document.newMaintainableObject.userPrompt",
                    KeyConstants.ERROR_FOLLOWUP_USER_PROMPT_REQUIRED,
                    new String[] { });
            result = false;

        } else if (!validProtocolActionAction.getUserPromptFlag() && StringUtils.isNotBlank(validProtocolActionAction.getUserPrompt())) {
            GlobalVariables.getMessageMap().putError("document.newMaintainableObject.userPrompt",
                    KeyConstants.ERROR_FOLLOWUP_USER_PROMPT_REQUIRED_EMPTY,
                    new String[] { });
            result = false;
        }
       return result; 
    }
}
