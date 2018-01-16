/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.iacuc.committee.rule.event;

import org.kuali.coeus.common.committee.impl.bo.CommitteeScheduleBase;
import org.kuali.coeus.common.committee.impl.document.CommitteeDocumentBase;
import org.kuali.coeus.common.committee.impl.rule.event.DeleteCommitteeScheduleEventBase;
import org.kuali.coeus.common.committee.impl.rules.DeleteCommitteeScheduleRuleBase;
import org.kuali.coeus.common.committee.impl.web.struts.form.schedule.ScheduleData;
import org.kuali.kra.iacuc.committee.rules.IacucDeleteCommitteeScheduleRule;
import org.kuali.rice.krad.document.Document;

import java.util.List;

public class IacucDeleteCommitteeScheduleEvent extends DeleteCommitteeScheduleEventBase {

    public IacucDeleteCommitteeScheduleEvent(String errorPathPrefix, CommitteeDocumentBase document, ScheduleData scheduleData, List<CommitteeScheduleBase> committeeSchedules, ErrorType type) {
        super(errorPathPrefix, document, scheduleData, committeeSchedules, type);
    }

    
    public IacucDeleteCommitteeScheduleEvent(String errorPathPrefix, Document document, ScheduleData scheduleData, List<CommitteeScheduleBase> committeeSchedules, ErrorType type) {
        this(errorPathPrefix, (CommitteeDocumentBase) document, scheduleData, committeeSchedules, type);
    }

    @Override
    protected DeleteCommitteeScheduleRuleBase getNewDeleteCommitteeScheduleRuleInstanceHook() {
        return new IacucDeleteCommitteeScheduleRule();
    }

}
