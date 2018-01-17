/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.notesandattachments;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.coi.notesandattachments.attachments.FinancialEntityAttachment;
import org.kuali.kra.coi.personfinancialentity.AddFinancialEntityAttachmentEvent;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

public class FinancialEntityAttachmentRule extends KcTransactionalDocumentRuleBase implements KcBusinessRule<AddFinancialEntityAttachmentEvent> {

    public boolean validPrimitiveFields(FinancialEntityAttachment newFinancialEntityAttachment) {
        Long oldFileId = newFinancialEntityAttachment.getFileId();
        try {
            //adding a bogus file id to pass the validation service since the fileId is DB generated
            newFinancialEntityAttachment.setFileId(Long.valueOf(0));
            return getDictionaryValidationService().isBusinessObjectValid(newFinancialEntityAttachment);
        } finally {
            newFinancialEntityAttachment.setFileId(oldFileId);
        }    
    }

    public boolean validFile(FinancialEntityAttachment newFinancialEntityAttachment) {
        final boolean valid;
        
        if (newFinancialEntityAttachment.getAttachmentFile() == null) {
            valid = false;
            reportError("newFile",
                KeyConstants.ERROR_COI_ATTACHMENT_MISSING_FILE);
        } else {
            valid = getDictionaryValidationService().isBusinessObjectValid(newFinancialEntityAttachment.getAttachmentFile());
        }
        
        return valid;
    }

    @Override
    public boolean processRules(AddFinancialEntityAttachmentEvent event) {
        GlobalVariables.getMessageMap().addToErrorPath(event.getErrorPathPrefix());
        boolean result = validPrimitiveFields(event.getAttachment());
        result &= validFile(event.getAttachment());
        GlobalVariables.getMessageMap().removeFromErrorPath(event.getErrorPathPrefix());
        return result;
    }


}
