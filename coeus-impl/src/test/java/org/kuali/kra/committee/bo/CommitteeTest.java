/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.bo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CommitteeTest {
    
    
    @Test
    public void testGetCommitteeMembershipFor() {
        
        // create three committee membership objects, 
        // two with legit person ids, and the last one with null person id
        CommitteeMembership cm1 = new CommitteeMembership();
        cm1.setPersonId("person1");
        
        CommitteeMembership cm2 = new CommitteeMembership();
        cm2.setPersonId("person2");
        
        CommitteeMembership nullPersonIdMember = new CommitteeMembership();
        nullPersonIdMember.setPersonId(null);
        
        
        // create the test committee instance and add the memberships to it
        Committee committee = new Committee();
        committee.getCommitteeMemberships().add(cm1);
        committee.getCommitteeMemberships().add(cm2);
        committee.getCommitteeMemberships().add(nullPersonIdMember);
        
        assertEquals(cm1, committee.getCommitteeMembershipFor("person1"));
        assertEquals(cm2, committee.getCommitteeMembershipFor("person2"));
        assertEquals(null, committee.getCommitteeMembershipFor("random"));
        assertEquals(null, committee.getCommitteeMembershipFor(null));
    }
    
}
