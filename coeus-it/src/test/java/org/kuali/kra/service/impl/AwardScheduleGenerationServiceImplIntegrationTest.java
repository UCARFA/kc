/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 *
 * Copyright 2005-2018 Kuali, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kuali.kra.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardAmountInfo;
import org.kuali.kra.award.paymentreports.Frequency;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.kra.award.service.AwardScheduleGenerationService;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.PersistenceService;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

public class AwardScheduleGenerationServiceImplIntegrationTest extends KcIntegrationTestBase {

    private static final LocalDate START_DATE = LocalDate.of(2016, 7, 1);
    private static final LocalDate END_DATE = LocalDate.of(2019, 6, 30);
    private static final String PROJECT_START_FREQUENCY_BASE_CODE = "2";
    private static final String QUARTERLY_FREQUENCY_CODE = "3";

    private AwardScheduleGenerationService awardScheduleGenerationService;
    private BusinessObjectService businessObjectService;

    @Before
    public void setUp() throws Exception {
        awardScheduleGenerationService = KcServiceLocator.getService(AwardScheduleGenerationService.class);
        businessObjectService =  KcServiceLocator.getService(BusinessObjectService.class);
        ReflectionTestUtils.setField(awardScheduleGenerationService, "persistenceService", mock(PersistenceService.class));
    }

    @After
    public void tearDown() {
        ReflectionTestUtils.setField(awardScheduleGenerationService, "persistenceService", KcServiceLocator.getService(PersistenceService.class));
    }

    @Test
    public void testGetDatesHandlesDayOffsetsCorrectly() throws ParseException {
        List<Date> expectedDates = Arrays.asList(
                Date.valueOf(LocalDate.of(2016, 9, 16)),
                Date.valueOf(LocalDate.of(2016, 12, 17)),
                Date.valueOf(LocalDate.of(2017, 3, 17)),
                Date.valueOf(LocalDate.of(2017, 6, 16)),
                Date.valueOf(LocalDate.of(2017, 9, 16)),
                Date.valueOf(LocalDate.of(2017, 12, 17)),
                Date.valueOf(LocalDate.of(2018, 3, 17)),
                Date.valueOf(LocalDate.of(2018, 6, 16)),
                Date.valueOf(LocalDate.of(2018, 9, 16)),
                Date.valueOf(LocalDate.of(2018, 12, 17)),
                Date.valueOf(LocalDate.of(2019, 3, 17)),
                Date.valueOf(LocalDate.of(2019, 6, 16))
        );
        Award award = setupAward();
        List<java.util.Date> schedule = awardScheduleGenerationService.generateSchedules(award, award.getAwardReportTermItems(), true);
        assertFalse(schedule.isEmpty());
        assertEquals(expectedDates, schedule);
    }

    private Award setupAward() {
        Frequency frequency = new Frequency();
        frequency.setFrequencyCode(QUARTERLY_FREQUENCY_CODE);
        frequency.setRepeatFlag(true);
        frequency.setNumberOfMonths(3);
        frequency.setAdvanceNumberOfDays(15);
        AwardReportTerm term = new AwardReportTerm();
        term.setFrequency(frequency);
        term.setFrequencyCode(QUARTERLY_FREQUENCY_CODE);
        term.setFrequencyBaseCode(PROJECT_START_FREQUENCY_BASE_CODE);
        term.setReportCode("unimportant");
        Award award = new Award();
        award.setAwardEffectiveDate(Date.valueOf(START_DATE));
        award.setAwardExecutionDate(Date.valueOf(START_DATE));
        award.setProjectEndDate(Date.valueOf(END_DATE));
        award.setAwardReportTermItems(Collections.singletonList(term));
        AwardAmountInfo awardAmountInfo = new AwardAmountInfo();
        awardAmountInfo.setFinalExpirationDate(award.getProjectEndDate());
        award.setAwardAmountInfos(Collections.singletonList(awardAmountInfo));
        return award;
    }

}
