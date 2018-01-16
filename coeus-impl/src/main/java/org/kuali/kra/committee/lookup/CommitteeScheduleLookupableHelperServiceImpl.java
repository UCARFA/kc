/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.lookup;

import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.lookup.CommitteeScheduleLookupableHelperServiceImplBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.document.authorization.CommitteeScheduleTask;
import org.kuali.kra.infrastructure.TaskGroupName;

/**
 * 
 * This class is to create action links and inquiry url for committeeschedule lookup.
 */
@SuppressWarnings("serial")
public class CommitteeScheduleLookupableHelperServiceImpl extends CommitteeScheduleLookupableHelperServiceImplBase<CommitteeSchedule, Committee, CommitteeTaskBase<Committee>, CommitteeScheduleTask> {

    @Override
    protected Class<Committee> getCommonCommitteeBOClassHook() {
        return Committee.class;
    }

    @Override
    protected Class<CommitteeSchedule> getCommitteeScheduleBOClassHook() {
        return CommitteeSchedule.class;
    }

    @Override
    protected String getCommitteeTypeCodeHook() {
        return CommitteeType.IRB_TYPE_CODE;
    }

    @Override
    protected String getMeetingManagementActionIdHook() {
        return "meetingManagement";
    }

    @Override
    protected CommitteeTaskBase<Committee> getNewCommitteeTaskInstanceHook(String taskName, Committee committee) {
        // creating an anonymous class to avoid task hierarchy issues
        return new CommitteeTaskBase<Committee>(TaskGroupName.COMMITTEE, taskName, committee) {};
    }

    @Override
    protected CommitteeScheduleTask getNewCommitteeScheduleTaskInstanceHook(String taskName, Committee committee, CommitteeSchedule committeeSchedule) {
        return new CommitteeScheduleTask(taskName, committee, committeeSchedule);
    }

    @Override
    protected boolean isCurrentVersion(Committee committee) {
        return super.isCurrentVersion(committee);
    }
}
