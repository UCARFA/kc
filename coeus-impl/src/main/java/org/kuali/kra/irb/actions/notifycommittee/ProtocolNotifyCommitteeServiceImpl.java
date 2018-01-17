/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notifycommittee;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.submit.ProtocolActionService;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.krad.service.DocumentService;

import java.sql.Timestamp;

/**
 * Protocol Request Service Implementation.
 */
public class ProtocolNotifyCommitteeServiceImpl implements ProtocolNotifyCommitteeService {
    
    private DocumentService documentService;
    private ProtocolActionService protocolActionService;

    /**
     * Set the business object service.
     * @param businessObjectService the business office service
     */
    public void setProtocolActionService(ProtocolActionService protocolActionService) {
        this.protocolActionService = protocolActionService;
    }

    /**
     * @throws WorkflowException 
     * @see org.kuali.kra.irb.actions.notifycommittee.ProtocolNotifyCommitteeService#submitCommitteeNotification(org.kuali.kra.irb.Protocol, org.kuali.kra.irb.actions.notifycommittee.ProtocolNotifyCommitteeBean)
     */
    @Override
    public void submitCommitteeNotification(Protocol protocol, ProtocolNotifyCommitteeBean notifyCommitteeBean) throws WorkflowException {
        // we do not create a new submission here unlike in notify IRB
        ProtocolAction protocolAction = new ProtocolAction(protocol, null, ProtocolActionType.NOTIFIED_COMMITTEE);
        protocolAction.setComments(notifyCommitteeBean.getComment());
        protocolAction.setActionDate(new Timestamp(notifyCommitteeBean.getActionDate().getTime()));
        protocol.getProtocolActions().add(protocolAction);
        protocolActionService.updateProtocolStatus(protocolAction, protocol);
        documentService.saveDocument(protocol.getProtocolDocument());
    }
    
    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
    
}
