/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.subaward.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.common.framework.version.VersionStatus;
import org.kuali.coeus.common.framework.version.history.VersionHistory;
import org.kuali.coeus.sys.api.model.KcFile;
import org.kuali.coeus.sys.framework.gv.GlobalVariableService;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.coeus.sys.framework.util.CollectionUtils;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.infrastructure.KeyConstants;
import org.kuali.kra.subaward.SubAwardForm;
import org.kuali.kra.subaward.bo.*;
import org.kuali.kra.subaward.document.SubAwardDocument;
import org.kuali.kra.subaward.subawardrule.SubAwardDocumentRule;
import org.kuali.rice.kew.api.exception.WorkflowException;
import org.kuali.rice.kns.question.ConfirmationQuestion;
import org.kuali.rice.krad.util.GlobalVariables;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SubAwardHomeAction extends SubAwardAction{

    private static final String SUBAWARD_VERSION_EDITPENDING_PROMPT_KEY = "message.subaward.version.editpending.prompt";
    private static final String PENDING = "PENDING";

    private static final String SUB_AWARD_AMOUNT_INFO = "subAwardAmountInfo";
    private GlobalVariableService globalVariableService;

    @Override
    public ActionForward refresh(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        super.refresh(mapping, form, request, response);
        SubAwardForm subAwardMultiLookupForm = (SubAwardForm)form;
        String lookupResultsBOClassName =
        request.getParameter(KRADConstants.LOOKUP_RESULTS_BO_CLASS_NAME);
        String lookupResultsSequenceNumber =
        request.getParameter(KRADConstants.LOOKUP_RESULTS_SEQUENCE_NUMBER);
        subAwardMultiLookupForm.setLookupResultsBOClassName(
        lookupResultsBOClassName);
        subAwardMultiLookupForm.
        setLookupResultsSequenceNumber(lookupResultsSequenceNumber);
        subAwardMultiLookupForm.
        getSubAwardDocument().getSubAward();
        return mapping.findForward(Constants.MAPPING_BASIC);
    }

    /**
     * This method is used to handle the edit button
     * action on an ACTIVE Subaward.
     *  If no Pending version exists for the same
     * subawardCode, a new Subaward version is created.
     * If a Pending version exists,
     * the user is prompted as to whether she would
     * like to edit the Pending version. Answering Yes results in that Pending
     * version SubAwardDocument to be opened. Answering No
     * simply returns the user to the ACTIVE document screen
     */
    public ActionForward editOrVersion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = ((SubAwardForm)form);
        SubAwardDocument subAwardDocument = subAwardForm.getSubAwardDocument();
        SubAward subaward = subAwardDocument.getSubAward();
        ActionForward forward;

        if (subaward.getVersionHistory().getStatusForOjb().equals(PENDING)) {
            response.sendRedirect(buildForwardUrl(subAwardForm.getDocId()));
            return null;
        }

        VersionHistory foundPending = findPendingVersion(subaward);
        if (foundPending != null) {
            Object question = request.getParameter(KRADConstants.QUESTION_CLICKED_BUTTON);
            if (question == null) {
                forward = showPromptForEditingPendingVersion(mapping, form, request, response);
            } else {
                forward = processPromptForEditingPendingVersionResponse(mapping, request, response, subAwardForm, foundPending);
            }
        }
        else if (getVersionHistoryService().isAnotherUserEditingDocument(subAwardDocument.getDocumentNumber())) {
            getGlobalVariableService().getMessageMap().putError(Constants.DOCUMENT_NUMBER_FIELD, KeyConstants.MESSAGE_DOCUMENT_VERSION_ANOTHER_USER_EDITING,
                    Constants.SUBAWARD_PANEL_NAME, globalVariableService.getUserSession().getPerson().getFirstName(),
                    globalVariableService.getUserSession().getPerson().getLastName(),
                    globalVariableService.getUserSession().getPrincipalName());
            forward = mapping.findForward(Constants.MAPPING_BASIC);
        }
        else {
            getPessimisticLockService().generateNewLock(
                    subAwardDocument.getDocumentNumber(),
                    getVersionHistoryService().getVersionLockDescriptor(subAwardDocument.getDocumentTypeCode(), subAwardDocument.getDocumentNumber()),
                    GlobalVariables.getUserSession().getPerson());
            forward = createAndSaveNewSubAwardVersion(response, subAwardForm, subAwardDocument, subaward);
        }

        return forward;
    }

    private VersionHistory findPendingVersion(SubAward subaward) {
        List<VersionHistory> histories = getVersionHistoryService().loadVersionHistory(SubAward.class, subaward.getSubAwardCode());
        VersionHistory foundPending = null;
        for (VersionHistory history: histories) {
            if (history.getStatus() == VersionStatus.PENDING && subaward.getSequenceNumber() < history.getSequenceOwnerSequenceNumber()) {
                foundPending = history;
                break;
            }
        }
        return foundPending;
    }

    private ActionForward showPromptForEditingPendingVersion(ActionMapping mapping, ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        return this.performQuestionWithoutInput(mapping, form, request, response, "EDIT_OR_VERSION_QUESTION_ID",
                    getResources(request).getMessage(SUBAWARD_VERSION_EDITPENDING_PROMPT_KEY),
                    KRADConstants.CONFIRMATION_QUESTION,
                    KRADConstants.MAPPING_CANCEL, "");
    }

    private ActionForward processPromptForEditingPendingVersionResponse(ActionMapping mapping, HttpServletRequest request,
            HttpServletResponse response, SubAwardForm subAwardForm, 
            VersionHistory foundPending) throws WorkflowException, 
                                                IOException {
        ActionForward forward;
        Object buttonClicked = request.getParameter(KRADConstants.QUESTION_CLICKED_BUTTON);
        if (ConfirmationQuestion.NO.equals(buttonClicked)) {
            forward = mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);            
        } else {
            initializeFormWithSubAward(subAwardForm, (SubAward) foundPending.getSequenceOwner());
            response.sendRedirect(buildForwardUrl(subAwardForm.getSubAwardDocument().getDocumentNumber()));
            forward = null;
        }
        return forward;
    }
    
    private void initializeFormWithSubAward(SubAwardForm subAwardForm, SubAward subAward) throws WorkflowException {
        reinitializeSubAwardForm(subAwardForm, findDocumentForSubAward(subAward));
    }
    
    private SubAwardDocument findDocumentForSubAward(SubAward subAward) throws WorkflowException {
        SubAwardDocument document = (SubAwardDocument) getDocumentService().getByDocumentHeaderId(subAward.getSubAwardDocument().getDocumentNumber());
        document.setSubAward(subAward);
        return document;
    }

    private ActionForward createAndSaveNewSubAwardVersion(HttpServletResponse response, SubAwardForm subAwardForm,
       SubAwardDocument subAwardDocument, SubAward subAward) throws Exception {
       subAwardForm.getSubAwardDocument().getSubAward().setNewVersion(true);
       SubAwardDocument newSubAwardDocument = getSubAwardService().createNewSubAwardVersion(subAwardForm.getSubAwardDocument());
       getDocumentService().saveDocument(newSubAwardDocument);
       getSubAwardService().updateSubAwardSequenceStatus(newSubAwardDocument.getSubAward(), VersionStatus.PENDING);
       getVersionHistoryService().updateVersionHistory(newSubAwardDocument.getSubAward(), VersionStatus.PENDING, 
               GlobalVariables.getUserSession().getPrincipalName());
        reinitializeSubAwardForm(subAwardForm, newSubAwardDocument);
        return new ActionForward(buildForwardUrl(newSubAwardDocument.getDocumentNumber()), true);
    }

    /**.
     * This method prepares the SubAwardForm with
     * the document found via the SubAward lookup
     * Because the helper beans may have preserved a different
     *  SubAwardForm, we need to reset these too
     */
    private void reinitializeSubAwardForm(SubAwardForm subAwardForm,
    SubAwardDocument document) throws WorkflowException {
   subAwardForm.populateHeaderFields(document.getDocumentHeader().
   getWorkflowDocument());
        subAwardForm.setDocument(document);
        subAwardForm.initialize();
    }

    public ActionForward addFundingSource(
    ActionMapping mapping, ActionForm form, HttpServletRequest request,
    HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAward subAward = subAwardForm.getSubAwardDocument().getSubAward();
        SubAwardFundingSource fundingSources=
        subAwardForm.getNewSubAwardFundingSource();

        if (new SubAwardDocumentRule().
        processAddSubAwardFundingSourceBusinessRules(
        fundingSources, subAward)) {
            addFundingSourceToSubAward(
            subAwardForm.getSubAwardDocument().getSubAward(), fundingSources);
            subAwardForm.setNewSubAwardFundingSource(
            new SubAwardFundingSource());
        }
        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

    boolean addFundingSourceToSubAward(
    SubAward subAward, SubAwardFundingSource fundingSources) {
        if (subAward.getSubAwardCode() == null) {
            String subAwardCode = getSubAwardService().getNextSubAwardCode();
            subAward.setSubAwardCode(subAwardCode);
        }
        fundingSources.setSubAward(subAward);
        return subAward.getSubAwardFundingSourceList().add(fundingSources);
    }

    public ActionForward deleteFundingSource(ActionMapping mapping,
    ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAwardDocument subAwardDocument = subAwardForm.getSubAwardDocument();
        int selectedLineNumber = getSelectedLine(request);

        subAwardDocument.getSubAward().
        getSubAwardFundingSourceList().remove(selectedLineNumber);
        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

    public ActionForward addContacts(ActionMapping mapping,
    ActionForm form, HttpServletRequest request,
        HttpServletResponse response) throws Exception {

        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAwardContact subAwardContact = subAwardForm.getNewSubAwardContact();
        SubAward subAward = subAwardForm.getSubAwardDocument().getSubAward();

        if (new SubAwardDocumentRule().
        processAddSubAwardContactBusinessRules(
        subAwardContact, subAward)) {
            addContactsToSubAward(subAwardForm.
            getSubAwardDocument().getSubAward(), subAwardContact);
            subAwardForm.setNewSubAwardContact(new SubAwardContact());
        }
        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

    boolean addContactsToSubAward(SubAward subAward,
    SubAwardContact subAwardContact) {
        if (subAward.getSubAwardCode() == null) {
            String subAwardCode = getSubAwardService().getNextSubAwardCode();
            subAward.setSubAwardCode(subAwardCode);
        }
        subAwardContact.setSubAward(subAward);
        return subAward.getSubAwardContactsList().add(subAwardContact);
    }

    public ActionForward deleteContact(ActionMapping mapping,
    ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAwardDocument subAwardDocument = subAwardForm.getSubAwardDocument();
        int selectedLineNumber = getSelectedLine(request);
        subAwardDocument.getSubAward().
        getSubAwardContactsList().remove(selectedLineNumber);
        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

    public ActionForward addCloseouts(ActionMapping mapping,
    ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAwardCloseout subAwardCloseout =
        subAwardForm.getNewSubAwardCloseout();

        if (new SubAwardDocumentRule().
        processAddSubAwardCloseoutBusinessRules(subAwardCloseout)) {
            if (subAwardCloseout.getDateFollowup() == null) {
                subAwardCloseout.setDateFollowup(
                this.getSubAwardService().getCalculatedFollowupDate(
                subAwardCloseout.getDateRequested()));
            }
            addCloseoutToSubAward(subAwardForm.
            getSubAwardDocument().getSubAward(), subAwardCloseout);
            subAwardForm.setNewSubAwardCloseout(new SubAwardCloseout());
        }
        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

    boolean addCloseoutToSubAward(SubAward subAward,
    SubAwardCloseout subAwardCloseout) {
        if (subAward.getSubAwardCode() == null) {
            String subAwardCode = getSubAwardService().getNextSubAwardCode();
            subAward.setSubAwardCode(subAwardCode);
        }
        subAwardCloseout.setSubAward(subAward);
        return subAward.getSubAwardCloseoutList().add(subAwardCloseout);
    }

public ActionForward deleteCloseout(ActionMapping mapping,
		ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAwardDocument subAwardDocument = subAwardForm.getSubAwardDocument();
        int selectedLineNumber = getSelectedLine(request);
        subAwardDocument.getSubAward().
        getSubAwardCloseoutList().remove(selectedLineNumber);

        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

public ActionForward selectAllSubAwardPrintNoticeItems(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    SubAwardForm subAwardForm = (SubAwardForm)form;
    subAwardForm.getSubAwardPrintAgreement().selectAllItems();
    return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
}

public ActionForward deselectAllSubAwardPrintNoticeItems(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    SubAwardForm subAwardForm = (SubAwardForm)form;
    subAwardForm.getSubAwardPrintAgreement().deselectAllItems();
    return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
}

    public ActionForward addFfataReport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAward subAward = subAwardForm.getSubAwardDocument().getSubAward();
        SubAwardFfataReporting ffataReporting = subAwardForm.getNewSubAwardFfataReporting();
        ffataReporting.setSubAwardId(subAward.getSubAwardId());

        final boolean refreshAmountInfo = ffataReporting.getSubAwardAmountInfoId() != null && (ffataReporting.getSubAwardAmountInfo() == null ||
                        (ffataReporting.getSubAwardAmountInfo() != null && !ffataReporting.getSubAwardAmountInfoId().equals(ffataReporting.getSubAwardAmountInfo().getSubAwardAmountInfoId())));

        if (refreshAmountInfo) {
            ffataReporting.refreshReferenceObject(SUB_AWARD_AMOUNT_INFO);
        }

        if (new SubAwardDocumentRule().processAddSubAwardFfataReportingBusinessRules(ffataReporting, subAward)) {
            addFfataReportToSubAward(subAwardForm.getSubAwardDocument().getSubAward(), ffataReporting);
            subAwardForm.setNewSubAwardFfataReporting(new SubAwardFfataReporting());
        }
        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }


    private boolean addFfataReportToSubAward(SubAward subAward, SubAwardFfataReporting ffataReporting) {
        ffataReporting.populateAttachment();
        ffataReporting.setSubAwardId(subAward.getSubAwardId());
        return subAward.getSubAwardFfataReporting().add(ffataReporting);
    }


    public ActionForward deleteFfataReport(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        SubAwardForm subAwardForm = (SubAwardForm) form;
        SubAwardDocument subAwardDocument = subAwardForm.getSubAwardDocument();
        int selectedLineNumber = getSelectedLine(request);

        subAwardDocument.getSubAward().getSubAwardFfataReporting().remove(selectedLineNumber);

        return mapping.findForward(Constants.MAPPING_SUBAWARD_PAGE);
    }

    public ActionForward downloadFfataReportAttachment(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        final SubAwardForm subAwardForm = (SubAwardForm) form;
        final SubAwardDocument subAwardDocument = subAwardForm.getSubAwardDocument();
        final Integer index = getSelectedLine(request);

        if (CollectionUtils.validIndexForList(index, subAwardDocument.getSubAwardList().get(0).getSubAwardFfataReporting())) {
            KcFile report = subAwardDocument.getSubAwardList().get(0).getSubAwardFfataReporting().get(index);
            if (report != null && report.getData() != null) {
                this.streamToResponse(report.getData(),
                        getValidHeaderString(report.getName()), getValidHeaderString(report.getType()), response);
            }
        }
        return null;
    }

    public GlobalVariableService getGlobalVariableService() {
        if (globalVariableService == null) {
            globalVariableService = KcServiceLocator.getService(GlobalVariableService.class);
        }
        return globalVariableService;
    }
}
