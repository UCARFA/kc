/*
 * Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.common.impl.person.citi;

import org.kuali.coeus.common.framework.person.citi.PersonTrainingCitiMap;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.util.*;

public class PersonTrainingCitiMapRules extends KcMaintenanceDocumentRuleBase  {

    @Override
    public boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return this.checkUniqueness(document);
    }

    @Override
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return this.checkUniqueness(document);
    }

    private boolean checkUniqueness(final MaintenanceDocument maintenanceDocument) {
        final PersonTrainingCitiMap personTrainingCitiMap = (PersonTrainingCitiMap) maintenanceDocument.getNewMaintainableObject().getDataObject();
        boolean valid = true;
        if (personTrainingCitiMap.getTrainingCode() != null) {
            if (differentId(personTrainingCitiMap, getBoService().findMatching(PersonTrainingCitiMap.class, Collections.singletonMap("trainingCode", personTrainingCitiMap.getTrainingCode())))) {
                valid = false;
                final MessageMap errorMap = GlobalVariables.getMessageMap();
                errorMap.putError("document.newMaintainableObject.trainingCode", "error.citi.map.duplicate.training.code", personTrainingCitiMap.getTrainingCode().toString());
            }
        }


        final Map<String, String> criteria = new HashMap<>();
        criteria.put("groupId", personTrainingCitiMap.getGroupId());
        criteria.put("stageNumber", personTrainingCitiMap.getStageNumber());

        if (differentId(personTrainingCitiMap, getBoService().findMatching(PersonTrainingCitiMap.class, criteria))) {
            valid = false;
            final MessageMap errorMap = GlobalVariables.getMessageMap();
            errorMap.putError("document.newMaintainableObject.groupId", "error.citi.map.duplicate.group.stage", personTrainingCitiMap.getGroupId(), personTrainingCitiMap.getStageNumber());
        }

        return valid;
    }

    private boolean differentId(PersonTrainingCitiMap personTrainingCitiMap, Collection<PersonTrainingCitiMap> mappings) {
        return mappings.stream().filter(map -> !map.getId().equals(personTrainingCitiMap.getId())).findAny().isPresent();
    }
}
