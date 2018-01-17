/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.award.api;

import java.util.Collection;

import org.kuali.coeus.sys.framework.rest.ResponseResults;

import com.codiform.moo.annotation.CollectionProperty;

public class AwardResults extends ResponseResults {


	@CollectionProperty(source="results", itemClass=AwardSummaryDto.class)
	private Collection<AwardSummaryDto> awards;

	public Collection<AwardSummaryDto> getAwards() {
		return awards;
	}
	public void setAwards(Collection<AwardSummaryDto> awards) {
		this.awards = awards;
	}
}
