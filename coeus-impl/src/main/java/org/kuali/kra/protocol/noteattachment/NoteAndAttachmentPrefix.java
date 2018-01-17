/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

/**
 * Contains all the property prefixes used in this package.
 */
public enum NoteAndAttachmentPrefix {
    NEW_ATTACHMENT_PROTOCOL("notesAttachmentsHelper.newAttachmentProtocol", false),
    NEW_ATTACHMENT_PERSONNEL("notesAttachmentsHelper.newAttachmentPersonnel", false),
    ATTACHMENT_PROTOCOL("document.protocolList[0].attachmentProtocols", true),
    ATTACHMENT_PERSONNEL("document.protocolList[0].attachmentPersonnels", true),
    NEW_NOTEPAD("notesAttachmentsHelper.newProtocolNotepad", false);
    
    private final String name;
    private final boolean indexed;
    
    /**
     * Sets the enum properties.
     * @param name the name.
     * @param indexed whether it is an index type.
     */
    NoteAndAttachmentPrefix(final String name, boolean indexed) {
        this.name = name;
        this.indexed = indexed;
    }
    
    /**
     * Gets the prefix name.
     * @return the prefix name.
     */
    public String getPrefixName() {
        return this.name;
    }
    
    /**
     * Gets the prefix name with an index value.
     * @param index the index
     * @return the prefix name with an index value.
     * @throws UnsupportedOperationException if not an indexed type
     */
    public String getIndexedPrefix(int index) {
        if (!this.indexed) {
            throw new UnsupportedOperationException(this.name() + " is not an indexed type.");
        }
        
        return this.name + "[" + index + "]";
    }
    
    @Override
    public String toString() {
        return "name: " + this.name + " indexed: " + this.indexed;
    }
}
