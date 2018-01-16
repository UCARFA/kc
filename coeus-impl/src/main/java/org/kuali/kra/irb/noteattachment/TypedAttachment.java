/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.noteattachment;

/**
 * Defines a Attachment that has a {@link ProtocolAttachmentType type} with a description.
 */
public interface TypedAttachment {

    /**
     * Gets the Protocol Attachment Base Type.
     * @return the Protocol Attachment Base Type
     */
    ProtocolAttachmentType getType();
    
    /**
     * Sets the Protocol Attachment Base Type.
     * @param type the Protocol Attachment Base Type
     */
    void setType(ProtocolAttachmentType type);
    
    /**
     * Gets the type Code . 
     * @return the type Code.
     */
    String getTypeCode();

    /**
     * Sets the type Code.
     * @param typeCode the type Code.
     */
    void setTypeCode(String typeCode);
    
    /**
     * Gets the Document Id.  The document id is used to allow multiple typed attachments to exist.
     * So two attachments of the same type will have different document numbers.
     * @return the  Document Id
     */
    Integer getDocumentId();
    
    /**
     * Sets the Document Id.
     * @param documentId the  Document Id
     * @see #getDocumentId()
     */
    void setDocumentId(Integer documentId);
    
    /**
     * Gets the  Description.
     * @return the  Description
     */
    String getDescription();
    
    /**
     * Sets the  Description.
     * @param description the  Description
     */
    void setDescription(String description);
    
    /**
     * The group code that the Protocol Attachment belongs to.
     * The group code relates to {@link ProtocolAttachmentGroup ProtocolAttachmentGroup}.
     * 
     * @return the group code.
     */
    String getGroupCode();
    
    /**
     * Contains all the property names that will be used by implementations.
     * This is required in order to meet the JavaBeans spec.
     */
    public static enum PropertyName {
        TYPE_CODE("typeCode"), GROUP_CODE("groupCode"), DESCRIPTION("description"), DOCUMENT_ID("documentId");
        
        private final String name;
        
        /**
         * Sets the enum properties.
         * @param name the name.
         */
        PropertyName(final String name) {
            this.name = name;
        }
        
        /**
         * Gets the property name.
         * @return the the property name.
         */
        public String getPropertyName() {
            return this.name;
        }
        
        /**
         * Gets the {@link #getPropertyName() propertyName()}.
         * @return {@link #getPropertyName() propertyName()}
         */
        @Override
        public String toString() {
            return this.name;
        }
    }
}
