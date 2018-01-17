/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.person.attr;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonTrainingMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        PersonTraining personTraining = (PersonTraining)document.getNoteTarget();
        return validate(personTraining);
    }
    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        PersonTraining personTraining = (PersonTraining)document.getNoteTarget();
        return validate(personTraining);
    }

    private boolean validate(PersonTraining personTraining) {
        boolean valid = true;
        if (StringUtils.isNotBlank(personTraining.getPersonId()) && personTraining.getTrainingNumber() != null) {
            Map fieldValues = new HashMap();
            fieldValues.put("personId", personTraining.getPersonId());
            fieldValues.put("trainingNumber", personTraining.getTrainingNumber());
            List<PersonTraining> personTrainings = (List<PersonTraining>)boService.findMatching(PersonTraining.class, fieldValues);
            if (!personTrainings.isEmpty()) {
                PersonTraining existPersonTraining = personTrainings.get(0);
                if (personTraining.getPersonTrainingId() == null || personTraining.getPersonTrainingId() == existPersonTraining.getPersonTrainingId()) {
                    GlobalVariables.getMessageMap().putError("document.newMaintainableObject.personId", KeyConstants.PERSON_TRAINING_EXISTS,
                            new String[] { personTraining.getTrainingNumber().toString(), personTraining.getPersonId() });
                    valid = false;
                }
            }
            
        }
        
        return valid;
    }

}
