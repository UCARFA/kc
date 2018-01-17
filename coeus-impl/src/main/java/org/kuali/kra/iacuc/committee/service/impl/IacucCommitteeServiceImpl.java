/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.service.impl;

import org.kuali.coeus.common.committee.impl.bo.CommitteeResearchAreaBase;
import org.kuali.coeus.common.committee.impl.service.impl.CommitteeServiceImplBase;
import org.kuali.kra.iacuc.actions.submit.IacucProtocolSubmissionLite;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeResearchArea;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.committee.meeting.IacucCommitteeScheduleMinute;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;

public class IacucCommitteeServiceImpl extends CommitteeServiceImplBase<IacucCommittee, IacucCommitteeSchedule, IacucProtocolSubmissionLite, IacucCommitteeScheduleMinute> implements IacucCommitteeService {

    @Override
    protected Class<IacucCommittee> getCommitteeBOClassHook() {
        return IacucCommittee.class;
    }

    @Override
    protected CommitteeResearchAreaBase getNewCommitteeResearchAreaInstanceHook() {
        return new IacucCommitteeResearchArea();
    }

}
