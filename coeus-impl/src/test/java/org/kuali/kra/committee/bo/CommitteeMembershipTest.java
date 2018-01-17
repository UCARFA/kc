/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.bo;

import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommitteeMembershipTest {

    @Test
    public void testIsRepresentingPerson() {
        // create three committee membership objects, 
        // two with legit person ids, and the last one with null person id
        CommitteeMembership cm1 = new CommitteeMembership();
        cm1.setPersonId("person1");
        
        CommitteeMembership cm2 = new CommitteeMembership();
        cm2.setPersonId("person2");
        
        CommitteeMembership nullPersonIdMember = new CommitteeMembership();
        nullPersonIdMember.setPersonId(null);
        
        assertTrue(cm1.isRepresentingPerson("person1"));
        assertTrue(cm2.isRepresentingPerson("person2"));
        assertFalse(cm1.isRepresentingPerson("person2"));
        assertFalse(cm2.isRepresentingPerson(null));
        assertFalse(nullPersonIdMember.isRepresentingPerson(null));
    }
    
    @Test
    public void testHasTermEnded() {
        // get a calendar using the default time zone and locale.
        Calendar cal = Calendar.getInstance();
        // clear lower time fields
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        
        Date dateToday = new Date(cal.getTime().getTime());
        // one day into the future
        //cal.roll(Calendar.DATE, true);
        cal.add(Calendar.DATE, 1);
        Date dateTomorrow = new Date(cal.getTime().getTime());
        // one day into the past
        //cal.roll(Calendar.DATE, false);
        //cal.roll(Calendar.DATE, false);
        cal.add(Calendar.DATE, -2);
        Date dateYesterday = new Date(cal.getTime().getTime());
        
        CommitteeMembership cm = new CommitteeMembership();
        
        cm.setTermEndDate(dateYesterday);
        assertTrue(cm.hasTermEnded());
        cm.setTermEndDate(dateToday);
        assertFalse(cm.hasTermEnded());
        cm.setTermEndDate(dateTomorrow);
        assertFalse(cm.hasTermEnded());
        cm.setTermEndDate(null);
        assertTrue(cm.hasTermEnded());        
    }
        
}
