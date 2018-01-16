/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.personfinancialentity;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;

/**
 * 
 * This class is and event class when save FE
 */
public class SaveFinancialEntityEvent  extends KcDocumentEventBaseExtension {
    
    private String propertyName;
    private PersonFinIntDisclosure personFinIntDisclosure;

    /**
     * 
     * Constructs a SaveFinancialEntityEvent.java.
     * @param propertyName
     * @param personFinIntDisclosure
     */
    public SaveFinancialEntityEvent(String propertyName, PersonFinIntDisclosure personFinIntDisclosure) {
        super("Save financial entity", "", null);
        this.propertyName = propertyName;
        this.personFinIntDisclosure = personFinIntDisclosure;
        
    }
        
    public String getPropertyName() {
        return propertyName;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new SaveFinancialEntityRule();
    }

    public PersonFinIntDisclosure getPersonFinIntDisclosure() {
        return personFinIntDisclosure;
    }

    public void setPersonFinIntDisclosure(PersonFinIntDisclosure personFinIntDisclosure) {
        this.personFinIntDisclosure = personFinIntDisclosure;
    }

}
