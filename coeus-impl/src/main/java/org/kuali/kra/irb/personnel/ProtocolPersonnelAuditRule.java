/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.personnel;

import org.kuali.kra.protocol.personnel.ProtocolPersonnelAuditRuleBase;

import static org.kuali.coeus.sys.framework.service.KcServiceLocator.getService;


/**
 * Rules that invoke audit mode for KeyPersonnel
 */
public class ProtocolPersonnelAuditRule extends ProtocolPersonnelAuditRuleBase {
    
    /**
     * This method is to get personnel sevice
     * @return ProtocolPersonnelService
     */
    @Override
    protected ProtocolPersonnelService getProtocolPersonnelService() {
        return getService(ProtocolPersonnelService.class);
    }
}
