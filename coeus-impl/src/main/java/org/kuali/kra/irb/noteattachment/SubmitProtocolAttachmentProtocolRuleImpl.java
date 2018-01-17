/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.kra.protocol.noteattachment.SubmitProtocolAttachmentProtocolRuleImplBase;

/**
 * Class handles rules for submitting a {@link ProtocolAttachmentProtocol ProtocolAttachmentProtocol}.
 * This class does not have a corresponding event or Rule interface because it is just used-by the mega
 * {@link org.kuali.kra.irb.ProtocolDocumentRule ProtocolDocumentRule} for submit events.
 */
public class SubmitProtocolAttachmentProtocolRuleImpl extends SubmitProtocolAttachmentProtocolRuleImplBase {
    
    
    public SubmitProtocolAttachmentProtocolRuleImpl() {
        super();
        
        // TODO : temporarily plugin this propertyprefix.  need to rework to have correct prefix
        protocolHelper = new ProtocolAttachmentProtocolRuleHelper("notesAttachmentsHelper.newAttachmentProtocol");
    }
}
