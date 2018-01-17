/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.undo;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.committee.bo.CommitteeBatchCorrespondenceDetail;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.ProtocolStatus;
import org.kuali.kra.irb.correspondence.ProtocolCorrespondence;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.ProtocolActionBase;
import org.kuali.kra.protocol.actions.undo.UndoLastActionServiceImplBase;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndoLastActionServiceImpl extends UndoLastActionServiceImplBase implements UndoLastActionService {

    @Override
    protected String getAmendmentInProgressStatusHook() {
        return ProtocolStatus.AMENDMENT_IN_PROGRESS;
    }
    
    @Override
    protected String getInProgressStatusHook() {
        return ProtocolStatus.IN_PROGRESS;
    }
    
    @Override
    protected String getRenewalInProgressStatusHook() {
        return ProtocolStatus.RENEWAL_IN_PROGRESS;
    }

    @Override
    protected String getFyiInProgressStatusHook() {
        return ProtocolStatus.FYI_IN_PROGRESS;
    }

    @Override
    protected boolean isApprovedActionTypeCode(String actionTypeCode) {
        return StringUtils.equals(actionTypeCode, ProtocolActionType.APPROVED) 
            || StringUtils.equals(actionTypeCode, ProtocolActionType.EXPEDITE_APPROVAL);
    }
    
    @Override
    protected boolean isRevisionsRequiredActionTypeCode(String actionTypeCode) {
        return StringUtils.equals(actionTypeCode, ProtocolActionType.SUBSTANTIVE_REVISIONS_REQUIRED) 
            || StringUtils.equals(actionTypeCode, ProtocolActionType.SPECIFIC_MINOR_REVISIONS_REQUIRED);
    }
    
    @Override
    protected void removeAttachedCorrespondences(ProtocolActionBase protocolAction) {
        if(protocolAction != null) {
            getBusinessObjectService().deleteMatching(CommitteeBatchCorrespondenceDetail.class, Collections.singletonMap("protocolActionId", protocolAction.getProtocolActionId().toString()));

            final Map<String, String> fieldValues = new HashMap<>();
            fieldValues.put("actionIdFk", protocolAction.getProtocolActionId().toString());
            fieldValues.put("protocolNumber", protocolAction.getProtocolNumber());
            fieldValues.put("sequenceNumber", protocolAction.getSequenceNumber().toString());

            getBusinessObjectService().deleteMatching(ProtocolCorrespondence.class, fieldValues);
        }
    }
    

    @Override
    protected ProtocolBase getOldProtocol(ProtocolBase protocol) {
        Map<String, Object> fieldValues = new HashMap<String, Object>();
        fieldValues.put("protocolNumber", protocol.getProtocolNumber());
        fieldValues.put("sequenceNumber", protocol.getSequenceNumber() - 1);
        return ((List<Protocol>) getBusinessObjectService().findMatching(Protocol.class, fieldValues)).get(0);
   }
}
