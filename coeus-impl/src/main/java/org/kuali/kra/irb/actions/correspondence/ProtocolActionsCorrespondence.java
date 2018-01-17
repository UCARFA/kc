/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.correspondence;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.RoleConstants;
import org.kuali.kra.irb.actions.print.CorrespondenceXmlStream;
import org.kuali.kra.irb.actions.print.ProtocolPrintWatermark;
import org.kuali.kra.protocol.actions.correspondence.ProtocolActionsCorrespondenceBase;
import org.kuali.kra.protocol.actions.print.CorrespondenceXmlStreamBase;
import org.kuali.kra.protocol.actions.print.ProtocolPrintWatermarkBase;

public class ProtocolActionsCorrespondence extends ProtocolActionsCorrespondenceBase {

    private static final long serialVersionUID = 241798237383300450L;
    private String protocolActionType;
    
    public ProtocolActionsCorrespondence(String protocolActionType) {
        this.protocolActionType = protocolActionType;
    }
    
    @Override
    public String getProtocolActionType() {
        return protocolActionType;
    }
    
    public void setProtocolActionType(String protocolActionType) {
        this.protocolActionType = protocolActionType;
    }

    @Override
    protected ProtocolActionTypeToCorrespondenceTemplateService getProtocolActionTypeToCorrespondenceTemplateService() {
        return KcServiceLocator.getService(ProtocolActionTypeToCorrespondenceTemplateService.class);
    }
    
    @Override
    protected ProtocolPrintWatermarkBase getNewProtocolPrintWatermarkInstanceHook() {
        return new ProtocolPrintWatermark();
    }

    @Override
    public CorrespondenceXmlStreamBase getCorrespondenceXmlStream() {
        return KcServiceLocator.getService(CorrespondenceXmlStream.class);
    }

    @Override
    protected String getAdministratorType() {
        return RoleConstants.IRB_ADMINISTRATOR;
    }

    @Override
    protected String getModuleNameSpace() {
        return Constants.MODULE_NAMESPACE_IRB;
    }    

}
