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
 * Encapsulates a validation event for a Protocol Risk Level add action.
 */
public class ProtocolAddRiskLevelEvent extends KcDocumentEventBaseExtension {
    
    private String propertyName;
    private ProtocolRiskLevel riskLevel;

    /**
     * Constructs a ProtocolAddRiskLevelEvent.
     * 
     * @param document The document to validate
     * @param propertyName The error path property prefix
     * @param riskLevel The added Risk Level
     */
    public ProtocolAddRiskLevelEvent(ProtocolDocument document, String propertyName, ProtocolRiskLevel riskLevel) {
        super("Enter risk level", "", document);
        this.propertyName = propertyName;
        this.riskLevel = riskLevel;
    }
    
    public ProtocolDocument getProtocolDocument() {
        return (ProtocolDocument) getDocument();
    }
    
    public String getPropertyName() {
        return propertyName;
    }
    
    public ProtocolRiskLevel getProtocolRiskLevel() {
        return riskLevel;
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new ProtocolAddRiskLevelRule();
    }

}
