/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.decision;

import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.protocol.ProtocolDocumentBase;
import org.kuali.kra.protocol.actions.decision.CommitteeDecisionVoterRuleBase;
import org.kuali.kra.protocol.actions.decision.ExecuteCommitteeDecisionAbstainerRule;
import org.kuali.rice.krad.util.GlobalVariables;

/**
 * 
 * This class handles the rules for the abstainer side of the committee decision.
 */
public class CommitteeDecisionAbstainerRule extends CommitteeDecisionVoterRuleBase implements ExecuteCommitteeDecisionAbstainerRule<CommitteeDecision> {
    
    @Override
    public boolean proccessCommitteeDecisionAbstainerRule(ProtocolDocumentBase document, CommitteeDecision committeeDecision) {
        boolean retVal = true;
        if (!processVoter(committeeDecision.getNewAbstainer(), committeeDecision.getAbstainers(), committeeDecision.getRecused())) {
            GlobalVariables.getMessageMap().putError(Constants.PROTOCOL_COMMITTEE_DECISION_ACTION_PROPERTY_KEY + ".newAbstainer.membershipId", 
                    KeyConstants.ERROR_PROTOCOL_RECORD_COMMITTEE_ABSTAIN_RECUSED_ALREADY_EXISTS);
            retVal = false; 
        }
        return retVal;
    }
}
