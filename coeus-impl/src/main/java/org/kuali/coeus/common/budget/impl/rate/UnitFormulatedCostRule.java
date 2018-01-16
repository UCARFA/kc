/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.rate;

import java.util.Objects;
import org.kuali.coeus.common.budget.impl.rate.UnitFormulatedCost;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UnitFormulatedCostRule extends KcMaintenanceDocumentRuleBase {


    public UnitFormulatedCostRule() {
        super();
    }
    
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkForUnitCostExistence(document);
    }
    /**
     * 
     * This method is to check the existence of terms of the Sponsor Template.
     * @param maintenanceDocument
     * @return
     */
    private boolean checkForUnitCostExistence(MaintenanceDocument maintenanceDocument) {
        boolean valid = true;
        UnitFormulatedCost newCost = (UnitFormulatedCost) maintenanceDocument.getNewMaintainableObject().getDataObject();

        BusinessObjectService businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("formulatedTypeCode", newCost.getFormulatedTypeCode());
        values.put("unitNumber", newCost.getUnitNumber());
        Collection<UnitFormulatedCost> costs = businessObjectService.findMatching(UnitFormulatedCost.class, values);
        for (UnitFormulatedCost cost : costs) {
            if (!Objects.equals(newCost.getUnitFormulatedCostId(), cost.getUnitFormulatedCostId())) {
                ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
                errorReporter.reportError("document.newMaintainableObject.formulatedTypeCode",
                        KeyConstants.ERROR_FORUMLATED_COST_DUPLICATE);
                return false;
            }
        }
        return true;
    }
    
}
