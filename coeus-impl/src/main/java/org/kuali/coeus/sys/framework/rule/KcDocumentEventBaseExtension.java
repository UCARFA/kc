/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rule;

import org.kuali.rice.krad.document.Document;

public abstract class KcDocumentEventBaseExtension extends KcDocumentEventBase {

    protected KcDocumentEventBaseExtension(String description, String errorPathPrefix, Document document) {
        super(description, errorPathPrefix, document);
    }

    public abstract KcBusinessRule getRule();
    

    @Override
    @SuppressWarnings("unchecked")
    public boolean invokeRuleMethod(org.kuali.rice.krad.rules.rule.BusinessRule rule) {
        return ((KcBusinessRule)rule).processRules(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class getRuleInterfaceClass() {
        return KcBusinessRule.class;
    }

    @Override
    protected void logEvent() {       
    }
}
