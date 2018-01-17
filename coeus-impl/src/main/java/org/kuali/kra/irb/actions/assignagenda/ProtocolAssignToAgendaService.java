/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.assignagenda;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.expeditedapprove.ProtocolExpeditedApproveBean;

/**
 * Handles the processing of assigning a protocol to an agenda.
 */
public interface ProtocolAssignToAgendaService extends org.kuali.kra.protocol.actions.assignagenda.ProtocolAssignToAgendaService {

    void assignToAgenda(Protocol protocol, ProtocolExpeditedApproveBean actionBean) throws Exception;
}
