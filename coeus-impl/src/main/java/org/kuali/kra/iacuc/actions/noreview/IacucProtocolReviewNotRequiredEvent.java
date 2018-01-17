/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.noreview;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.noreview.ExecuteProtocolReviewNotRequiredRule;
import org.kuali.rice.krad.rules.rule.BusinessRule;


public class IacucProtocolReviewNotRequiredEvent extends KcDocumentEventBase {
    
    private IacucProtocolReviewNotRequiredBean actionBean;
    
    /**
     * 
     * Constructs a ProtocolReviewNotRequiredEvent.java.
     * @param document
     * @param actionBean
     */
    public IacucProtocolReviewNotRequiredEvent(ProtocolDocumentBase document, IacucProtocolReviewNotRequiredBean actionBean) {
        super("review not required for document " + getDocumentId(document), "", document);
        this.actionBean = actionBean;
        logEvent();
    }

    @Override
    public Class getRuleInterfaceClass() {
        return ExecuteProtocolReviewNotRequiredRule.class;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule rule) {
        return ((ExecuteProtocolReviewNotRequiredRule) rule).processReviewNotRequiredRule((ProtocolDocumentBase) getDocument(), actionBean);
    }

    @Override
    protected void logEvent() {

        
    }

}
