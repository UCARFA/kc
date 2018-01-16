/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.document.authorization;

import org.kuali.coeus.common.committee.impl.document.authorization.CommitteeScheduleTaskBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.infrastructure.TaskGroupName;

public class IacucCommitteeScheduleTask extends CommitteeScheduleTaskBase<IacucCommittee, IacucCommitteeSchedule> {

    public IacucCommitteeScheduleTask(String taskName, IacucCommittee committee, IacucCommitteeSchedule schedule) {
        super(TaskGroupName.IACUC_COMMITTEE, taskName, committee, schedule);
    }

}
