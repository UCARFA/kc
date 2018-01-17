/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.onlinereview.IacucProtocolOnlineReview;
import org.kuali.kra.protocol.notification.ProtocolNotificationContextBase;
import org.kuali.kra.protocol.notification.ProtocolNotificationRoleQualifierService;


/**
 * This class extends the notification context base and provides some helpful functions for
 * any Protocol- specific events.
 */
public class IacucProtocolNotificationContext extends ProtocolNotificationContextBase {

    private static final long serialVersionUID = 7517888688386565168L;

    public IacucProtocolNotificationContext(IacucProtocol protocol, IacucProtocolOnlineReview protocolOnlineReview, String actionTypeCode, String contextName, IacucProtocolNotificationRenderer renderer) {
        this(protocol, actionTypeCode, contextName, renderer);
        ((ProtocolNotificationRoleQualifierService) getNotificationRoleQualifierService()).setProtocolOnlineReview(protocolOnlineReview);
    }
    
    public IacucProtocolNotificationContext(IacucProtocol protocol, String actionTypeCode, String contextName, IacucProtocolNotificationRenderer renderer, String forwardName) {
        this(protocol, actionTypeCode, contextName, renderer);
        setForwardName(forwardName);
    }
    
    public IacucProtocolNotificationContext(IacucProtocol protocol, String actionTypeCode, String contextName, IacucProtocolNotificationRenderer renderer) {
        super(protocol, actionTypeCode, contextName, renderer);
        setNotificationRoleQualifierService(KcServiceLocator.getService(IacucProtocolNotificationRoleQualifierService.class));
        ((IacucProtocolNotificationRoleQualifierService) getNotificationRoleQualifierService()).setProtocol(protocol);
    }

    @Override
    public String getModuleCode() {
        return CoeusModule.IACUC_PROTOCOL_MODULE_CODE;
    }

    
}
