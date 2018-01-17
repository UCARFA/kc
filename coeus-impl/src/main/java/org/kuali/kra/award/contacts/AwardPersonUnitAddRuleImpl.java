/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.contacts;

import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * This class implements the specified rule
 */
public class AwardPersonUnitAddRuleImpl implements AwardPersonUnitAddRule {

    @Override
    public boolean processAddAwardPersonUnitBusinessRules(AwardPersonUnitRuleAddEvent event) {
        boolean valid = checkForDuplicateUnits(event.getProjectPerson(), event.getNewPersonUnit(), event.getAddUnitPersonIndex());
        valid &= checkForInvalidUnit(event.getNewPersonUnit(), event.getAddUnitPersonIndex());
        return valid;
    }
        
    boolean checkForDuplicateUnits(AwardPerson projectPerson, AwardPersonUnit newAwardPersonUnit, int addUnitPersonIndex) {
        boolean valid = true;
        for(AwardPersonUnit apu: projectPerson.getUnits()) {
            valid = !apu.getUnit().equals(newAwardPersonUnit.getUnit());
            if(!valid) {
                break;
            }
        }
        
        if(!valid) {
            Unit dupeUnit = newAwardPersonUnit.getUnit();
            GlobalVariables.getMessageMap().putError(AWARD_PROJECT_PERSON_LIST_ERROR_KEY+"["+addUnitPersonIndex+"].unitNumber", 
                                                        ERROR_AWARD_PROJECT_PERSON_DUPLICATE_UNITS, 
                                                        dupeUnit.getUnitName(), dupeUnit.getUnitNumber(),
                                                        projectPerson.getFullName());
        }
        
        return valid;
    }
    
    boolean checkForInvalidUnit(AwardPersonUnit newAwardPersonUnit, int addUnitPersonIndex) {
        if (newAwardPersonUnit.getUnit() == null) {
            GlobalVariables.getMessageMap().putError(AWARD_PROJECT_PERSON_LIST_ERROR_KEY+"["+addUnitPersonIndex+"].unitNumber", ERROR_AWARD_PROJECT_PERSON_INVAILD_UNIT);
            return false;
        }
        return true;
    }

}
