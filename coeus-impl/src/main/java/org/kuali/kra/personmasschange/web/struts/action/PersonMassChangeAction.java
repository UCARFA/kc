/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.personmasschange.web.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;
import org.kuali.coeus.sys.framework.controller.KcHoldingPageConstants;
import org.kuali.coeus.sys.framework.controller.KcTransactionalDocumentActionBase;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.kra.personmasschange.web.struts.form.PersonMassChangeForm;
import org.kuali.kra.personmasschange.web.struts.form.PersonMassChangeHomeHelper;
import org.kuali.kra.personmasschange.web.struts.form.PersonMassChangeViewHelper;
import org.kuali.rice.kew.api.KewApiConstants;
import org.kuali.rice.krad.document.Document;
import org.kuali.rice.krad.rules.rule.event.DocumentEvent;
import org.kuali.rice.krad.service.KRADServiceLocatorWeb;
import org.kuali.rice.krad.service.KualiRuleService;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Defines the overall action class for Person Mass Change.
 */
public class PersonMassChangeAction extends KcTransactionalDocumentActionBase {

    @Override
    public ActionForward docHandler(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward forward = null;
        
        PersonMassChangeForm personMassChangeForm = (PersonMassChangeForm) form;
        String command = personMassChangeForm.getCommand();
        
        if (Constants.MAPPING_PMC_HOME_PAGE.equals(command) || Constants.MAPPING_PMC_VIEW_PAGE.equals(command)) {
            String docIdRequestParameter = request.getParameter(KRADConstants.PARAMETER_DOC_ID);
            Document retrievedDocument = KRADServiceLocatorWeb.getDocumentService().getByDocumentHeaderId(docIdRequestParameter);
            personMassChangeForm.setDocument(retrievedDocument);
            request.setAttribute(KRADConstants.PARAMETER_DOC_ID, docIdRequestParameter);
            loadDocument(personMassChangeForm);
        } else {
            forward = super.docHandler(mapping, form, request, response);
        }

        if (KewApiConstants.INITIATE_COMMAND.equals(command)) {
            personMassChangeForm.getPersonMassChangeDocument().initialize();
        } else {
            personMassChangeForm.initialize();
        }
        
        if (Constants.MAPPING_PMC_HOME_PAGE.equals(command)) {
            forward = home(mapping, personMassChangeForm, request, response);
        }
        if (Constants.MAPPING_PMC_VIEW_PAGE.equals(command)) {
            forward = view(mapping, personMassChangeForm, request, response);
        }
        
        return forward;
    }
    
    public ActionForward home(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        PersonMassChangeForm personMassChangeForm = (PersonMassChangeForm) form;
        PersonMassChangeHomeHelper personMassChangeHomeHelper = personMassChangeForm.getPersonMassChangeHomeHelper();
        personMassChangeHomeHelper.prepareView();
        
        return mapping.findForward(Constants.MAPPING_PMC_HOME_PAGE);
    }

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        PersonMassChangeForm personMassChangeForm = (PersonMassChangeForm) form;
        PersonMassChangeViewHelper personMassChangeViewHelper = personMassChangeForm.getPersonMassChangeViewHelper();
        personMassChangeViewHelper.prepareView();
        
        return mapping.findForward(Constants.MAPPING_PMC_VIEW_PAGE);
    }
    
    public ActionForward routeToHoldingPage(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String command) {
        PersonMassChangeForm personMassChangeForm = (PersonMassChangeForm) form;
        String routeHeaderId = personMassChangeForm.getDocument().getDocumentNumber();
        String returnLocation = buildActionUrl(routeHeaderId, command, "PersonMassChangeDocument");
        
        ActionForward basicForward = mapping.findForward(Constants.MAPPING_BASIC);
        ActionRedirect holdingPageForward = new ActionRedirect(mapping.findForward(KcHoldingPageConstants.MAPPING_HOLDING_PAGE));
        holdingPageForward.addParameter(KcHoldingPageConstants.HOLDING_PAGE_DOCUMENT_ID, routeHeaderId);
        return routeToHoldingPage(basicForward, basicForward, holdingPageForward, returnLocation, routeHeaderId);
    }
    
    public final boolean applyRules(DocumentEvent event) {
        return getKualiRuleService().applyRules(event);
    }
        
    @Override
    protected KualiRuleService getKualiRuleService() {
        return KcServiceLocator.getService(KualiRuleService.class);
    }

}
