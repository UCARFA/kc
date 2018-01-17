/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.service.impl;

import org.kuali.coeus.common.committee.impl.service.impl.CommitteeScheduleAttendanceServiceImplBase;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.committee.document.CommitteeDocument;
import org.kuali.kra.committee.service.CommitteeScheduleAttendanceService;
import org.kuali.kra.committee.service.CommitteeService;


public class CommitteeScheduleAttendanceServiceImpl  extends CommitteeScheduleAttendanceServiceImplBase<CommitteeService, Committee, CommitteeDocument, CommitteeSchedule> 
                                                     implements CommitteeScheduleAttendanceService {

    @Override
    protected Class<CommitteeDocument> getCommitteeDocumentClassBOHook() {
        return CommitteeDocument.class;
    }
    
}
