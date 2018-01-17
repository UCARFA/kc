/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.irb.actions.decision;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.committee.impl.bo.CommitteeDecisionMotionType;

import static org.junit.Assert.*;
public class CommitteeDecisionRecuserRuleTest extends CommitteeDecisionRuleBase {
    
    private CommitteeDecisionRecuserRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new CommitteeDecisionRecuserRule();
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
    }
    
    /**
     * Tests a valid new recused.
     */
    @Test
    public void testValidNewRecused() {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, null, getBasicPerson(), null, false);
        assertTrue(rule.proccessCommitteeDecisionRecuserRule(null, decision));
    }
    
   /**
    * Tests invalid new recused which has no membership ID
    */
    @Test
    public void testInvalidNewRecusedNoMembershipId() {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, null, new CommitteePerson(), null, false);
        assertFalse(rule.proccessCommitteeDecisionRecuserRule(null, decision));
    }
    
    /**
     * Tests an invalid new recused which is already in the recused list.
     */
    @Test
    public void testInvalidNewRecusedInRecusedList() {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, null, getBasicRecused(), null, false);
        assertFalse(rule.proccessCommitteeDecisionRecuserRule(null, decision));
    }
    
    /**
     * Tests an invalid new recused which is already in the abstainer list.
     */
    @Test
    public void testInvalidNewRecusedInAbstainerList() {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, null, getBasicAbstainer(), null, false);
        assertFalse(rule.proccessCommitteeDecisionRecuserRule(null, decision));
    }

}
