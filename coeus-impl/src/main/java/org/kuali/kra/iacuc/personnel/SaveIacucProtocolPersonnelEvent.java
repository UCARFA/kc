/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.personnel.SaveProtocolPersonnelEventBase;

/**
 * Represents the event to save a ProtocolPersonnel.
 */
public class SaveIacucProtocolPersonnelEvent extends SaveProtocolPersonnelEventBase {

    /**
     * Constructs an SaveProtocolPersonnelEventBase.
     * @param errorPathPrefix The error path prefix
     * @param document The document to validate
     */
    public SaveIacucProtocolPersonnelEvent(String errorPathPrefix, ProtocolDocumentBase document) {
        super(errorPathPrefix, document);
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new SaveIacucProtocolPersonnelRule();
    }
    
}
