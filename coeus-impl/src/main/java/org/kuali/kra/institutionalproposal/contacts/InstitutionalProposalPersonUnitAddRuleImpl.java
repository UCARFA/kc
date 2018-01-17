/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.contacts;

import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;


public class InstitutionalProposalPersonUnitAddRuleImpl implements InstitutionalProposalPersonUnitAddRule {

    @Override
    public boolean processAddInstitutionalProposalPersonUnitBusinessRules(InstitutionalProposalPersonUnitRuleAddEvent event) {
        return checkForValidUnit(event.getNewPersonUnit()) && checkForDuplicateUnits(event.getProjectPerson(), event.getNewPersonUnit());
    }
        
    boolean checkForDuplicateUnits(InstitutionalProposalPerson projectPerson, InstitutionalProposalPersonUnit newInstitutionalProposalPersonUnit) {
        boolean valid = true;
        for(InstitutionalProposalPersonUnit apu: projectPerson.getUnits()) {
            valid = !apu.getUnit().equals(newInstitutionalProposalPersonUnit.getUnit());
            if(!valid) {
                break;
            }
        }
        
        if(!valid) {
            Unit dupeUnit = newInstitutionalProposalPersonUnit.getUnit();
            GlobalVariables.getMessageMap().putError(NEW_UNIT_NUMBER_FIELD, 
                                                        ERROR_PROPOSAL_PROJECT_PERSON_DUPLICATE_UNITS, 
                                                        dupeUnit.getUnitName(), dupeUnit.getUnitNumber(),
                                                        projectPerson.getFullName());
            //this null is to just clean stuff up
            newInstitutionalProposalPersonUnit.setUnit(null);
        }
        
        return valid;
    }
    
    protected boolean checkForValidUnit(InstitutionalProposalPersonUnit newInstitutionalProposalPersonUnit){
        String newUnitNumber = newInstitutionalProposalPersonUnit.getUnitNumber();
        boolean valid =  KcServiceLocator.getService(UnitService.class).getUnit(newUnitNumber) != null;
        if (!valid) {
            GlobalVariables.getMessageMap().putError(NEW_UNIT_NUMBER_FIELD, 
                    KeyConstants.ERROR_INVALID_UNIT, newUnitNumber);
            //this null is to just clean stuff up
            newInstitutionalProposalPersonUnit.setUnit(null);
        }
        return valid;
    }

}
