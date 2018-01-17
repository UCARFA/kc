/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.actions;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiUserRole;

/**
 * 
 * This class represents the event fired when a coi reviewer is added to 
 * a disclosure.
 */
public class AddCoiReviewerEvent extends KcDocumentEventBaseExtension {

    private String propertyName;
    private CoiDisclosure coiDisclosure;
    private CoiUserRole coiUserRole;
    
    
    public AddCoiReviewerEvent(String propertyName, CoiDisclosure coiDisclosure, CoiUserRole coiUserRole) {
        super("Add Coi Reviewer", "", null);       
        this.propertyName = propertyName;
        this.coiDisclosure = coiDisclosure;
        this.coiUserRole = coiUserRole;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public KcBusinessRule getRule() {
        return new AddCoiReviewerRule();
    }

    public CoiDisclosure getCoiDisclosure() {
        return coiDisclosure;
    }

    public void setCoiDisclosure(CoiDisclosure coiDisclosure) {
        this.coiDisclosure = coiDisclosure;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public CoiUserRole getCoiUserRole() {
        return coiUserRole;
    }

    public void setCoiUserRole(CoiUserRole coiUserRole) {
        this.coiUserRole = coiUserRole;
    }
}
