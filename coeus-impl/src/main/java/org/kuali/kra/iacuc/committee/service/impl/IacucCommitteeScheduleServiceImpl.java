/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.service.impl;

import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleAttachmentsBase;
import org.kuali.coeus.common.committee.impl.service.impl.CommitteeScheduleServiceImplBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.committee.meeting.IacucCommitteeScheduleAttachments;
import org.kuali.kra.iacuc.committee.meeting.IacucCommitteeScheduleMinute;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeScheduleService;

public class IacucCommitteeScheduleServiceImpl extends CommitteeScheduleServiceImplBase<IacucCommitteeSchedule, IacucCommittee, IacucCommitteeScheduleMinute> implements IacucCommitteeScheduleService{

    @Override
    protected IacucCommitteeSchedule getNewCommiteeScheduleInstanceHook() {
        return new IacucCommitteeSchedule(); 
    }

    @Override
    protected Class<IacucCommitteeScheduleMinute> getCommitteeScheduleMinuteBOClassHook() {
        return IacucCommitteeScheduleMinute.class;
    }

    @Override
    protected CommitteeScheduleAttachmentsBase getNewCommitteeScheduleAttachmentsInstanceHook() {
        return new IacucCommitteeScheduleAttachments();
    }

}
