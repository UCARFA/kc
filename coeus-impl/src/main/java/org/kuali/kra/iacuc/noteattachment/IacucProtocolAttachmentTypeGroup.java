/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentGroupBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentTypeBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentTypeGroupBase;

public class IacucProtocolAttachmentTypeGroup extends ProtocolAttachmentTypeGroupBase {

    private static final long serialVersionUID = 3812011266823556737L;

    public IacucProtocolAttachmentTypeGroup() {
        super();
    }
    
    public IacucProtocolAttachmentTypeGroup(ProtocolAttachmentTypeBase type, ProtocolAttachmentGroupBase group) {
        super(type, group);
    }
}
