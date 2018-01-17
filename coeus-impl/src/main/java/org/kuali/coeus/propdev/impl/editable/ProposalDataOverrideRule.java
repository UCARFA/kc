/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.editable;

import org.kuali.coeus.propdev.impl.editable.ProposalDataOverrideEvent;
import org.kuali.rice.krad.rules.rule.BusinessRule;

/**
 * The Copy Proposal Rule validates copying of a proposal.
 *
 * @author Kuali Research Administration Team (kualidev@oncourse.iu.edu)
 */
public interface ProposalDataOverrideRule extends BusinessRule {
    
    /**
     * Validates the Overriding of a proposal data.  
     * 
     * @param document the proposal development document
     * @param proposalChangedData the user-specified overriding data
     * @return true if the update request is valid; otherwise false
     */
    public boolean processProposalDataOverrideRules(ProposalDataOverrideEvent proposalDataOverrideEvent);
}
