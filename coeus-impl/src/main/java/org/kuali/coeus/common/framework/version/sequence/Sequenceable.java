/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.version.sequence;

import java.io.Serializable;

/**
 * This interface defines a class with sequence information.
 */
public interface Sequenceable extends Serializable {
    /**
     * This gets the current version number.
     * @return the sequence number
     */
    Integer getSequenceNumber();
    
    /**
     * This method resets the persistence state used to establish 
     * whether this is a new entity or an already-persisted entity.
     * 
     * During sequencing, the VersioningService needs to be able to
     * signal that a Sequenceable has changed state from an persisted
     * entity to a new, unpersisted one. Otherwise, versioning 
     * operations would result earlier SequenceOwners losing the 
     * association with older versions of associates.
     * 
     * This behavior comes into play whenever an associated object
     * is versioned. 
     * 
     * Typically, implementers will set primary key fields to null 
     * to trigger an INSERT during save.
     */
    void resetPersistenceState();
}
