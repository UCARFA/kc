/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.kim.bo.KcKimAttributes;

/**
 * Implements the IRBNotificationRoleQualifierService.
 */
public class IRBNotificationRoleQualifierServiceImpl implements IRBNotificationRoleQualifierService {

    private Protocol protocol;
    private ProtocolOnlineReview protocolOnlineReview;
    
    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String roleQualifierValue = null;
        
        String qName = qualifier.getQualifier();
        
        if (StringUtils.equalsIgnoreCase(qName, KcKimAttributes.UNIT_NUMBER) 
                || StringUtils.equalsIgnoreCase(qName, "protocolLeadUnitNumber")) {
            roleQualifierValue = getProtocol().getLeadUnitNumber();
        } else if (StringUtils.equalsIgnoreCase(qName, KcKimAttributes.PROTOCOL)) {
            roleQualifierValue = getProtocol().getProtocolNumber();
        } else if (StringUtils.equalsIgnoreCase(qName, KcKimAttributes.SUBUNITS)) {
            roleQualifierValue = "Y";
        } else if (StringUtils.equalsIgnoreCase(qName, "submissionId")) {
            if (getProtocol().getProtocolSubmission() != null) {
                roleQualifierValue = getProtocol().getProtocolSubmission().getSubmissionId().toString();
            }
        } else if (StringUtils.equals(qName, "protocolOnlineReviewId")) {
            if (protocolOnlineReview != null) {
                roleQualifierValue = protocolOnlineReview.getProtocolOnlineReviewId().toString();
            }
        }
        
        return roleQualifierValue;
    }

    @Override
    public Protocol getProtocol() {
        return protocol;
    }

    @Override
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public ProtocolOnlineReview getProtocolOnlineReview() {
        return protocolOnlineReview;
    }

    @Override
    public void setProtocolOnlineReview(ProtocolOnlineReview protocolOnlineReview) {
        this.protocolOnlineReview = protocolOnlineReview;
    }

}
