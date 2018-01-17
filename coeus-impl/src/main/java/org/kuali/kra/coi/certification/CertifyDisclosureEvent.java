/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.certification;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.coi.CoiDisclosure;

// TODO: Note, this is a stub class that must be filled out to allow print.
public class CertifyDisclosureEvent  extends KcDocumentEventBaseExtension {
    
    private CoiDisclosure disclosure;
    private String propertyName;

    public CertifyDisclosureEvent(String propertyName, CoiDisclosure disclosure) {
        super("Disclosure Certification", "", null);
        this.disclosure = disclosure;
        this.propertyName = propertyName;
    }
        
    public String getPropertyName() {
        return propertyName;
    }
    
    public CoiDisclosure getDisclosure() {
        return disclosure;
    }
     
    @SuppressWarnings("rawtypes")
    @Override
    public KcBusinessRule getRule() {
        return new CertifyDisclosureRule();
    }


}
