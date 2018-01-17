/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.versioningartifacts;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;

import java.util.Random;

/**
 * This class is the "grandchild" SequenceAssociate of the owner
 */
public class SequenceAssociateGrandChild implements SequenceAssociate<SequenceOwnerImpl> {
    private static final long serialVersionUID = -7334498072241996364L;
    
    private Long grandChildId;
    private SequenceOwnerImpl owner;
    private SequenceAssociateChild parent;
    private String name;
    private Integer sequenceNumber;
        
    public SequenceAssociateGrandChild(String name) {
        this.name = name;
        setGrandChildId(new Random().nextLong());
    }
    
    /**
     * Gets the parent attribute. 
     * @return Returns the parent.
     */
    public SequenceAssociateChild getParent() {
        return parent;
    }

    /**
     * Sets the parent attribute value.
     * @param parent The parent to set.
     */
    public void setParent(SequenceAssociateChild parent) {
        this.parent = parent;
    }

    @Override
    public SequenceOwnerImpl getSequenceOwner() {
        return owner;
    }
    
    @Override
    public void setSequenceOwner(SequenceOwnerImpl newOwner) {
        setOwner(newOwner);
    }
    
    @Override
    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Gets the owner attribute. 
     * @return Returns the owner.
     */
    public SequenceOwnerImpl getOwner() {
        return owner;
    }

    /**
     * Gets the name attribute. 
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the owner attribute value.
     * @param owner The owner to set.
     */
    public void setOwner(SequenceOwnerImpl owner) {
        this.owner = owner;
        this.sequenceNumber = owner != null ? owner.getSequenceNumber() : null;
    }

    /**
     * Sets the name attribute value.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the sequenceNumber attribute value.
     * @param sequenceNumber The sequenceNumber to set.
     */
    public void setSequenceNumber(Integer sequenceNumber) {
        // do nothing
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        result = PRIME * result + ((sequenceNumber == null) ? 0 : sequenceNumber.hashCode());
        return result;
    }

    public Long getGrandChildId() {
        return grandChildId;
    }

    public void setGrandChildId(Long grandChildId) {
        this.grandChildId = grandChildId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SequenceAssociateGrandChild)) {
            return false;
        }
        SequenceAssociateGrandChild other = (SequenceAssociateGrandChild) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (sequenceNumber == null) {
            if (other.sequenceNumber != null) {
                return false;
            }
        } else if (!sequenceNumber.equals(other.sequenceNumber)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public void resetPersistenceState() {
        setGrandChildId(null);
    }
}
