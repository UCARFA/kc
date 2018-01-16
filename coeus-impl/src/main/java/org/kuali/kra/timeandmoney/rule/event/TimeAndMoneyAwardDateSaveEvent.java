/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.timeandmoney.rule.event;

import org.kuali.coeus.sys.framework.rule.KcDocumentEventBase;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.BusinessRule;


public class TimeAndMoneyAwardDateSaveEvent extends KcDocumentEventBase {

    public TimeAndMoneyAwardDateSaveEvent(String errorPathPrefix, Document document) {
        super("Save Date Rules", errorPathPrefix, document);
    }

    @Override
    protected void logEvent() {


    }

    @Override
    public Class getRuleInterfaceClass() {

        return null;
    }

    @Override
    public boolean invokeRuleMethod(BusinessRule arg0) {

        return false;
    }

}
