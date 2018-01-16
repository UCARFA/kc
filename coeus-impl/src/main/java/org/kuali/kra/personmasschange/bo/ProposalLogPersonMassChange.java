/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.bo;

import org.kuali.coeus.sys.framework.model.KcPersistableBusinessObjectBase;

/**
 * Defines the fields for a Proposal Log Person Mass Change.
 */
public class ProposalLogPersonMassChange extends KcPersistableBusinessObjectBase {

    private static final long serialVersionUID = 3351381999001017550L;
    
    private long proposalLogPersonMassChangeId;
    private long personMassChangeId;
    private boolean principalInvestigator;
    
    private PersonMassChange personMassChange;

    public long getProposalLogPersonMassChangeId() {
        return proposalLogPersonMassChangeId;
    }

    public void setProposalLogPersonMassChangeId(long proposalLogPersonMassChangeId) {
        this.proposalLogPersonMassChangeId = proposalLogPersonMassChangeId;
    }

    public long getPersonMassChangeId() {
        return personMassChangeId;
    }

    public void setPersonMassChangeId(long personMassChangeId) {
        this.personMassChangeId = personMassChangeId;
    }

    public boolean isPrincipalInvestigator() {
        return principalInvestigator;
    }

    public void setPrincipalInvestigator(boolean principalInvestigator) {
        this.principalInvestigator = principalInvestigator;
    }
    
    public PersonMassChange getPersonMassChange() {
        return personMassChange;
    }

    public void setPersonMassChange(PersonMassChange personMassChange) {
        this.personMassChange = personMassChange;
    }

    /**
     * Determines whether this Person Mass Change is required.
     * 
     * @return true if any of the fields are true, false otherwise
     */
    public boolean requiresChange() {
        return principalInvestigator;
    }

}
