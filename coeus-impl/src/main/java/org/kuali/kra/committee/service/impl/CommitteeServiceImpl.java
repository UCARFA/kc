/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.service.impl;

import org.kuali.coeus.common.committee.impl.bo.CommitteeResearchAreaBase;
import org.kuali.coeus.common.committee.impl.service.impl.CommitteeServiceImplBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeResearchArea;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.service.CommitteeService;
import org.kuali.kra.irb.actions.submit.ProtocolSubmissionLite;
import org.kuali.kra.meeting.CommitteeScheduleMinute;

/**
 * The Committee Service implementation.
 */
public class CommitteeServiceImpl extends CommitteeServiceImplBase<Committee, CommitteeSchedule, ProtocolSubmissionLite, CommitteeScheduleMinute> implements CommitteeService {

    @Override
    protected Class<Committee> getCommitteeBOClassHook() {
        return Committee.class;
    }

    @Override
    protected CommitteeResearchAreaBase getNewCommitteeResearchAreaInstanceHook() {
        return new CommitteeResearchArea();
    }

}
