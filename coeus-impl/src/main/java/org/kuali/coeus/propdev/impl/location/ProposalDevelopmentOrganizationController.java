/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.propdev.impl.location;

import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentControllerBase;
import org.kuali.coeus.propdev.impl.core.ProposalDevelopmentDocumentForm;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProposalDevelopmentOrganizationController extends ProposalDevelopmentControllerBase {


    @Transactional @RequestMapping(value = "/proposalDevelopment", params={"methodToCall=refresh", "refreshCaller=Organization-LookupView"} )
    public ModelAndView refreshOrganization(@ModelAttribute("KualiForm") ProposalDevelopmentDocumentForm form)
            throws Exception {
        getDataObjectService().wrap(form.getDevelopmentProposal().getPerformingOrganization()).fetchRelationship("organization");
        form.getDevelopmentProposal().getPerformingOrganization().initializeDefaultCongressionalDistrict();
        return getRefreshControllerService().refresh(form);
    }
}
