/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
