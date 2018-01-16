/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentService;
import org.kuali.rice.kns.service.DictionaryValidationService;
import org.kuali.rice.kns.service.KNSServiceLocator;

/**
 * This class contains methods to "help" in validating ProtocolAttachmentBase.
 */
@SuppressWarnings("deprecation")
class ProtocolAttachmentBaseRuleHelper extends org.kuali.kra.protocol.noteattachment.ProtocolAttachmentBaseRuleHelper {

    protected ProtocolAttachmentBaseRuleHelper(String aPropertyPrefix) {
        super(aPropertyPrefix, KcServiceLocator.getService(ProtocolAttachmentService.class), KNSServiceLocator.getKNSDictionaryValidationService());
    }

    protected ProtocolAttachmentBaseRuleHelper(final ProtocolAttachmentService attachmentService,
            final DictionaryValidationService validationService) {
                super(attachmentService, validationService);
    }
    
}
