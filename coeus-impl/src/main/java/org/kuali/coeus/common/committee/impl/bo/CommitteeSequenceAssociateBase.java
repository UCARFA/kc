/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public abstract class CommitteeSequenceAssociateBase extends KcPersistableBusinessObjectBase implements SequenceAssociate<CommitteeBase<?, ?, ?>> {

    private static final long serialVersionUID = -9040705064557493297L;

    private CommitteeBase sequenceOwner;

    @Override
    public CommitteeBase getSequenceOwner() {
        return this.sequenceOwner;
    }

    @Override
    public void setSequenceOwner(CommitteeBase newOwner) {
        this.sequenceOwner = newOwner;
    }

    @Override
    public Integer getSequenceNumber() {
        return this.sequenceOwner.getSequenceNumber();
    }

    @Override
    public abstract boolean equals(Object obj);
    
    @Override
    public abstract int hashCode();
    
    @Override
    public abstract void resetPersistenceState();

}
