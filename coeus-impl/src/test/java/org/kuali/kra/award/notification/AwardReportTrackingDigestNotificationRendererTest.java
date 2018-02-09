/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.award.notification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.contacts.AwardPersonUnit;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.Award;
import org.kuali.kra.award.home.ContactRole;
import org.kuali.kra.award.paymentreports.Report;
import org.kuali.kra.award.paymentreports.ReportClass;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.rice.core.api.CoreApiServiceLocator;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.kns.service.KNSServiceLocator;
import org.kuali.rice.krad.service.LegacyAppFrameworkAdapterService;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@PrepareForTest({ CoreApiServiceLocator.class, KNSServiceLocator.class })
@RunWith(PowerMockRunner.class)
public class AwardReportTrackingDigestNotificationRendererTest {

    private static final String RENDER_TEMPLATE = "{BEGIN_DIGEST_TABLE}<table><tr>" +
            "<th>Award Number</th>" +
            "<th>Sponsor</th>" +
            "<th>Sponsor Award Number</th>" +
            "<th>Award Title</th>" +
            "<th>PI</th>" +
            "<th>Unit</th>" +
            "<th>Account Number</th>" +
            "<th>Report Class</th>" +
            "<th>Report Type</th>" +
            "<th>Due Date</th>" +
            "</tr>{BEGIN_REPEAT_SECTION}<tr>" +
            "<td>{AWARD_NUMBER}</td>" +
            "<td>{SPONSOR_NAME}</td>" +
            "<td>{SPONSOR_AWARD_NUMBER}</td>" +
            "<td>{AWARD_TITLE}</td>" +
            "<td>{PI_NAME}</td>" +
            "<td>{LEAD_UNIT_NAME}</td>" +
            "<td>{ACCOUNT_NUMBER}</td>" +
            "<td>{REPORT_CLASS}</td>" +
            "<td>{REPORT_TYPE}</td>" +
            "<td>{REPORT_DUE_DATE}</td>" +
            "</tr>{END_REPEAT_SECTION}</table>{END_DIGEST_TABLE}";

    private static final Map<String, String> REPORT_CLASS_CODE_TO_DESCRIPTION;
    static {
        Map<String, String> reportClassCodeMap = new HashMap<>();
        reportClassCodeMap.put("1", "Financial");
        reportClassCodeMap.put("3", "Intellectual Property");
        reportClassCodeMap.put("6", "Payment/Invoice");
        REPORT_CLASS_CODE_TO_DESCRIPTION = Collections.unmodifiableMap(reportClassCodeMap);
    }

    private static final Map<String, String> REPORT_CODE_TO_DESCRIPTION;
    static {
        Map<String, String> reportCodeMap = new HashMap<>();
        reportCodeMap.put("1", "Executive Summary");
        reportCodeMap.put("2", "SF 269 Expenditure Report");
        reportCodeMap.put("3", "Payment");
        REPORT_CODE_TO_DESCRIPTION = Collections.unmodifiableMap(reportCodeMap);
    }

    private AwardReportTrackingDigestNotificationRenderer renderer;

    @Before
    public void setup() {
        ConfigurationService configurationServiceMock = mock(ConfigurationService.class);
        when(configurationServiceMock.getPropertyValueAsString(anyString())).thenReturn("");
        mockStatic(CoreApiServiceLocator.class);
        when(CoreApiServiceLocator.getKualiConfigurationService()).thenReturn(configurationServiceMock);

        mockStatic(KNSServiceLocator.class);
        when(KNSServiceLocator.getLegacyAppFrameworkAdapterService()).thenReturn(mock(LegacyAppFrameworkAdapterService.class));
    }

    @Test
    public void testDueAndOverdueReportDigest() {
        final String expectedRenderedOutput = "<h3>OVERDUE</h3>" +
                "<table><tr><th>Award Number</th><th>Sponsor</th><th>Sponsor Award Number</th><th>Award Title</th><th>PI</th><th>Unit</th><th>Account Number</th><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>" +
                "<tr><td>000001-00001</td><td>Free Money</td><td>000001-0000S</td><td>TEST TITLE</td><td>I. M. Poster</td><td>College University</td><td></td><td>Intellectual Property</td><td>Executive Summary</td><td>10/05/2017</td></tr></table>" +
                "<h3>DUE</h3>" +
                "<table><tr><th>Award Number</th><th>Sponsor</th><th>Sponsor Award Number</th><th>Award Title</th><th>PI</th><th>Unit</th><th>Account Number</th><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>" +
                "<tr><td>000001-00001</td><td>Free Money</td><td>000001-0000S</td><td>TEST TITLE</td><td>I. M. Poster</td><td>College University</td><td></td><td>Payment/Invoice</td><td>SF 269 Expenditure Report</td><td>02/05/2018</td></tr>" +
                "<tr><td>000001-00001</td><td>Free Money</td><td>000001-0000S</td><td>TEST TITLE</td><td>I. M. Poster</td><td>College University</td><td></td><td>Financial</td><td>Executive Summary</td><td>04/05/2018</td></tr>" +
                "<tr><td>000001-00001</td><td>Free Money</td><td>000001-0000S</td><td>TEST TITLE</td><td>I. M. Poster</td><td>College University</td><td></td><td>Payment/Invoice</td><td>Payment</td><td>05/05/2018</td></tr></table>";
        final LocalDate comparisonDate = LocalDate.of(2018, 1, 5);
        renderer = new AwardReportTrackingDigestNotificationRenderer();
        renderer.setComparisonDate(comparisonDate);
        renderer.setDigestReports(getReports(comparisonDate));
        Assert.assertEquals(expectedRenderedOutput, renderer.render(RENDER_TEMPLATE));
    }

    @Test
    public void testOverdueOnlyReportDigest() {
        final String expectedRenderedOutput = "<h3>OVERDUE</h3>" +
                "<table><tr><th>Award Number</th><th>Sponsor</th><th>Sponsor Award Number</th><th>Award Title</th><th>PI</th><th>Unit</th><th>Account Number</th><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>" +
                "<tr><td>000001-00001</td><td>Free Money</td><td>000001-0000S</td><td>TEST TITLE</td><td>I. M. Poster</td><td>College University</td><td></td><td>Intellectual Property</td><td>Executive Summary</td><td>10/05/2017</td></tr></table>";
        final LocalDate comparisonDate = LocalDate.of(2018, 1, 5);
        renderer = new AwardReportTrackingDigestNotificationRenderer();
        renderer.setComparisonDate(comparisonDate);
        renderer.setDigestReports(getReports(comparisonDate));
        renderer.setIncludeDue(false);
        Assert.assertEquals(expectedRenderedOutput, renderer.render(RENDER_TEMPLATE));
    }

    private List<ReportTracking> getReports(LocalDate relativeDate) {
        return Arrays.asList(
                getReportTracking("6", "3", relativeDate.plus(4, ChronoUnit.MONTHS)),
                getReportTracking("1", "1", relativeDate.plus(3, ChronoUnit.MONTHS)),
                getReportTracking("6", "2", relativeDate.plus(1, ChronoUnit.MONTHS)),
                getReportTracking("3", "1", relativeDate.minus(3, ChronoUnit.MONTHS))
        );
    }

    private ReportTracking getReportTracking(String reportClassCode, String reportCode, LocalDate dueDate) {
        ReportTracking reportTracking = new ReportTracking();
        ReportClass reportClass = new ReportClass();
        reportClass.setReportClassCode(reportClassCode);
        reportClass.setDescription(REPORT_CLASS_CODE_TO_DESCRIPTION.get(reportClassCode));
        reportTracking.setReportClass(reportClass);
        reportTracking.setReportClassCode(reportClassCode);
        Report report = new Report();
        report.setReportCode(reportCode);
        report.setDescription(REPORT_CODE_TO_DESCRIPTION.get(reportCode));
        reportTracking.setReport(report);
        reportTracking.setReportCode(reportCode);
        reportTracking.setDueDate(Date.valueOf(dueDate));
        reportTracking.setAward(getAward());
        reportTracking.setPiName(reportTracking.getAward().getPrincipalInvestigatorName());
        return reportTracking;
    }

    private Award getAward() {
        Award award = new Award() {
            @Override
            public Integer getIndexOfAwardAmountInfoForDisplay() {
                return 0;
            }
        };
        award.getAwardAmountInfos().add(null);
        award.setAwardNumber("000001-00001");
        award.setAwardId(1L);
        Unit unit = new Unit();
        unit.setUnitNumber("CO-UNIV");
        unit.setUnitName("College University");
        AwardPerson pi = new AwardPerson();
        pi.setFullName("I. M. Poster");
        pi.setContactRoleCode(ContactRole.PI_CODE);
        AwardPersonUnit piUnit = new AwardPersonUnit();
        piUnit.setUnit(unit);
        award.add(pi);
        award.setLeadUnit(unit);
        award.setUnitNumber(unit.getUnitNumber());
        Sponsor sponsor = new Sponsor();
        sponsor.setSponsorCode("FM");
        sponsor.setSponsorName("Free Money");
        award.setSponsor(sponsor);
        award.setSponsorCode(sponsor.getSponsorCode());
        award.setSponsorAwardNumber("000001-0000S");
        award.setTitle("TEST TITLE");
        award.setAwardDocument(new AwardDocument() {
            @Override
            public String getDocumentNumber() {
                return "1";
            }
        });
        return award;
    }

}
