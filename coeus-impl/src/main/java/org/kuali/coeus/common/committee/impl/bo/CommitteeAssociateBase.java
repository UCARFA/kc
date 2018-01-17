/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;


/**
 * 
 * This class is for associating common CommitteeBase properties to the extended CommitteeBase children BOs
 */
public abstract class CommitteeAssociateBase extends CommitteeSequenceAssociateBase {

    private static final long serialVersionUID = -6350020738083606018L;

    private Long committeeIdFk;

    public Long getCommitteeIdFk() {
        return committeeIdFk;
    }

    public void setCommitteeIdFk(Long committeeIdFk) {
        this.committeeIdFk = committeeIdFk;
    }
}
