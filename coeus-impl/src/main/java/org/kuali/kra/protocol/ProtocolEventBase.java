/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

/**
 * 
 * This class
 */
public abstract class ProtocolEventBase<Z extends KcBusinessRule> extends KcDocumentEventBaseExtension {

    /**
     * Enum helps identify type of error to respond.
     */
    public enum ErrorType {
        HARDERROR, SOFTERROR
    };

    private ErrorType type;

    public ProtocolEventBase(String description, String errorPathPrefix, Document document, ErrorType type) {
        super(description, errorPathPrefix, document);
        this.type = type;
    }

    /**
     * This method should return CommitteeScheduleEvent.event.
     * 
     * @return
     */
    public ErrorType getType() {
        return this.type;
    }

}
