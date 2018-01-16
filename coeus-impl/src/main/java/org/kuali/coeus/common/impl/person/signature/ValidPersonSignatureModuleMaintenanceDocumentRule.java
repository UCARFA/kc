/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person.signature;

import org.kuali.coeus.common.framework.person.signature.PersonSignature;
import org.kuali.coeus.common.framework.person.signature.PersonSignatureModule;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPersonSignatureModuleMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    private static final String PERSON_SIGNATURE_ID_INVALID_ERROR_KEY = "error.invalid.personSignature.invalid.personSignatureId";

    @Override
    @SuppressWarnings("deprecation")
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return isPersonSignatureModuleValidForSave(document);
    }


    @SuppressWarnings("deprecation")
    @Override
    public boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        return isPersonSignatureModuleValidForSave(document);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return isPersonSignatureModuleValidForSave(document);
    }

    @SuppressWarnings("deprecation")
    public boolean isPersonSignatureModuleValidForSave(MaintenanceDocument document) {
        boolean result = super.isDocumentValidForSave(document);
        result &= isSignatureIdValid(document);
        result &= isNotDuplicateSignatureId(document);
        return result;
    }
    
    @SuppressWarnings("deprecation")
    private boolean isSignatureIdValid(MaintenanceDocument document) {
        boolean isValid = true;
        PersonSignatureModule personSignatureModule = (PersonSignatureModule) document.getNewMaintainableObject().getDataObject();
        Map<String, Long> keyMap = new HashMap<String, Long>();
        keyMap.put("personSignatureId", personSignatureModule.getPersonSignatureId());
        isValid = checkExistenceFromTable(PersonSignature.class, keyMap, "personSignatureId", "Person Signature Id");
        return isValid;
    }

    @SuppressWarnings("deprecation")
    private boolean isNotDuplicateSignatureId(MaintenanceDocument document) {
        boolean isValid = true;
        PersonSignatureModule personSignatureModule = (PersonSignatureModule) document.getNewMaintainableObject().getDataObject();
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put("personSignatureId", personSignatureModule.getPersonSignatureId());
        fieldValues.put("moduleCode", personSignatureModule.getModuleCode());
        if(document.isNew()) {
            isValid = getBoService().countMatching(PersonSignatureModule.class, fieldValues) == 0;
        }else if (document.isEdit()) {
            isValid = isRecordUpdateValid(fieldValues, personSignatureModule);
        }
        if(!isValid) {
            ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
            errorReporter.reportError("document.newMaintainableObject.personSignatureId", 
                    PERSON_SIGNATURE_ID_INVALID_ERROR_KEY,
                    new String[]{});
        }
        return isValid;
    }
    
    /**
     * This method is to check the record is identical on update
     * if record does not exist then return true to perform update
     * @param fieldValues
     * @param mdocPersonSignatureModule
     * @return
     */
    @SuppressWarnings("deprecation")
    private boolean isRecordUpdateValid(Map<String, Object> fieldValues, PersonSignatureModule mdocPersonSignatureModule) {
        boolean isRecordUpdateValid = false;
        List<PersonSignatureModule> authorizedSignatures = (List<PersonSignatureModule>)getBoService().findMatching(PersonSignatureModule.class, fieldValues);
        if(authorizedSignatures.isEmpty()) {
            isRecordUpdateValid = true;
        }else {
            PersonSignatureModule dbPersonSignatureModule = authorizedSignatures.get(0);
            Long dbPersonSignatureModuleId = dbPersonSignatureModule.getPersonSignatureModuleId();
            if(mdocPersonSignatureModule.getPersonSignatureModuleId().equals(dbPersonSignatureModuleId)) {
                isRecordUpdateValid = true;
            }
        }
        return isRecordUpdateValid;
    }
    
}
