/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.scheduling;

import org.kuali.coeus.sys.framework.scheduling.seq.ScheduleSequence;
import org.kuali.coeus.sys.framework.scheduling.util.CronSpecialChars;
import org.kuali.coeus.sys.framework.scheduling.util.Time24HrFmt;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface ScheduleService {

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, ScheduleSequence scheduleSequence)
            throws ParseException;

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param frequencyInDay
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, Integer frequencyInDay,
            ScheduleSequence scheduleSequence) throws ParseException;
    
    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param intervalInDays is the number of days in each repeating interval
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getIntervalInDaysScheduledDates(Date startDate, Date endDate, Time24HrFmt time, Integer intervalInDays) throws ParseException;

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param weekdays is array of CronSpecialChars containing week day values.
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, CronSpecialChars[] weekdays,
            ScheduleSequence scheduleSequence) throws ParseException;

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param day is day of month.
     * @param frequencyInMonth
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, Integer day, Integer frequencyInMonth,
            ScheduleSequence scheduleSequence) throws ParseException;
            
    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, ScheduleSequence scheduleSequence, Integer dayOfMonth) throws ParseException;

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param dayOfWeek is CronSpecialChars defining day of week.
     * @param weekOfMonth is CronSpecialChars defining week of month.
     * @param frequencyInMonth
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, CronSpecialChars dayOfWeek,
            CronSpecialChars weekOfMonth, Integer frequencyInMonth, ScheduleSequence scheduleSequence) throws ParseException;

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param month is CronSpecialChars defining month.
     * @param day is day of month.
     * @param frequencyInYear
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, CronSpecialChars month, Integer day,
            Integer frequencyInYear, ScheduleSequence scheduleSequence) throws ParseException;

    /**
     * This method must return schedule dates generated between provided parameters.
     * @param startDate is begin date.
     * @param endDate is end date.
     * @param time is time.
     * @param weekOfMonth is CronSpecialChars defining week of month.
     * @param dayOfWeek is CronSpecialChars defining day of week.
     * @param month is CronSpecialChars defining month.
     * @param frequencyInYear
     * @param scheduleSequence to used for generating sequence. If value passed is null, DefaultScheduleSequnce will be used.
     * @return List&lt;Date&gt; of date sequence generated.
     * @throws ParseException
     */
    public List<Date> getScheduledDates(Date startDate, Date endDate, Time24HrFmt time, CronSpecialChars weekOfMonth,
            CronSpecialChars dayOfWeek, CronSpecialChars month, Integer frequencyInYear, ScheduleSequence scheduleSequence)
            throws ParseException;

}
