/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.amendrenew;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.actions.amendrenew.CreateRenewalEventBase;

public class CreateIacucRenewalEvent extends CreateRenewalEventBase {

    public CreateIacucRenewalEvent(IacucProtocolDocument document, String propertyName, String renewalSummary) {
        super(document, propertyName, renewalSummary);
    }

    @Override
    public KcBusinessRule getRule() {
        return new CreateIacucRenewalRule();
    }

}
