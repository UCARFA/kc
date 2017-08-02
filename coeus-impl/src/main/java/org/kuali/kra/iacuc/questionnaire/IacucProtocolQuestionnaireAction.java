/*
 * Kuali Coeus, a comprehensive research administration system for higher education.
 * 
 * Copyright 2005-2016 Kuali, Inc.
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
package org.kuali.kra.iacuc.questionnaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.framework.module.CoeusModule;
import org.kuali.coeus.common.framework.module.CoeusSubModule;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.iacuc.IacucProtocol;
import org.kuali.kra.iacuc.IacucProtocolAction;
import org.kuali.kra.iacuc.IacucProtocolForm;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.coeus.common.framework.print.AttachmentDataSource;
import org.kuali.kra.protocol.ProtocolFormBase;
import org.kuali.kra.protocol.questionnaire.SaveProtocolQuestionnaireEvent;
import org.kuali.coeus.common.questionnaire.framework.answer.AnswerHeader;
import org.kuali.coeus.common.questionnaire.framework.answer.ModuleQuestionnaireBean;
import org.kuali.coeus.common.questionnaire.framework.answer.QuestionnaireAnswerService;
import org.kuali.coeus.common.questionnaire.framework.answer.SaveQuestionnaireAnswerEvent;
import org.kuali.coeus.common.questionnaire.framework.answer.SaveQuestionnaireAnswerRule;
import org.kuali.coeus.common.questionnaire.framework.core.QuestionnaireConstants;
import org.kuali.rice.krad.document.Document;

/**
 * This class represents the Struts Action for Protocol Questionnaires.
 */
public class IacucProtocolQuestionnaireAction extends IacucProtocolAction {
    private static final String PROTOCOL_NUMBER = "protocolNumber";
    private static final String SEQUENCE_NUMBER = "sequenceNumber";
    private static final String SUBMISSION_QUESTIONNAIRE = "submissionQuestionnaire";

    @Override
    public void preSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.preSave(mapping, form, request, response);
        
        IacucProtocolForm protocolForm = (IacucProtocolForm) form;
        Document document = protocolForm.getDocument();
        List<AnswerHeader> answerHeaders = protocolForm.getQuestionnaireHelper().getAnswerHeaders();
        
        if ( applyRules(new SaveQuestionnaireAnswerEvent(document, answerHeaders)) && applyRules(new SaveProtocolQuestionnaireEvent(document, answerHeaders)) ) {
            protocolForm.getQuestionnaireHelper().preSave();
            getBusinessObjectService().save(answerHeaders);
        }
    }

    /**
     * 
     * This method is for the 'update' button to update questionnaire answer to new version
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ActionForward updateAnswerToNewVersion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                                  HttpServletResponse response) throws Exception {
        ((IacucProtocolForm) form).getQuestionnaireHelper().updateQuestionnaireAnswer(getLineToDelete(request));
        getBusinessObjectService().save(((IacucProtocolForm) form).getQuestionnaireHelper().getAnswerHeaders().get(getLineToDelete(request)));
        return mapping.findForward(Constants.MAPPING_BASIC);

    }

    /**
     * This is specifically for 'lookup' return a value.
     */
    @Override
    public ActionForward refresh(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionForward forward =  super.refresh(mapping, form, request, response);
        if (request.getParameter("refreshCaller") !=null && request.getParameter("refreshCaller").toString().equals("kualiLookupable")) {
            // Lookup field 'onchange' is not working if it is return a value from 'lookup', so do it on server side
            for (Object obj : request.getParameterMap().keySet()) {
                if (StringUtils.indexOf((String) obj, "questionnaireHelper.answerHeaders[") == 0) {
                    ((IacucProtocolForm) form).getQuestionnaireHelper().updateChildIndicator(Integer.parseInt(StringUtils.substringBetween((String) obj, "questionnaireHelper.answerHeaders[",
                            "].answers[")));
                }
            }
        }
        if (StringUtils.isBlank(((IacucProtocolForm) form).getDocId())) {
            // lookup return to submission questionnaire popup
            forward = mapping.findForward(SUBMISSION_QUESTIONNAIRE);
            ((IacucProtocolForm) form).getQuestionnaireHelper().resetHeaderLabels();
        }
        return forward;
    }

    @Override
    public ActionForward reload(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO : reload should reload the action page too, so this submissionquestionnaire may not needed ?
        ActionForward actionForward = super.reload(mapping, form, request, response);
        ((IacucProtocolForm)form).getQuestionnaireHelper().prepareView();
        ((IacucProtocolForm)form).getQuestionnaireHelper().populateAnswers();
        ((IacucProtocolForm)form).getQuestionnaireHelper().setQuestionnaireActiveStatuses();
        return actionForward;
    }
    
    
    @Override
    protected ActionForward saveOnClose(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = mapping.findForward(Constants.MAPPING_BASIC);
        
        IacucProtocolForm protocolForm = (IacucProtocolForm) form;
        Document document = protocolForm.getDocument();
        List<AnswerHeader> answerHeaders = protocolForm.getQuestionnaireHelper().getAnswerHeaders();
        
        if (applyRules(new SaveQuestionnaireAnswerEvent(document, answerHeaders))) {
            protocolForm.getQuestionnaireHelper().preSave();
            getBusinessObjectService().save(answerHeaders);
            
            forward = super.saveOnClose(mapping, form, request, response);
        }
        
        return forward;
    }

    @Override
    public ActionForward printQuestionnaireAnswer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                                  HttpServletResponse response) throws Exception {
        // TODO : this is only available after questionnaire is saved ?
        ActionForward forward = mapping.findForward(Constants.MAPPING_BASIC);
        Map<String, Object> reportParameters = new HashMap<String, Object>();
        IacucProtocolForm protocolForm = (IacucProtocolForm) form;
        final int answerHeaderIndex = this.getSelectedLine(request);
        // TODO : a flag to check whether to print answer or not
        // for release 3 : if questionnaire questions has answer, then print answer. 
        reportParameters.put(QuestionnaireConstants.QUESTIONNAIRE_SEQUENCE_ID_PARAMETER_NAME, ((IacucProtocolForm) form).getQuestionnaireHelper().getAnswerHeaders().get(answerHeaderIndex).getQuestionnaire().getQuestionnaireSeqIdAsInteger());
        reportParameters.put("template", ((IacucProtocolForm) form).getQuestionnaireHelper().getAnswerHeaders().get(answerHeaderIndex).getQuestionnaire().getTemplate());
        reportParameters.put("moduleSubItemCode", ((IacucProtocolForm) form).getQuestionnaireHelper().getAnswerHeaders().get(answerHeaderIndex).getModuleSubItemCode());

        AttachmentDataSource dataStream = getQuestionnairePrintingService().printQuestionnaireAnswer(protocolForm.getProtocolDocument().getProtocol(), reportParameters);
        if (dataStream.getData() != null) {
            streamToResponse(dataStream, response);
            forward = null;
        }
        return forward;
    }

    public ActionForward summaryQuestionnairePop(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ActionForward forward;
        IacucProtocolForm protocolForm = (IacucProtocolForm) form;
        String sequenceNumber = request.getParameter("sequenceNumber");
        String protocolNumber = request.getParameter(PROTOCOL_NUMBER);
        
        ModuleQuestionnaireBean moduleQuestionnaireBean = new IacucProtocolModuleQuestionnaireBean(CoeusModule.IACUC_PROTOCOL_MODULE_CODE, protocolNumber,
            (protocolNumber.contains("A") || protocolNumber.contains("R")) ? CoeusSubModule.AMENDMENT_RENEWAL : CoeusSubModule.ZERO_SUBMODULE, sequenceNumber, true);
        protocolForm.getQuestionnaireHelper().setAnswerHeaders(
                getQuestionnaireAnswerService().getQuestionnaireAnswer(moduleQuestionnaireBean));

        protocolForm.getQuestionnaireHelper().setAnswerHeaders(
                getAnsweredQuestionnaire(protocolForm.getQuestionnaireHelper().getAnswerHeaders()));
        forward = mapping.findForward("viewQuestionnaire");

        protocolForm.getQuestionnaireHelper().resetHeaderLabels();
        protocolForm.getQuestionnaireHelper().setQuestionnaireActiveStatuses();
        return forward;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ActionForward summaryQuestionnaireAjax(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ActionForward forward;
        IacucProtocolForm protocolForm = (IacucProtocolForm) form;
        String sequenceNumber = request.getParameter(SEQUENCE_NUMBER);
        String protocolNumber = request.getParameter(PROTOCOL_NUMBER);
        Map keyValues= new HashMap();
        keyValues.put(PROTOCOL_NUMBER, protocolNumber);
        keyValues.put(SEQUENCE_NUMBER, sequenceNumber);
        IacucProtocol protocol = ((List<IacucProtocol>)getBusinessObjectService().findMatching(IacucProtocol.class, keyValues)).get(0);
        String subModuleCode = CoeusSubModule.ZERO_SUBMODULE;
        if (protocol.isRenewal()) {
            subModuleCode = CoeusSubModule.AMENDMENT_RENEWAL;
            if (protocol.isRenewalWithoutAmendment()) {
                subModuleCode = CoeusSubModule.RENEWAL;
            }
        } 
        if (protocol.isAmendment()) {
            subModuleCode = CoeusSubModule.AMENDMENT;
        }
        ModuleQuestionnaireBean moduleQuestionnaireBean = new IacucProtocolModuleQuestionnaireBean(CoeusModule.IACUC_PROTOCOL_MODULE_CODE, protocolNumber,
                                                                                      subModuleCode, sequenceNumber, true);
        // TODO : should handle this more smoothly.  maybe in service, change the fieldvalues map of subitemcode to a list
        // so bos.findmatching will find all the matching codes in the list 
        protocolForm.getQuestionnaireHelper().setAnswerHeaders(
                getQuestionnaireAnswerService().getQuestionnaireAnswer(moduleQuestionnaireBean));
        if (protocol.isAmendment() || protocol.isRenewal()) {  
            // get the questionnaire amended if 'questionnaire' is selected amendment section
            moduleQuestionnaireBean.setModuleSubItemCode(CoeusSubModule.ZERO_SUBMODULE);
            List<AnswerHeader> answerHeaders = getQuestionnaireAnswerService().getQuestionnaireAnswer(moduleQuestionnaireBean);
            if (!answerHeaders.isEmpty()) {
                protocolForm.getQuestionnaireHelper().getAnswerHeaders().addAll(answerHeaders);
            }
        }

        protocolForm.getQuestionnaireHelper().setAnswerHeaders(
                getAnsweredQuestionnaire(protocolForm.getQuestionnaireHelper().getAnswerHeaders()));
        forward = mapping.findForward("ajaxQuestionnaire");

        protocolForm.getQuestionnaireHelper().resetHeaderLabels();        
        protocolForm.getQuestionnaireHelper().setQuestionnaireActiveStatuses();
        
        return forward;
    }


    /*
     * to filter out the questionnaire answer not saved
     */
    private List<AnswerHeader> getAnsweredQuestionnaire(List<AnswerHeader> answerHeaders) {
        List<AnswerHeader> savedHeaders = new ArrayList<AnswerHeader>();
        for (AnswerHeader answerHeader : answerHeaders) {
            if (answerHeader.getId() != null) {
                savedHeaders.add(answerHeader);
            }
        }
        return savedHeaders;
    }
    
    /**
     * 
     * This method is to save the submission questionnaire answer from the pop up window
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward saveSubmissionQuestionnaire(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ProtocolFormBase protocolForm = (ProtocolFormBase) form;
        List<AnswerHeader> answerHeaders = protocolForm.getQuestionnaireHelper().getAnswerHeaders();
        SaveQuestionnaireAnswerRule rule = new SaveQuestionnaireAnswerRule();
        if (rule.processRules(new SaveQuestionnaireAnswerEvent(null, answerHeaders))) {
            protocolForm.getQuestionnaireHelper().preSave();
            getBusinessObjectService().save(answerHeaders);
            
        }
        protocolForm.getQuestionnaireHelper().resetHeaderLabels();
        
        return mapping.findForward(SUBMISSION_QUESTIONNAIRE);
    }

    protected QuestionnaireAnswerService getQuestionnaireAnswerService() {
        return KcServiceLocator.getService(QuestionnaireAnswerService.class);
    }


}
