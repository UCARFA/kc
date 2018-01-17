/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notesandattachments;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.coi.notesandattachments.attachments.CoiDisclosureAttachment;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.coeus.sys.framework.validation.ErrorReporter;
import org.kuali.rice.kns.service.DictionaryValidationService;
import org.kuali.rice.kns.service.KNSServiceLocator;

public class CoiDisclosureAttachmentRuleHelper {
    private final DictionaryValidationService validationService;
    private final ErrorReporter errorReporter = KcServiceLocator.getService(ErrorReporter.class);
    private final String propertyPrefix = "coiNotesAndAttachmentsHelper.newCoiDisclosureAttachment";


    CoiDisclosureAttachmentRuleHelper() {
        this(KNSServiceLocator.getKNSDictionaryValidationService());
    }
    
    public CoiDisclosureAttachmentRuleHelper(final DictionaryValidationService validationService) {
           
            if (validationService == null) {
                throw new IllegalArgumentException("the validationService is null");
            }            
            this.validationService = validationService;
    }

    public boolean validPrimitiveFields(CoiDisclosureAttachment newCoiDisclosureAttachment) {
        Long oldFileId = newCoiDisclosureAttachment.getFileId();
        boolean valid = true;
        try {
            //adding a bogus file id to pass the validation service since the fileId is DB generated
            newCoiDisclosureAttachment.setFileId(Long.valueOf(0));
            valid &= this.validationService.isBusinessObjectValid(newCoiDisclosureAttachment, propertyPrefix);
        } finally {
            newCoiDisclosureAttachment.setFileId(oldFileId);
        }  
        return valid;
    }

    public boolean validFile(CoiDisclosureAttachment newCoiDisclosureAttachment) {
        final boolean valid;
        
        if (newCoiDisclosureAttachment.getFile() == null) {
            valid = false;
            this.errorReporter.reportError(propertyPrefix + ".newFile",
                KeyConstants.ERROR_COI_ATTACHMENT_MISSING_FILE);
        } else {
            valid = this.validationService.isBusinessObjectValid(newCoiDisclosureAttachment.getFile());
        }
        
        return valid;
    }


}
