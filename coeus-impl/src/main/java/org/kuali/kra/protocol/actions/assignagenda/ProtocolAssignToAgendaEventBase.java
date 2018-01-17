/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.assignagenda;

import org.kuali.coeus.sys.framework.rule.KcBusinessRule;
import org.kuali.coeus.sys.framework.rule.KcDocumentEventBaseExtension;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.ProtocolDocumentBase;

/**
 * The event that occurs when the IRB Administrator assigns a protocol to an agenda.
 */
public abstract class ProtocolAssignToAgendaEventBase extends KcDocumentEventBaseExtension {

    private ProtocolAssignToAgendaBean protocolAssignToAgendaBean;
    
    /**
     * Constructs a ProtocolAssignToAgendaEventBase.
     * @param document the document to validate
     * @param protocolAssignToAgendaBean the bean that keeps the data
     */
    public ProtocolAssignToAgendaEventBase(ProtocolDocumentBase document, ProtocolAssignToAgendaBean protocolAssignToAgendaBean) {
        super("Submitting to agenda document " + getDocumentId(document), Constants.PROTOCOL_ASSIGN_TO_AGENDA_ACTION_PROPERTY_KEY, document);
        
        this.protocolAssignToAgendaBean = protocolAssignToAgendaBean;
    }
    
    
    public ProtocolAssignToAgendaBean getProtocolAssignToAgendaBean() {
        return protocolAssignToAgendaBean;
    }

    
    @Override
    public abstract KcBusinessRule getRule();

}
