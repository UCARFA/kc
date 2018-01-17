/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.instprop.impl.api;

import com.codiform.moo.curry.Translate;

import org.kuali.coeus.sys.framework.controller.rest.SimpleCrudMapBasedRestController;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.kuali.kra.institutionalproposal.dao.InstitutionalProposalDao;
import org.kuali.kra.institutionalproposal.home.InstitutionalProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class InstitutionalProposalController extends SimpleCrudMapBasedRestController<InstitutionalProposal> {

    @Autowired
    @Qualifier("institutionalProposalDao")
    private InstitutionalProposalDao institutionalProposalDao;

    @RequestMapping(params="summary", method=RequestMethod.GET)
    public @ResponseBody
    InstitutionalProposalResults getInstitutionalProposalSummary(@RequestParam(value="updatedSince", required=false) Instant updatedSince,
                                 @RequestParam(value="page", required=false) Integer page, @RequestParam(value="limit", required=false) Integer limit) {
        assertMethodSupported(RequestMethod.GET);
        assertUserHasReadAccess();
        InstitutionalProposalResults result = Translate.to(InstitutionalProposalResults.class).from(getProposals(updatedSince == null ? null : Date.from(updatedSince), page, limit));
		if (result == null || result.getCount() == null || result.getCount() == 0) {
			throw new ResourceNotFoundException("not found");
		}
		return result;
    }
    
	SearchResults<InstitutionalProposal> getProposals(Date updatedSince, Integer page, Integer numberPerPage) {
		return getInstitutionalProposalDao().retrievePopulatedInstitutionalProposalByCriteria(new HashMap<>(), updatedSince, page, numberPerPage);
	}

    public InstitutionalProposalDao getInstitutionalProposalDao() {
        return institutionalProposalDao;
    }

    public void setInstitutionalProposalDao(InstitutionalProposalDao institutionalProposalDao) {
        this.institutionalProposalDao = institutionalProposalDao;
    }
}
