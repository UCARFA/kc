/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.committee.impl.bo;

import org.kuali.rice.krad.datadictionary.AttributeReference;


public class CommitteeScheduleAttributeReferenceDummy extends AttributeReference {

    private static final long serialVersionUID = 4004201645215456568L;

    private Integer intValue;
    
    private Integer dayRecurrence;
    
    private Integer weekRecurrence;
    
    private Integer monthDay;
    
    private Integer monthRecurrence;
    
    private Integer yearDay;
    
    private Integer yearRecurrence;
    
    private String monthsWeek;
    
    private String weekDay;
    
    private String month;
    
    private String time;
    
    private String meridiem;
    
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public Integer getDayRecurrence() {
        return dayRecurrence;
    }

    public void setDayRecurrence(Integer dayRecurrence) {
        this.dayRecurrence = dayRecurrence;
    }

    public Integer getWeekRecurrence() {
        return weekRecurrence;
    }

    public void setWeekRecurrence(Integer weekRecurrence) {
        this.weekRecurrence = weekRecurrence;
    }

    public Integer getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(Integer monthDay) {
        this.monthDay = monthDay;
    }

    public Integer getMonthRecurrence() {
        return monthRecurrence;
    }

    public void setMonthRecurrence(Integer monthRecurrence) {
        this.monthRecurrence = monthRecurrence;
    }

    public Integer getYearDay() {
        return yearDay;
    }

    public void setYearDay(Integer yearDay) {
        this.yearDay = yearDay;
    }

    public Integer getYearRecurrence() {
        return yearRecurrence;
    }

    public void setYearRecurrence(Integer yearRecurrence) {
        this.yearRecurrence = yearRecurrence;
    }

    public void setMonthsWeek(String monthsWeek) {
        this.monthsWeek = monthsWeek;
    }

    public String getMonthsWeek() {
        return monthsWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMeridiem() {
        return meridiem;
    }

    public void setMeridiem(String meridiem) {
        this.meridiem = meridiem;
    }



}
