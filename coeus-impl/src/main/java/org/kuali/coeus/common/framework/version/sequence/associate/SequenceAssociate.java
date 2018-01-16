/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.version.sequence.associate;

import org.kuali.coeus.common.framework.version.sequence.Sequenceable;
import org.kuali.coeus.common.framework.version.sequence.owner.SequenceOwner;

/**
 * This interface applies to classes that are associated 
 * with a sequence owner; i.e. child BOs of an Award or Protocol
 * 
 * SequenceAssociates must override equals and hashCode!
 * @param <T> the type of sequence owner which itself has an owner of unknown type
 */
public interface SequenceAssociate<T extends SequenceOwner<?>> extends Sequenceable {
    /**
     * This sets the sequence owner on the associate. 
     * Should no-op if this associate has no sequence owner 
     * @param newlyVersionedOwner
     */
    void setSequenceOwner(T newlyVersionedOwner);
    
    /**
     * The SequenceOwner is returned; "this" should be returned if this associate is the sequence owner.
     * @return the SequenceOwner
     */
    T getSequenceOwner();
}
