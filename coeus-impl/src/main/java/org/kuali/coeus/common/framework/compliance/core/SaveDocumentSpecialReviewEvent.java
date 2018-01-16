/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.compliance.core;

import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;
import org.kuali.rice.krad.rules.rule.event.SaveDocumentEvent;

public class SaveDocumentSpecialReviewEvent<T extends SpecialReview> extends SaveDocumentEvent {
  
    public SaveDocumentSpecialReviewEvent(String errorPathPrefix, Document document) {
        super(errorPathPrefix, document);
    }
    
    @Override
    public Class<? extends BusinessRule> getRuleInterfaceClass() {
        return SaveDocumentSpecialReviewRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((SaveDocumentSpecialReviewRule) rule).processSaveDocumentSpecialReview(this);
    }
}
