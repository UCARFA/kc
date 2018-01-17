/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.reviewcomments;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * This class implements the business rule when adding new review attachment.  ie, validate description and file are entered.
 */
public class ProtocolAddReviewAttachmentRule<E extends ProtocolAddReviewAttachmentEventBase<?>> extends KcTransactionalDocumentRuleBase implements KcBusinessRule<E> {
    
    @Override
    public boolean processRules(E event) {
        boolean isValid = true;
        
        String errorPathKey = event.getPropertyName() + ".newReviewAttachment";
        GlobalVariables.getMessageMap().addToErrorPath(errorPathKey);
        getDictionaryValidationService().validateBusinessObject(event.getReviewAttachment());
        if (event.getReviewAttachment().getNewFile() == null || StringUtils.isBlank(event.getReviewAttachment().getNewFile().getFileName())) {
            GlobalVariables.getMessageMap().putError("newFile",
            KeyConstants.ERROR_PROTOCOL_ATTACHMENT_MISSING_FILE);
        }
        GlobalVariables.getMessageMap().removeFromErrorPath(errorPathKey);
        
        isValid &= GlobalVariables.getMessageMap().hasNoErrors();
        
        return isValid;
    }

}
