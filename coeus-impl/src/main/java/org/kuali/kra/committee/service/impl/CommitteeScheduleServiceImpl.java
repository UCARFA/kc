/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.service.impl;

import org.kuali.coeus.common.committee.impl.meeting.CommitteeScheduleAttachmentsBase;
import org.kuali.coeus.common.committee.impl.service.impl.CommitteeScheduleServiceImplBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.service.CommitteeScheduleService;
import org.kuali.kra.meeting.CommitteeScheduleAttachments;
import org.kuali.kra.meeting.CommitteeScheduleMinute;
import org.springframework.transaction.annotation.Transactional;


/**
 * The Committee Service implementation.
 */
@Transactional
public class CommitteeScheduleServiceImpl extends CommitteeScheduleServiceImplBase<CommitteeSchedule, Committee, CommitteeScheduleMinute> implements CommitteeScheduleService {

    @Override
    protected CommitteeSchedule getNewCommiteeScheduleInstanceHook() {
        return new CommitteeSchedule();
    }

    @Override
    protected Class<CommitteeScheduleMinute> getCommitteeScheduleMinuteBOClassHook() {
        return CommitteeScheduleMinute.class;
    }

    @Override
    protected CommitteeScheduleAttachmentsBase getNewCommitteeScheduleAttachmentsInstanceHook() {
        return new CommitteeScheduleAttachments();
    }
}
