/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.species.rule;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.iacuc.species.IacucProtocolSpecies;

/**
 * This class is abstract base class for Event Notification
 */
public abstract class ProtocolSpeciesEventBase extends KcDocumentEventBase implements ProtocolSpeciesEvent {
    
    private IacucProtocolSpecies protocolSpecies;
    
    protected ProtocolSpeciesEventBase(String description, String errorPathPrefix, IacucProtocolDocument document, IacucProtocolSpecies protocolSpecies) {
        super(description, errorPathPrefix, document);
        this.protocolSpecies = protocolSpecies;
    }

    @Override
    protected void logEvent() {
    }
    
    @Override
    public IacucProtocolSpecies getProtocolSpecies() {
        return this.protocolSpecies;
    }

}
