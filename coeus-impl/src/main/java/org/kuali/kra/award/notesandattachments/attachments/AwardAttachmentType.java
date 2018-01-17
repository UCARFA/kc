/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.notesandattachments.attachments;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;
import org.kuali.kra.irb.noteattachment.ProtocolAttachmentType;


public class AwardAttachmentType extends KcPersistableBusinessObjectBase {


    private static final long serialVersionUID = 3918563746120540897L;

    private String typeCode;

    private String description;

    /**
     * empty ctor to satisfy JavaBean convention.
     */
    public AwardAttachmentType() {
        super();
    }

    /**
     * Convenience ctor to set the relevant properties of this class.
     * 
     * <p>
     * This ctor does not validate any of the properties.
     * </p>
     * 
     * @param code the code.
     * @param description the description.
     */
    public AwardAttachmentType(String typeCode, String description) {
        this.typeCode = typeCode;
        this.description = description;
    }

    /**
     * Gets the protocol attachment type code.
     * @return the protocol attachment type code
     */
    public String getTypeCode() {
        return this.typeCode;
    }

    /**
     * Sets the protocol attachment type code.
     * @param code the protocol attachment type code
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * Gets the protocol attachment type description.
     * @return the protocol attachment type description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the protocol attachment type description.
     * @param description the protocol attachment type description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.typeCode == null) ? 0 : this.typeCode.hashCode());
        result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProtocolAttachmentType)) {
            return false;
        }
        AwardAttachmentType other = (AwardAttachmentType) obj;
        if (this.typeCode == null) {
            if (other.typeCode != null) {
                return false;
            }
        } else if (!this.typeCode.equals(other.typeCode)) {
            return false;
        }
        if (this.description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
}
