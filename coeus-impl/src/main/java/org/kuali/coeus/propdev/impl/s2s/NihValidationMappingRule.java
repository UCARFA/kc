/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
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
                    valid = Boolean.FALSE;
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
