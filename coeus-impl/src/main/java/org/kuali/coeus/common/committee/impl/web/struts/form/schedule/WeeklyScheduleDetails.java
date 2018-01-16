/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.web.struts.form.schedule;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;



/**
 * This class holds weekly recurrence UI data.
 */
public class WeeklyScheduleDetails extends ScheduleDetails {
    
    private Integer week;
    
    private List<String> daysOfWeek;    
    
    public WeeklyScheduleDetails() {
        super();
        this.setWeek(1);
        this.daysOfWeek = new ArrayList<String>(2);
        this.daysOfWeek.add(DayOfWeek.Monday.name());
        this.daysOfWeek.add("Hidden");
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getWeek() {
        return week;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        this.daysOfWeek = (null != daysOfWeek? convertToWeekDays(daysOfWeek) : null);
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }
    
    private List<String> convertToWeekDays(List<String> daysOfWeek) {     
        if(daysOfWeek.size() == 1 && daysOfWeek.get(0).equalsIgnoreCase("Hidden"))
            return null;
        List<String> tmp = new ArrayList<String>(daysOfWeek.size() - 1);
        int i = 0;
        if(CollectionUtils.isNotEmpty(daysOfWeek)) {
            for(String dayOfWeek : daysOfWeek) {
                if(dayOfWeek.equalsIgnoreCase("Hidden"))
                    continue;
                tmp.add(dayOfWeek);
            }
        }
        return tmp;
    }
}
