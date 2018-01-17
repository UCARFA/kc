/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.noteattachment.SubmitProtocolAttachmentProtocolRuleImplBase;

public class SubmitIacucProtocolAttachmentProtocolRuleImpl extends SubmitProtocolAttachmentProtocolRuleImplBase {

    public SubmitIacucProtocolAttachmentProtocolRuleImpl() {
        super();
        
        // TODO : temporarily plugin this propertyprefix to fix runtime exception.  need to rework to have correct prefix
        protocolHelper = new IacucProtocolAttachmentProtocolRuleHelper("notesAttachmentsHelper.newAttachmentProtocol");
    }
}
