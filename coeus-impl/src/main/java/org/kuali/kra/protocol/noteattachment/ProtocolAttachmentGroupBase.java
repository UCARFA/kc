/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.noteattachment;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * This class represents the ProtocolBase Attachment Group.
 */
public abstract class ProtocolAttachmentGroupBase extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 2053606476193782286L;

    private String code;

    private String description;

    /**
     * empty ctor to satisfy JavaBean convention.
     */
    protected ProtocolAttachmentGroupBase() {
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
    public ProtocolAttachmentGroupBase(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Gets the protocol attachment group code.
     * @return the protocol attachment group code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets the protocol attachment group code.
     * @param code the protocol attachment group code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the protocol attachment group description.
     * @return the protocol attachment group description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the protocol attachment group description.
     * @param description the protocol attachment group description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
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
        if (!(obj instanceof ProtocolAttachmentGroupBase)) {
            return false;
        }
        ProtocolAttachmentGroupBase other = (ProtocolAttachmentGroupBase) obj;
        if (this.code == null) {
            if (other.code != null) {
                return false;
            }
        } else if (!this.code.equals(other.code)) {
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
