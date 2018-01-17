/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.sponsor;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.kuali.coeus.common.framework.sponsor.Sponsor;
import org.kuali.coeus.sys.framework.lookup.KcKualiLookupableHelperServiceImpl;
import org.kuali.rice.krad.bo.BusinessObject;
import org.kuali.rice.krad.lookup.CollectionIncomplete;
import org.kuali.rice.krad.util.GlobalVariables;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sponsorHierarchyMaintenanceLookupableHelperService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SponsorHierachyMaintenanceLookupableHelperServiceImpl  extends KcKualiLookupableHelperServiceImpl {
    private static final String SPONSOR_CODES = "sponsorCodes";

    @Override
    public List<? extends BusinessObject> getSearchResults(Map<String, String> fieldValues) {
        List<Sponsor> searchResults = (List<Sponsor>) super.getSearchResults(fieldValues);
		String sponsorsCodes = (String) GlobalVariables.getUserSession().retrieveObject(SPONSOR_CODES);
		String[] sponsorArray = sponsorsCodes.split(";");
		List<String> sponsorList = Arrays.asList(sponsorArray);
		final List<Sponsor> searchResultsReturn = searchResults.stream()
				.filter(sponsor -> !sponsorList.contains(sponsor.getSponsorCode())).collect(Collectors.toList());
		return new CollectionIncomplete(searchResultsReturn, new Long(searchResults.size()));
	}

}
