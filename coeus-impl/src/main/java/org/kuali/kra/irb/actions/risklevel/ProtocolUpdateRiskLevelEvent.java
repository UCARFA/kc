/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.risklevel;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.irb.ProtocolDocument;

/**
 * Encapsulates a validation event for a Protocol Risk Level update action.
 */
public class ProtocolUpdateRiskLevelEvent extends KcDocumentEventBaseExtension {
    
    private int index;

    /**
     * Constructs a ProtocolUpdateRiskLevelEvent.
     * 
     * @param document The document to validate
     * @param index The index of the Risk Level to validate
     */
    public ProtocolUpdateRiskLevelEvent(ProtocolDocument document, int index) {
        super("Enter risk level", "", document);
        this.index = index;
    }
    
    public ProtocolDocument getProtocolDocument() {
        return (ProtocolDocument) getDocument();
    }
    
    public int getIndex() {
        return index;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new ProtocolUpdateRiskLevelRule();
    }

}
