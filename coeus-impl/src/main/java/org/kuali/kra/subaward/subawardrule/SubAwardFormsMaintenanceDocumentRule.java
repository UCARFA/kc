/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.subawardrule;

import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.subaward.bo.SubAwardForms;
import org.kuali.rice.kns.document.MaintenanceDocument;

public class SubAwardFormsMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    
    private static final String TEMPLATE_FILE_FIELD_NAME = "templateFile";

    /**
     * 
     * @see org.kuali.rice.kns.maintenance.rules.MaintenanceDocumentRuleBase#processCustomRouteDocumentBusinessRules(org.kuali.rice.kns.document.MaintenanceDocument)
     */

    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return isDocumentValidForSave(document);
    }


    /**
     * @see org.kuali.rice.kns.maintenance.rules.MaintenanceDocumentRuleBase#processCustomSaveDocumentBusinessRules(org.kuali.rice.kns.document.MaintenanceDocument)
     */
    @Override
    public boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        return isDocumentValidForSave(document);
    }

    /**
     * 
     * @see org.kuali.rice.kns.maintenance.rules.MaintenanceDocumentRuleBase#processCustomApproveDocumentBusinessRules(org.kuali.rice.kns.document.MaintenanceDocument)
     */
    @Override
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return isDocumentValidForSave(document);
    }

    /**
     * 
     * @see org.kuali.rice.kns.maintenance.rules.MaintenanceDocumentRuleBase#isDocumentValidForSave(org.kuali.rice.kns.document.MaintenanceDocument)
     */
    @Override
    public boolean isDocumentValidForSave(MaintenanceDocument document) {
        boolean result = super.isDocumentValidForSave(document);
        final SubAwardForms subAwardForms = (SubAwardForms) document.getNewMaintainableObject().getDataObject();
       
        String fileName = "";
        if (subAwardForms.getFileName() == null) {  
            if (subAwardForms.getTemplateFile() != null) {
                fileName = subAwardForms.getTemplateFile().getFileName();
            }
        } else {
            fileName = subAwardForms.getFileName();
        }
        
        if (!fileName.endsWith(".xsl")) {
            result = false;
            putFieldError(TEMPLATE_FILE_FIELD_NAME, KeyConstants.SUBAWARD_ERROR_INVALID_FILE_TYPE);
        }
        return result;
    }
    
}
