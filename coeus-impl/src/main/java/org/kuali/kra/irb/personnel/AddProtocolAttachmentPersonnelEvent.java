/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.personnel;

import org.kuali.kra.irb.ProtocolDocument;
import org.kuali.kra.irb.noteattachment.ProtocolAttachmentPersonnel;

public class AddProtocolAttachmentPersonnelEvent extends org.kuali.kra.protocol.personnel.AddProtocolAttachmentPersonnelEvent {
    
    protected AddProtocolAttachmentPersonnelEvent(String errorPathPrefix, ProtocolDocument document, ProtocolAttachmentPersonnel protocolAttachmentPersonnel, int personIndex) {
        super(errorPathPrefix, document, protocolAttachmentPersonnel, personIndex);
    }

}
