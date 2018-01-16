/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */

package org.kuali.kra.subaward.web.struts.action;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.api.sponsor.hierarchy.SponsorHierarchyService;
import org.kuali.coeus.common.framework.krms.KrmsRulesExecutionService;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.common.framework.version.history.VersionHistoryService;
import org.kuali.coeus.common.notification.impl.service.KcNotificationService;
import org.kuali.coeus.propdev.impl.coi.CoiConstants;
import org.kuali.coeus.sys.framework.validation.AuditHelper;
import org.kuali.coeus.sys.framework.validation.AuditHelper.ValidationState;
import org.kuali.coeus.sys.framework.controller.KcTransactionalDocumentActionBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.subaward.SubAwardForm;
import org.kuali.kra.subaward.bo.*;
import org.kuali.kra.subaward.customdata.SubAwardCustomData;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.kra.subaward.notification.SubAwardNotificationContext;
import org.kuali.kra.subaward.reporting.printing.service.SubAwardPrintingService;
import org.kuali.kra.subaward.service.SubAwardService;
import org.kuali.kra.subaward.subawardrule.SubAwardDocumentRule;
import org.kuali.kra.subaward.templateAttachments.SubAwardAttachmentFormBean;
import org.kuali.rice.coreservice.framework.parameter.ParameterConstants;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kns.question.ConfirmationQuestion;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.kns.web.struts.form.KualiDocumentFormBase;
import org.kuali.rice.kns.web.struts.form.KualiForm;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubAwardAction extends KcTransactionalDocumentActionBase {

    public static final String DISABLE_ATTACHMENT_REMOVAL = "disableAttachmentRemoval";
    private transient SubAwardService subAwardService;
    private static final String DOCUMENT_ROUTE_QUESTION="DocRoute";
    private static final String FDP_PTE_INVOICE_EMAIL = "FDP_PTE_Invoice_email";
    private static final String FDP_PTE_INVOICE_ADDRESS = "FDP_PTE_Invoice_address";

    @Override
    public ActionForward execute(ActionMapping mapping,
    ActionForm form, HttpServletRequest request,
    	HttpServletResponse response) throws Exception {

        SubAwardForm subAwardForm = (SubAwardForm) form;
        if (subAwardForm.getSubAward() != null) {
                getSubAwardService().calculateAmountInfo(subAwardForm.getSubAward());
        }

        ActionForward actionForward = super.
        execute(mapping, form, request, response);
        if (GlobalVariables.getAuditErrorMap().isEmpty()) {
            getAuditHelper().auditConditionally((SubAwardForm) form);
        }
        if (subAwardForm.isAuditActivated()){
            subAwardForm.setUnitRulesMessages(getUnitRulesMessages(subAwardForm.getSubAwardDocument()));
        }

        if(subAwardForm.getSubAwardDocument().getSubAwardList() != null) {
            for(SubAward subAwardList:subAwardForm.getSubAwardDocument().getSubAwardList()) {
                List<SubAwardAttachments> subAwardAttachmentsList = subAwardList.getSubAwardAttachments();
                if(subAwardAttachmentsList != null && !subAwardAttachmentsList.isEmpty()) {
                     for(SubAwardAttachments subAwardAttachments:subAwardAttachmentsList) {
                            if(subAwardAttachments.getFileName() != null) {
                                String printAttachmentTypeInclusion=getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, Constants.PARAMETER_PRINT_ATTACHMENT_TYPE_INCLUSION);
                                String[] attachmentTypeCode=printAttachmentTypeInclusion.split("\\,");
                                for (String anAttachmentTypeCode : attachmentTypeCode) {
                                    if (StringUtils.equals(subAwardAttachments.getSubAwardAttachmentTypeCode(), anAttachmentTypeCode)) {
                                        String[] fileNameSplit = subAwardAttachments.getFileName().split("\\.pdf");
                                        if (getSubAwardPrintingService().isPdf(subAwardAttachments.getAttachmentContent())) {
                                            subAwardAttachments.setFileNameSplit(fileNameSplit[0]);
                                        }
                                    }
                                }
                             }
                            SubAwardAttachmentType subAwardAttachmentTypeValue =  getBusinessObjectService().findBySinglePrimaryKey(SubAwardAttachmentType.class, subAwardAttachments.getSubAwardAttachmentTypeCode());
                            subAwardAttachments.setTypeAttachment(subAwardAttachmentTypeValue);
                     }
                }
            }
        }

        return actionForward;
    }

    protected List<String> getUnitRulesMessages(SubAwardDocument subAwardDocument) {
        return getKrmsRulesExecutionService().processUnitValidations(subAwardDocument.getSubAward().getRequisitionerUnit(), subAwardDocument);
    }

    @Override
    public ActionForward docHandler(ActionMapping mapping, ActionForm form
            , HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        ActionForward forward;
        forward = handleDocument(
        mapping, form, request, response, subAwardForm);
        SubAwardDocument subAwardDocument =
        (SubAwardDocument) subAwardForm.getDocument();
        subAwardForm.initializeFormOrDocumentBasedOnCommand();
        SubAward subAward = getSubAwardService().calculateAmountInfo(subAwardDocument.getSubAward());
        subAwardForm.getSubAwardDocument().setSubAward(subAward);



        return forward;
    }

    ActionForward handleDocument(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                  HttpServletResponse response, SubAwardForm subAwardForm) throws Exception {

        ActionForward forward = null;

        String command = subAwardForm.getCommand();
        if (KewApiConstants.ACTIONLIST_INLINE_COMMAND.equals(command)) {
            loadDocumentInForm(request, subAwardForm);
        } else if (Constants.MAPPING_SUBAWARD_ACTION_PAGE.equals(command)) {
            loadDocumentInForm(request, subAwardForm);
            forward = subAwardActions(mapping, subAwardForm, request, response);
        } else if (Constants.MAPPING_FINANCIAL_PAGE.equals(command)) {
            loadDocumentInForm(request, subAwardForm);
            forward = mapping.findForward(Constants.MAPPING_FINANCIAL_PAGE);
        } else {
            forward = super.docHandler(mapping, form, request, response);
        }
        return forward;
    }

    protected void loadDocumentInForm(HttpServletRequest request,
    SubAwardForm subAwardForm)
    throws WorkflowException {
        String docIdRequestParameter =
        request.getParameter(KRADConstants.PARAMETER_DOC_ID);
        SubAwardDocument retrievedDocument = (SubAwardDocument)
        KRADServiceLocatorWeb.getDocumentService().
        getByDocumentHeaderId(docIdRequestParameter);
        subAwardForm.setDocument(retrievedDocument);
        request.setAttribute(KRADConstants.PARAMETER_DOC_ID,
                docIdRequestParameter);
    }

   public String buildForwardStringForActionListCommand(String forwardPath,
		 String docIdRequestParameter) {
       StringBuilder sb = new StringBuilder();
       sb.append(forwardPath);
       sb.append("?");
       sb.append(KRADConstants.PARAMETER_DOC_ID);
       sb.append("=");
       sb.append(docIdRequestParameter);
       return sb.toString();
   }

    @Override
    protected void loadDocument(KualiDocumentFormBase kualiForm)
    throws WorkflowException {
        super.loadDocument(kualiForm);
        ((SubAwardForm) kualiForm).
        getSubAwardDocument().getSubAward();
    }


    @Override
    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;

        SubAward subAward = subAwardForm.getSubAwardDocument().getSubAward();
        checkSubAwardCode(subAward);
        checkSubAwardTemplateCode(subAward);
        String userId = GlobalVariables.getUserSession().getPrincipalName();
        if (subAward.getSubAwardId() == null) {
            getVersionHistoryService().updateVersionHistory(subAward, VersionStatus.PENDING, userId);
        }
        if (executeSaveRules(subAward)) {
            ActionForward forward = super.save(mapping, form, request, response);
            if (subAward.getSubAwardId() == null) {
                getSubAwardService().updateSubAwardSequenceStatus(subAward, VersionStatus.PENDING);
            }
            return forward;
        } else {
            return mapping.findForward(Constants.MAPPING_BASIC);
        }
    }

    protected boolean executeSaveRules(SubAward subAward) {
        return new SubAwardDocumentRule().processAddSubAwardBusinessRules(subAward);
    }

   public ActionForward subAward(ActionMapping mapping,
 ActionForm form, HttpServletRequest request, HttpServletResponse response) {

       return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
   }

    public ActionForward fundingSource(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward(Constants.MAPPING_FUNDING_SOURCE_PAGE);
    }

   public ActionForward financial(ActionMapping mapping, ActionForm form,
		  HttpServletRequest request, HttpServletResponse response) {

       return mapping.findForward(Constants.MAPPING_FINANCIAL_PAGE);
   }

   public ActionForward templateInformation(ActionMapping mapping, ActionForm form,
           HttpServletRequest request, HttpServletResponse response) {
        setDisableRemovalAttachmentIndicator(((SubAwardForm) form).getSubAwardAttachmentFormBean());

       final String hierarchyName = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_PROPOSAL_DEVELOPMENT, Constants.PARAMETER_COMPONENT_DOCUMENT, CoiConstants.COI_SPONSOR_HIERARCHY);

       if (((SubAwardForm) form).getSubAward().getSubAwardTemplateInfo().isEmpty()) {
           ((SubAwardForm) form).getSubAward().getSubAwardTemplateInfo().add(new SubAwardTemplateInfo());
       }

       final String fdpPteInvoiceEmail = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, FDP_PTE_INVOICE_EMAIL);
       final String fdpPteInvoiceAddress = getParameterService().getParameterValueAsString(Constants.MODULE_NAMESPACE_SUBAWARD, ParameterConstants.DOCUMENT_COMPONENT, FDP_PTE_INVOICE_ADDRESS);

       ((SubAwardForm) form).getSubAward().getSubAwardTemplateInfo().forEach(info -> {
           if (info.getFcio() == null &&
                   ((SubAwardForm) form).getSubAward().getSubAwardFundingSourceList().stream()
                           .filter(source -> source.getAward() != null)
                           .filter(source -> source.getAward().getPrimeSponsor() != null)
                           .map(source -> source.getAward().getPrimeSponsorCode())
                           .distinct()
                           .anyMatch(sponsorCode -> getSponsorHierarchyService().isSponsorInHierarchy(sponsorCode, hierarchyName))) {

               info.setFcio(true);
           }

           if (StringUtils.isNotBlank(fdpPteInvoiceEmail)) {
               if (info.getInvoiceEmailDifferent() == null) {
                   info.setInvoiceEmailDifferent(true);
               }

               if (info.getInvoicesEmailed() == null) {
                   info.setInvoicesEmailed(true);
               }
           }

           if (StringUtils.isNotBlank(fdpPteInvoiceAddress) && info.getInvoiceAddressDifferent() == null) {
               info.setInvoiceAddressDifferent(true);
           }
       });

       return mapping.findForward(Constants.MAPPING_TEMPLATE_PAGE);
    }


    protected void setDisableRemovalAttachmentIndicator(SubAwardAttachmentFormBean subAwardAttachmentForm) {
        if (subAwardAttachmentForm != null) {
            subAwardAttachmentForm.setDisableAttachmentRemovalIndicator(getParameterService().getParameterValueAsBoolean(Constants.KC_GENERIC_PARAMETER_NAMESPACE,
                    ParameterConstants.DOCUMENT_COMPONENT, DISABLE_ATTACHMENT_REMOVAL));
        }
    }

  public ActionForward amountReleased(
		ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response) {

      return mapping.findForward(Constants.MAPPING_AMOUNT_RELEASED_PAGE);
  }

 public ActionForward contacts(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response) {

     return mapping.findForward(Constants.MAPPING_CONTACTS_PAGE);
 }

public ActionForward closeouts(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {       

    return mapping.findForward(Constants.MAPPING_CLOSEOUT_PAGE);
}

public ActionForward customData(ActionMapping mapping, ActionForm form
        , HttpServletRequest request, HttpServletResponse response) {
    SubAwardForm subAwardForm = (SubAwardForm) form;
    subAwardForm.getCustomDataHelper().prepareCustomData();
    return mapping.findForward(Constants.MAPPING_CUSTOM_DATA);
}

public ActionForward subAwardActions(ActionMapping mapping,
ActionForm form, HttpServletRequest request, HttpServletResponse response) {

    return mapping.findForward(Constants.MAPPING_SUBAWARD_ACTION_PAGE);
}

/**
 * This method sets an subAwardCode on an subAward if
 * the subAwardCode hasn't been initialized yet.
 */
protected void checkSubAwardCode(SubAward subAward){
    if (subAward.getSubAwardCode() == null) {
        String subAwardCode = getSubAwardService().getNextSubAwardCode();
        subAward.setSubAwardCode(subAwardCode);
    }
    for (SubAwardCustomData customData : subAward.getSubAwardCustomDataList()) {
        customData.setSubAward(subAward);
    }
}

protected void checkSubAwardTemplateCode(SubAward subAward){
    for (SubAwardTemplateInfo subAwardTemplateInfo : subAward.getSubAwardTemplateInfo()) {
        if (subAward.getSubAwardCode()!=null && subAwardTemplateInfo.getSubAwardCode() == null) { 
            String subAwardCode = subAward.getSubAwardCode();
            Integer subAwardSequenceNumber = subAward.getSequenceNumber();
            subAwardTemplateInfo.setSubAwardCode(subAwardCode);
            subAwardTemplateInfo.setSequenceNumber(subAwardSequenceNumber);
        }
    }
}

@Override
public ActionForward route(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

    SubAwardForm subAwardForm = (SubAwardForm) form;
    subAwardForm.setAuditActivated(false);
    ValidationState status = getAuditHelper().isValidSubmission(subAwardForm, true);
    Object question = request.getParameter(KRADConstants.QUESTION_INST_ATTRIBUTE_NAME);
    Object buttonClicked = request.getParameter(KRADConstants.QUESTION_CLICKED_BUTTON);
    String methodToCall = ((KualiForm) form).getMethodToCall();
    
    if (status == ValidationState.OK) {
        sendNotification(mapping, subAwardForm, SubAward.NOTIFICATION_TYPE_SUBMIT, "Submit SubAward");
        return super.route(mapping, form, request, response);
    } else {
        if (status == ValidationState.WARNING) {
            if(question == null){
                return this.performQuestionWithoutInput(mapping, form, request, response, DOCUMENT_ROUTE_QUESTION, "Validation Warning Exists. Are you sure want to submit to workflow routing.", KRADConstants.CONFIRMATION_QUESTION, methodToCall, "");
            } else if(DOCUMENT_ROUTE_QUESTION.equals(question) && ConfirmationQuestion.YES.equals(buttonClicked)) {
                sendNotification(mapping, subAwardForm, SubAward.NOTIFICATION_TYPE_SUBMIT, "Submit SubAward");
                return super.route(mapping, form, request, response);
            } else {
                return mapping.findForward(Constants.MAPPING_BASIC);
            }    
        } else {
            GlobalVariables.getMessageMap().clearErrorMessages();
            GlobalVariables.getMessageMap().
            putError("datavalidation", KeyConstants.ERROR_WORKFLOW_SUBMISSION);
            subAwardForm.setAuditActivated(true);   
            return mapping.findForward(Constants.MAPPING_BASIC);
        }
    }
}

@Override
public ActionForward blanketApprove(ActionMapping mapping,
		ActionForm form, HttpServletRequest request,
        HttpServletResponse response) throws Exception {
    SubAwardForm subAwardForm = (SubAwardForm) form;

    subAwardForm.setAuditActivated(false);
    ValidationState status = getAuditHelper().
    isValidSubmission(subAwardForm, true);
    if ((status == ValidationState.OK) || (status == ValidationState.WARNING)) {
        sendNotification(mapping, subAwardForm, SubAward.NOTIFICATION_TYPE_SUBMIT, "Submit SubAward");
        return super.blanketApprove(mapping, form, request, response);
    } else {
        GlobalVariables.getMessageMap().clearErrorMessages();
        GlobalVariables.getMessageMap().
        putError("datavalidation", KeyConstants.ERROR_WORKFLOW_SUBMISSION);
        subAwardForm.setAuditActivated(true);
        return mapping.findForward(Constants.MAPPING_BASIC);

    }
}

  @Override
  public ActionForward approve(ActionMapping mapping, ActionForm form,
   HttpServletRequest request,
   HttpServletResponse response) throws Exception {
      SubAwardForm subAwardForm = (SubAwardForm) form;
      ActionForward forward = mapping.findForward(Constants.MAPPING_BASIC);
      ValidationState status = getAuditHelper().
      isValidSubmission(subAwardForm, true);

      if ((status == ValidationState.OK) || (status == ValidationState.WARNING)) {
          return super.approve(mapping, form, request, response);
      } else {
          GlobalVariables.getMessageMap().clearErrorMessages();
          GlobalVariables.getMessageMap().
          putError("datavalidation", KeyConstants.
          ERROR_WORKFLOW_SUBMISSION);

          return forward;
      }
  }


  public ActionForward medusa(ActionMapping mapping,
          ActionForm form, HttpServletRequest request,
          HttpServletResponse response) throws Exception {
      SubAwardForm subAwardForm = (SubAwardForm) form;
      if (subAwardForm.getDocument().getDocumentNumber() == null) {
          loadDocumentInForm(request, subAwardForm);
      }
      subAwardForm.getMedusaBean().setMedusaViewRadio("0");
      subAwardForm.getMedusaBean().setModuleName("subaward");
      subAwardForm.getMedusaBean().setModuleIdentifier(subAwardForm.getSubAwardDocument().getSubAward().getSubAwardId());
      subAwardForm.getMedusaBean().generateParentNodes();
      return mapping.findForward(Constants.MAPPING_AWARD_MEDUSA_PAGE);
  }

  /**
   * Use the Kuali Rule Service to apply the rules for the given event.
   * @param event the event to process
   * @return true if success; false if there was a validation error
   */
  protected final boolean applyRules(DocumentEvent event) {
      return getKualiRuleService().applyRules(event);
  }

  public ActionForward sendNotification(ActionMapping mapping, SubAwardForm subAwardForm, 
                                        String notificationType, String notificationString) {
      SubAward subAward = subAwardForm.getSubAwardDocument().getSubAward();
      SubAwardNotificationContext context = new SubAwardNotificationContext(subAward, notificationType, notificationString, Constants.MAPPING_SUBAWARD_PAGE);
      if (subAwardForm.getNotificationHelper().getPromptUserForNotificationEditor(context)) {
          subAwardForm.getNotificationHelper().initializeDefaultValues(context);
          return mapping.findForward("notificationEditor");
      } else {
          getNotificationService().sendNotification(context);
          return mapping.findForward(Constants.MAPPING_BASIC);
      }
  }

    public ActionForward printForms(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        streamToResponse(getSubAwardPrintingService().printSubAwardFDPReport(subAwardForm.getSubAwardPrintAgreement(), subAwardForm.getSubAwardDocument().getSubAward()), response);
        return mapping.findForward(Constants.MAPPING_BASIC);
    }

    protected KrmsRulesExecutionService getKrmsRulesExecutionService() {
        return KcServiceLocator.getService(KrmsRulesExecutionService.class);
    }

    protected KcNotificationService getNotificationService() {
        return KcServiceLocator.getService(KcNotificationService.class);
    }

    protected SponsorHierarchyService getSponsorHierarchyService() {
        return KcServiceLocator.getService(SponsorHierarchyService.class);
    }

    protected SubAwardPrintingService getSubAwardPrintingService() {
        return KcServiceLocator.getService(SubAwardPrintingService.class);
    }

    protected AuditHelper getAuditHelper() {
        return KcServiceLocator.getService(AuditHelper.class);
    }

    protected VersionHistoryService getVersionHistoryService() {
        return KcServiceLocator.getService(VersionHistoryService.class);
    }

    public SubAwardService getSubAwardService() {
        if (subAwardService == null) {
            subAwardService = KcServiceLocator.getService(SubAwardService.class);
        }
        return subAwardService;
    }

    public void setSubAwardService(SubAwardService subAwardService) {
        this.subAwardService = subAwardService;
    }

}
