/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.version.sequence.owner;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;

/**
 * This interface applies to classes that own a sequence number.
 * @param <T> the type of sequence owner which itself has an owner of unknown type
 */
public interface SequenceOwner<T extends SequenceOwner<?>> extends SequenceAssociate<T> {
    /**
     * This increments sequence number on an owner of a sequence.
     */
    void incrementSequenceNumber();
    
    /**
     * This method returns its owner's sequence number. If this is the top level owner; i.e. Protocol or Award, it should return null
     * @return the owner's sequence number
     */
    Integer getOwnerSequenceNumber();
    
    /**
     * For Award, this would be "awardNumber", for Committee "committeeName", for Protocol "protocolNumber", etc.
     * @return the field name that versions are "grouped" by
     */
    String getVersionNameField();

    String getVersionNameFieldValue();

}
