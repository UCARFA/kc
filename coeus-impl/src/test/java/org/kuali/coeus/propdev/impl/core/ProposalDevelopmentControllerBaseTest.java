/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.coeus.propdev.impl.core;

import org.junit.Before;
import org.junit.Test;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.common.questionnaire.framework.answer.Answer;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.propdev.impl.person.KeyPersonnelService;
import org.kuali.coeus.propdev.impl.person.ProposalPerson;
import org.kuali.coeus.propdev.impl.person.question.ProposalPersonQuestionnaireHelper;
import org.kuali.coeus.propdev.impl.questionnaire.ProposalDevelopmentQuestionnaireHelper;
import org.kuali.coeus.propdev.impl.s2s.question.ProposalDevelopmentS2sQuestionnaireHelper;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.kra.authorization.KraAuthorizationConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.rice.coreservice.framework.parameter.ParameterService;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.krad.document.authorization.PessimisticLock;
import org.kuali.rice.krad.service.BusinessObjectService;
import org.kuali.rice.krad.service.LegacyDataAdapter;
import org.kuali.rice.krad.service.PessimisticLockService;
import org.kuali.rice.krad.util.KRADConstants;
import org.kuali.rice.krad.util.MessageMap;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProposalDevelopmentControllerBaseTest {

    private BusinessObjectService businessObjectService;
    private GlobalVariableService globalVariablesService;
    private KeyPersonnelService keyPersonnelService;
    private LegacyDataAdapter legacyDataAdapter;
    private MessageMap messageMap;
    private ParameterService parameterService;
    private PessimisticLockService pessimisticLockService;

    private ProposalDevelopmentController pdController;

    class ProposalDevelopmentController extends ProposalDevelopmentControllerBase {}

    @Before
    public void setup() {
        pdController = new ProposalDevelopmentController();
        globalVariablesService = mock(GlobalVariableService.class);
        messageMap = new MessageMap();
        when(globalVariablesService.getMessageMap()).thenReturn(messageMap);
        businessObjectService = mock(BusinessObjectService.class);
        keyPersonnelService = mock(KeyPersonnelService.class);
        legacyDataAdapter = mock(LegacyDataAdapter.class);
        pessimisticLockService = mock(PessimisticLockService.class);
        parameterService = mock(ParameterService.class);
        pdController.setBusinessObjectService(businessObjectService);
        pdController.setGlobalVariableService(globalVariablesService);
        ReflectionTestUtils.setField(pdController, "keyPersonnelService", keyPersonnelService);
        pdController.setLegacyDataAdapter(legacyDataAdapter);
        pdController.setPessimisticLockService(pessimisticLockService);
        pdController.setParameterService(parameterService);
    }

    @Test
    public void testSubmitAnswers() {
        AnswerHeader newAnswerHeader = null;
        AnswerHeader currentAnswerHeader = null;
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));

        currentAnswerHeader = new AnswerHeader();
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));

        newAnswerHeader = new AnswerHeader();
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));

        List<Answer> newAnswers = new ArrayList<>();
        Answer answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer("Y");
        Answer answer2 = new Answer();
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(false);
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());
        currentAnswerHeader.setAnswers(new ArrayList<>());

        List<Answer> currentAnswers = new ArrayList<>();
        Answer currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer("Y");
        Answer currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1.setQuestionId(1L);
        answer1.setAnswer("Y");
        answer2.setQuestionId(2L);
        answer2.setAnswer("Y");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());


        newAnswers = new ArrayList<>();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(false);
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(false);
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = null;
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer(null);
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer(null);
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = null;
        answer2.setQuestionId(2L);
        answer2.setAnswer("N");
        newAnswers.add(answer1);
        newAnswers.add(answer2);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer("Y");
        currentAnswer2 = new Answer();
        currentAnswer2.setQuestionId(2L);
        currentAnswer2.setAnswer("N");
        currentAnswers.add(currentAnswer1);
        currentAnswers.add(currentAnswer2);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        newAnswers.add(answer1);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswers = new ArrayList<>();
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer(null);
        currentAnswers.add(currentAnswer1);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertTrue(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());

        newAnswers = new ArrayList<>();
        answer1 = new Answer();
        answer1.setQuestionId(1L);
        answer1.setAnswer(null);
        newAnswers.add(answer1);
        newAnswerHeader.setAnswers(newAnswers);
        newAnswerHeader.setCompleted(true);
        currentAnswers = new ArrayList<>();
        currentAnswer1 = new Answer();
        currentAnswer1.setQuestionId(1L);
        currentAnswer1.setAnswer("Y");
        currentAnswers.add(currentAnswer1);
        currentAnswerHeader.setAnswers(currentAnswers);
        assertFalse(pdController.answersIncompleteOrUnchanged(newAnswerHeader, currentAnswerHeader));
        currentAnswerHeader.setAnswers(new ArrayList<>());
        newAnswerHeader.setAnswers(new ArrayList<>());
    }

    @Test
    public void testCertificationLockOnlyPreventsSavingCertificationQuestions() {
        final String proposalNumber = "123";
        final String documentNumber = "456";

        ProposalDevelopmentDocumentForm pdForm = new ProposalDevelopmentDocumentForm() {
            @Override
            protected void instantiateDocument() { setDocument(new ProposalDevelopmentDocument()); }
        };
        ProposalDevelopmentDocument pdDoc = new ProposalDevelopmentDocument();
        pdDoc.setDocumentNumber(documentNumber);
        DevelopmentProposal pd = new DevelopmentProposal();
        pd.setProposalNumber(proposalNumber);
        pdDoc.setDevelopmentProposal(pd);
        pd.setProposalDocument(pdDoc);
        pdForm.setDocument(pdDoc);

        AnswerHeader certificationHeader = new AnswerHeader();
        Long certHeaderId = 1L;
        certificationHeader.setId(certHeaderId);
        certificationHeader.setVersionNumber(1L);
        certificationHeader.setModuleItemCode(CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE);
        certificationHeader.setModuleSubItemCode(CoeusSubModule.PROPOSAL_PERSON_CERTIFICATION);
        ProposalPersonQuestionnaireHelper personQuestionnaireHelper = mock(ProposalPersonQuestionnaireHelper.class);
        when(personQuestionnaireHelper.getAnswerHeaders()).thenReturn(Collections.singletonList(certificationHeader));
        pdForm.setProposalPersonQuestionnaireHelper(personQuestionnaireHelper);

        ProposalPerson pdPerson = mock(ProposalPerson.class);
        when(pdPerson.getQuestionnaireHelper()).thenReturn(personQuestionnaireHelper);
        pd.setProposalPersons(Collections.singletonList(pdPerson));

        AnswerHeader normalHeader = new AnswerHeader();
        Long normalHeaderId = 2L;
        normalHeader.setId(normalHeaderId);
        normalHeader.setVersionNumber(1L);
        normalHeader.setModuleItemCode(CoeusModule.PROPOSAL_DEVELOPMENT_MODULE_CODE);
        normalHeader.setModuleSubItemCode(CoeusSubModule.ZERO_SUBMODULE);
        ProposalDevelopmentQuestionnaireHelper pdQuestionnaireHelper = mock(ProposalDevelopmentQuestionnaireHelper.class);
        when(pdQuestionnaireHelper.getAnswerHeaders()).thenReturn(Collections.singletonList(normalHeader));
        pdForm.setQuestionnaireHelper(pdQuestionnaireHelper);

        ProposalDevelopmentS2sQuestionnaireHelper s2sQuestionnaireHelper = mock(ProposalDevelopmentS2sQuestionnaireHelper.class);
        when(s2sQuestionnaireHelper.getAnswerHeaders()).thenReturn(Collections.emptyList());
        pdForm.setS2sQuestionnaireHelper(s2sQuestionnaireHelper);

        PessimisticLock certificationLock = mock(PessimisticLock.class);
        when(certificationLock.getDocumentNumber()).thenReturn(documentNumber);
        when(certificationLock.getLockDescriptor()).thenReturn(KraAuthorizationConstants.LOCK_DESCRIPTOR_PERSONNEL);
        Person lockOwner = mock(Person.class);
        when(lockOwner.getName()).thenReturn("quickstart");
        when(certificationLock.getOwnedByUser()).thenReturn(lockOwner);

        when(parameterService.getParameterValueAsBoolean(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, Constants.PARAMETER_COMPONENT_DOCUMENT,
                ProposalDevelopmentConstants.Parameters.NOTIFY_ALL_CERTIFICATIONS_COMPLETE)).thenReturn(false);

        // Presence of a Personnel section lock blocks saving certification questionnaires
        when(pessimisticLockService.getPessimisticLocksForDocument(documentNumber)).thenReturn(Collections.singletonList(certificationLock));
        pdForm.setPageId(Constants.KEY_PERSONNEL_PAGE);
        pdController.saveAnswerHeaderIfNotLocked(pdForm, pdDoc);
        assertTrue(messageMap.getWarningMessagesForProperty(KRADConstants.GLOBAL_ERRORS).stream().anyMatch(err -> KeyConstants.KC_ERROR_PERSONNEL_LOCKED.equals(err.getErrorKey())));
        verify(legacyDataAdapter, never()).save(any(AnswerHeader.class));

        // Personnel section lock does not block saving normal questionnaires
        reset(legacyDataAdapter);
        when(businessObjectService.findByPrimaryKey(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(normalHeader);
        messageMap.getWarningMessages().clear();
        pdForm.setPageId(Constants.QUESTIONS_PAGE);
        pdController.saveAnswerHeaderIfNotLocked(pdForm, pdDoc);
        assertNull(messageMap.getWarningMessagesForProperty(KRADConstants.GLOBAL_ERRORS));
        verify(legacyDataAdapter, times(1)).save(argThat(new AnswerHeaderMatcher(normalHeaderId)));
        verify(legacyDataAdapter, never()).save(argThat(new AnswerHeaderMatcher(certHeaderId)));

        // Certification questionnaires still save if there is no lock
        reset(legacyDataAdapter);
        when(pessimisticLockService.getPessimisticLocksForDocument(documentNumber)).thenReturn(Collections.emptyList());
        when(businessObjectService.findByPrimaryKey(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(certificationHeader);
        messageMap.getWarningMessages().clear();
        pdForm.setPageId(Constants.KEY_PERSONNEL_PAGE);
        pdController.saveAnswerHeaderIfNotLocked(pdForm, pdDoc);
        assertNull(messageMap.getWarningMessagesForProperty(KRADConstants.GLOBAL_ERRORS));
        verify(legacyDataAdapter, times(1)).save(argThat(new AnswerHeaderMatcher(certHeaderId)));
        verify(legacyDataAdapter, never()).save(argThat(new AnswerHeaderMatcher(normalHeaderId)));
    }

    private class AnswerHeaderMatcher implements ArgumentMatcher<AnswerHeader> {

        private Long id;

        AnswerHeaderMatcher(Long id) {
            this.id = id;
        }

        @Override
        public boolean matches(AnswerHeader argument) {
            return id.equals(argument.getId());
        }
    }

}
