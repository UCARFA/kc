/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignagenda;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.kra.iacuc.IacucProtocolDocument;
import org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaEventBase;

/**
 * The event that occurs when the IRB Administrator assigns a protocol to an agenda.
 */
public class IacucProtocolAssignToAgendaEvent extends ProtocolAssignToAgendaEventBase {


    public IacucProtocolAssignToAgendaEvent(IacucProtocolDocument document, IacucProtocolAssignToAgendaBean protocolAssignToAgendaBean) {
        super(document, protocolAssignToAgendaBean);
    }

    @Override
    @SuppressWarnings("unchecked")
    public KcBusinessRule getRule() {
        return new IacucProtocolAssignToAgendaRule();
    }
    
}
