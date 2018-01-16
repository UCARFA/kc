/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.auth;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.irb.actions.amendrenew.ProtocolAmendRenewService;
import org.kuali.kra.irb.actions.amendrenew.ProtocolModule;

import java.util.ArrayList;
import java.util.List;

/**
 * The Modify Amendment Authorizer determines if the user can modify a particular module within the amendment.
 */
public abstract class ModifyAmendmentAuthorizer extends ModifyProtocolAuthorizer {

    private String moduleTypeCode;
    private ProtocolAmendRenewService protocolAmendRenewService;
    
    protected ModifyAmendmentAuthorizer(String moduleTypeCode) {
        this.moduleTypeCode = moduleTypeCode;
    }

    @Override
    public boolean isAuthorized(String userId, ProtocolTask task) {
        Protocol protocol = task.getProtocol();
        boolean hasPermission = super.isAuthorized(userId, task);

        if (hasPermission && protocol.isRenewalWithoutAmendment()) {
            hasPermission = ProtocolModule.ADD_MODIFY_ATTACHMENTS.equals(moduleTypeCode) || canModifyModule(protocol, moduleTypeCode);
        } else if (hasPermission && isAmendmentOrRenewal(protocol)) {
            hasPermission = canModifyModule(protocol, moduleTypeCode);
        }

        if (hasPermission && protocol.isCorrectionMode()) {
            hasPermission = canCorrectModule(protocol, moduleTypeCode);
        }
        
        return hasPermission;
    }
    
    private boolean canCorrectModule(Protocol protocol, String moduleTypeCode) {
        List<String> availableModules = new ArrayList<String>();
        
        try {
            availableModules = protocolAmendRenewService.getAvailableModules(protocol.getProtocolNumber());
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        
        return availableModules.contains(moduleTypeCode);
    }
    
    /**
     * For amendment (or a renewal with an amendment), the user can only modify certain modules (parts) of the protocol. Determine
     * if a certain module can be modified or not.
     * 
     * @param protocol the amendment protocol
     * @param moduleTypeCode the module type code
     * @return true if the module can be modified; otherwise false
     */
    private boolean canModifyModule(Protocol protocol, String moduleTypeCode) {
        return protocol.getProtocolAmendRenewal().hasModule(moduleTypeCode);
    }

    public void setProtocolAmendRenewService(ProtocolAmendRenewService protocolAmendRenewService) {
        this.protocolAmendRenewService = protocolAmendRenewService;
    }
}
