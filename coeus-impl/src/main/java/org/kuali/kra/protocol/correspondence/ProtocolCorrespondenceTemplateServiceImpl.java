/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.correspondence;

import org.apache.struts.upload.FormFile;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.krad.service.BusinessObjectService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * This class implements the ProtocolCorrespondenceTemplateService.
 */
public abstract class ProtocolCorrespondenceTemplateServiceImpl implements ProtocolCorrespondenceTemplateService {

    BusinessObjectService businessObjectService;

    @Override
    public void addDefaultProtocolCorrespondenceTemplate(ProtocolCorrespondenceTypeBase correspondenceType,
                                                         ProtocolCorrespondenceTemplateBase correspondenceTemplate) throws Exception {
        correspondenceTemplate.setCommitteeId(Constants.DEFAULT_CORRESPONDENCE_TEMPLATE);
        addProtocolCorrespondenceTemplate(correspondenceType, correspondenceTemplate);
    }
    
    @Override
    public void addCommitteeProtocolCorrespondenceTemplate(ProtocolCorrespondenceTypeBase correspondenceType,
                                                           ProtocolCorrespondenceTemplateBase correspondenceTemplate) throws Exception {
        addProtocolCorrespondenceTemplate(correspondenceType, correspondenceTemplate);
    }

    protected void addProtocolCorrespondenceTemplate(ProtocolCorrespondenceTypeBase correspondenceType, 
            ProtocolCorrespondenceTemplateBase correspondenceTemplate) throws Exception {
        correspondenceTemplate.setProtoCorrespTypeCode(correspondenceType.getProtoCorrespTypeCode());

        FormFile templateFile = correspondenceTemplate.getTemplateFile();
        correspondenceTemplate.setFileName(templateFile.getFileName());
        correspondenceTemplate.setCorrespondenceTemplate(templateFile.getFileData());
        
        correspondenceType.getProtocolCorrespondenceTemplates().add(correspondenceTemplate);
    }
    
    @Override
    public void saveProtocolCorrespondenceTemplates(List<ProtocolCorrespondenceTypeBase> protocolCorrespondenceTypes,
                                                    List<ProtocolCorrespondenceTemplateBase> deletedBos) {
        if (!deletedBos.isEmpty()) {
            businessObjectService.delete(deletedBos);
        }

        for (ProtocolCorrespondenceTypeBase protocolCorrespondenceType : protocolCorrespondenceTypes) {
            businessObjectService.save(protocolCorrespondenceType);
        }
    }

    public void setBusinessObjectService(BusinessObjectService businessObjectService) {
        this.businessObjectService = businessObjectService;
    }
    
    @Override
    public ProtocolCorrespondenceTemplateBase getProtocolCorrespondenceTemplate (String committeeId, String protoCorrespTypeCode) {
        Map fieldValues = new HashMap();
        fieldValues.put("committeeId", committeeId);
        fieldValues.put("protoCorrespTypeCode", protoCorrespTypeCode);
        ProtocolCorrespondenceTemplateBase protocolCorrespondenceTemplate = null;        
        List<ProtocolCorrespondenceTemplateBase> templates = (List<ProtocolCorrespondenceTemplateBase>)businessObjectService.findMatching(getProtocolCorrespondenceTemplateBOClassHook(), fieldValues);
        if (templates.isEmpty()) {
            fieldValues.put("committeeId", "DEFAULT");
            templates = (List<ProtocolCorrespondenceTemplateBase>)businessObjectService.findMatching(getProtocolCorrespondenceTemplateBOClassHook(), fieldValues);
            if (!templates.isEmpty()) {
                protocolCorrespondenceTemplate = templates.get(0);
            }
        } else {
            protocolCorrespondenceTemplate = templates.get(0);            
        }
        return protocolCorrespondenceTemplate;
    }

    
    protected abstract Class<? extends ProtocolCorrespondenceTemplateBase> getProtocolCorrespondenceTemplateBOClassHook();

}
