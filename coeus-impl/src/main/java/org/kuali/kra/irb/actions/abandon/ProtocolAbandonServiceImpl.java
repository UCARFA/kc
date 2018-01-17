/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.abandon;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.genericactions.ProtocolGenericCorrespondence;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.abandon.ProtocolAbandonServiceImplBase;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.kra.protocol.actions.genericactions.ProtocolGenericActionBean;
import org.kuali.rice.kew.api.exception.WorkflowException;

/**
 * 
 * This class to implement the detail of abandon protocol
 */
public class ProtocolAbandonServiceImpl extends ProtocolAbandonServiceImplBase implements ProtocolAbandonService {

    @Override
    protected String getActionType() {
        return ProtocolActionType.ABANDON_PROTOCOL;
    }
  
    @Override
    public ProtocolActionBase getNewActionHook(ProtocolBase protocol) {
        return new ProtocolAction((Protocol)protocol, null, getActionType());

    }

    @Override
    protected ProtocolActionsCorrespondenceBase getNewProtocolCorrespondenceHook(String actionType) {
        return new ProtocolGenericCorrespondence(actionType);
    }
    
    @Override
    public void abandonProtocol(ProtocolBase protocol, ProtocolGenericActionBean protocolAbandonBean) throws WorkflowException {

        ProtocolActionBase protocolAction = getNewActionHook(protocol); 
        protocolAction.setComments(protocolAbandonBean.getComments());
        protocol.getProtocolActions().add(protocolAction);
        super.getProtocolActionService().updateProtocolStatus(protocolAction, protocol);
        protocol.setActive(false);
        ProtocolDocumentBase protocolDocument = protocol.getProtocolDocument();
        
        //KEW exception will be thrown if document is in Final status and cancelDocument is called.
        //Batch Correspondence could have abandon action as the final action for batch correspondence with documents in Final status.
        if (!protocolDocument.getDocumentHeader().getWorkflowDocument().isFinal()) {
            super.getDocumentService().cancelDocument(protocol.getProtocolDocument(), null);
        }
    }
}
