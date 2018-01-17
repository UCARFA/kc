/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.person.masschange;

import org.kuali.kra.personmasschange.bo.PersonMassChange;
import org.kuali.coeus.propdev.impl.core.DevelopmentProposal;

import java.util.List;

/**
 * Defines the service interface for performing a Person Mass Change on Proposal Developments.
 */
public interface ProposalDevelopmentPersonMassChangeService {
    
    /**
     * Returns the Proposal Developments that would have a Person Mass Change performed on them.
     * 
     * @param personMassChange the Person Mass Change to be performed
     * @return the Proposal Developments that would have a Person Mass Change performed on them
     */
    List<DevelopmentProposal> getProposalDevelopmentChangeCandidates(PersonMassChange personMassChange);
    
    /**
     * Performs the Person Mass Change on the Proposal Developments.
     * 
     * @param personMassChange the Person Mass Change to be performed
     * @param proposalDevelopmentChangeCandidates the Proposal Developments to perform a Person Mass Change on
     */
    void performPersonMassChange(PersonMassChange personMassChange, List<DevelopmentProposal> proposalDevelopmentChangeCandidates);

}
