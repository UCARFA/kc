/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.assignagenda;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.actions.genericactions.IacucProtocolGenericActionBean;
import org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaService;


/**
 * Handles the processing of assigning a protocol to an agenda.
 */
public interface IacucProtocolAssignToAgendaService extends ProtocolAssignToAgendaService {
    
    public void removeFromAgenda(IacucProtocol protocol, IacucProtocolGenericActionBean actionBean) throws Exception;
    
}
