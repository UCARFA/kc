/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.noteattachment;

import org.kuali.kra.protocol.ProtocolBase;
import org.kuali.kra.protocol.noteattachment.ProtocolNotepadBase;

public class IacucProtocolNotepad extends ProtocolNotepadBase {

    private static final long serialVersionUID = 305642175397072637L;

    public IacucProtocolNotepad(ProtocolBase protocol) {
        super(protocol);
    }
    
    public IacucProtocolNotepad() {
        super();
    }
}
