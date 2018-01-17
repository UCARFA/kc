/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import java.util.Objects;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class implements business rule for data matrix maintenance
 */
public class FinEntitiesDataMatrixMaintenanceDocumentRule   extends KcMaintenanceDocumentRuleBase {

    private static final String COLUMN_SORT_ID_FIELD_NAME = "columnSortId";
    private static final String GROUP_ID_FIELD_NAME = "dataGroupId";
    
    private transient BusinessObjectService businessObjectService;

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkUniqueness(document);
    }

    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return checkUniqueness(document);
    }
    
    private boolean checkUniqueness(MaintenanceDocument document) {
        boolean isValid = true;
        
        FinEntitiesDataMatrix newFinEntitiesDataMatrix = (FinEntitiesDataMatrix) document.getNewMaintainableObject().getDataObject();
        
        isValid &= checkSortIdUniqueness(newFinEntitiesDataMatrix);
        isValid &= checkGroupIdExist(newFinEntitiesDataMatrix);
        
        return isValid;
    }

    
    /*
     * validate uniqueness of column sort id
     */
    @SuppressWarnings("unchecked")
    private boolean checkSortIdUniqueness(FinEntitiesDataMatrix newFinEntitiesDataMatrix) {
        boolean isValid = true;
        
        Integer coloumnSortId = newFinEntitiesDataMatrix.getColumnSortId();
        
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put(COLUMN_SORT_ID_FIELD_NAME, coloumnSortId);
        Collection<FinEntitiesDataMatrix> matchingDataMatrixs = getBusinessObjectService().findMatching(FinEntitiesDataMatrix.class, fieldValues);
        
        for (FinEntitiesDataMatrix dataMatrix : matchingDataMatrixs) {
            if (!Objects.equals(dataMatrix.getColumnName(), newFinEntitiesDataMatrix.getColumnName())
                    && Objects.equals(dataMatrix.getDataGroupId(), newFinEntitiesDataMatrix.getDataGroupId())) {
                isValid = false;
                putFieldError(COLUMN_SORT_ID_FIELD_NAME, KeyConstants.ERROR_DUPLICATE_PROPERTY, 
                    new String[] {"Column Sort Id"});
                break;
            }
        }
        
        return isValid;
    }
       
    /*
     * validate group id exist, ie, data group exist
     */
    @SuppressWarnings("unchecked")
    private boolean checkGroupIdExist(FinEntitiesDataMatrix newFinEntitiesDataMatrix) {
        boolean isValid = true;

        Integer groupId = newFinEntitiesDataMatrix.getDataGroupId();

        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put(GROUP_ID_FIELD_NAME, groupId);

        if (getBusinessObjectService().countMatching(FinEntitiesDataGroup.class, fieldValues) == 0) {
            isValid = false;
            putFieldError(GROUP_ID_FIELD_NAME, KeyConstants.ERROR_DATA_GROUP_NOT_EXIST, new String[] { groupId.toString() });
        }

        return isValid;
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
