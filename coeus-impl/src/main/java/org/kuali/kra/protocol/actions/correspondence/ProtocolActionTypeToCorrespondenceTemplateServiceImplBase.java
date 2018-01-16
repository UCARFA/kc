/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.correspondence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTypeBase;
import org.kuali.kra.protocol.correspondence.ValidProtoActionCoresp;
import org.kuali.rice.krad.service.BusinessObjectService;

public abstract class ProtocolActionTypeToCorrespondenceTemplateServiceImplBase implements ProtocolActionTypeToCorrespondenceTemplateService {
    
    protected abstract Class<? extends ProtocolCorrespondenceTypeBase> getProtocolCorrespondenceTypeClassHook();
    protected abstract Class<? extends ValidProtoActionCoresp> getProtocolActionCorrespondenceMappingClassHook();
    
    private BusinessObjectService businessObjectService;

    @Override
    public List<ProtocolCorrespondenceTemplateBase> getTemplatesByProtocolAction(String protocolActionType, String committeeId) {
        List<ProtocolCorrespondenceTemplateBase> templates = new ArrayList<ProtocolCorrespondenceTemplateBase>();
        Map<String, List<String>> actionTypesToCorrespondenceTypeMap = getActionTypesToCorrespondenceTypeMap();
        if (actionTypesToCorrespondenceTypeMap.containsKey(protocolActionType)) {
            for (String correspondenceTypeId : actionTypesToCorrespondenceTypeMap.get(protocolActionType)) {
                templates.addAll(getCorrespondenceTemplatesForTypeId(correspondenceTypeId, committeeId ));
            }
        }
        return templates;
    }
    
    @Override
    public List<ProtocolCorrespondenceTemplateBase> getTemplatesByProtocolAction(String protocolActionType) {
        return getTemplatesByProtocolAction(protocolActionType, Constants.DEFAULT_CORRESPONDENCE_TEMPLATE);   
    }
    
    
    public void setBusinessObjectService(BusinessObjectService businessObjectService){
        this.businessObjectService = businessObjectService;
    }
    
    protected BusinessObjectService getBusinessObjectService(){
        return this.businessObjectService;
    }
    
    /**
     * This method is to get protocol action and correspondence mapping
     * @return
     */
    protected Map<String, List<String>> getActionTypesToCorrespondenceTypeMap() {
        Map<String, List<String>> actionTypesToCorrespondenceType = new HashMap<String, List<String>>();
        List<ValidProtoActionCoresp>  validCorrespTypes =  getValidProtocolActionCorrespondence();
        for(ValidProtoActionCoresp validProtoActionCorresp : validCorrespTypes) {
            String protocolActionTypeCode = validProtoActionCorresp.getProtocolActionTypeCode();
            List<String> actionCorresps = (List<String>) actionTypesToCorrespondenceType.get(protocolActionTypeCode);
            if(actionCorresps == null) {
                actionCorresps = new ArrayList<String>();
            }
            actionCorresps.add(validProtoActionCorresp.getProtoCorrespTypeCode());
            actionTypesToCorrespondenceType.put(protocolActionTypeCode, actionCorresps);
        }
        return actionTypesToCorrespondenceType;
    }
    
    @SuppressWarnings("unchecked")
    protected List<ValidProtoActionCoresp> getValidProtocolActionCorrespondence() {
        return (List<ValidProtoActionCoresp>)getBusinessObjectService().findAll(getProtocolActionCorrespondenceMappingClassHook());
    }
    
    protected List<ProtocolCorrespondenceTemplateBase> getCorrespondenceTemplatesForTypeId(String correspondenceTypeId, String committeeId) {
        ProtocolCorrespondenceTypeBase type = getBusinessObjectService().findBySinglePrimaryKey(getProtocolCorrespondenceTypeClassHook(), correspondenceTypeId);
        if (type != null) {
            List<ProtocolCorrespondenceTemplateBase> committeeTemplates = type.getCommitteeProtocolCorrespondenceTemplates(committeeId);
            return committeeTemplates.isEmpty() ? type.getProtocolCorrespondenceTemplates() : committeeTemplates;
        } else {
            return new ArrayList<ProtocolCorrespondenceTemplateBase>();
        }
    }

}
