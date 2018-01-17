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
public class CommitteeDecisionAbstainerRuleTest extends CommitteeDecisionRuleBase {
    
    private CommitteeDecisionAbstainerRule rule;

    @Before
    public void setUp() throws Exception {
        rule = new CommitteeDecisionAbstainerRule();
    }

    @After
    public void tearDown() throws Exception {
        rule = null;
    }
    
    /**
     * Tests a valid new abstainer.
     */
    @Test
    public void testValidNewAbstainer() throws Exception {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, getBasicPerson(), null, null, false);
        assertTrue(rule.proccessCommitteeDecisionAbstainerRule(null, decision));
    }
    
    /**
     * Tests invalid new abstainer which has no membership ID
     */
    @Test
    public void testInvalidNewAbstainerNoMembershipId() throws Exception {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, new CommitteePerson(), null, null, false);
        assertFalse(rule.proccessCommitteeDecisionAbstainerRule(null, decision));
    }
    
    /**
     * Tests an invalid new abstainer which is already in the abstainer list.
     */
    @Test
    public void testInvalidNewAbstainerInAbstainerList() throws Exception {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, getBasicAbstainer(), null, null, false);
        assertFalse(rule.proccessCommitteeDecisionAbstainerRule(null, decision));
    }
    
    /**
     * Tests an invalid new abstainer which is already in the recused list.
     */
    @Test
    public void testInvalidNewAbstainerInRecusedList() throws Exception {
        CommitteeDecision decision = getMockCommitteeDecisionBean(CommitteeDecisionMotionType.APPROVE, YES_COUNT, NO_COUNT, getBasicRecused(), null, null, false);
        assertFalse(rule.proccessCommitteeDecisionAbstainerRule(null, decision));
    }
    
}
