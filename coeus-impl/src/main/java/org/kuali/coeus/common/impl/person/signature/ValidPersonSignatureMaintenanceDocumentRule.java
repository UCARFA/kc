/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.person.signature;

import org.kuali.coeus.common.framework.person.signature.PersonSignature;
import org.kuali.coeus.sys.framework.rule.KcMaintenanceDocumentRuleBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.rice.kns.document.MaintenanceDocument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidPersonSignatureMaintenanceDocumentRule extends KcMaintenanceDocumentRuleBase {
    private static final String PERSON_SIGNATURE_FILE_INVALID_ERROR_KEY = "error.invalid.personSignature.invalid.fileName";
    private static final String PERSON_SIGNATURE_ID_INVALID_ERROR_KEY = "error.invalid.personSignature.invalid.personSignatureId";

    @Override

    @SuppressWarnings("deprecation")
    protected boolean processCustomRouteDocumentBusinessRules(MaintenanceDocument document) {
        return isPersonSignatureValidForSave(document);
    }


    @SuppressWarnings("deprecation")
    @Override
    public boolean processCustomSaveDocumentBusinessRules(MaintenanceDocument document) {
        return isPersonSignatureValidForSave(document);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean processCustomApproveDocumentBusinessRules(MaintenanceDocument document) {
        return isPersonSignatureValidForSave(document);
    }

    @SuppressWarnings("deprecation")
    public boolean isPersonSignatureValidForSave(MaintenanceDocument document) {
        boolean result = super.isDocumentValidForSave(document);
        result &= isSignatureValid(document);
        result &= isNotDuplicateSignatureId(document);
        return result;
    }
    
    @SuppressWarnings("deprecation")
    private boolean isSignatureValid(MaintenanceDocument document) {
        boolean isSignatureValid = true;
        PersonSignature personSignature = (PersonSignature)document.getNewMaintainableObject().getDataObject();
        
        if(personSignature.getTemplateFile() == null && personSignature.getFileName() == null) {
            ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
            errorReporter.reportError("document.newMaintainableObject.templateFile", 
                    PERSON_SIGNATURE_FILE_INVALID_ERROR_KEY,
                    new String[]{});
            isSignatureValid = false;
        }
        return isSignatureValid;
    }
    
    @SuppressWarnings("deprecation")
    private boolean isNotDuplicateSignatureId(MaintenanceDocument document) {
        boolean isValid = true;
        PersonSignature personSignature = (PersonSignature) document.getNewMaintainableObject().getDataObject();
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put("personId", personSignature.getPersonId());
        if(document.isNew()) {
            isValid = getBoService().countMatching(PersonSignature.class, fieldValues) == 0;
        }else if (document.isEdit()) {
            isValid = isRecordUpdateValid(fieldValues, personSignature);
        }
        if(!isValid) {
            ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
            errorReporter.reportError("document.newMaintainableObject.personId", 
                    PERSON_SIGNATURE_ID_INVALID_ERROR_KEY,
                    new String[]{});
        }
        return isValid;
    }

    @SuppressWarnings("deprecation")
    private boolean isRecordUpdateValid(Map<String, Object> fieldValues, PersonSignature mdocPersonSignature) {
        boolean isRecordUpdateValid = false;
        List<PersonSignature> authorizedSignatures = (List<PersonSignature>)getBoService().findMatching(PersonSignature.class, fieldValues);
        if(authorizedSignatures.isEmpty()) {
            isRecordUpdateValid = true;
        }else {
            PersonSignature dbPersonSignature = authorizedSignatures.get(0);
            Long dbPersonSignatureId = dbPersonSignature.getPersonSignatureId();
            if(mdocPersonSignature.getPersonSignatureId().equals(dbPersonSignatureId)) {
                isRecordUpdateValid = true;
            }
        }
        return isRecordUpdateValid;
    }
    
}
