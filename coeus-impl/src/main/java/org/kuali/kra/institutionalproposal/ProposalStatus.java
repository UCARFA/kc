/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

public class ProposalStatus extends KcPersistableBusinessObjectBase {

    public static final Integer PENDING = 1;

    public static final Integer FUNDED = 2;

    private static final long serialVersionUID = 1L;

    private Integer proposalStatusCode;

    private String description;

    public ProposalStatus() {
    }

    public Integer getProposalStatusCode() {
        return proposalStatusCode;
    }

    public void setProposalStatusCode(Integer proposalStatusCode) {
        this.proposalStatusCode = proposalStatusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isFunded() {
        return proposalStatusCode.intValue() == FUNDED.intValue();
    }

    public boolean isPending() {
        return proposalStatusCode.intValue() == PENDING.intValue();
    }
}
