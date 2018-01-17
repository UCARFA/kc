/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.protocol.actions.decision;

import java.util.List;

/**
 * 
 * This class takes care of the basic functionality of verifying on meeting voter.
 */
public abstract class CommitteeDecisionVoterRuleBase<CP extends CommitteePersonBase> {
    
    /**
     * 
     * This method manages the business rules of a voter.
     * @param voter
     * @param abstainers
     * @param recused
     * @return
     */
    protected boolean processVoter(CP voter, List<CP> abstainers, List<CP> recused) {
        boolean retVal = true;
        if (voter.getMembershipId() == null 
                || !checkCommitteePerson(abstainers, voter)
                || !checkCommitteePerson(recused, voter)) {
            retVal = false;
        }
        return retVal;
    }
    
    protected boolean checkCommitteePerson(List<CP> people, CP committeePersonToCheck) {
        for (CP listPerson : people) {
            if (listPerson.getMembershipId().equals(committeePersonToCheck.getMembershipId())) {
                return false;
            }
        }
        return true;
    }
}
