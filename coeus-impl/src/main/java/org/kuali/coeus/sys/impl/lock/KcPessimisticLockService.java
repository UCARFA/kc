/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.impl.lock;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.rice.kim.api.identity.Person;

/**
 * KC Pessimistic Lock Service.
 */
public interface KcPessimisticLockService {
    
    /**
     * Clear expired locks.  An expired lock is defined as a lock
     * that older than a given amount of time, e.g. 24 hours.
     */
    void clearExpiredLocks();

    boolean hasPersonnelLocks(String documentNumber);

    public boolean isPessimisticLockNeeded(ProposalDevelopmentDocument document, Person user, boolean canEdit, String customLockDescriptor);
}
