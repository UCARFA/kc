/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.actions.delete.ProtocolDeleteBean;

import java.util.Map;

/**
 * Renders additional fields for the Protocol Disapproved notification.
 */
public class IacucProtocolWithReasonNotificationRenderer extends IacucProtocolNotificationRenderer {

    private static final long serialVersionUID = 1859318194507340344L;
    private String reason;
    
    /**
     * Constructs a Protocol Disapproved notification renderer.
     * @param protocol
     * @param actionComments
     */
    public IacucProtocolWithReasonNotificationRenderer(IacucProtocol protocol, ProtocolDeleteBean protocolDeleteBean) {
        super(protocol);
        reason = protocolDeleteBean.getReason();
    }
    
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{REASON}", reason == null ? "N/A" : reason);
        return params;
    }

}
