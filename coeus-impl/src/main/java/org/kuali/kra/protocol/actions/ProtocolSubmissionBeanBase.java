/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.kra.protocol.actions.notify.ProtocolActionAttachment;

import java.util.List;

/**
 * 
 * This class for the base property of request/notify action
 */
public interface ProtocolSubmissionBeanBase extends ProtocolActionBean {
   

    public String getCommitteeId();
    
    public void setCommitteeId(String committeeId);

    public ProtocolActionAttachment getNewActionAttachment();
    
    public void setNewActionAttachment(ProtocolActionAttachment newActionAttachment);

    public List<ProtocolActionAttachment> getActionAttachments();

    public void setActionAttachments(List<ProtocolActionAttachment> actionAttachments);
}
