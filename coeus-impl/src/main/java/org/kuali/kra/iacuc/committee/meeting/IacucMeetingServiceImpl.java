/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.meeting;

import org.kuali.coeus.common.committee.impl.meeting.*;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.correspondence.IacucProtocolCorrespondence;
import org.kuali.kra.protocol.correspondence.ProtocolCorrespondence;

public class IacucMeetingServiceImpl extends MeetingServiceImplBase<IacucCommitteeSchedule, IacucCommitteeScheduleMinute, IacucCommittee> implements IacucMeetingService {

    @Override
    protected Class<? extends ScheduleAgendaBase> getScheduleAgendaBOClassHook() {
        return IacucScheduleAgenda.class;
    }

    @Override
    protected Class<? extends CommScheduleMinuteDocBase> getCommScheduleMinuteDocBOClassHook() {
        return IacucCommScheduleMinuteDoc.class;
    }

    @Override
    protected Class<? extends ProtocolCorrespondence> getProtocolCorrespondenceBOClassHook() {
        return IacucProtocolCorrespondence.class;
    }

    @Override
    protected Class<? extends ProtocolContingencyBase> getProtocolContingencyBOClassHook() {
        return IacucProtocolContingency.class;
    }

    @Override
    protected OtherPresentBeanBase getNewOtherPresentBeanInstanceHook() {
        return new IacucOtherPresentBean();
    }

    @Override
    protected IacucCommitteeScheduleMinute getNewCommitteeScheduleMinuteInstanceHook() {
        return new IacucCommitteeScheduleMinute();
    }

    @Override
    protected CommitteeScheduleAttendanceBase getNewCommitteeScheduleAttendanceInstanceHook() {
        return new IacucCommitteeScheduleAttendance();
    }

}
