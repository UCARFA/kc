/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.protocol.notification.ProtocolReplacementParameters;
import org.kuali.rice.core.api.CoreApiServiceLocator;

import java.util.Map;

/**
 * Renders fields for the IRB and IACUC notifications.
 */
public class IacucProtocolRequestActionNotificationRenderer extends IacucProtocolNotificationRenderer {

    private static final long serialVersionUID = 1058103556564286014L;

    private String reason;

    private static final String NO_REASON_GIVEN="message.none.given";
    
    public IacucProtocolRequestActionNotificationRenderer(IacucProtocol protocol, String reason) {
        super(protocol);
        this.reason = reason;
    }

    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put(ProtocolReplacementParameters.REASON, StringUtils.isNotBlank(reason) ? reason : CoreApiServiceLocator.getKualiConfigurationService().getPropertyValueAsString(NO_REASON_GIVEN));
        return params;
    }
}
