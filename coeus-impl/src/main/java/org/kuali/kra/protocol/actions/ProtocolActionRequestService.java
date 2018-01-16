/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.ProtocolFormBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondence;
import org.kuali.kra.protocol.notification.ProtocolNotificationRequestBeanBase;

public interface ProtocolActionRequestService {

    public void createProtocol(ProtocolFormBase protocolForm) throws Exception;
    
    public void rejectedInRouting(ProtocolBase protocol) throws Exception;

    public void recalledInRouting(ProtocolBase protocol) throws Exception;

    public boolean checkToSendNotification(ProtocolFormBase protocolForm, ProtocolNotificationRequestBeanBase notificationRequestBean, String promptAfterNotification);
    
    /**
     * This method checks the document state to see if something has changed between the time the user
     * loaded the document to when they clicked on an action.
     * @param protocolForm
     * @return
     */
    public boolean hasDocumentStateChanged(ProtocolFormBase protocolForm);
    
    public ProtocolCorrespondence getProtocolCorrespondence (ProtocolFormBase protocolForm, String forwardName, ProtocolNotificationRequestBeanBase notificationRequestBean, boolean holdingPage);
    
}
