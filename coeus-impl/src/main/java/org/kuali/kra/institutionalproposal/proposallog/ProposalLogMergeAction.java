/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.institutionalproposal.proposallog;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.kuali.coeus.sys.framework.service.KcServiceLocator;
import org.kuali.kra.institutionalproposal.proposallog.service.ProposalLogService;
import org.kuali.rice.core.api.CoreApiServiceLocator;
import org.kuali.rice.core.api.config.property.ConfigurationService;
import org.kuali.rice.kns.web.struts.action.KualiAction;
import org.kuali.rice.krad.util.KRADConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProposalLogMergeAction extends KualiAction {
    protected static final String PAGE_ENTRY_REDIRECT_URL_FORMAT = "kr/lookup.do?methodToCall=start&businessObjectClassName=org.kuali.kra.institutionalproposal.home.InstitutionalProposal&docFormKey=88888888&includeCustomActionUrls=true&returnLocation=%s/mergeProposalLog.do&hideReturnLink=true%s";
    protected static final String PROPOSAL_LOG_PARAMETER_FORMAT = "&proposalLogNumber=%s";
    
    public ActionForward pageEntry(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        final ProposalLogMergeForm proposalLogMergeForm = (ProposalLogMergeForm) form;
        final String applicationUrl       = getKualiConfigurationService().getPropertyValueAsString(KRADConstants.APPLICATION_URL_KEY);
        final String proposalLogParameter = String.format(PROPOSAL_LOG_PARAMETER_FORMAT, proposalLogMergeForm.getProposalLogNumber());
        final String redirectUrl          = String.format(PAGE_ENTRY_REDIRECT_URL_FORMAT, applicationUrl, proposalLogParameter);

        request.getSession().setAttribute("proposalLogNumber", proposalLogMergeForm.getProposalLogNumber());
        return new ActionForward(redirectUrl, true);
    }
    
    public ActionForward mergeToInstitutionalProposal(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String proposalLogNumber = (String) request.getSession().getAttribute("proposalLogNumber");

        if (proposalLogNumber != null) {
        request.getSession().removeAttribute("proposalLogNumber");
        }
        else {
            final ProposalLogMergeForm proposalLogMergeForm = (ProposalLogMergeForm) form;
            proposalLogNumber = proposalLogMergeForm.getProposalLogNumber();
        }

        if (proposalLogNumber != null) {
        getProposalLogService().mergeProposalLog(proposalLogNumber);
        }
        return mapping.findForward("portal");
    }
    
    //http://127.0.0.1:8080/kc-dev/mergeProposalLog.do?methodToCall=getMatchingTemporaryProposals&proposalLogTypeCode=1&piId=10000000002
    public ActionForward getMatchingTemporaryProposals(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProposalLogMergeForm proposalLogMergeForm = (ProposalLogMergeForm) form;
        proposalLogMergeForm.setMatchedProposalLogs(
        		getProposalLogService().getMatchingTemporaryProposalLogs(getProposalLogTypeCodeFromForm(proposalLogMergeForm), 
        				proposalLogMergeForm.getPiId(), proposalLogMergeForm.getRolodexId()));
        return mapping.findForward("temporaryList");
    }

	protected String getProposalLogTypeCodeFromForm(ProposalLogMergeForm proposalLogMergeForm) {
        if (StringUtils.isEmpty(proposalLogMergeForm.getProposalLogTypeCode())) {
        	ProposalLogType type = getProposalLogService().getProposalLogTypeFromDescription(proposalLogMergeForm.getProposalLogTypeCodeDescription());
        	if (type != null) {
        		return type.getProposalLogTypeCode();
        	}
        }
        return proposalLogMergeForm.getProposalLogTypeCode();
	}
    
    protected ProposalLogService getProposalLogService() {
        return KcServiceLocator.getService(ProposalLogService.class);
    }
    
    protected ConfigurationService getKualiConfigurationService() {
        return CoreApiServiceLocator.getKualiConfigurationService();
    }

}
