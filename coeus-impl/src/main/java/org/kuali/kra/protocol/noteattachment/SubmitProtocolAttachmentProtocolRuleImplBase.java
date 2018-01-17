/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

import org.kuali.kra.protocol.ProtocolDocumentBase;

import java.util.List;

/**
 * Class handles rules for submitting a {@link ProtocolAttachmentProtocolBase ProtocolAttachmentProtocolBase}.
 * This class does not have a corresponding event or Rule interface because it is just used-by the mega
 * {@link org.kuali.kra.protocol.ProtocolDocumentRuleBase ProtocolDocumentRuleBase} for submit events.
 */
public abstract class SubmitProtocolAttachmentProtocolRuleImplBase {

    protected ProtocolAttachmentProtocolRuleHelperBase protocolHelper;

    /**
     * Executes the rules related to {@link ProtocolAttachmentProtocolBase ProtocolAttachmentProtocolBase} when saving a ProtocolDocumentBase.
     * @param document the document
     * @return true if valid  
     */
    public boolean processSubmitProtocolAttachmentProtocolRules(final ProtocolDocumentBase document) {      
        
        if (document == null) {
            throw new IllegalArgumentException("the document was null");
        }
        boolean valid = true;
        
        final List<ProtocolAttachmentProtocolBase> attachments = document.getProtocol().getAttachmentProtocols();
        
        for (int i = 0; i < attachments.size(); i++) {
            final ProtocolAttachmentProtocolBase attachment = attachments.get(i);
            this.setPropertyPrefixes(NoteAndAttachmentPrefix.ATTACHMENT_PROTOCOL.getIndexedPrefix(i));

            valid &= this.protocolHelper.validStatusForSubmission(attachment);
        }
        return valid;
    }
    
    /**
     * Resets the PropertyPrefixes on the used helpers.
     * @param prefix the prefix.
     */
    private void setPropertyPrefixes(String prefix) {
        this.protocolHelper.resetPropertyPrefix(prefix);
    }
}
