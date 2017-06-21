/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.kuali.coeus.propdev.impl.s2s;

import org.kuali.coeus.propdev.impl.s2s.nih.NihValidationMapping;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.util.KRADConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NihValidationMappingRule extends KcMaintenanceDocumentRuleBase {

    public static final String DOCUMENT_NEW_MAINTAINABLE_OBJECT_RULE_NUMBER = "document.newMaintainableObject.ruleNumber";
    public static final String RULE_NUMBER = "ruleNumber";
    private BusinessObjectService businessObjectService;


    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        boolean valid = super.processCustomRouteDocumentBusinessRules(document);

        final NihValidationMapping nihValidationMapping = (NihValidationMapping) document.getNewMaintainableObject().getDataObject();

        if (!KRADConstants.MAINTENANCE_DELETE_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction()) &&
                !KRADConstants.MAINTENANCE_EDIT_ACTION.equals(document.getNewMaintainableObject().getMaintenanceAction())) {

            Map<String, String> criteria = new HashMap<>();
            criteria.put(RULE_NUMBER, nihValidationMapping.getRuleNumber());
            final List<NihValidationMapping> ruleNumbers = (List<NihValidationMapping>) getBusinessObjectService().findMatching(NihValidationMapping.class, criteria);

            if (!ruleNumbers.isEmpty()) {
                final NihValidationMapping existingMapping = ruleNumbers.get(0);
                if (existingMapping.getRuleNumber().equals(nihValidationMapping.getRuleNumber())) {
                    getGlobalVariableService().getMessageMap().putError(DOCUMENT_NEW_MAINTAINABLE_OBJECT_RULE_NUMBER, KeyConstants.UNIQUE_NIH_VALIDATION_KEY, "");
                    valid = false;
                }
            }
        }

        return valid;
    }

    public BusinessObjectService getBusinessObjectService() {
        if (businessObjectService == null) {
            businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        }

        return businessObjectService;
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
}
