/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.award.paymentreports.awardreports.reporting.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.common.notification.impl.bo.NotificationType;
import org.kuali.coeus.common.notification.impl.bo.NotificationTypeRecipient;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.award.AwardFixtureFactory;
import org.kuali.kra.award.contacts.AwardPerson;
import org.kuali.kra.award.document.AwardDocument;
import org.kuali.kra.award.home.*;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTracking;
import org.kuali.kra.award.paymentreports.awardreports.reporting.ReportTrackingConstants;
import org.kuali.kra.award.version.service.AwardVersionService;
import org.kuali.kra.award.version.service.impl.AwardVersionServiceImpl;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ReportTrackingNotificationServiceTest extends KcIntegrationTestBase {

    private static final SimpleDateFormat DUE_DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");
    private static final String DUE_REPORT_STATUS_CODE = "4";
    private static final String PENDING_REPORT_STATUS_CODE = "1";
    private static final String NON_PENDING_REPORT_STATUS_CODE = "5";

    private ReportTrackingNotificationServiceImpl service;
    private BusinessObjectService boService;
    private DocumentService documentService;
    private KcNotificationService notificationServiceSpy;
    private Long currentTermId = 1L;
    
    private Award award;

     @Before
    public void setUp() throws Exception {
        service = (ReportTrackingNotificationServiceImpl) KcServiceLocator.getService(ReportTrackingNotificationService.class);
        boService = KcServiceLocator.getService(BusinessObjectService.class);
        documentService = KcServiceLocator.getService(DocumentService.class);
        notificationServiceSpy = spy(KcServiceLocator.getService(KcNotificationService.class));
        AwardDocument awardDoc = (AwardDocument) documentService.getNewDocument(AwardDocument.class);
        award = AwardFixtureFactory.createAwardFixture();
        award.setAwardSequenceStatus(VersionStatus.ACTIVE.name());
        setPI(award);
        awardDoc.setAward(award);
        awardDoc.getDocumentHeader().setDocumentDescription("Testing");
        documentService.saveDocument(awardDoc);
        AwardService mockAwardService = new AwardServiceImpl() {

            @Override
            public Award getAward(Long awardId) {
                return award;
            }

        };
        service.setAwardService(mockAwardService);
        AwardVersionService mockAwardVersionService = new AwardVersionServiceImpl() {

            @Override
            public Award getActiveAwardVersion(String awardNumber) {
                return award;
            }
        };
        service.setAwardVersionService(mockAwardVersionService);
        service.setNotificationService(notificationServiceSpy);
    }

    @After
    public void tearDown() throws Exception {
        service.setAwardService(KcServiceLocator.getService(AwardService.class));
        service.setAwardVersionService(KcServiceLocator.getService(AwardVersionService.class));
        service.setNotificationService(KcServiceLocator.getService(KcNotificationService.class));
    }
    
    @Test
    public void tstRunReportTrackingNotifications() {
        boService.save(getNewReportTracking(award, "4", "4", Calendar.getInstance().getTime()));
        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_MONTH, -40);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        
        service.getNotifications().clear();
        service.getNotifications().add(new ReportTrackingNotification("Test", "401", true, 30, 30, "4"));
        List<ReportTrackingNotificationDetails> details = service.runReportTrackingNotifications();
        assertEquals(1, details.size());
        assertTrue(details.get(0).isNotificationActive());
        assertEquals(1, details.get(0).getNotificationRecipients());
        assertEquals(2, details.get(0).getTrackingRecordsFound());
        assertEquals(1, details.get(0).getTrackingRecordsMatched());
        assertEquals(2, details.get(0).getNotificationsSent());
        List<SentReportNotification> notificationsSent = (List<SentReportNotification>) boService.findAll(SentReportNotification.class);
        assertEquals(1, notificationsSent.size());
    }
    
    @Test
    public void tstRunReportTrackingNotificationsPreviouslySent() {
        boService.save(getNewReportTracking(award, "4", "4", Calendar.getInstance().getTime()));
        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_MONTH, -40);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime())); 
        
        service.getNotifications().clear();
        service.getNotifications().add(new ReportTrackingNotification("Test", "401", true, 30, 30, "4"));        
        
        List<ReportTrackingNotificationDetails> details = service.runReportTrackingNotifications();
        List<SentReportNotification> notificationsSent = (List<SentReportNotification>) boService.findAll(SentReportNotification.class);
        assertEquals(1, notificationsSent.size());
        
        details = service.runReportTrackingNotifications();
        assertEquals(1, details.size());
        assertTrue(details.get(0).isNotificationActive());
        assertEquals(1, details.get(0).getNotificationRecipients());
        assertEquals(2, details.get(0).getTrackingRecordsFound());
        assertEquals(0, details.get(0).getTrackingRecordsMatched());
        assertEquals(0, details.get(0).getNotificationsSent());
    }
    
    @Test
    public void tstDateBarriers() {
        boService.save(getNewReportTracking(award, "4", "4", Calendar.getInstance().getTime()));
        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, -29);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, -30);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, -59);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, -60);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, 10);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, 30);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, 60);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_YEAR, 61);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));

        service.getNotifications().clear();
        service.getNotifications().add(new ReportTrackingNotification("Test", "401", true, 30, 30, "4"));
        service.getNotifications().add(new ReportTrackingNotification("Test", "402", true, 60, 30, "4"));
        service.getNotifications().add(new ReportTrackingNotification("Test", "403", false, 30, 30, "4"));
        service.getNotifications().add(new ReportTrackingNotification("Test", "404", false, 60, 30, "4"));

        List<ReportTrackingNotificationDetails> details = service.runReportTrackingNotifications();
        List<SentReportNotification> notificationsSent = (List<SentReportNotification>) boService.findAll(SentReportNotification.class);
        assertEquals(6, notificationsSent.size());
        assertEquals(4, details.size());
        assertEquals("401", details.get(0).getActionCode());
        assertEquals(9, details.get(0).getTrackingRecordsFound());
        assertEquals(2, details.get(0).getTrackingRecordsMatched());
        //the below is based on current demo data and the number of OSP Admins for 000001
        assertEquals(2, details.get(0).getNotificationsSent());

        assertEquals("402", details.get(1).getActionCode());
        assertEquals(9, details.get(1).getTrackingRecordsFound());
        assertEquals(1, details.get(1).getTrackingRecordsMatched());
        //the below is based on current demo data and the number of OSP Admins for 000001        
        assertEquals(2, details.get(1).getNotificationsSent());

        assertEquals("403", details.get(2).getActionCode());
        assertEquals(9, details.get(2).getTrackingRecordsFound());
        assertEquals(2, details.get(2).getTrackingRecordsMatched());
        //the below is based on current demo data and the number of OSP Admins for 000001        
        assertEquals(2, details.get(2).getNotificationsSent());

        assertEquals("404", details.get(3).getActionCode());
        assertEquals(9, details.get(3).getTrackingRecordsFound());
        assertEquals(1, details.get(3).getTrackingRecordsMatched());
        //the below is based on current demo data and the number of OSP Admins for 000001        
        assertEquals(2, details.get(3).getNotificationsSent());
    }

    @Test
    public void testNotificationsOnlySentForActiveAwardReports() {
        List<ReportTrackingNotificationDetails> details;
        List<SentReportNotification> notificationsSent;
        service.getNotifications().clear();
        service.getNotifications().add(new ReportTrackingNotification("Test", "401", true, 30, 30, "4"));

        Calendar newDate = Calendar.getInstance();
        newDate.add(Calendar.DAY_OF_MONTH, -40);
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime(), NON_PENDING_REPORT_STATUS_CODE));
        details = service.runReportTrackingNotifications();
        assertEquals(1, details.size());
        assertEquals(1, details.get(0).getTrackingRecordsFound());
        assertEquals(0, details.get(0).getTrackingRecordsMatched());
        assertEquals(0, details.get(0).getNotificationsSent());
        notificationsSent = (List<SentReportNotification>) boService.findAll(SentReportNotification.class);
        assertEquals(0, notificationsSent.size());

        award.setAwardSequenceStatus(VersionStatus.PENDING.name());
        boService.save(getNewReportTracking(award, "4", "4", newDate.getTime()));
        details = service.runReportTrackingNotifications();
        assertEquals(1, details.size());
        assertEquals(2, details.get(0).getTrackingRecordsFound());
        assertEquals(0, details.get(0).getTrackingRecordsMatched());
        assertEquals(0, details.get(0).getNotificationsSent());
        notificationsSent = (List<SentReportNotification>) boService.findAll(SentReportNotification.class);
        assertEquals(0, notificationsSent.size());

        award.setAwardSequenceStatus(VersionStatus.ACTIVE.name());
        award.setStatusCode(AwardConstants.AWARD_STATUS_PENDING_CODE);
        details = service.runReportTrackingNotifications();
        assertEquals(1, details.size());
        assertEquals(2, details.get(0).getTrackingRecordsFound());
        assertEquals(0, details.get(0).getTrackingRecordsMatched());
        assertEquals(0, details.get(0).getNotificationsSent());
        notificationsSent = (List<SentReportNotification>) boService.findAll(SentReportNotification.class);
        assertEquals(0, notificationsSent.size());
    }

    @Test
    public void testDigestsSentForDueAwardReports() {
        String digestSubject = "Testing Due and/or Overdue Reports";
        String digestMessage = "<p>Testing Digest Notifications</p>" +
                "{BEGIN_DIGEST_TABLE}<table><tr><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>" +
                "{BEGIN_REPEAT_SECTION}<tr><td>{REPORT_CLASS}</td><td>{REPORT_TYPE}</td><td>{REPORT_DUE_DATE}</td></tr>{END_REPEAT_SECTION}" +
                "</table>{END_DIGEST_TABLE}";
        String digestActionCode = "-99";
        String notificationName = "Digest Test";
        NotificationType digestNotification = getDigestNotification(digestActionCode, digestSubject, digestMessage, "KC-AWARD:PI");
        boService.save(digestNotification);

        LocalDate now = LocalDate.now();
        Date overdue3 = java.sql.Date.valueOf(now.minus(3, ChronoUnit.MONTHS));
        Date overdue1 = java.sql.Date.valueOf(now.minus(1, ChronoUnit.MONTHS));
        Date due2 = java.sql.Date.valueOf(now.plus(2, ChronoUnit.MONTHS));
        Date due5 = java.sql.Date.valueOf(now.plus(5, ChronoUnit.MONTHS));

        List<ReportTracking> reports = Arrays.asList(
            getNewReportTracking(award, "4", "4", due2, DUE_REPORT_STATUS_CODE),
            getNewReportTracking(award, "4", "4", overdue1, DUE_REPORT_STATUS_CODE),
            getNewReportTracking(award, "4", "4", due5, DUE_REPORT_STATUS_CODE),
            getNewReportTracking(award, "1", "4", overdue3, DUE_REPORT_STATUS_CODE),
            getNewReportTracking(award, "4", "4", overdue1, PENDING_REPORT_STATUS_CODE),
            getNewReportTracking(award, "1", "4", due2, NON_PENDING_REPORT_STATUS_CODE),
            getNewReportTracking(award, "2", "4", due5, PENDING_REPORT_STATUS_CODE));
        boService.save(reports);

        String renderedMessage = "<p>Testing Digest Notifications</p>" +
                "<h3>OVERDUE</h3>" +
                "<table><tr><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>" +
                getExpectedRenderedRowForReport(reports.get(3)) +
                getExpectedRenderedRowForReport(reports.get(1)) + "</table>" +
                "<h3>DUE</h3>" +
                "<table><tr><th>Report Class</th><th>Report Type</th><th>Due Date</th></tr>" +
                getExpectedRenderedRowForReport(reports.get(0)) +
                getExpectedRenderedRowForReport(reports.get(2)) + "</table>";
        ReportTrackingNotificationDetails details = service.runReportDigestNotification(digestActionCode, notificationName, true, true);
        assertEquals(4, details.getTrackingRecordsFound());
        assertEquals(4, details.getTrackingRecordsMatched());
        assertEquals(1, details.getNotificationsSent());
        assertEquals(1, details.getNotificationRecipients());
        verify(notificationServiceSpy).sendNotification(eq(notificationName), eq(digestSubject), eq(renderedMessage),
                eq(Collections.singletonList(award.getPrincipalInvestigator().getPerson().getUserName())));
    }

    public ReportTracking getNewReportTracking(Award award, String reportClassCode, String frequencyBaseCode, Date dueDate) {
         return getNewReportTracking(award, reportClassCode, frequencyBaseCode, dueDate, null);
    }

    public ReportTracking getNewReportTracking(Award award, String reportClassCode, String frequencyBaseCode, Date dueDate, String reportStatusCode) {
        ReportTracking result = new ReportTracking();
        result.setAwardReportTermId(currentTermId++);
        result.setAwardNumber(award.getAwardNumber());
        result.setAwardId(award.getAwardId());
        result.setPiName("Quickstart Quickstart");
        result.setLeadUnitNumber("000001");
        result.setReportClassCode(reportClassCode);
        result.setReportCode("4");
        result.setSponsorCode("4");
        result.setTitle("Testing");
        result.setLastUpdateUser("quickstart");
        result.setLastUpdateDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        result.setUpdateUser("quickstart");
        result.setUpdateTimestamp(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        result.setFrequencyBaseCode(frequencyBaseCode);
        result.setDueDate(new java.sql.Date(dueDate.getTime()));
        result.setStatusCode(reportStatusCode == null ? PENDING_REPORT_STATUS_CODE : reportStatusCode);
        return result;
    }

    private void setPI(Award award) {
        AwardPerson pi = new AwardPerson();
        pi.setPersonId("10000000002");
        pi.setContactRoleCode(ContactRole.PI_CODE);
        award.add(pi);
    }

    private NotificationType getDigestNotification(String actionCode, String subject, String message, String... recipientRoles) {
        NotificationType digestNotification = new NotificationType();
        digestNotification.setModuleCode(CoeusModule.AWARD_MODULE_CODE);
        digestNotification.setActionCode(actionCode);
        digestNotification.setDescription("Test Report Tracking Digest Notification");
        digestNotification.setSubject(subject);
        digestNotification.setMessage(message);
        digestNotification.setActive(true);
        digestNotification.setPromptUser(false);
        digestNotification.setNotificationTypeRecipients(Arrays.stream(recipientRoles)
                .map(role -> {
                    NotificationTypeRecipient recipient = new NotificationTypeRecipient();
                    recipient.setRoleName(role);
                    return recipient;
                }).collect(Collectors.toList()));
        return digestNotification;
    }

    private String getExpectedRenderedRowForReport(ReportTracking report) {
         String dueDate = DUE_DATE_FORMATTER.format(report.getDueDate());
         report.refreshReferenceObject(ReportTrackingConstants.REPORT_CLASS);
         report.refreshReferenceObject(ReportTrackingConstants.REPORT);
         return String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", report.getReportClass().getDescription(), report.getReport().getDescription(), dueDate);
    }

}
