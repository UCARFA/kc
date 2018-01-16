/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.personnel.ProtocolPersonRoleMappingBase;
import org.kuali.kra.protocol.personnel.ProtocolPersonnelService;
import org.kuali.rice.core.api.util.ConcreteKeyValue;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.uif.control.UifKeyValuesFinderBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is to get valid values for protocol person role
 * based on an assigned role. A source role can be change only to 
 * specific target roles in the list. This list is obtained from 
 * person role mapping. Include source role first and then start adding
 * target roles to the list.
 */
public class ProtocolPersonRoleValuesFinder extends UifKeyValuesFinderBase {
    private String sourceRoleId;
    private String sourceRoleReferenceObject = "sourceRole";
    private String targetRoleReferenceObject = "targetRole";

    @Override
    public List<KeyValue> getKeyValues() {
        final List<ProtocolPersonRoleMappingBase> validPersonRoles = getProtocolPersonnelService().getPersonRoleMapping(getSourceRoleId());
        
        List<ConcreteKeyValue> keyValues = new ArrayList<ConcreteKeyValue>();
        keyValues.add(new ConcreteKeyValue(getSourceRoleId(), getSourceRoleDescription()));
        for(ProtocolPersonRoleMappingBase protocolPersonRole : validPersonRoles) {
            keyValues.add(new ConcreteKeyValue(protocolPersonRole.getTargetRoleId(), getTargetRoleDescription(protocolPersonRole)));
        }
        Collections.sort(keyValues);
        
        List<KeyValue> returnKeyValues = new ArrayList<KeyValue>();
        returnKeyValues.addAll(keyValues);
        return returnKeyValues;
    }

    /**
     * This method is used to lookup the source role object and return description
     * @return String - source role name
     */
    private String getSourceRoleDescription() {
        return getProtocolPersonnelService().getProtocolPersonRole(getSourceRoleId()).getDescription();
    }
    
    /**
     * This method is used to refresh target role object and return description
     * @param protocolPersonRole
     * @return String - target role name
     */
    private String getTargetRoleDescription(ProtocolPersonRoleMappingBase protocolPersonRole) {
        protocolPersonRole.refreshReferenceObject(targetRoleReferenceObject);
        return protocolPersonRole.getTargetRole().getDescription(); 
    }

    /**
     * Locate from Spring a singleton instance of the <code>{@link ProtocolPersonnelService}</code>.
     * 
     * @return ProtocolPersonnelService
     */
    private ProtocolPersonnelService getProtocolPersonnelService() {
        return (ProtocolPersonnelService) KcServiceLocator.getService("iacucProtocolPersonnelService");
    }

    public String getSourceRoleId() {
        return sourceRoleId;
    }

    public void setSourceRoleId(String sourceRoleId) {
        this.sourceRoleId = sourceRoleId;
    }

}
