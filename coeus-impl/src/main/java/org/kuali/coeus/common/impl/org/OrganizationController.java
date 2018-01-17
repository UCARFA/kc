/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.org;

import org.kuali.coeus.common.framework.org.Organization;
import org.kuali.coeus.sys.framework.controller.rest.SimpleCrudMapBasedRestController;
import org.kuali.coeus.sys.framework.rest.ResourceNotFoundException;
import org.kuali.coeus.sys.framework.rest.SearchResults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codiform.moo.curry.Translate;

public class OrganizationController extends SimpleCrudMapBasedRestController<Organization> {
	
	@RequestMapping(params="summary", method=RequestMethod.GET)
	public @ResponseBody OrganizationResults getOrganizationSummary() {
		assertMethodSupported(RequestMethod.GET);
		assertUserHasReadAccess();

		final SearchResults<Organization> organizationSearchResults = new SearchResults<>();
		organizationSearchResults.setResults(getAllFromDataStore());
		if (organizationSearchResults.getResults() == null || organizationSearchResults.getResults().size() == 0) {
			throw new ResourceNotFoundException("not found");
		}
		organizationSearchResults.setTotalResults(organizationSearchResults.getResults().size());
		return Translate.to(OrganizationResults.class).from(organizationSearchResults);
	}
}
