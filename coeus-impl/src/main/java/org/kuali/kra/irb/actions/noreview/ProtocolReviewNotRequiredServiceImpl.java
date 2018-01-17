/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.noreview;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.actions.ProtocolAction;
import org.kuali.kra.irb.actions.ProtocolActionType;
import org.kuali.kra.irb.actions.submit.ProtocolActionService;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.sql.Timestamp;

/**
 * This class manages the action of marking a protocol as review not required.
 */
public class ProtocolReviewNotRequiredServiceImpl implements ProtocolReviewNotRequiredService {
    
    private BusinessObjectService businessObjectService;
    private ProtocolActionService protocolActionService;

    public ProtocolActionService getProtocolActionService() {
        return protocolActionService;
    }

    public void setProtocolActionService(ProtocolActionService protocolActionService) {
        this.protocolActionService = protocolActionService;
    }

    


    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    public BusinessObjectService getBusinessObjectService() {
        return businessObjectService;
    }

    @Override
    public void reviewNotRequired(ProtocolDocument protocolDocument, ProtocolReviewNotRequiredBean actionBean) {
        Protocol protocol = protocolDocument.getProtocol();
        ProtocolAction protocolAction = new ProtocolAction(protocol, protocol.getProtocolSubmission(), ProtocolActionType.IRB_REVIEW_NOT_REQUIRED);
        protocolAction.setComments(actionBean.getComments());
        protocolAction.setActionDate(new Timestamp(actionBean.getActionDate().getTime()));
        protocol.getProtocolActions().add(protocolAction);
        
        protocolActionService.updateProtocolStatus(protocolAction, protocol);     
        
        protocol.setApprovalDate(actionBean.getDecisionDate());
        
        protocol.refreshReferenceObject("protocolStatus");
        businessObjectService.save(protocolDocument.getProtocol());
    }
}
