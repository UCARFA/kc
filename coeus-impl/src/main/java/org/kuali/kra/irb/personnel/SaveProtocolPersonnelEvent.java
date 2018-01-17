/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.personnel;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.protocol.personnel.SaveProtocolPersonnelEventBase;

/**
 * Represents the event to save a ProtocolPersonnel.
 */
public class SaveProtocolPersonnelEvent extends SaveProtocolPersonnelEventBase {
    
    /**
     * Constructs an SaveProtocolPersonnelEvent.
     * @param errorPathPrefix The error path prefix
     * @param document The document to validate
     */
    public SaveProtocolPersonnelEvent(String errorPathPrefix, ProtocolDocument document) {
        super(errorPathPrefix, document);
    }
    

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new SaveProtocolPersonnelRule();
    }
    
}
