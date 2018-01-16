/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.rules;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.MessageMap;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public abstract class TemplateRuleTest<E extends KcDocumentEventBaseExtension, R extends KcBusinessRule> {
    
    protected E event;
     
    protected R rule;
    
    protected boolean expectedReturnValue;

    public TemplateRuleTest() {
        GlobalVariables.setMessageMap(new MessageMap());
        GlobalVariables.setAuditErrorMap(new HashMap());  
        prerequisite(); 
        assertEquals(expectedReturnValue, rule.processRules(event));
        checkRuleAssertions();
    }
    

    protected abstract void prerequisite();

    public void checkRuleAssertions() {
    ;
    }
    
    protected MessageMap getErrorMap() {
        return GlobalVariables.getMessageMap();
    }
}
