/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.amendrenew;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.protocol.actions.amendrenew.CreateAmendmentEventBase;

/**
 * When an amendment is created, this event is generated.
 */
@SuppressWarnings("unchecked")
public class CreateAmendmentEvent extends CreateAmendmentEventBase {


    public CreateAmendmentEvent(ProtocolDocument document, String propertyName, ProtocolAmendmentBean amendmentBean) {
        super(document, propertyName, amendmentBean);
    }

    @Override
    public KcBusinessRule getRule() {
        return new CreateAmendmentRule();
    }
}
