/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

/**
 * Implementation of {@link AddProtocolAttachmentProtocolRule AddProtocolAttachmentProtocolRule}.
 * @see AddProtocolAttachmentProtocolRule for details
 */
public abstract class AddProtocolAttachmentProtocolRuleImplBase implements AddProtocolAttachmentProtocolRule {

    protected ProtocolAttachmentBaseRuleHelper baseHelper;
    protected ProtocolAttachmentProtocolRuleHelperBase protocolHelper;

    @Override
    public boolean processAddProtocolAttachmentProtocolRules(AddProtocolAttachmentProtocolEvent event) {      
        
        final ProtocolAttachmentProtocolBase newAttachmentProtocol = event.getNewAttachmentProtocol();
        
        boolean valid = this.baseHelper.validPrimitiveFields(newAttachmentProtocol);
        valid &= this.baseHelper.validTypeForGroup(newAttachmentProtocol);
        valid &= this.baseHelper.validDescriptionWhenRequired(newAttachmentProtocol);
        valid &= this.protocolHelper.validStatus(newAttachmentProtocol);
        valid &= this.baseHelper.validFile(newAttachmentProtocol);
        
        return valid;
    }
}
