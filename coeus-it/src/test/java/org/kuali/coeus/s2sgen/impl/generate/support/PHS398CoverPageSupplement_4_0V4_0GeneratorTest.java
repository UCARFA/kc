package org.kuali.coeus.s2sgen.impl.generate.support;


import org.kuali.coeus.common.questionnaire.framework.answer.Answer;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;
import org.kuali.coeus.common.questionnaire.framework.answer.QuestionnaireAnswerService;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocument;
import org.kuali.coeus.propdev.impl.questionnaire.ProposalDevelopmentModuleQuestionnaireBean;
import org.kuali.coeus.propdev.impl.s2s.S2sOppForms;
import org.kuali.coeus.propdev.impl.s2s.S2sOpportunity;
import org.kuali.coeus.propdev.impl.s2s.question.ProposalDevelopmentS2sModuleQuestionnaireBean;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.rice.krad.service.BusinessObjectService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class PHS398CoverPageSupplement_4_0V4_0GeneratorTest extends S2STestBase {

    @Override
    protected String getFormGeneratorName() {
        return PHS398CoverPageSupplement_4_0V4_0Generator.class.getSimpleName();
    }

    private static final String NAMESPACE = "http://apply.grants.gov/forms/PHS398_CoverPageSupplement_4_0-V4.0";
    private static final String FORM_NAME = "PHS398_CoverPageSupplement_4_0-V4.0";

    @Override
    protected void prepareS2sData(ProposalDevelopmentDocument document) {
        super.prepareS2sData(document);
        S2sOpportunity s2sOpportunity = new S2sOpportunity();
        s2sOpportunity.setProviderCode("1");
        s2sOpportunity.setOpportunity("PA-EN-K08");
        s2sOpportunity.setDevelopmentProposal(document.getDevelopmentProposal());

        s2sOpportunity.setOpportunityId("PA-EN-K08");
        List<S2sOppForms> S2sOppFormsList = new ArrayList<>();
        S2sOppForms s2sOppForms = new S2sOppForms();
        s2sOppForms.setAvailable(true);
        s2sOppForms.setInclude(true);

        S2sOppForms.S2sOppFormsId s2sOppFormsId = new S2sOppForms.S2sOppFormsId();
        s2sOppFormsId.setOppNameSpace(NAMESPACE);
        s2sOppForms.setFormName(FORM_NAME);
        s2sOppForms.setS2sOppFormsId(s2sOppFormsId);
        s2sOppForms.getS2sOppFormsId().setProposalNumber(document.getDevelopmentProposal().getProposalNumber());
        S2sOppFormsList.add(s2sOppForms);
        s2sOpportunity.setS2sOppForms(S2sOppFormsList);

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date(System.currentTimeMillis()));
        final XMLGregorianCalendar date1;
        try {
            date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
        s2sOpportunity.setClosingDate(date1.toGregorianCalendar());

        document.getDevelopmentProposal().setS2sOpportunity(s2sOpportunity);
    }

    @Override
    protected void prepareData(ProposalDevelopmentDocument document) throws Exception {
        document.getDevelopmentProposal().setAgencyDivisionCode("88888888");
        document.getDevelopmentProposal().setAgencyProgramCode("4444");
        document.getDevelopmentProposal().setProgramAnnouncementNumber("13-540");

        saveAnswers(document);
    }

    protected BusinessObjectService getBusinessObjectService() {
        return KcServiceLocator.getService(BusinessObjectService.class);
    }

    protected void saveAnswers(ProposalDevelopmentDocument document) {
        ModuleQuestionnaireBean moduleQuestionnaireBean = new ProposalDevelopmentModuleQuestionnaireBean(document.getDevelopmentProposal());
        List<AnswerHeader> answerHeaders = KcServiceLocator.getService(QuestionnaireAnswerService.class).getQuestionnaireAnswer(moduleQuestionnaireBean);
        QuestionnaireAnswerService service2 = KcServiceLocator.getService(QuestionnaireAnswerService.class);

        List<AnswerHeader> rawAnswerHeaders = service2.getQuestionnaireAnswer(new ProposalDevelopmentS2sModuleQuestionnaireBean(document.getDevelopmentProposal()));

        for(AnswerHeader answerHeader:rawAnswerHeaders) {
            if (answerHeader.getLabel().contains("PHS 398 Cover Page Supplement")) {
                List<Answer> answerDetails = answerHeader.getAnswers();
                for (Answer answer : answerDetails) {
                    if (145 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (146 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (147 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("N");
                    } else if (148 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Idk, we're just gonna wing it.");
                    } else if (5 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (6 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("1234");
                    } else if (149 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (118 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (119 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (120 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("Y");
                    } else if (114 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("N");
                    } else if (115 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer(null);
                    } else if (116 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer("N");
                    } else if (117 == answer.getQuestion().getQuestionSeqId()) {
                        answer.setAnswer(null);
                    }

                }
                getBusinessObjectService().save(answerHeader);
            }
        }
        getBusinessObjectService().save(answerHeaders);
    }
}
