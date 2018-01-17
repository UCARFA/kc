/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.dao;

import java.util.List;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;

public interface CustomCommitteeDao {

	void updateSubmissionsToNewCommitteeVersion(CommitteeBase<?, ?, ? extends CommitteeScheduleBase> committee, List<? extends CommitteeScheduleBase> schedules);

}