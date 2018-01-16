/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.award.home.ContactType;
import org.kuali.kra.award.home.ContactUsage;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;

public class ContactUsageMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    
    private Long oldTypeId = null;

    
    public ContactUsageMaintenanceDocumentRule() {
        super();
    }
    
    @Override
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        setOldTypeId(document);
        ContactUsage contactUsage = (ContactUsage) document.getDocumentBusinessObject();
        return validate(contactUsage, document.getNewMaintainableObject().getMaintenanceAction());
    }
    
    @Override
    protected boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        setOldTypeId(document);
        ContactUsage contactUsage = (ContactUsage) document.getDocumentBusinessObject();
        return validate(contactUsage, document.getNewMaintainableObject().getMaintenanceAction());
    }

    private boolean validate(ContactUsage contactUsage, String maintenanceAction) {
        boolean valid = validateContactType(contactUsage);
        valid &= validateModule(contactUsage) && checkContactTypeModuleExists(contactUsage, maintenanceAction);
        return valid;
    }
    
    private boolean validateContactType(ContactUsage contactUsage) {
        boolean valid = true;
        if (StringUtils.isNotBlank(contactUsage.getContactTypeCode())) {
            Map<String, String> fieldValues = new HashMap<String, String>();
            fieldValues.put("contactTypeCode", contactUsage.getContactTypeCode());            
            List<ContactType> contactTypes = (List<ContactType>) boService.findMatching(ContactType.class, fieldValues);
            if (contactTypes.isEmpty()) {
                GlobalVariables.getMessageMap().putError("document.newMaintainableObject.contactTypeCode", KeyConstants.ERROR_CONTACT_TYPE_NOT_EXISTS,
                                                         new String[] { contactUsage.getContactTypeCode() });
                valid = false;
            }
        }
        return valid;
    }
    
    private boolean validateModule(ContactUsage contactUsage) {
        boolean valid = true;
        if (StringUtils.isNotBlank(contactUsage.getModuleCode())) {
            Map<String, String> fieldValues = new HashMap<String, String>();
            fieldValues.put("moduleCode", contactUsage.getModuleCode());
            List<CoeusModule> reviewTypes = (List<CoeusModule>) boService.findMatching(CoeusModule.class, fieldValues);
            if (reviewTypes.isEmpty()) {
                GlobalVariables.getMessageMap().putError("document.newMaintainableObject.moduleCode", KeyConstants.ERROR_MODULE_NOT_EXISTS,
                                                         new String[] { contactUsage.getModuleCode() });
                valid = false;
            }
        }
        return valid;
    }
    
    private boolean checkContactTypeModuleExists(ContactUsage contactUsage, String maintenanceAction) {
        boolean valid = true;
        if (StringUtils.isNotBlank(contactUsage.getContactTypeCode()) && StringUtils.isNotBlank(contactUsage.getModuleCode())) {
            Map<String, String> fieldValues = new HashMap<String, String>();
            fieldValues.put("contactTypeCode", contactUsage.getContactTypeCode());
            fieldValues.put("moduleCode", contactUsage.getModuleCode());
            List<ContactUsage> contactUsages = (List<ContactUsage>) boService.findMatching(ContactUsage.class, fieldValues);
            if (!contactUsages.isEmpty()) {
                ContactUsage existValidContactTypeModule = contactUsages.get(0);
                if ( (oldTypeId == null || 
                     ((!isMaintenanceActionEdit(maintenanceAction) & !isMaintenanceActionDelete(maintenanceAction)) && existValidContactTypeModule.getContactUsageId().equals(oldTypeId))) 
                        && contactUsage.getContactTypeCode().equals(existValidContactTypeModule.getContactTypeCode())
                        && contactUsage.getModuleCode().equals(existValidContactTypeModule.getModuleCode()) ) {
                    GlobalVariables.getMessageMap().putError("document.newMaintainableObject.contactTypeCode", KeyConstants.ERROR_CONTACT_TYPE_MODULE_EXISTS,
                                                             new String[] { contactUsage.getContactTypeCode(), contactUsage.getModuleCode() });
                    valid = false;
                }
            }
        }
        return valid;

    }
    
    private boolean isMaintenanceActionEdit(String maintenanceAction) {
        if (StringUtils.isNotBlank(maintenanceAction) && maintenanceAction.equals(KRADConstants.MAINTENANCE_EDIT_ACTION)) {
            return true;
        }
        return false;
    }
    
    private boolean isMaintenanceActionDelete(String maintenanceAction) {
        if (StringUtils.isNotBlank(maintenanceAction) && maintenanceAction.equals(KRADConstants.MAINTENANCE_DELETE_ACTION)) {
            return true;
        }
        return false;
    }
        
    private void setOldTypeId(MaintenanceDocument document) {
        oldTypeId = ((ContactUsage)document.getOldMaintainableObject().getDataObject()).getContactUsageId();       
    }

}
