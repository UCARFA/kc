/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentPersonnelBase;

public class IacucProtocolAttachmentPersonnel extends ProtocolAttachmentPersonnelBase {

    private static final long serialVersionUID = 5529222336473432436L;
    
    private static final String GROUP_CODE = "2";

    public IacucProtocolAttachmentPersonnel(ProtocolBase protocol) {
        super(protocol);
    }
    
    public IacucProtocolAttachmentPersonnel() {
        super();
    }
    
    @Override
    public String getGroupCode() {
        return GROUP_CODE;
    }

    @Override
    public String getAttachmentDescription() {
        return "Personnel Attachment";
    }

}
