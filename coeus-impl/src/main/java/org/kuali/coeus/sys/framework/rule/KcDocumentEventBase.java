/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rule;

import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.event.DocumentEventBase;


/**
 * Base implementation for events for KRA
 *
 * @author $Author: gmcgrego $
 * @version $Revision: 1.2 $
 */
public abstract class KcDocumentEventBase extends DocumentEventBase {

    protected KcDocumentEventBase(String description, String errorPathPrefix, Document document) {
        super(description, errorPathPrefix, document);
    }

    /**
     * Logs the event type and some information about the associated accountingLine
     */
    protected abstract void logEvent();
}
