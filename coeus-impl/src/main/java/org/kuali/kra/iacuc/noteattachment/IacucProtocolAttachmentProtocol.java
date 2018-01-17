/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentProtocolBase;

public class IacucProtocolAttachmentProtocol extends ProtocolAttachmentProtocolBase {

    private static final long serialVersionUID = 4879429021874546070L;
    private static final String GROUP_CODE = "1";
    
    public IacucProtocolAttachmentProtocol(ProtocolBase protocol) {
        super(protocol);
    }

    public IacucProtocolAttachmentProtocol() {
        super();
    }
    
    @Override
    public String getGroupCode() {
        return GROUP_CODE;
    }

    @Override
    public String getAttachmentDescription() {
        return "ProtocolBase Attachment";
    }

    @Override
    public boolean isDraft() {
        return IacucProtocolAttachmentStatus.DRAFT.equals(getDocumentStatusCode());
    }

    @Override
    public void setDraft() {
        setDocumentStatusCode(IacucProtocolAttachmentStatus.DRAFT);
    }

    @Override
    public boolean isFinal() {
        return IacucProtocolAttachmentStatus.FINALIZED.equals(getDocumentStatusCode());
    }

    @Override
    public void setFinal() {
        setDocumentStatusCode(IacucProtocolAttachmentStatus.FINALIZED);
    }

    @Override
    public boolean isDeleted() {
        return IacucProtocolAttachmentStatus.DELETED.equals(getDocumentStatusCode());
    }

    @Override
    public void setDeleted() {
        setDocumentStatusCode(IacucProtocolAttachmentStatus.DELETED);
    }

}
