/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.service.impl;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.sys.framework.scheduling.ScheduleService;
import org.kuali.coeus.sys.framework.scheduling.seq.ScheduleSequence;
import org.kuali.coeus.sys.framework.scheduling.util.Time24HrFmt;
import org.kuali.kra.award.AwardAmountInfoServiceImpl;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.paymentreports.Frequency;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.kra.award.paymentreports.paymentschedule.FrequencyBaseConstants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;

import java.sql.Date;
import java.text.ParseException;
import java.util.*;


@RunWith(JMock.class)
public class AwardScheduleGenerationServiceImplTest extends AwardAmountInfoSetUpTestBase {
    
    private static final int START_DATE_YEAR_2009 = 2009;
    private static final int START_DATE_YEAR_2011 = 2011;
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int ZERO = 0;
    private static final int FIFTEEN_DAYS = 15;
    private static final int THIRTY_DAYS = 30;
    private static final int THREE_MONTHS = 3;
    private static final String ZERO_HOURS = "00:00";
    private static final String REPORT_CLASS_CODE_CODE_SIX = "6";    
    private static final String PERIOD_IN_YEARS = "1";
    private static final String SF_269_EXPENDITURE_REPORT_CODE = "33";
    
    Award award;
    AwardReportTerm newAwardReportTerm;
    Frequency frequency;
    AwardScheduleGenerationServiceImpl awardScheduleGenerationServiceImpl;
    Calendar calendar;
    Calendar calendar1;
    Map<String, java.util.Date> mapOfDates;
    
    private Mockery context = new JUnit4Mockery() {{ setThreadingPolicy(new Synchroniser()); }};
    
    @Before
    public void setUp() throws Exception {
        award = new Award();
        MockGlobalVariableService globalVariableService = new MockGlobalVariableService();
        globalVariableService.setUserSession(new MockUserSession("quickstart"));
        award.getAwardAmountInfos().get(0).setGlobalVariableService(globalVariableService);
        frequency = new Frequency();
        newAwardReportTerm = new AwardReportTerm();
        awardScheduleGenerationServiceImpl = new AwardScheduleGenerationServiceImpl();
        awardScheduleGenerationServiceImpl.setAwardAmountInfoService(new AwardAmountInfoServiceImpl());
        calendar = new GregorianCalendar();
        calendar1 = new GregorianCalendar();
        setMapOfDatesOnAward(award);
        mapOfDates = new HashMap<>();
        awardScheduleGenerationServiceImpl.initializeDatesForThisAward(award, mapOfDates);
        
    }

    @After
    public void tearDown() throws Exception {
        frequency = null;
        newAwardReportTerm = null;
        awardScheduleGenerationServiceImpl = null;
        newAwardReportTerm = null;
        calendar = null;
        calendar1 = null;
    }


    
    public void setMapOfDatesOnAward(Award award){
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.APRIL, FIRST_DAY_OF_MONTH);
        award.setAwardEffectiveDate(new java.sql.Date(calendar.getTimeInMillis()));
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.MAY, FIRST_DAY_OF_MONTH);
        award.setAwardExecutionDate(new java.sql.Date(calendar.getTimeInMillis()));
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.SEPTEMBER, FIRST_DAY_OF_MONTH);
        award.setProjectEndDate(new java.sql.Date(calendar.getTimeInMillis()));
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.JUNE, FIRST_DAY_OF_MONTH);
        award.setAwardEffectiveDate(new java.sql.Date(calendar.getTimeInMillis()));
    }
    
    @Test
    public final void testGetStartDate(){
        // test Execution Date as the start Date
        newAwardReportTerm.setFrequencyBaseCode(FrequencyBaseConstants.AWARD_EXECUTION_DATE.getfrequencyBase());
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.MAY, FIRST_DAY_OF_MONTH);
        
        newAwardReportTerm.setFrequency(frequency);
        newAwardReportTerm.setAward(award);
        newAwardReportTerm.setDueDate(new Date(calendar.getTimeInMillis()));
        
        java.util.Date startDate = awardScheduleGenerationServiceImpl.getStartDate(newAwardReportTerm, mapOfDates);
        
        Assert.assertEquals(calendar.getTime(), startDate);
        
        // Test Project Start Date as the start date
        newAwardReportTerm.setFrequencyBaseCode(FrequencyBaseConstants.AWARD_EFFECTIVE_DATE.getfrequencyBase());
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.JUNE, FIRST_DAY_OF_MONTH);
        
        newAwardReportTerm.setFrequency(frequency);
        newAwardReportTerm.setAward(award);
        newAwardReportTerm.setDueDate(new Date(calendar.getTimeInMillis()));
        
        startDate = awardScheduleGenerationServiceImpl.getStartDate(newAwardReportTerm, mapOfDates);
        
        Assert.assertEquals(calendar.getTime(), startDate);
        
    }
    
    @Test
    public final void testGetEndDate(){
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.JULY, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);

        final ParameterService parameterService = context.mock(ParameterService.class);

        context.checking(new Expectations() {{
            oneOf(parameterService).getParameterValueAsString(AwardDocument.class, KeyConstants.PERIOD_IN_YEARS_WHEN_FREQUENCY_BASE_IS_FINAL_EXPIRATION_DATE);will(returnValue(PERIOD_IN_YEARS));
        }});
        awardScheduleGenerationServiceImpl.setParameterService(parameterService);
        AwardReportTerm awardReportTerm = new AwardReportTerm();
        awardReportTerm.setFrequencyBaseCode(FrequencyBaseConstants.FINAL_EXPIRATION_DATE.getfrequencyBase());
        java.util.Date endDate = awardScheduleGenerationServiceImpl.getEndDate(awardReportTerm, calendar.getTime(), mapOfDates);
        calendar.add(Calendar.YEAR, 1);
        Assert.assertEquals(calendar.getTime(),endDate);

        awardReportTerm.setFrequencyBaseCode(FrequencyBaseConstants.AWARD_EFFECTIVE_DATE.getfrequencyBase());
        endDate = awardScheduleGenerationServiceImpl.getEndDate(awardReportTerm, calendar.getTime(), mapOfDates);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.SEPTEMBER, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        Assert.assertEquals(calendar.getTime(),endDate);
    }
    
    @Test
    public final void testGetUpdatedStartDate(){
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.JULY, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2009, Calendar.JULY, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(null);
        java.util.Date startDate = awardScheduleGenerationServiceImpl.getStartDateFromTheBaseDate(calendar, frequency);
        Assert.assertEquals(calendar1.getTime(),startDate);
        
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.JULY, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2009, Calendar.JULY, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(THREE_MONTHS);
        startDate = awardScheduleGenerationServiceImpl.getStartDateFromTheBaseDate(calendar, frequency);
        calendar1.add(Calendar.MONTH, -THREE_MONTHS);
        Assert.assertEquals(calendar1.getTime(),startDate);
    }
    
    @Test
    public final void testAddOffSetMonthsToStartDate(){
        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(THREE_MONTHS);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        frequency.setAdvanceNumberOfMonths(THREE_MONTHS);
        awardScheduleGenerationServiceImpl.addOffSetMonthsToStartDate(frequency, calendar);
        calendar1.add(Calendar.MONTH, -THREE_MONTHS);
        Assert.assertEquals(calendar1.getTime(),calendar.getTime());

        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(null);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);

        awardScheduleGenerationServiceImpl.addOffSetMonthsToStartDate(frequency, calendar);
        Assert.assertEquals(calendar1.getTime(),calendar.getTime());
    }

    @Test
    public final void testOffsetDateByFrequencyDays(){
        frequency.setNumberOfDays(THIRTY_DAYS);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(null);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        frequency.setNumberOfDays(THIRTY_DAYS);
        calendar1.add(Calendar.DAY_OF_YEAR, THIRTY_DAYS);
        Assert.assertEquals(calendar1.getTime(), awardScheduleGenerationServiceImpl.offsetDateByFrequencyDays(frequency, calendar.getTime()));

        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(THIRTY_DAYS);
        frequency.setAdvanceNumberOfMonths(null);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        frequency.setAdvanceNumberOfDays(THIRTY_DAYS);
        calendar1.add(Calendar.DAY_OF_YEAR, -THIRTY_DAYS);
        Assert.assertEquals(calendar1.getTime(), awardScheduleGenerationServiceImpl.offsetDateByFrequencyDays(frequency, calendar.getTime()));

        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(null);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);

        Assert.assertEquals(calendar1.getTime(), awardScheduleGenerationServiceImpl.offsetDateByFrequencyDays(frequency, calendar.getTime()));
    }
    
    @Test
    public void testAddNumberOfMonthsToStartDate(){
        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(THREE_MONTHS);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(null);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        awardScheduleGenerationServiceImpl.addNumberOfMonthsToStartDate(frequency, calendar);
        calendar1.add(Calendar.MONTH, THREE_MONTHS);
        Assert.assertEquals(calendar1.getTime(),calendar.getTime());
        
        frequency.setNumberOfDays(null);
        frequency.setNumberOfMonths(null);
        frequency.setAdvanceNumberOfDays(null);
        frequency.setAdvanceNumberOfMonths(null);
        calendar.clear();
        calendar.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        calendar1.clear();
        calendar1.set(START_DATE_YEAR_2011, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        awardScheduleGenerationServiceImpl.addNumberOfMonthsToStartDate(frequency, calendar);        
        Assert.assertEquals(calendar1.getTime(),calendar.getTime());
    }
    
    @Test
    public void testGetDatesSuccessCaseWhenRepeatFlagIsTrue() throws ParseException{        
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.DECEMBER, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        final java.util.Date START_DATE = calendar.getTime();
        final int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.YEAR, 1);
        final java.util.Date END_DATE = calendar.getTime();
        final List<java.util.Date> DATES = new ArrayList<java.util.Date>();
        DATES.add(START_DATE);
        
        frequency.setRepeatFlag(true);
        frequency.setNumberOfMonths(THREE_MONTHS);
        
        newAwardReportTerm = new AwardReportTerm();
        newAwardReportTerm.setFrequency(frequency);
        newAwardReportTerm.setReportClassCode(REPORT_CLASS_CODE_CODE_SIX);
        newAwardReportTerm.setFrequencyBaseCode(FrequencyBaseConstants.FINAL_EXPIRATION_DATE.getfrequencyBase());
        newAwardReportTerm.setReportCode(SF_269_EXPENDITURE_REPORT_CODE);
        
        final ScheduleService scheduleService = context.mock(ScheduleService.class);
        final ParameterService parameterService = context.mock(ParameterService.class);
        
        context.checking(new Expectations() {{
            oneOf(scheduleService).getScheduledDates(with(equal(START_DATE)), with(equal(END_DATE)), with(equal(new Time24HrFmt(ZERO_HOURS)))
                    , with(any(ScheduleSequence.class)), with(equal(DAY_OF_MONTH)));will(returnValue(DATES));
        }});
        
        context.checking(new Expectations() {{
            oneOf(parameterService).getParameterValueAsString(AwardDocument.class, KeyConstants.PERIOD_IN_YEARS_WHEN_FREQUENCY_BASE_IS_FINAL_EXPIRATION_DATE);will(returnValue(PERIOD_IN_YEARS));
        }});
                        
        awardScheduleGenerationServiceImpl.setScheduleService(scheduleService);
        awardScheduleGenerationServiceImpl.setParameterService(parameterService);
        
        Assert.assertEquals(DATES, awardScheduleGenerationServiceImpl.getDates(newAwardReportTerm, mapOfDates,0));
    }
    
    @Test
    public void testGetDatesSuccessCaseWhenRepeatFlagIsFalse() throws ParseException {
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.AUGUST, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);
        final java.util.Date START_DATE = calendar.getTime();
        final int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.YEAR, 1);
        final java.util.Date END_DATE = calendar.getTime();
        final List<java.util.Date> DATES = new ArrayList<java.util.Date>();
        DATES.add(START_DATE);
        
        frequency.setRepeatFlag(false);
        frequency.setNumberOfMonths(THREE_MONTHS);
        
        newAwardReportTerm = new AwardReportTerm();
        newAwardReportTerm.setFrequency(frequency);
        newAwardReportTerm.setReportClassCode(REPORT_CLASS_CODE_CODE_SIX);
        newAwardReportTerm.setFrequencyBaseCode(FrequencyBaseConstants.AWARD_EXECUTION_DATE.getfrequencyBase());
        newAwardReportTerm.setReportCode(SF_269_EXPENDITURE_REPORT_CODE);
        
        final ScheduleService scheduleService = context.mock(ScheduleService.class);
        
        context.checking(new Expectations() {{
            never(scheduleService).getScheduledDates(with(equal(START_DATE)), with(equal(END_DATE)), with(equal(new Time24HrFmt(ZERO_HOURS)))
                , with(any(ScheduleSequence.class)),with(equal(DAY_OF_MONTH)));will(returnValue(DATES));
        }});
        
        awardScheduleGenerationServiceImpl.setScheduleService(scheduleService);        
        Assert.assertEquals(DATES, awardScheduleGenerationServiceImpl.getDates(newAwardReportTerm, mapOfDates,0));
    }

    @Test
    public void testGetEndDateWithOffsetAfterFinalExpirationDate() {
        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.SEPTEMBER, FIRST_DAY_OF_MONTH);
        calendar.add(Calendar.MONTH, 3);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        java.util.Date expectedEndDate = calendar.getTime();

        calendar.clear();
        calendar.set(START_DATE_YEAR_2009, Calendar.JULY, FIRST_DAY_OF_MONTH,ZERO,ZERO,ZERO);

        Frequency quarterly30After = new Frequency();
        quarterly30After.setNumberOfMonths(3);
        quarterly30After.setNumberOfDays(30);
        quarterly30After.setRepeatFlag(true);
        quarterly30After.setActive(true);

        AwardReportTerm awardReportTerm = new AwardReportTerm();
        awardReportTerm.setFrequency(quarterly30After);
        awardReportTerm.setFrequencyBaseCode("As Required");

        java.util.Date endDate = awardScheduleGenerationServiceImpl.getEndDate(awardReportTerm, calendar.getTime(), mapOfDates);
        Assert.assertEquals(expectedEndDate,endDate);
    }
    
}
