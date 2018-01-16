/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.meeting;

import org.junit.Test;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.framework.auth.perm.KcAuthorizationService;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.document.authorization.CommitteeScheduleTask;
import org.kuali.kra.infrastructure.TaskGroupName;
import org.kuali.kra.infrastructure.TaskName;
import org.kuali.kra.service.impl.mocks.KraAuthorizationServiceMock;

import static org.junit.Assert.assertEquals;

public class ViewScheduleAuthorizerTest {
    private static final String USERNAME = "quickstart";
    private static final String PERSON_ID = "jtester";
  
    @Test
    public void testViewSchedulePermission() throws Exception {
        ViewScheduleAuthorizer authorizer = new ViewScheduleAuthorizer();
        
        final KcAuthorizationService kraAuthorizationService = new KraAuthorizationServiceMock(true);
        authorizer.setKraAuthorizationService(kraAuthorizationService);
        
        Committee committee = createCommittee("viewschedule1", "view schedule test");
        CommitteeTaskBase<Committee> task = new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, TaskName.VIEW_SCHEDULE, committee) {};
        assertEquals(true, authorizer.isAuthorized(USERNAME, task));
        final KcAuthorizationService kraAuthorizationService1 = new KraAuthorizationServiceMock(false);
        authorizer.setKraAuthorizationService(kraAuthorizationService1);
        assertEquals(false, authorizer.isAuthorized("tdurkin", task));
        
        
        // now check the available to reviewers flag functionality        
        CommitteeSchedule committeeSchedule = new CommitteeSchedule();
        final KcAuthorizationService kraAuthorizationService2 = new KraAuthorizationServiceMock(true);
        authorizer.setKraAuthorizationService(kraAuthorizationService2);        
        task = new CommitteeScheduleTask(TaskName.VIEW_SCHEDULE, committeeSchedule.getParentCommittee(), committeeSchedule);
        assertEquals(false, authorizer.isAuthorized(PERSON_ID, task));        
        committeeSchedule.setAvailableToReviewers(true);        
        task = new CommitteeScheduleTask(TaskName.VIEW_SCHEDULE, committeeSchedule.getParentCommittee(), committeeSchedule);
        assertEquals(true, authorizer.isAuthorized(PERSON_ID, task));
    }
    
    
    
    
    private Committee createCommittee(String committeeId, String committeeName) {
        Committee committee = new Committee();
        committee.setCommitteeId(committeeId);
        committee.setCommitteeName(committeeName);
        return committee;
    }
    
}
