/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.unit;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.framework.unit.UnitService;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;

import java.util.List;

public class UnitMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {


    public static final String DOCUMENT_PARENT_UNIT_NUMBER = "document.newMaintainableObject.parentUnitNumber";

    public UnitMaintenanceDocumentRule() {
        super();
    }

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return moveUnit(document) && isValidParentUnit(document);
    }

    public boolean isValidParentUnit(MaintenanceDocument document) {
        Unit unit = (Unit)document.getNewMaintainableObject().getDataObject();
        if(unit!= null && unit.getParentUnitNumber() == null) {
            UnitService unitService = getUnitService();
            final Unit topUnit = unitService.getTopUnit();
            if(topUnit != null && !topUnit.getUnitNumber().equalsIgnoreCase(unit.getUnitNumber())) {
                GlobalVariables.getMessageMap().putError(DOCUMENT_PARENT_UNIT_NUMBER, KeyConstants.PARENT_UNIT_REQUIRED);
                return false;
            }
        }
        return true;
    }

    public UnitService getUnitService() {
        return KcServiceLocator.getService(UnitService.class);
    }

    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return moveUnit(document);
    }
    /**
     * 
     * Units cannot be moved to its own descendants.
     * This method returns false if it is moving to its own descendants.
     * @param maintenanceDocument
     * @return
     */
    private boolean moveUnit(MaintenanceDocument maintenanceDocument) {

        boolean valid = true;
        Unit unit=(Unit)maintenanceDocument.getNewMaintainableObject().getDataObject();
        String unitNumber=unit.getUnitNumber();
        String parentUnitNumber=unit.getParentUnitNumber();
        if(StringUtils.equals(unitNumber, parentUnitNumber)) {
            GlobalVariables.getMessageMap().putError(DOCUMENT_PARENT_UNIT_NUMBER, KeyConstants.UNIT_SAME_AS_PARENT);
            valid=false;
        }
        List<Unit> allSubUnits = getUnitService().getAllSubUnits(unitNumber);
        for (Unit subunits : allSubUnits) {  
            if(subunits.getUnitNumber().equals(parentUnitNumber)){
                GlobalVariables.getMessageMap().putError(DOCUMENT_PARENT_UNIT_NUMBER, KeyConstants.MOVE_UNIT_OWN_DESCENDANTS,
                        new String[] { unit.getParentUnitNumber(), unit.getParentUnitNumber() });
                valid=false;
            }
            
        }

        
    return valid;
}
}
