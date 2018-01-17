/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.genericactions;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionEventBase;

public class IacucProtocolGenericActionEvent extends ProtocolGenericActionEventBase {

    public IacucProtocolGenericActionEvent(IacucProtocolDocument document, IacucProtocolGenericActionBean protocolGenericActionBean) {
        super(document, protocolGenericActionBean);
    }

    
    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new IacucProtocolGenericActionRule();
    }
}
