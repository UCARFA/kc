/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.versioningartifacts;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;

import java.util.ArrayList;
import java.util.Collection;

public class SelfReferenceAssociate implements SequenceAssociate<SelfReferenceOwner> {

    public Long id = 1L;
    public Integer seqNumber = 1;
    
    public SelfReferenceOwner owner;
    
    public final Collection<SelfReferenceAssociate> selfs = new ArrayList<SelfReferenceAssociate>();
    
    /**
     * Gets the selfs attribute. 
     * @return Returns the selfs.
     */
    public Collection<SelfReferenceAssociate> getSelfs() {
        return selfs;
    }

    /**
     * Gets the id attribute. 
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id attribute value.
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the seqNumber attribute. 
     * @return Returns the seqNumber.
     */
    public Integer getSeqNumber() {
        return seqNumber;
    }

    /**
     * Sets the seqNumber attribute value.
     * @param seqNumber The seqNumber to set.
     */
    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    /**
     * Gets the owner attribute. 
     * @return Returns the owner.
     */
    public SelfReferenceOwner getOwner() {
        return owner;
    }

    /**
     * Sets the owner attribute value.
     * @param owner The owner to set.
     */
    public void setOwner(SelfReferenceOwner owner) {
        this.owner = owner;
    }

    @Override
    public SelfReferenceOwner getSequenceOwner() {

        return owner;
    }

    @Override
    public void setSequenceOwner(SelfReferenceOwner newlyVersionedOwner) {
        owner = newlyVersionedOwner;
        
    }

    @Override
    public Integer getSequenceNumber() {
        return seqNumber;
    }

    @Override
    public void resetPersistenceState() {
        id = null;
    }

}
