/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.personnel;

import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.noteattachment.ProtocolAttachmentPersonnelBase;
import org.kuali.kra.protocol.personnel.AddProtocolAttachmentPersonnelEvent;


public class AddIacucProtocolAttachmentPersonnelEvent extends AddProtocolAttachmentPersonnelEvent {

    public AddIacucProtocolAttachmentPersonnelEvent(String errorPathPrefix, ProtocolDocumentBase document,
            ProtocolAttachmentPersonnelBase protocolAttachmentPersonnel, int personIndex) {
        super(errorPathPrefix, document, protocolAttachmentPersonnel, personIndex);
    }

}
