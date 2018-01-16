/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.impl.org;

import java.util.Collection;

import org.kuali.coeus.common.framework.org.OrganizationSummaryDto;
import org.kuali.coeus.sys.framework.rest.ResponseResults;

import com.codiform.moo.annotation.CollectionProperty;

public final class OrganizationResults extends ResponseResults {
	@CollectionProperty(source="results", itemClass=OrganizationSummaryDto.class)
	private Collection<OrganizationSummaryDto> organizations;

	public Collection<OrganizationSummaryDto> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Collection<OrganizationSummaryDto> organizations) {
		this.organizations = organizations;
	}
}
