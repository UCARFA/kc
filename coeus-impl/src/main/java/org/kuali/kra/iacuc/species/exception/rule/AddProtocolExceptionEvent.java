/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.exception.rule;

import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.species.exception.IacucProtocolException;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class hooks Rule to Event in KNS
 */
public class AddProtocolExceptionEvent extends ProtocolExceptionEventBase {

    /**
     * 
     * Constructs a AddProtocolExceptionEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param iacucProtocolException
     */
    public AddProtocolExceptionEvent(String errorPathPrefix, IacucProtocolDocument document, IacucProtocolException iacucProtocolException) {
        super("adding ProtocolException to document " + getDocumentId(document), errorPathPrefix, document, iacucProtocolException);
    }
    
    /**
     * 
     * Constructs a AddProtocolExceptionEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param iacucProtocolException
     */
    public AddProtocolExceptionEvent(String errorPathPrefix, Document document, IacucProtocolException iacucProtocolException) {
        this(errorPathPrefix, (IacucProtocolDocument)document, iacucProtocolException);
    } 
    
    @Override
    public Class getRuleInterfaceClass() {
        return AddProtocolExceptionRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProtocolExceptionRule)rule).processAddProtocolExceptionBusinessRules(this);
    }


}
