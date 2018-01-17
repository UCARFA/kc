/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.version.sequence.associate;

import org.kuali.coeus.common.framework.version.sequence.Sequenceable;



/**
 * This interface specifies behavior for sequence associates that should not be 
 * deep copied when the SequenceOwner is versioned; i.e. attachment BOs
 */
public interface SeparatelySequenceableAssociate extends Sequenceable {
    
    /**
     * This increments sequence number on an separately sequenceable associate.
     */
    void incrementSequenceNumber();
}
