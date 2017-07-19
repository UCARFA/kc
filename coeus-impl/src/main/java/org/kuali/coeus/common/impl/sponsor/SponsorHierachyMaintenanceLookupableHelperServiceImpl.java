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
