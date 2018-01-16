/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.coi.DisclosureReporterUnit;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

public class SaveDisclosureReporterUnitRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<SaveDisclosureReporterUnitEvent> {
    
    @Override
    public boolean processRules(SaveDisclosureReporterUnitEvent event) {
        boolean isValid = true;
        
//        String errorPathKey = event.getPropertyName() + ".financialEntityReporter";
        GlobalVariables.getMessageMap().addToErrorPath(event.getPropertyName());
        if (org.apache.commons.collections4.CollectionUtils.isEmpty(event.getDisclosureReporterUnits())) {
            GlobalVariables.getMessageMap().putError("unitNumber",
            KeyConstants.ERROR_ONE_UNIT, "Reporter");
            
        } else {
            boolean leadUnitFound = false;
            for (DisclosureReporterUnit unit : event.getDisclosureReporterUnits()) {
                if (unit.isLeadUnitFlag()) {
                    leadUnitFound = true;
                    break;
                }
            }
            if (!leadUnitFound) {
                GlobalVariables.getMessageMap().putError("unitNumber",
                        KeyConstants.ERROR_LEAD_UNIT_REQUIRED);
                
            }
            
        }
        isValid &= GlobalVariables.getMessageMap().hasNoErrors();
        GlobalVariables.getMessageMap().removeFromErrorPath(event.getPropertyName());
        
        return isValid;
    }


}
