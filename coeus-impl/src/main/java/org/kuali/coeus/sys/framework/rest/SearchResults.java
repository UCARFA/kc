/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.sys.framework.rest;

import java.util.Collection;

public class SearchResults<T> {

	private Integer totalResults;
	private Collection<T> results;
	
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	
	public Collection<T> getResults() {
		return results;
	}
	public void setResults(Collection<T> results) {
		this.results = results;
	}
	
}
