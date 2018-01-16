/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.specialreview;

import org.kuali.coeus.common.framework.version.sequence.associate.SequenceAssociate;
import org.kuali.coeus.common.framework.compliance.core.SpecialReview;
import org.kuali.kra.protocol.ProtocolBase;

/**
 * Defines a Special Review for a ProtocolBase.
 */
public abstract class ProtocolSpecialReviewBase extends SpecialReview<ProtocolSpecialReviewExemption> implements SequenceAssociate<ProtocolBase> {

    private static final long serialVersionUID = -9010537404528653558L;

    private Long protocolSpecialReviewId;

    private Long protocolId;

    private ProtocolBase sequenceOwner;

    public Long getProtocolSpecialReviewId() {
        return protocolSpecialReviewId;
    }

    public void setProtocolSpecialReviewId(Long protocolSpecialReviewId) {
        this.protocolSpecialReviewId = protocolSpecialReviewId;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    @Override
    public ProtocolBase getSequenceOwner() {
        return sequenceOwner;
    }

    @Override
    public void setSequenceOwner(ProtocolBase sequenceOwner) {
        this.sequenceOwner = sequenceOwner;
    }

    @Override
    public Integer getSequenceNumber() {
        return sequenceOwner != null ? sequenceOwner.getSequenceNumber() : null;
    }

    @Override
    public void resetPersistenceState() {
        protocolSpecialReviewId = null;
    }

    @Override
    public abstract ProtocolSpecialReviewExemption createSpecialReviewExemption(String exemptionTypeCode);
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((protocolId == null) ? 0 : protocolId.hashCode());
        result = prime * result + ((protocolSpecialReviewId == null) ? 0 : protocolSpecialReviewId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProtocolSpecialReviewBase other = (ProtocolSpecialReviewBase) obj;
        if (protocolId == null) {
            if (other.protocolId != null) {
                return false;
            }
        } else if (!protocolId.equals(other.protocolId)) {
            return false;
        }
        if (protocolSpecialReviewId == null) {
            if (other.protocolSpecialReviewId != null) {
                return false;
            }
        } else if (!protocolSpecialReviewId.equals(other.protocolSpecialReviewId)) {
            return false;
        }
        return true;
    }
}
