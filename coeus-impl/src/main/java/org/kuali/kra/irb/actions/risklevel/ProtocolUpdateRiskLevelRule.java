/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * Validates the rules for a Protocol Risk Level update action.
 */
public class ProtocolUpdateRiskLevelRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<ProtocolUpdateRiskLevelEvent> {
    
    @Override
    public boolean processRules(ProtocolUpdateRiskLevelEvent event) {
        boolean isValid = true;
        
        int index = event.getIndex();
        String errorPathKey = Constants.PROTOCOL_UPDATE_RISK_LEVEL_KEY + "[" + index + "]";
        ProtocolRiskLevel persistedProtocolRiskLevel = event.getProtocolDocument().getProtocol().getProtocolRiskLevels().get(index);
        
        GlobalVariables.getMessageMap().addToErrorPath(errorPathKey);
        getDictionaryValidationService().validateBusinessObject(persistedProtocolRiskLevel);
        GlobalVariables.getMessageMap().removeFromErrorPath(errorPathKey);
        
        isValid &= GlobalVariables.getMessageMap().hasNoErrors();
        isValid &= validateDateInactivated(persistedProtocolRiskLevel, errorPathKey);
        
        return isValid;
    }
    
    /**
     * Verifies that on an update action, the dateInactivated is non-null.
     * 
     * @param updatedProtocolRiskLevel The updated Protocol Risk Level
     * @param errorPathKey The key on the page on which to visibly place the error (if any)
     * @return true if dateInactivated is non-null, false otherwise
     */
    private boolean validateDateInactivated(ProtocolRiskLevel updatedProtocolRiskLevel, String errorPathKey) {
        boolean isValid = true;
        
        if (updatedProtocolRiskLevel.getDateInactivated() == null) {
            isValid = false;
            GlobalVariables.getMessageMap().putError(errorPathKey + ".dateInactivated", 
                    KeyConstants.ERROR_PROTOCOL_DATE_INACTIVATED_REQUIRED);
        }
        
        return isValid;
    }

}
