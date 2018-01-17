/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.notification;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.notification.IRBNotificationRenderer;

import java.util.Map;

/**
 * Renders additional fields for the Batch Correspondence notification.
 */
public class BatchCorrespondenceNotificationRenderer extends IRBNotificationRenderer {

    private static final long serialVersionUID = -9052923333795275244L;
    
    private Long detailId;
    private String protocolCorrespondenceType;
    private String userFullName;

    /**
     * Constructs a Batch Correspondence notification renderer.
     * 
     * @param protocol
     * @param detailId
     * @param protocolCorrespondenceType
     * @param userFullName
     */
    public BatchCorrespondenceNotificationRenderer(Protocol protocol, Long detailId, String protocolCorrespondenceType, String userFullName) {
        super(protocol);
        
        this.detailId = detailId;
        this.protocolCorrespondenceType = protocolCorrespondenceType;
        this.userFullName = userFullName;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public String getProtocolCorrespondenceType() {
        return protocolCorrespondenceType;
    }

    public void setProtocolCorrespondenceType(String protocolCorrespondenceType) {
        this.protocolCorrespondenceType = protocolCorrespondenceType;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{DETAIL_ID}", detailId.toString());
        params.put("{PROTOCOL_CORRESPONDENCE_TYPE}", protocolCorrespondenceType);
        return params;
    }

}
