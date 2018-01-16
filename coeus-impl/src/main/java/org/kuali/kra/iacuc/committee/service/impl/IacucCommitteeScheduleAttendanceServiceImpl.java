/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.service.impl;

import org.kuali.coeus.common.committee.impl.service.impl.CommitteeScheduleAttendanceServiceImplBase;
import org.kuali.kra.iacuc.committee.bo.IacucCommittee;
import org.kuali.kra.iacuc.committee.bo.IacucCommitteeSchedule;
import org.kuali.kra.iacuc.committee.document.CommonCommitteeDocument;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeScheduleAttendanceService;
import org.kuali.kra.iacuc.committee.service.IacucCommitteeService;

public class IacucCommitteeScheduleAttendanceServiceImpl extends 
                                                            CommitteeScheduleAttendanceServiceImplBase<IacucCommitteeService, IacucCommittee, CommonCommitteeDocument, IacucCommitteeSchedule> 
                                                         implements IacucCommitteeScheduleAttendanceService {

    @Override
    protected Class<CommonCommitteeDocument> getCommitteeDocumentClassBOHook() {
        return CommonCommitteeDocument.class;
    }

}
