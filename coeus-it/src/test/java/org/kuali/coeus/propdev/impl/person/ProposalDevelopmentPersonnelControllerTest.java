package org.kuali.coeus.propdev.impl.person;

import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.person.KcPerson;
import org.kuali.coeus.common.framework.person.KcPersonService;
import org.kuali.coeus.common.framework.person.PropAwardPersonRole;
import org.kuali.coeus.common.framework.unit.Unit;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.QuestionnaireAnswerService;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.test.fixtures.ProposalDevelopmentDocumentFixture;
import org.kuali.kra.test.infrastructure.KcIntegrationTestBase;
import org.kuali.rice.ken.api.notification.Notification;
import org.kuali.rice.ken.api.service.SendNotificationService;
import org.kuali.rice.krad.data.DataObjectService;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.DocumentService;
import org.kuali.rice.krad.uif.view.View;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.web.form.HistoryManager;
import org.kuali.rice.krad.web.form.UifFormManager;
import org.mockito.ArgumentMatcher;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class ProposalDevelopmentPersonnelControllerTest extends KcIntegrationTestBase {

    private static final String ALL_CERTIFIED_NOTIFICATION_TEMPLATE = "All Proposal Persons Certification Completed for %s";
    private static final String CERTIFICATION_QUESTIONNAIRE_NAME = "Proposal Person Certification";
    private static final String PI_USERNAME = "cate";
    private static final String COI_USERNAME = "burd";

    private BusinessObjectService businessObjectService;
    private DataObjectService dataObjectService;
    private DocumentService documentService;
    private KcPersonService kcPersonService;
    private KcNotificationService kcNotificationService;
    private KeyPersonnelService keyPersonnelService;
    private HistoryManager historyManagerMock;
    private QuestionnaireAnswerService questionnaireAnswerService;
    private SendNotificationService sendNotificationService;
    private SendNotificationService sendNotificationServiceMock;

    private ProposalDevelopmentPersonnelController pdPersonnelController;
    private ProposalDevelopmentDocument pdDocument;

    @Before
    public void setup() {
        GlobalVariables.setUifFormManager(new UifFormManager());
        businessObjectService = KcServiceLocator.getService(BusinessObjectService.class);
        dataObjectService = KcServiceLocator.getService(DataObjectService.class);
        documentService = KcServiceLocator.getService(DocumentService.class);
        kcNotificationService = KcServiceLocator.getService(KcNotificationService.class);
        kcPersonService = KcServiceLocator.getService(KcPersonService.class);
        keyPersonnelService = KcServiceLocator.getService(KeyPersonnelService.class);
        questionnaireAnswerService = KcServiceLocator.getService(QuestionnaireAnswerService.class);
        pdPersonnelController = KcServiceLocator.getService(ProposalDevelopmentPersonnelController.class);
        // Mocking SendNotificationService for this test since it's hard to verify that notifications were sent otherwise
        sendNotificationService = KcServiceLocator.getService(SendNotificationService.class);
        sendNotificationServiceMock = mock(SendNotificationService.class);
        ReflectionTestUtils.setField(kcNotificationService, "sendNotificationService", sendNotificationServiceMock);
        // Mocking HistoryManager since we don't really care about the view layer for this test
        historyManagerMock = mock(HistoryManager.class);
        pdDocument = ProposalDevelopmentDocumentFixture.NORMAL_DOCUMENT.getDocument();
        Unit leadUnit = new Unit();
        leadUnit.setUnitNumber(pdDocument.getDevelopmentProposal().getOwnedByUnitNumber());
        pdDocument.getDevelopmentProposal().setOwnedByUnit(leadUnit);
        pdDocument.getDocumentHeader().setDocumentDescription("ProposalDevelopmentPersonnelControllerTest test document");
    }

    @After
    public void tearDown() {
        GlobalVariables.setUifFormManager(null);
        ReflectionTestUtils.setField(kcNotificationService, "sendNotificationService", sendNotificationService);
    }

    @Test
    public void testAllPersonCertificationFiresFromCertificationScreen() throws Exception {
        ProposalDevelopmentDocument document = (ProposalDevelopmentDocument) documentService.saveDocument(pdDocument);
        ProposalDevelopmentDocumentForm form = new ProposalDevelopmentDocumentForm();
        form.setDocument(document);
        form.initialize();
        form.setView(new View());
        form.setHistoryManager(historyManagerMock);

        ProposalPerson pi = addProjectPerson(document, PI_USERNAME, PropAwardPersonRole.PRINCIPAL_INVESTIGATOR);
        ProposalPerson coi = addProjectPerson(document, COI_USERNAME, PropAwardPersonRole.CO_INVESTIGATOR);

        document.getDevelopmentProposal().getProposalPersons().stream()
                .map(ProposalPerson::getQuestionnaireHelper)
                .forEach(qh -> {
                    questionnaireAnswerService.preSave(qh.getAnswerHeaders());
                    qh.getAnswerHeaders().forEach(businessObjectService::save);
                });
        AllCertifiedNotificationMatcher notificationMatcher = new AllCertifiedNotificationMatcher(document.getDevelopmentProposal().getProposalNumber());
        AnswerHeader piCertificationHeader = completeCertificationQuestionnaireForPerson(pi);
        questionnaireAnswerService.preSave(pi.getQuestionnaireHelper().getAnswerHeaders());
        businessObjectService.save(piCertificationHeader);

        // Saving certification answers does not fire notification if they're not complete
        form.setProposalPersonQuestionnaireHelper(coi.getQuestionnaireHelper());
        pdPersonnelController.closeCertWithSave(form);
        verify(sendNotificationServiceMock, never()).sendNotification(argThat(notificationMatcher));

        // Saving completed certification questionnaire does fire notification if it's the last one to be completed
        completeCertificationQuestionnaireForPerson(coi);
        pdPersonnelController.closeCertWithSave(form);
        verify(sendNotificationServiceMock, times(1)).sendNotification(argThat(notificationMatcher));

        // Notification doesn't fire again once all certification questionnaires have been completed
        pdPersonnelController.closeCertWithSave(form);
        verify(sendNotificationServiceMock, times(1)).sendNotification(argThat(notificationMatcher));
    }

    private class AllCertifiedNotificationMatcher implements ArgumentMatcher<Notification> {
        private final String proposalNumber;

        public AllCertifiedNotificationMatcher(String proposalNumber) {
            this.proposalNumber = proposalNumber;
        }

        @Override
        public boolean matches(Notification notification) {
            return StringUtils.equals(notification.getTitle(), String.format(ALL_CERTIFIED_NOTIFICATION_TEMPLATE, proposalNumber));
        }
    }

    private ProposalPerson addProjectPerson(ProposalDevelopmentDocument doc, String username, String projectRole) {
        ProposalPerson newPerson = new ProposalPerson();
        KcPerson person = kcPersonService.getKcPersonByUserName(username);
        newPerson.setPersonId(person.getPersonId());
        newPerson.setFullName(person.getFullName());
        newPerson.setUserName(person.getUserName());
        newPerson.setProposalPersonRoleId(projectRole);
        keyPersonnelService.addProposalPerson(newPerson, doc);
        return newPerson;
    }

    private AnswerHeader completeCertificationQuestionnaireForPerson(ProposalPerson person) {
        AnswerHeader certificationHeader = person.getQuestionnaireHelper().getAnswerHeaders().stream()
                .filter(ah -> ah.getQuestionnaire().getName().equals(CERTIFICATION_QUESTIONNAIRE_NAME))
                .findFirst()
                .get();
        certificationHeader.getAnswers().forEach(answer -> answer.setAnswer("Y"));
        return certificationHeader;
    }

}
