/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.coeus.common.framework.version.VersioningService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.ProtocolFormBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentProtocolBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentService;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentVersioningUtilityBase;

public class IacucProtocolAttachmentVersioningUtility extends ProtocolAttachmentVersioningUtilityBase {

    public IacucProtocolAttachmentVersioningUtility(ProtocolFormBase form) {
        super(form, getProtocolAttachmentService(), KcServiceLocator.getService(VersioningService.class));
    }
    
    private static ProtocolAttachmentService getProtocolAttachmentService() {
        return KcServiceLocator.getService("iacucProtocolAttachmentService");
    }

    @Override
    protected Class<? extends ProtocolAttachmentProtocolBase> getProtocolAttachmentProtocolClassHook() {
        return IacucProtocolAttachmentProtocol.class;
    }


}
