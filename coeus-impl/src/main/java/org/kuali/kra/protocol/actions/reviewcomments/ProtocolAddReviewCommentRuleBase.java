/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.reviewcomments;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * Validates the rules for a ProtocolBase Risk Level add action.
 */
public abstract class ProtocolAddReviewCommentRuleBase<E extends ProtocolAddReviewCommentEventBase> extends KcTransactionalDocumentRuleBase implements KcBusinessRule<E> {
    
    @Override
    public boolean processRules(E event) {
        boolean isValid = true;
        
        String errorPathKey = event.getPropertyName() + ".newReviewComment";
        GlobalVariables.getMessageMap().addToErrorPath(errorPathKey);
        getDictionaryValidationService().validateBusinessObject(event.getReviewComment());
        GlobalVariables.getMessageMap().removeFromErrorPath(errorPathKey);
        
        isValid &= GlobalVariables.getMessageMap().hasNoErrors();
        
        return isValid;
    }

}
