/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.notification;

import org.kuali.coeus.common.notification.impl.service.KcNotificationRoleQualifierService;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;

public interface CommitteeNotificationRoleQualifierService extends KcNotificationRoleQualifierService {

    public void setCommittee(Committee committee);
    public Committee getCommittee();
    
    public void setCommitteeSchedule(CommitteeSchedule committeeSchedule);
    public CommitteeSchedule getCommitteeSchedule();
        
}
