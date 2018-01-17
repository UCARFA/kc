/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.budget.impl.core.category;

import org.kuali.coeus.common.budget.framework.core.category.BudgetCategory;
import org.kuali.coeus.common.budget.framework.core.category.BudgetCategoryMapping;
import org.kuali.coeus.common.budget.framework.core.CostElement;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.HashMap;
import java.util.Map;

public class BudgetCategoryExistenceRule extends KcMaintenanceDocumentRuleBase {
    

    public BudgetCategoryExistenceRule() {
        super();
    }
    
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return checkExistence(document);
    }
    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return checkExistence(document);
    }

    /**
     * 
     * This method is to check the existence of budgetcategorycode in table.
     * @param maintenanceDocument
     * @return
     */
    private boolean checkExistence(MaintenanceDocument maintenanceDocument) {


        boolean valid= true;
        if (LOG.isDebugEnabled()) {
            LOG.debug("new maintainable is: " + maintenanceDocument.getNewMaintainableObject().getClass());
        }
        // shared by budgetcategorymapping & costelement
        String budgetCategoryCode;
        if (maintenanceDocument.getNewMaintainableObject().getDataObject() instanceof BudgetCategoryMapping) {
            BudgetCategoryMapping budgetCategoryMapping = (BudgetCategoryMapping) maintenanceDocument.getNewMaintainableObject().getDataObject();
            budgetCategoryCode=budgetCategoryMapping.getBudgetCategoryCode();
        } else {
            CostElement costElement = (CostElement) maintenanceDocument.getNewMaintainableObject().getDataObject();
            budgetCategoryCode=costElement.getBudgetCategoryCode();
            
        }
        Map pkMap = new HashMap();
        pkMap.put("code", budgetCategoryCode);
        valid=checkExistenceFromTable(BudgetCategory.class,pkMap,"code", "Budget Category");


        return valid;

    }
    

}
