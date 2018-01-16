/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentProtocolBase;

/**
 * This class represents the Protocol Attachment Protocol.
 */
public class ProtocolAttachmentProtocol extends ProtocolAttachmentProtocolBase {

    private static final long serialVersionUID = -7115904344245464654L;

    private static final String GROUP_CODE = "1";

    public static final String INCOMPLETE_STATUS_CODE = "1";
    public static final String COMPLETE_STATUS_CODE = "2";    
    
    /**
     * empty ctor to satisfy JavaBean convention.
     */
    public ProtocolAttachmentProtocol() {
        super();
    }

    /**
     * Convenience ctor to add the protocol as an owner.
     * 
     * <p>
     * This ctor does not validate any of the properties.
     * </p>
     * 
     * @param protocol the protocol.
     */
    public ProtocolAttachmentProtocol(final Protocol protocol) {
        super(protocol);
    }

    @Override
    public String getGroupCode() {
        return GROUP_CODE;
    }

    @Override
    public String getAttachmentDescription() {
        return "Protocol Attachment";
    }

    @Override
    public boolean isDraft() {
        return ProtocolAttachmentStatus.DRAFT.equals(documentStatusCode);
    }
    
    @Override
    public void setDraft() {
        documentStatusCode = ProtocolAttachmentStatus.DRAFT;
    }
    
    @Override
    public boolean isFinal() {
        return ProtocolAttachmentStatus.FINALIZED.equals(documentStatusCode);
    }
    
    @Override
    public void setFinal() {
        documentStatusCode = ProtocolAttachmentStatus.FINALIZED;
    }
    
    @Override
    public boolean isDeleted() {
        return ProtocolAttachmentStatus.DELETED.equals(documentStatusCode);
    }
    
    @Override
    public void setDeleted() {
        documentStatusCode = ProtocolAttachmentStatus.DELETED;
    }
}
