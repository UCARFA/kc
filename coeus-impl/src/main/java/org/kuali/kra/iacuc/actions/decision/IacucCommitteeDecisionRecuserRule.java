/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.actions.decision;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.decision.CommitteeDecisionVoterRuleBase;
import org.kuali.kra.protocol.actions.decision.ExecuteCommitteeDecisionRecuserRule;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * This class handles the rules for the recuser side of the committee decision.
 */
public class IacucCommitteeDecisionRecuserRule extends CommitteeDecisionVoterRuleBase<IacucCommitteePerson> implements ExecuteCommitteeDecisionRecuserRule<IacucCommitteeDecision> {
    
    @Override
    public boolean proccessCommitteeDecisionRecuserRule(ProtocolDocumentBase document, IacucCommitteeDecision committeeDecision) {
        boolean retVal = true; 
        
        if(!processVoter(committeeDecision.getNewRecused(), committeeDecision.getAbstainers(), committeeDecision.getRecused())) {
            GlobalVariables.getMessageMap().putError(Constants.PROTOCOL_COMMITTEE_DECISION_ACTION_PROPERTY_KEY + ".newRecused.membershipId", 
                    KeyConstants.ERROR_PROTOCOL_RECORD_COMMITTEE_ABSTAIN_RECUSED_ALREADY_EXISTS);
            retVal = false;
        }
        return retVal;
    }
}
