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

package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.AwardConstants;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.award.paymentreports.ReportClass;
import org.kuali.kra.award.paymentreports.ReportStatus;
import org.kuali.kra.award.paymentreports.awardreports.AwardReportTerm;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.kra.award.service.AwardScheduleGenerationService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.LegacyAppFrameworkAdapterService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingServiceImpl.DESCRIPTION;
import static org.kuali.kra.award.paymentreports.awardreports.reporting.service.ReportTrackingServiceImpl.PENDING_STATUS_DESCRIPTION;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@PrepareForTest(KNSServiceLocator.class)
@RunWith(PowerMockRunner.class)
public class ReportTrackingServiceImplTest {

    private static final LocalDate START_DATE = LocalDate.of(2018, 1, 1);
    private static final Period MONTHLY = Period.ofMonths(1);
    private static final Period QUARTERLY = Period.ofMonths(3);
    private static final Period ANNUAL = Period.ofYears(1);

    @Mock
    private AwardScheduleGenerationService awardScheduleGenerationService;
    @Mock
    private BusinessObjectService businessObjectService;

    @InjectMocks
    private ReportTrackingServiceImpl reportTrackingService;

    @Before
    public void setup() {
        PowerMockito.mockStatic(KNSServiceLocator.class);
        when(KNSServiceLocator.getLegacyAppFrameworkAdapterService()).thenReturn(mock(LegacyAppFrameworkAdapterService.class));

        when(businessObjectService.findByPrimaryKey(eq(ReportStatus.class), eq(Collections.singletonMap(DESCRIPTION, PENDING_STATUS_DESCRIPTION))))
                .thenReturn(new ReportStatus());
    }

    @Test
    public void reportTrackingServiceCreatesNewTrackingEntriesWhenNoneExist() throws Exception {
        Award award = setupAward(createTerm());
        when(awardScheduleGenerationService.generateSchedules(award, award.getAwardReportTermItems(), true))
                .thenReturn(generateScheduleDates(START_DATE, LocalDate.of(2019, 1, 1), MONTHLY));
        reportTrackingService.generateReportTrackingAndSave(award, true);
        assertEquals(12, award.getAwardReportTermItems().get(0).getReportTrackings().size());
        verify(businessObjectService).save(award.getAwardReportTermItems().get(0).getReportTrackings());
        verify(businessObjectService).delete(Collections.emptyList());
    }

    @Test
    public void reportTrackingServiceDeletesTrackingEntriesThatDontMatchSchedule() throws Exception {
        Award award = setupAward(createTerm());
        when(awardScheduleGenerationService.generateSchedules(award, award.getAwardReportTermItems(), true))
                .thenReturn(generateScheduleDates(START_DATE, LocalDate.of(2020, 1, 1), MONTHLY));
        reportTrackingService.generateReportTrackingAndSave(award, true);
        assertEquals(24, award.getAwardReportTermItems().get(0).getReportTrackings().size());
        clearInvocations(businessObjectService);

        List<Date> scheduleDates = generateScheduleDates(START_DATE, LocalDate.of(2020, 3, 1), QUARTERLY);
        when(awardScheduleGenerationService.generateSchedules(award, award.getAwardReportTermItems(), true))
                .thenReturn(scheduleDates);
        List<ReportTracking> expectedDeletes = award.getAwardReportTermItems().get(0).getReportTrackings().stream()
                .filter(tracking -> !scheduleDates.contains(tracking.getDueDate()))
                .collect(Collectors.toList());
        reportTrackingService.generateReportTrackingAndSave(award, true);
        assertEquals(8, award.getAwardReportTermItems().get(0).getReportTrackings().size());
        verify(businessObjectService).save(award.getAwardReportTermItems().get(0).getReportTrackings());
        verify(businessObjectService).delete(expectedDeletes);
    }

    @Test
    public void reportTrackingServicePreservesDatesWhenScheduleChanges() throws Exception {
        Award award = setupAward(createTerm());
        when(awardScheduleGenerationService.generateSchedules(award, award.getAwardReportTermItems(), true))
                .thenReturn(generateScheduleDates(START_DATE, LocalDate.of(2021, 1, 1), ANNUAL));
        reportTrackingService.generateReportTrackingAndSave(award, true);
        assertEquals(3, award.getAwardReportTermItems().get(0).getReportTrackings().size());
        clearInvocations(businessObjectService);

        String savedComment1 = "This entry should remain after schedule changes";
        String savedComment2 = "So should this one";
        String deletedComment = "This one will not";
        String preparerName = "tester";
        java.sql.Date activityDate = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2018").getTime());

        ReportTracking firstTracking = award.getAwardReportTermItems().get(0).getReportTrackings().get(2);
        firstTracking.setComments(savedComment1);
        firstTracking.setPreparerName(preparerName);
        firstTracking.setActivityDate(activityDate);

        ReportTracking secondTracking = award.getAwardReportTermItems().get(0).getReportTrackings().get(1);
        secondTracking.setComments(savedComment2);

        ReportTracking thirdTracking = award.getAwardReportTermItems().get(0).getReportTrackings().get(0);
        thirdTracking.setComments(deletedComment);

        when(awardScheduleGenerationService.generateSchedules(award, award.getAwardReportTermItems(), true))
                .thenReturn(generateScheduleDates(START_DATE, LocalDate.of(2020, 3, 1), QUARTERLY));
        reportTrackingService.generateReportTrackingAndSave(award, true);
        assertEquals(8, award.getAwardReportTermItems().get(0).getReportTrackings().size());
        assertEquals(savedComment1, award.getAwardReportTermItems().get(0).getReportTrackings().get(4).getComments());
        assertEquals(preparerName, award.getAwardReportTermItems().get(0).getReportTrackings().get(4).getPreparerName());
        assertEquals(activityDate, award.getAwardReportTermItems().get(0).getReportTrackings().get(4).getActivityDate());
        assertNotNull(award.getAwardReportTermItems().get(0).getReportTrackings().get(4).getLastUpdateDate());
        assertEquals(savedComment2, award.getAwardReportTermItems().get(0).getReportTrackings().get(0).getComments());
        assertNotNull(award.getAwardReportTermItems().get(0).getReportTrackings().get(0).getLastUpdateDate());
        assertTrue(award.getAwardReportTermItems().get(0).getReportTrackings().stream()
                .map(ReportTracking::getComments)
                .noneMatch(deletedComment::equals));
        verify(businessObjectService).save(award.getAwardReportTermItems().get(0).getReportTrackings());
        verify(businessObjectService).delete(Collections.singletonList(thirdTracking));
    }

    private AwardReportTerm createTerm(ReportTracking... reportTrackings) {
        AwardReportTerm term = new AwardReportTerm();
        ReportClass reportClass = new ReportClass();
        reportClass.setGenerateReportRequirements(true);
        term.setReportClass(reportClass);
        term.setReportTrackings(Arrays.stream(reportTrackings)
                .peek(tracking -> tracking.setAwardReportTermId(term.getAwardReportTermId()))
                .collect(Collectors.toList()));
        return term;
    }

    private Award setupAward(AwardReportTerm... terms) {
        Award award = new Award();
        award.setAwardNumber("123456" + AwardConstants.ROOT_AWARD_SUFFIX);
        award.setAwardId(1L);
        award.setTitle("report tracking test");

        Unit leadUnit = new Unit();
        leadUnit.setUnitNumber("UN-TEST");
        award.setLeadUnit(leadUnit);

        AwardPerson pi = new AwardPerson();
        pi.setContactRoleCode(ContactRole.PI_CODE);
        award.setPrincipalInvestigatorName("Tester, Joe");
        award.getProjectPersons().add(pi);

        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorCode("sponsor");
        award.setSponsor(sponsor);

        award.setAwardReportTermItems(Arrays.stream(terms)
                .peek(term -> term.setAward(award))
                .collect(Collectors.toList()));

        return award;
    }

    private List<Date> generateScheduleDates(LocalDate startDate, LocalDate endDate, Period schedule) {
        List<Date> dates = new ArrayList<>();
        LocalDate nextDate = startDate.plus(schedule);
        while(!nextDate.isAfter(endDate)) {
            dates.add(Date.from(nextDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            nextDate = nextDate.plus(schedule);
        }
        return dates;
    }

}