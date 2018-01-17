/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.meeting;


/**
 * 
 * This class is meeting generated agenda doc.
 */
public abstract class ScheduleAgendaBase extends GeneratedMeetingDocBase {

    private static final long serialVersionUID = -3448403457020324952L;

    private Long scheduleAgendaId;

    private Integer agendaNumber;

    private String agendaName;

    public ScheduleAgendaBase() {
    }

    public Long getScheduleAgendaId() {
        return scheduleAgendaId;
    }

    public void setScheduleAgendaId(Long scheduleAgendaId) {
        this.scheduleAgendaId = scheduleAgendaId;
    }

    public Integer getAgendaNumber() {
        return agendaNumber;
    }

    public void setAgendaNumber(Integer agendaNumber) {
        this.agendaNumber = agendaNumber;
    }

    public String getAgendaName() {
        return agendaName;
    }

    public void setAgendaName(String agendaName) {
        this.agendaName = agendaName;
    }
}
