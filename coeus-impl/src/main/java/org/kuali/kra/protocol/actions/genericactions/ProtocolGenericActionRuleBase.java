/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.genericactions;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcTransactionalDocumentRuleBase;
import org.kuali.kra.infrastructure.KeyConstants;

/**
 * Encapsulates the rules for performing a generic action.
 */
public abstract class ProtocolGenericActionRuleBase<E extends ProtocolGenericActionEventBase> extends KcTransactionalDocumentRuleBase implements KcBusinessRule<E> {
    
    private static final String ACTION_DATE_FIELD = "actionDate";
    
    @Override
    public boolean processRules(E event) {
        boolean isValid = true;
        
        if (event.getProtocolGenericActionBean().getActionDate() == null) {
            isValid = false;
            reportError(ACTION_DATE_FIELD, KeyConstants.ERROR_PROTOCOL_GENERIC_ACTION_DATE_REQUIRED);  
        }
        
        return isValid;
    }

}
