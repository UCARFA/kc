/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;


/**
 * Implementation of {@link AddProtocolNotepadRule AddProtocolNotepadRule}.
 * @see AddProtocolNotepadRule for details
 */
public class AddProtocolNotepadRuleImpl implements AddProtocolNotepadRule {
    
    private final ProtocolNotepadRuleHelper notesHelper
        = new ProtocolNotepadRuleHelper(NoteAndAttachmentPrefix.NEW_NOTEPAD.getPrefixName());
    
    @Override
    public boolean processAddProtocolNotepadRules(AddProtocolNotepadEvent event) {
        final ProtocolNotepadBase newProtocolNotepad = event.getNewProtocolNotepad();
        
        boolean valid = this.notesHelper.validPrimitiveFields(newProtocolNotepad);
               
        return valid;
    }
}
