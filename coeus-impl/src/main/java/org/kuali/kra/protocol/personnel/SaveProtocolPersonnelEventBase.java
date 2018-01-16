/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.personnel;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * Represents the event to save a ProtocolPersonnel.
 */
public abstract class SaveProtocolPersonnelEventBase extends KcDocumentEventBaseExtension {

    /**
     * Constructs an SaveProtocolPersonnelEventBase.
     * @param errorPathPrefix The error path prefix
     * @param document The document to validate
     */
    protected SaveProtocolPersonnelEventBase(String errorPathPrefix, ProtocolDocumentBase document) {
        super("Saving protocol personnel on document " + getDocumentId(document), errorPathPrefix, document);
    }
  
}
