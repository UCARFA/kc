/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.service.impl.versioningartifacts;

import org.kuali.coeus.common.framework.version.sequence.owner.SequenceOwner;

import java.util.ArrayList;
import java.util.Collection;

public class SelfReferenceOwner implements SequenceOwner<SelfReferenceOwner>{
    private static final long serialVersionUID = 5794406936890268956L;
    
    public Long id = 1L;
    public Integer seq = 0;
    public final Collection<SelfReferenceAssociate> associates = new ArrayList<SelfReferenceAssociate>();
    
    /**
     * Gets the associates attribute. 
     * @return Returns the associates.
     */
    public Collection<SelfReferenceAssociate> getAssociates() {
        return associates;
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
     * Gets the seq attribute. 
     * @return Returns the seq.
     */
    public Integer getSeq() {
        return seq;
    }

    /**
     * Sets the seq attribute value.
     * @param seq The seq to set.
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public Integer getOwnerSequenceNumber() {
        return seq;
    }

    @Override
    public void incrementSequenceNumber() {
        seq++;
    }

    @Override
    public SelfReferenceOwner getSequenceOwner() {
        return this;
    }

    @Override
    public void setSequenceOwner(SelfReferenceOwner newlyVersionedOwner) {
        //do nothing
    }

    @Override
    public Integer getSequenceNumber() {
        return seq;
    }

    @Override
    public void resetPersistenceState() {
        id = null;
    }
    
    @Override
    public String getVersionNameField() {
        return "id";
    }

    @Override
    public String getVersionNameFieldValue() {
        return id.toString();
    }
}
