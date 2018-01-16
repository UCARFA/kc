/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.rule;

import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.species.IacucProtocolSpecies;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * This class hooks Rule to Event in KNS
 */
public class AddProtocolSpeciesEvent extends ProtocolSpeciesEventBase {

    /**
     * 
     * Constructs a AddProtocolSpeciesEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param iacucProtocolSpecies
     */
    public AddProtocolSpeciesEvent(String errorPathPrefix, IacucProtocolDocument document, IacucProtocolSpecies iacucProtocolSpecies) {
        super("adding ProtocolSpecies to document " + getDocumentId(document), errorPathPrefix, document, iacucProtocolSpecies);
    }
    
    /**
     * 
     * Constructs a AddProtocolSpeciesEvent.java.
     * @param errorPathPrefix
     * @param document
     * @param iacucProtocolSpecies
     */
    public AddProtocolSpeciesEvent(String errorPathPrefix, Document document, IacucProtocolSpecies iacucProtocolSpecies) {
        this(errorPathPrefix, (IacucProtocolDocument)document, iacucProtocolSpecies);
    } 
    
    @Override
    public Class getRuleInterfaceClass() {
        return AddProtocolSpeciesRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((AddProtocolSpeciesRule)rule).processAddProtocolSpeciesBusinessRules(this);
    }


}
