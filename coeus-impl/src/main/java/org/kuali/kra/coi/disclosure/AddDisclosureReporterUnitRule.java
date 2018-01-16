/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.disclosure;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.coi.DisclosureReporterUnit;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

public class AddDisclosureReporterUnitRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<AddDisclosureReporterUnitEvent> {
    
    @Override
    public boolean processRules(AddDisclosureReporterUnitEvent event) {
        boolean isValid = true;

//        String errorPathKey = event.getPropertyName() + ".newDisclosurePersonUnit";
        GlobalVariables.getMessageMap().addToErrorPath(event.getPropertyName());
        if (StringUtils.isBlank(event.getDisclosureReporterUnit().getUnitNumber())) {
            GlobalVariables.getMessageMap().putError("unitNumber", KeyConstants.ERROR_UNIT_NUMBER_REQUIRED);

        }
        else {
            if (!CollectionUtils.isEmpty(event.getDisclosureReporterUnits())) {
                boolean duplicateUnitNumber = false;
                for (DisclosureReporterUnit unit : event.getDisclosureReporterUnits()) {
                    if (StringUtils.equals(unit.getUnitNumber(), event.getDisclosureReporterUnit().getUnitNumber())) {
                        duplicateUnitNumber = true;
                        break;
                    }
                }
                if (duplicateUnitNumber) {
                    GlobalVariables.getMessageMap().putError("unitNumber", KeyConstants.ERROR_PROTOCOL_UNIT_DUPLICATE);

                }

            }
            if (event.getDisclosureReporterUnit().getUnit() == null) {
                GlobalVariables.getMessageMap().putError("unitNumber", KeyConstants.ERROR_INVALID_UNIT, event.getDisclosureReporterUnit().getUnitNumber());                
            }
        }

        isValid &= GlobalVariables.getMessageMap().hasNoErrors();
        GlobalVariables.getMessageMap().removeFromErrorPath(event.getPropertyName());
        return isValid;
    }

}
