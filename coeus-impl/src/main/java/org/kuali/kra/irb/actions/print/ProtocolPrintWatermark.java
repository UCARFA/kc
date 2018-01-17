/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.print;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.notification.IRBNotificationRenderer;
import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.actions.print.ProtocolPrintWatermarkBase;
import org.kuali.kra.protocol.notification.ProtocolNotificationRendererBase;

/**
 * 
 * This class for setting watermark to the protocol related reports.
 */
public class ProtocolPrintWatermark extends ProtocolPrintWatermarkBase {

    @Override
    protected ProtocolNotificationRendererBase getNewProtocolNotificationRendererInstanceHook(ProtocolBase protocol) {
        return new IRBNotificationRenderer((Protocol) protocol);
    }
}
