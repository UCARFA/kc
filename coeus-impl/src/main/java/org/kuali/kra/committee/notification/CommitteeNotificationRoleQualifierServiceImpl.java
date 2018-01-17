/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.committee.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.notification.impl.bo.NotificationModuleRoleQualifier;
import org.kuali.kra.committee.bo.Committee;
import org.kuali.kra.committee.bo.CommitteeSchedule;
import org.kuali.kra.kim.bo.KcKimAttributes;


public class CommitteeNotificationRoleQualifierServiceImpl implements CommitteeNotificationRoleQualifierService {

    private Committee committee;
    private CommitteeSchedule committeeSchedule;
    
    @Override
    public String getRoleQualifierValue(NotificationModuleRoleQualifier qualifier) {
        String qName = qualifier.getQualifier();
        String qVal = null;
        if (StringUtils.equalsIgnoreCase(qName, KcKimAttributes.COMMITTEE)) {
            qVal = committee.getCommitteeId();
        }
        else if (StringUtils.equalsIgnoreCase(qName, KcKimAttributes.COMMITTEESCHEDULE)) {
            qVal = committeeSchedule.getScheduleId();
        }
        return qVal;
    }

    @Override
    public Committee getCommittee() {
        return committee;
    }

    @Override
    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

    @Override
    public CommitteeSchedule getCommitteeSchedule() {
        return committeeSchedule;
    }

    @Override
    public void setCommitteeSchedule(CommitteeSchedule committeeSchedule) {
        this.committeeSchedule = committeeSchedule;
    }

}
