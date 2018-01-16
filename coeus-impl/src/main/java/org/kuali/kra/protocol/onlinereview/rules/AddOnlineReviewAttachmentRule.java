/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.onlinereview.rules;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.onlinereview.event.AddProtocolOnlineReviewAttachmentEvent;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * This class implements validation rule when adding new OLR review attachment.
 */
public class AddOnlineReviewAttachmentRule  extends KcTransactionalDocumentRuleBase implements KcBusinessRule<AddProtocolOnlineReviewAttachmentEvent> {
    
    @Override
    public boolean processRules(AddProtocolOnlineReviewAttachmentEvent event) {
        boolean isValid = true;
        
        String errorPathKey = event.getPropertyName() + "newReviewAttachment";
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
