/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.rule;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.kra.award.home.ContactType;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.kns.document.MaintenanceDocument;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.dao.DataIntegrityViolationException;

public class ContactTypeMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    
    public ContactTypeMaintenanceDocumentRule () {
        super();
    }
    
    @Override
    public boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return canRecordBeDeleted(document);
    }

    @Override
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return canRecordBeDeleted(document);
    }
    
    private boolean canRecordBeDeleted(MaintenanceDocument document) {        
        boolean recordCanBeDeleted = true;
        ContactType contactType = (ContactType)document.getDocumentBusinessObject();       
        if (StringUtils.isNotBlank(contactType.getContactTypeCode())) {
            Map<String, String> fieldValues = new HashMap<String, String>();
            fieldValues.put("contactTypeCode", contactType.getContactTypeCode());
            try {
                boService.deleteMatching(ContactType.class, fieldValues);
            }
            catch (DataIntegrityViolationException dive) {
                GlobalVariables.getMessageMap().putError("document.newMaintainableObject.contactTypeCode", 
                        KeyConstants.ERROR_CONTACT_TYPE_CODE_FOREIGN_KEY_EXISTS, new String[] { contactType.getContactTypeCode() });
                recordCanBeDeleted = false;
            }
        }
        return recordCanBeDeleted;
    }
}
