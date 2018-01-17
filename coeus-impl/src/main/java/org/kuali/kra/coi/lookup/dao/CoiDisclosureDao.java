/* Copyright © 2005-2018 Kuali, Inc. - All Rights Reserved
 * You may use and modify this code under the terms of the Kuali, Inc.
 * Pre-Release License Agreement. You may not distribute it.
 *
 * You should have received a copy of the Kuali, Inc. Pre-Release License
 * Agreement with this file. If not, please write to license@kuali.co.
 */
package org.kuali.kra.coi.lookup.dao;

import org.kuali.kra.coi.CoiDisclosure;
import org.kuali.kra.coi.CoiDisclosureHistory;

import java.util.Collection;
import java.util.List;

public interface CoiDisclosureDao {

    public List<CoiDisclosureHistory> getApprovedAndDisapprovedDisclosureHistory(String coiDisclosureNumber);
    
    public List<CoiDisclosure> getReviewsForReviewStatuses(Collection<String> reviewStatusCodes);
}
