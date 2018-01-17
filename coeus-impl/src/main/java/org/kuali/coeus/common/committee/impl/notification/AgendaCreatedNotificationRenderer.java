/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.notification;

import org.apache.commons.lang3.StringUtils;
import org.kuali.coeus.common.committee.impl.meeting.ScheduleAgendaBase;

import java.util.Map;

/**
 * Renders additional fields for the Agenda Created notification.
 */
public class AgendaCreatedNotificationRenderer extends CommitteeNotificationRenderer {

    private static final long serialVersionUID = -6019679826378390076L;
    
    private String actionTaken;
    private ScheduleAgendaBase scheduleAgenda;

    public AgendaCreatedNotificationRenderer(ScheduleAgendaBase scheduleAgenda, String actionTaken) {
        super(scheduleAgenda.getCommitteeSchedule().getParentCommittee());
        this.scheduleAgenda = scheduleAgenda;
        this.actionTaken = actionTaken;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public ScheduleAgendaBase getScheduleAgenda() {
        return scheduleAgenda;
    }
    
    public void setScheduleAgenda(ScheduleAgendaBase scheduleAgenda) {
        this.scheduleAgenda = scheduleAgenda;
    }
    
    @Override
    public Map<String, String> getDefaultReplacementParameters() {
        Map<String, String> params = super.getDefaultReplacementParameters();
        params.put(CommitteeReplacementParameters.LAST_ACTION_DATE, scheduleAgenda.getCommitteeSchedule().getScheduledDate().toString());
        params.put(CommitteeReplacementParameters.ACTION_TAKEN, actionTaken);
        params.put(CommitteeReplacementParameters.OBJECT_INDEX, Integer.valueOf(scheduleAgenda.getAgendaNumber() - 1).toString());
        params.put(CommitteeReplacementParameters.SCHEDULE_ID, StringUtils.EMPTY + scheduleAgenda.getCommitteeSchedule().getId());
        return params;
    }    

}
