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

/**
 * 
 * This class needs to be extended by specific action correspondence objects.
 */
public abstract class AbstractProtocolActionsCorrespondence extends ProtocolActionsCorrespondenceBase {


    private static final long serialVersionUID = 4993731064232051911L;

    @Override
    protected org.kuali.kra.protocol.actions.correspondence.ProtocolActionTypeToCorrespondenceTemplateService getProtocolActionTypeToCorrespondenceTemplateService() {
        return KcServiceLocator.getService(ProtocolActionTypeToCorrespondenceTemplateService.class);
    }


    @Override
    public CorrespondenceXmlStreamBase getCorrespondenceXmlStream() {
        return KcServiceLocator.getService(CorrespondenceXmlStream.class);
    }

    @Override
    protected ProtocolPrintWatermarkBase getNewProtocolPrintWatermarkInstanceHook() {
        return new ProtocolPrintWatermark();
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
