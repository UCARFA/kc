/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.notification;

import org.kuali.coeus.common.committee.impl.bo.CommitteeBase;
import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;

public interface CommonCommitteeNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    public void setCommittee(CommitteeBase committee);
    public CommitteeBase getCommittee();
    
    public void setCommitteeSchedule(CommitteeScheduleBase committeeSchedule);
    public CommitteeScheduleBase getCommitteeSchedule();
        
}
