/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.exception.rule;

import org.kuali.kra.iacuc.species.exception.IacucProtocolException;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

/**
 * This class is implementation of <code>AddProtocolExceptionRule</code> interface. Impl makes sure necessary rules are satisfied 
 * before object can be used.
 */
public class ProtocolExceptionRule extends KcTransactionalDocumentRuleBase implements AddProtocolExceptionRule {
    private static final String NEW_PROTOCOL_EXCEPTION_PATH = "iacucProtocolExceptionHelper.newIacucProtocolException";

    @Override
    public boolean processAddProtocolExceptionBusinessRules(AddProtocolExceptionEvent addProtocolExceptionEvent) {
        
        boolean rulePassed = true;
        MessageMap errorMap = GlobalVariables.getMessageMap();
        errorMap.addToErrorPath(NEW_PROTOCOL_EXCEPTION_PATH);
        IacucProtocolException protocolException = addProtocolExceptionEvent.getProtocolException();
        
        getDictionaryValidationService().validateBusinessObject(protocolException);
        rulePassed &= GlobalVariables.getMessageMap().hasNoErrors();

        errorMap.removeFromErrorPath(NEW_PROTOCOL_EXCEPTION_PATH);

        return rulePassed;
    }

}
