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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Renders additional fields for the Protocol Expired notification.
 */
public class ProtocolExpiredNotificationRenderer extends IRBNotificationRenderer {

    private static final long serialVersionUID = 8919323461538670065L;

    /**
     * Constructs a Protocol Expired notification renderer.
     * @param protocol
     * @param expirationDate
     */
    public ProtocolExpiredNotificationRenderer(Protocol protocol) {
        super(protocol);
    }

    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put("{EXPIRED_DATE}", (new SimpleDateFormat("d'-'MMM'-'yyyy")).format(new Date()));
        return params;
    }
}
