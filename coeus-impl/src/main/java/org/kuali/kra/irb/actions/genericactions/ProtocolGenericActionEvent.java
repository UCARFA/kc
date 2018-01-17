/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.genericactions;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionEventBase;

/**
 * Encapsulates the event that the user performs a generic action.
 */
@SuppressWarnings("unchecked")
public class ProtocolGenericActionEvent extends ProtocolGenericActionEventBase {

    public ProtocolGenericActionEvent(ProtocolDocumentBase document, ProtocolGenericActionBean protocolGenericActionBean) {
        super(document, protocolGenericActionBean);
    }
    
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public KcBusinessRule getRule() {
        return new ProtocolGenericActionRule();
    }

}
