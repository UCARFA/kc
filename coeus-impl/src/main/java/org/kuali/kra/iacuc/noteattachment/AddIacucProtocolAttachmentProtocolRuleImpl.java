/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.noteattachment.AddProtocolAttachmentProtocolRuleImplBase;
import org.kuali.kra.protocol.noteattachment.NoteAndAttachmentPrefix;


public class AddIacucProtocolAttachmentProtocolRuleImpl extends AddProtocolAttachmentProtocolRuleImplBase {

    public AddIacucProtocolAttachmentProtocolRuleImpl() {
        super();
        
        baseHelper = new IacucProtocolAttachmentBaseRuleHelper(NoteAndAttachmentPrefix.NEW_ATTACHMENT_PROTOCOL.getPrefixName());
        protocolHelper = new IacucProtocolAttachmentProtocolRuleHelper(NoteAndAttachmentPrefix.NEW_ATTACHMENT_PROTOCOL.getPrefixName());
    }
}
