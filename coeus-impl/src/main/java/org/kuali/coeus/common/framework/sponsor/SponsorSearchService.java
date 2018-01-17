/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.coeus.common.framework.sponsor;

import java.util.List;

public interface SponsorSearchService {

    /**
     * Searches for sponsors where the search string is like the sponsor code, sponsor name, or acronym.  A blank
     * searchString is not allowed.
     * @param searchString the search string.  cannot be blank.
     * @return a list of results.  Will never return null.  Will return a max of 25 items.
     * @throws java.lang.IllegalArgumentException if the searchString is blank
     */
    List<SponsorSearchResult> findSponsors(String searchString);
}
