/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.rule.event;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.rice.krad.document.Document;

@SuppressWarnings("unchecked")
public abstract class CommitteeActionsEventBase <Z extends KcBusinessRule> extends KcDocumentEventBaseExtension {

    protected CommitteeActionsEventBase(String description, String errorPathPrefix, Document document) {
        super(description, errorPathPrefix, document);
    }

}
