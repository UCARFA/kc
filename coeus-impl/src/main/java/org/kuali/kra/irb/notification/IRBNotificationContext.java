/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.notification;


import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.notification.impl.NotificationRenderer;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.onlinereview.ProtocolOnlineReview;
import org.kuali.kra.protocol.notification.ProtocolNotificationContextBase;

/**
 * This class extends the notification context base and provides some helpful functions for
 * any IRB specific events.
 */
public class IRBNotificationContext extends ProtocolNotificationContextBase {

    private static final long serialVersionUID = 6642334312368480034L;
    
    /**
     * Constructs an IRB notification context and sets the necessary services.
     * @param protocol
     * @param protocolOnlineReview
     * @param actionTypeCode
     * @param contextName
     */
    public IRBNotificationContext(Protocol protocol, ProtocolOnlineReview protocolOnlineReview, String actionTypeCode, String contextName, NotificationRenderer renderer) {
        this(protocol, actionTypeCode, contextName, renderer);        
        ((IRBNotificationRoleQualifierService) getNotificationRoleQualifierService()).setProtocolOnlineReview(protocolOnlineReview);
    }

    /**
     * Constructs an IRB notification context and sets the necessary services.
     * @param protocol
     * @param actionTypeCode
     * @param contextName
     */
    public IRBNotificationContext(Protocol protocol, String actionTypeCode, String contextName, NotificationRenderer renderer) {
        super(protocol, actionTypeCode, contextName, renderer);
        setNotificationRoleQualifierService(KcServiceLocator.getService(IRBNotificationRoleQualifierService.class));
        ((IRBNotificationRoleQualifierService) getNotificationRoleQualifierService()).setProtocol(protocol);
    }
    
    public IRBNotificationContext(Protocol protocol, String actionTypeCode, String contextName, NotificationRenderer renderer, String forwardName) {
        this(protocol, actionTypeCode, contextName, renderer);        
        setForwardName(forwardName);
    }
    
    @Override
    public String getModuleCode() {
        return CoeusModule.IRB_MODULE_CODE;
    }    
}
