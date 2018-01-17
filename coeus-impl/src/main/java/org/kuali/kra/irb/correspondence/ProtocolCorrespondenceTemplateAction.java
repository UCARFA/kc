/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.correspondence;

import org.kuali.kra.infrastructure.PermissionConstants;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateActionBase;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateAuthorizationService;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondenceTemplateFormBase;

/**
 * 
 * Action class for ProtocolCorrespondenceTemplate.
 */
public class ProtocolCorrespondenceTemplateAction extends ProtocolCorrespondenceTemplateActionBase {
    
    
    @Override
    protected String getModifyCorrespondenceTemplatePermissionNameHook() {
        return PermissionConstants.MODIFY_CORRESPONDENCE_TEMPLATE;
    }
    
    @Override
    protected String getViewCorrespondenceTemplatePermissionNameHook() {
        return PermissionConstants.VIEW_IACUC_CORRESPONDENCE_TEMPLATE;
    }

    @Override
    protected ProtocolCorrespondenceTemplateFormBase getNewProtocolCorrespondenceTemplateFormInstanceHook() {
        return new ProtocolCorrespondenceTemplateForm();        
    }
    
    @Override
    protected Class<ProtocolCorrespondenceTemplateService> getProtocolCorrespondenceTemplateServiceClassHook() {
        return ProtocolCorrespondenceTemplateService.class;
    }
    
    @Override
    protected Class<? extends ProtocolCorrespondenceTemplateAuthorizationService> getProtocolCorrespondenceTemplateAuthorizationServiceClassHook() {
        return ProtocolCorrespondenceTemplateAuthorizationService.class;
    }
}
