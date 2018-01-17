/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.kra.protocol.noteattachment.AddProtocolAttachmentProtocolRuleImplBase;

/**
 * Implementation of {@link AddProtocolAttachmentProtocolRule AddProtocolAttachmentProtocolRule}.
 * @see AddProtocolAttachmentProtocolRule for details
 */
public class AddProtocolAttachmentProtocolRuleImpl extends AddProtocolAttachmentProtocolRuleImplBase {
    
    
    public AddProtocolAttachmentProtocolRuleImpl() {
        super();
        
        baseHelper = new ProtocolAttachmentBaseRuleHelper(NoteAndAttachmentPrefix.NEW_ATTACHMENT_PROTOCOL.getPrefixName());
        protocolHelper = new ProtocolAttachmentProtocolRuleHelper(NoteAndAttachmentPrefix.NEW_ATTACHMENT_PROTOCOL.getPrefixName());
    }
}
