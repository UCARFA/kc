/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

import org.kuali.kra.irb.Protocol;
import org.kuali.kra.protocol.noteattachment.ProtocolNotepadBase;

/**
 * The Protocol Notepad class.
 */
public class ProtocolNotepad extends ProtocolNotepadBase {

    private static final long serialVersionUID = -294125058992878907L;
    
     /**
      * empty ctor to satisfy JavaBean convention.
      */
     public ProtocolNotepad() {
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
     public ProtocolNotepad(final Protocol protocol) {
         super(protocol);
     }
}
