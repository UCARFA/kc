/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.controller;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentConstants;
import org.kuali.kra.infrastructure.Constants;
import org.kuali.rice.kew.routing.web.ClientAppDocHandlerRedirectAction;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This class is for copy document.
 * currently, PD &amp; protocol provide 'copy' function.
 */
        
public class CustomDocHandlerRedirectAction extends ClientAppDocHandlerRedirectAction {

    public static final String DOCUMENT_TYPE_NAME = "documentTypeName";
    public static final String PROTOCOL_DOCUMENT = "ProtocolDocument";
    public static final String IACUC_PROTOCOL_DOCUMENT = "IacucProtocolDocument";
    public static final String AWARD_DOCUMENT = "AwardDocument";

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return start(mapping, form, request, response);
    }
    
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward returnForward = super.execute(mapping, form, request, response);
        
        String docHandler = returnForward.getPath();
        if (ProposalDevelopmentConstants.KewConstants.PROPOSAL_DEVELOPMENT_DOCUMENT.equals(request.getParameter(DOCUMENT_TYPE_NAME))) {
            docHandler = docHandler.replace(KRADConstants.DOC_HANDLER_METHOD, Constants.PROPOSAL_ACTIONS_PAGE);
        } else if (PROTOCOL_DOCUMENT.equals(request.getParameter(DOCUMENT_TYPE_NAME)) ||
                IACUC_PROTOCOL_DOCUMENT.equals(request.getParameter(DOCUMENT_TYPE_NAME))) {
            docHandler = docHandler.replace(KRADConstants.DOC_HANDLER_METHOD, Constants.MAPPING_PROTOCOL_ACTIONS);
        } else if (AWARD_DOCUMENT.equals(request.getParameter(DOCUMENT_TYPE_NAME))) {
            docHandler = docHandler.replace(KRADConstants.DOC_HANDLER_METHOD, Constants.MAPPING_AWARD_ACTIONS_PAGE);
        }
          
        returnForward = new ActionForward(docHandler, returnForward.getRedirect());
        return returnForward;
    }
}
