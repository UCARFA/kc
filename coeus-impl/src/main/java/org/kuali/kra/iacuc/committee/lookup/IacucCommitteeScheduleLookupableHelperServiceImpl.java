/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.lookup;

import org.kuali.coeus.common.committee.impl.bo.CommitteeType;
import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeTaskBase;
import org.kuali.coeus.common.committee.impl.lookup.CommitteeScheduleLookupableHelperServiceImplBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.committee.document.authorization.IacucCommitteeScheduleTask;
import org.kuali.kra.infrastructure.TaskGroupName;

public class IacucCommitteeScheduleLookupableHelperServiceImpl extends CommitteeScheduleLookupableHelperServiceImplBase<IacucCommitteeSchedule, IacucCommittee, CommitteeTaskBase<IacucCommittee>, IacucCommitteeScheduleTask> {


    private static final long serialVersionUID = 2963379561699240982L;

    @Override
    protected Class<IacucCommittee> getCommonCommitteeBOClassHook() {
        return IacucCommittee.class;
    }

    @Override
    protected Class<IacucCommitteeSchedule> getCommitteeScheduleBOClassHook() {
        return IacucCommitteeSchedule.class;
    }

    @Override
    protected String getCommitteeTypeCodeHook() {
        return CommitteeType.IACUC_TYPE_CODE;
    }

    @Override
    protected CommitteeTaskBase<IacucCommittee> getNewCommitteeTaskInstanceHook(String taskName, IacucCommittee committee) {
        // creating an anonymous class to avoid task hierarchy issues
        return new CommitteeTaskBase<IacucCommittee>(TaskGroupName.IACUC_COMMITTEE, taskName, committee) {};
    }

    @Override
    protected IacucCommitteeScheduleTask getNewCommitteeScheduleTaskInstanceHook(String taskName, IacucCommittee committee, IacucCommitteeSchedule committeeSchedule) {
        return new IacucCommitteeScheduleTask(taskName, committee, committeeSchedule);
    }

    @Override
    protected String getMeetingManagementActionIdHook() {
        return "iacucMeetingManagement";
    }

}
